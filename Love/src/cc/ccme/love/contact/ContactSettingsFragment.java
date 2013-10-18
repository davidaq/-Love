package cc.ccme.love.contact;

import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactSettingsFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contact_settings, null);
        return view;
    }

}
