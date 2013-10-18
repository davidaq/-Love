package cc.ccme.love.person;

import cc.ccme.love.R;
import cc.ccme.love.R.layout;
import cc.ccme.love.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PersonEditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_edit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_edit, menu);
		return true;
	}

}
