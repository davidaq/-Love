package cc.ccme.love.widget;

import cc.ccme.love.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HListViewFooter extends LinearLayout {

	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	private TextView mContentView;
	private Context mContext;
	

	public HListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	public HListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	@SuppressWarnings("deprecation")
	private void initView(Context context) {
		mContext = context;
		LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext)
				.inflate(R.layout.hlistview_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

		mContentView = (TextView) moreView
				.findViewById(R.id.hlistview_footer_hint);

	}
	
	public void setState(int state) {
		//mContentView.setVisibility(View.INVISIBLE);
		if (state == STATE_READY) {
			mContentView.setVisibility(View.VISIBLE);
			mContentView.setText(R.string.hlistview_hint_ready);
		} else {
			mContentView.setVisibility(View.VISIBLE);
			mContentView.setText(R.string.hlistview_hint_normal);
		}
	}

	public void setBottomMargin(int height) {
		if (height < 0)
			return;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}

	public int getBottomMargin() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		return lp.bottomMargin;
	}

	public void hide() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		lp.height = 0;
		mContentView.setLayoutParams(lp);
	}

	public void show() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		lp.height = LayoutParams.WRAP_CONTENT;
		mContentView.setLayoutParams(lp);
	}

}
