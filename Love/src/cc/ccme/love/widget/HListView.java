package cc.ccme.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class HListView extends ListView implements OnScrollListener {

	private float mLastY = -1;
	private Scroller mScroller;
	private OnScrollListener mScrollListener;
	private boolean mIsFooterReady = false;
	private boolean mEnablePullBack;
	
	private FallListener fallListener;

	private HListViewFooter mFooterView;

	private int mTotalItemCount;

	private final static int SCROLL_DURATION = 400;
	private final static int PULL_LOAD_MORE_DELTA = 200;
	private final static float OFFSET_RADIO = 1.8f;

	public HListView(Context context) {
		super(context);
		initView(context);
	}

	public HListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public HListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public interface OnXScrollListener extends OnScrollListener {
		public void onXScrolling(View view);

	}

	private void initView(Context context) {
		mScroller = new Scroller(context, new DecelerateInterpolator());
		super.setOnScrollListener(this);
		mFooterView = new HListViewFooter(context);

	}

	@Override
	public void setAdapter(ListAdapter adapter) {
		if (mIsFooterReady == false) {
			mIsFooterReady = true;
			addFooterView(mFooterView);
		}
		super.setAdapter(adapter);
	}

	public void setPullLoadEnable(boolean enable) {
		mEnablePullBack = enable;
		if (!mEnablePullBack) {
			mFooterView.hide();
			mFooterView.setOnClickListener(null);
		} else {
			mFooterView.show();
			mFooterView.setState(HListViewFooter.STATE_NORMAL);
		}
	}

	private void updateFooterHeight(float delta) {
		int height = mFooterView.getBottomMargin() + (int) delta;
		if (mEnablePullBack) {
			if (height > PULL_LOAD_MORE_DELTA) {
				mFooterView.setState(HListViewFooter.STATE_READY);
			} else {
				mFooterView.setState(HListViewFooter.STATE_NORMAL);
			}
		}
		mFooterView.setBottomMargin(height);
	}

	private void resetFooterHeight() {
		int bottomMargin = mFooterView.getBottomMargin();
		if (bottomMargin > 0) {
			mScroller.startScroll(0, bottomMargin, 0, -bottomMargin,
					SCROLL_DURATION);
			invalidate();
		}
	}

	private void invokeOnScrolling() {
		if (mScrollListener instanceof OnXScrollListener) {
			OnXScrollListener l = (OnXScrollListener) mScrollListener;
			l.onXScrolling(this);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (mLastY == -1) {
			mLastY = ev.getRawY();
		}
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mLastY = ev.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:
			final float deltaY = ev.getRawY() - mLastY;
			mLastY = ev.getRawY();
			if (getLastVisiblePosition() == mTotalItemCount - 1
					&& (mFooterView.getBottomMargin() > 0 || deltaY < 0)) {
				updateFooterHeight(-deltaY / OFFSET_RADIO);
			}
			break;
		default:
			mLastY = -1;
			if (getLastVisiblePosition() == mTotalItemCount - 1) {
				if (mEnablePullBack
						&& mFooterView.getBottomMargin() > PULL_LOAD_MORE_DELTA) {
					fallListener.onFall();
				}
				resetFooterHeight();
				mFooterView.setState(HListViewFooter.STATE_NORMAL);
				
			}
			break;
		}
		return super.onTouchEvent(ev);
	}

	@Override
	public void computeScroll() {
		if (mScroller.computeScrollOffset()) {
			mFooterView.setBottomMargin(mScroller.getCurrY());
			postInvalidate();
			invokeOnScrolling();
		}
		super.computeScroll();
	}

	@Override
	public void setOnScrollListener(OnScrollListener l) {
		mScrollListener = l;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if (mScrollListener != null) {
			mScrollListener.onScrollStateChanged(view, scrollState);
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		mTotalItemCount = totalItemCount;
		if (mScrollListener != null) {
			mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount,
					totalItemCount);
		}
	}
	
	public void setFallListener(FallListener f)
	{
		fallListener = f;
	}
	
	
	public interface FallListener
	{
		public void onFall();
	}
	
 
}
