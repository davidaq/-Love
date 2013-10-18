package cc.ccme.love.fragment;

import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class ContactFragment extends BaseFragment {

	private TabHost tabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, null);
        LayoutInflater mInflater = LayoutInflater.from(getActivity()); 
        final View tabSelectorSingle = mInflater.inflate(R.layout.tabselector_single, null);
		final View tabSelectorGroup = mInflater.inflate(R.layout.tabselector_group, null);
		final View tabSelectorSettings = mInflater.inflate(R.layout.tabselector_settings, null);
		
		//init view
		tabHost = (TabHost) view.findViewById(android.R.id.tabhost);
		tabHost.setup();
		
		tabHost.addTab(tabHost.newTabSpec("single").setIndicator(tabSelectorSingle).setContent(R.id.contact_single));
		tabHost.addTab(tabHost.newTabSpec("group").setIndicator(tabSelectorGroup).setContent(R.id.contact_group));
		tabHost.addTab(tabHost.newTabSpec("setings").setIndicator(tabSelectorSettings).setContent(R.id.contact_settings));
        tabHost.setCurrentTab(2);
		return view;
    }

}
