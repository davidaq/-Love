package cc.ccme.love.widget;

import cc.ccme.love.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CheckedView extends RelativeLayout{

	private ImageView image;
	private Boolean isSelected = false;
	public CheckedView(Context context) {
		super(context);
		
	}
	
	public CheckedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=View.inflate(context, R.layout.widget_checkview, null);
		this.addView(view);
		image = (ImageView)view.findViewById(R.id.image);
    }
	
	public void setChecked(boolean checked)
	{
		isSelected = checked;
		setBackground();
		
	}
	
	public void toggle()
	{
		isSelected = !isSelected;
		setBackground();
	}
	
	public boolean isChecked()
	{
		return isSelected;
	}
	
	private void setBackground()
	{
		if(isSelected)
			image.setBackgroundResource(R.drawable.gallery_checked);
		else
			image.setBackgroundResource(R.drawable.gallery_checked_nor);
	}

	
}
