package cc.ccme.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * This useless ListView is called "What The Fuck" ListView,the only function of it 
 * is to clear the warning of layout "activity_event_detail",for a ListView should not be in a 
 * ScrollView , this is all the designer's fault, fuck him!!!
 * @author He Weibing
 *
 */
public class WTFListView extends ListView{

	public WTFListView(Context context) {
		super(context);
	}

	public WTFListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public WTFListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}



}
