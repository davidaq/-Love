package cc.ccme.love.video;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.cache.ImageFileCache;
import cc.ccme.love.cache.ImageMemoryCache;
import cc.ccme.love.util.DensityUtil;
import cc.ccme.love.widget.CheckedView;

public abstract  class VideoImageSelectBaseActivity extends BaseActivity implements
		OnItemClickListener, OnClickListener {

	protected String[] columns = new String[] { ImageColumns._ID,
			ImageColumns.DATE_MODIFIED, ImageColumns.DATA, ImageColumns.DISPLAY_NAME,
			ImageColumns.SIZE };
	ExecutorService threadPool = Executors.newFixedThreadPool(2);

	private HashSet<Integer> isSelected = new HashSet<Integer>();
	private PickAdapter adapter;
	private MyHandler handler;
	protected ArrayList<CommonFile> list;
	public static ArrayList<CommonFile> listSelected;
	private float x, y;
	private Integer selectBeginPosition, selectBeginPosition_, selectBeginCol;
	private boolean selecting = false;
	private  int ITEMS_IN_A_ROW = 4;
	private float width;
	protected ImageMemoryCache memoryCache;
	protected ImageFileCache fileCache;
	protected int size, size2;
	private ImageButton btnBack,btnOk;
	private GridView gridView;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_video_image_select_base);
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnOk = (ImageButton) findViewById(R.id.btn_ok);
		gridView = (GridView) findViewById(R.id.gridview);
	}

	@Override
	protected void initData() {
		memoryCache = new ImageMemoryCache(this);
		fileCache = new ImageFileCache();
		size = DensityUtil.dip2px(this, 90);
		size2 = DensityUtil.dip2px(this, 90);
		list = new ArrayList<CommonFile>();
		listSelected = new ArrayList<CommonFile>();
		btnBack.setOnClickListener(this);
		btnOk.setOnClickListener(this);
		gridView.setOnItemClickListener(this);
		DisplayMetrics display = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay()
				.getMetrics(display);
		width = display.widthPixels;
		gridView.setOnTouchListener(new OnTouchListener() {
			private boolean prevIsSelect;

			@SuppressWarnings("unused")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					x = event.getX();
					y = event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					if (selectBeginPosition == null)
						break;
					float cx = event.getX(),
					cy = event.getY();
					float dx = cx - x,
					dy = cy - y;
					int t = DensityUtil.dip2px(VideoImageSelectBaseActivity.this, selecting ? 20
							: 70);
					if (dx * dx + dy * dy < t * t) {
						return true;
					}
					if (!selecting && Math.abs(dy) > t * 0.9) {
						selectBeginPosition = null;
						selectBeginCol = null;
					} else {
						selecting = true;
						boolean isSelect = cx > x;
						int col = (int) (x / width * ITEMS_IN_A_ROW);
						if (selectBeginCol == null) {
							selectBeginCol = col;
						}
						x = cx;
						int min = col > selectBeginCol ? selectBeginCol : col, max = selectBeginCol
								+ col - min;
						if (prevIsSelect != isSelect) {
							selectBeginPosition = selectBeginPosition
									- selectBeginCol + col;
							selectBeginCol = col;
						}
						int sz = list.size();
						boolean changed = false;
						if (isSelect) {
							for (int i = selectBeginCol; i <= col; i++) {
								int sel = selectBeginPosition - selectBeginCol
										+ i;
								if (sel < sz && !isSelected.contains(sel)) {
									isSelected.add(sel);
									listSelected.add(list.get(sel));
									Log.v("XX", "" + sel);
									if (holders.indexOfKey(sel) >= 0)
										holders.get(sel).box.setChecked(true);
									changed = true;
								}
							}
						} else {
							for (int i = col; i <= selectBeginCol; i++) {
								int sel = selectBeginPosition - selectBeginCol
										+ i;
								if (sel < sz && isSelected.contains(sel)) {
									isSelected.remove(sel);
									listSelected.remove(list.get(sel));
									if (holders.indexOfKey(sel) >= 0)
										holders.get(sel).box.setChecked(false);
									changed = true;
								}
							}
						}
						if (changed) {
							CheckedView check = holders.get(selectBeginPosition_).box;
							check.setChecked(isSelected
									.contains(selectBeginPosition_));
							check.invalidate();
						}
					}
					return selecting;
				case MotionEvent.ACTION_UP:
					selectBeginPosition = null;
					selectBeginCol = null;
					try {
						return selecting;
					} finally {
						selecting = false;
					}
				}
				return false;
			}
		});
		handler = new MyHandler();
		new Thread(new Runnable() {
			@Override
			public void run() {
				list.clear();
				list.addAll(getList());
				handler.sendEmptyMessageDelayed(0, 0);
			}

		}).start();
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_ok:
			
			break;
		}
		
	}

	class PickAdapter extends BaseAdapter {

		public PickAdapter() {
			isSelected = new HashSet<Integer>();
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int which) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup arg2) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = VideoImageSelectBaseActivity.this.getLayoutInflater().inflate(
						R.layout.grid_item_select, null);
				holder.image = (ImageView) convertView.findViewById(R.id.image);
				holder.box = (CheckedView) convertView.findViewById(R.id.checkbox);
				holder.box.setClickable(true);
				holder.box.setEnabled(true);
				convertView.setTag(holder);
				final ViewHolder _holder = holder;
				holder.image.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View arg0, MotionEvent event) {
						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							selectBeginPosition_ = selectBeginPosition = _holder.position;
							break;
						}
						return false;
					}
				});
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			final ViewHolder _holder = holder;
			if (holder.position != position) {
				holders.remove(holder.position);
				holder.position = position;
				holders.put(position, holder);
				holder.box.setChecked(isSelected.contains(position));
				if (holder.task != null)
					holder.task.cancel(true);
				holder.task = threadPool.submit(new Runnable() {
					@Override
					public void run() {
						final Bitmap bmp = 	getPicture(list.get(position).getUrl(),size);
						handler.submitTask(new Runnable() {
							@Override
							public void run() {
								_holder.image.setImageBitmap(bmp);
							}
						});
					}
				});
			}
			return convertView;
		}
	}

	private SparseArray<ViewHolder> holders = new SparseArray<ViewHolder>();

	class ViewHolder {
		ImageView image;
		CheckedView box;
		int position = -1;
		Future<?> task;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View convertView,
			int position, long arg3) {
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.box.toggle();
		if (holder.box.isChecked())
			isSelected.add(position);
		else
			isSelected.remove(position);
		if (holder.box.isChecked() == true) {
			listSelected.add(list.get(position));
		} else {
			listSelected.remove(list.get(position));
		}

	}	
	
	@SuppressLint("HandlerLeak")
	class MyHandler extends Handler {
		public MyHandler() {
		}

		public MyHandler(Looper L) {
			super(L);
		}

		@Override
		public void handleMessage(Message msg) {
			if (adapter == null) {
				adapter = new PickAdapter();
				gridView.setAdapter(adapter);
			}
			if (msg.what == 1) {
				if (msg.obj != null && msg.obj instanceof Runnable)
					((Runnable) msg.obj).run();
			}
		}

		public void submitTask(Runnable runnable) {
			Message msg = new Message();
			msg.what = 1;
			msg.obj = runnable;
			sendMessage(msg);
		}
	}

	public Bitmap getPicture(String url  ,int size) {
		// get Image from memory
		Bitmap result = memoryCache.getBitmapFromCache(url);
		if (result == null) {
			// from disk
			result = fileCache.getImage(url);
			if (result == null) {
				// get image
				result = getBitmap(url);
				if (result != null) {
					fileCache.saveBitmap(result, url);
					memoryCache.addBitmapToCache(url, result);
				}
			} else {
				// add to memory
				memoryCache.addBitmapToCache(url, result);
			}
		}
		return result;
	}
	private List<CommonFile> getList()
	{
		Cursor cur = getCursor();
		LinkedList<CommonFile> list = new LinkedList<CommonFile>();
		while (cur.moveToNext()) {
			int path_index = cur
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			int size_index = cur
					.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE);
			int name_index = cur
					.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
			int date_index = cur
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED);
			
			String path = cur.getString(path_index);
			String size = cur.getString(size_index);
			String name = cur.getString(name_index);
			String date = cur.getString(date_index);

			CommonFile file = new CommonFile();
			file.setDate(Long.parseLong(date)*1000);
			file.setName(name);
			file.setSize(Long.parseLong(size));
			file.setUrl(path);

			list.add(file);
		}
		return list;
	}
	protected abstract Cursor getCursor();

	protected abstract Bitmap getBitmap(String url);

}
