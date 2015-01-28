package com.test;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import data.DietaContract.CategoriesEntry;

public class MainActivity extends ActionBarActivity {
	final static String LOG_TAG = "myLogs";

	ActionBarDrawerToggle mToggle;

	// Д/з. Создать учетную запись на githab
	// ActionBar, ToolBar,
	// ContentProvider)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			DrawerLayout DrawerLayout1 = (DrawerLayout) findViewById(R.id.drawer_layout1);
			ListView ListView1 = (ListView) findViewById(R.id.listView1);

			Toolbar mToolbar = (Toolbar) findViewById(R.layout.toolbar);
			String projection[] = new String[] { CategoriesEntry._ID,
					CategoriesEntry.COLUMN_CATEGORIES };
			Cursor catCursor = this.getContentResolver().query(
					CategoriesEntry.CONTENT_URI, projection, null, null, null);
			CategoryAdaptor catAdaptor = new CategoryAdaptor(this, catCursor, 0);
			ListView1.setAdapter(catAdaptor);
			mToggle = new ActionBarDrawerToggle(this,
					DrawerLayout1, mToolbar, R.drawable.ic_drawer,
					R.drawable.ic_drawer) {
				@Override
				public void onDrawerClosed(View drawerView) {
					// TODO Auto-generated method stub
					super.onDrawerClosed(drawerView);
				}
				
				@Override
						public void onDrawerOpened(View drawerView) {
							// TODO Auto-generated method stub
							super.onDrawerOpened(drawerView);
						}
			};
			
			DrawerLayout1.setDrawerListener(mToggle);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setHomeButtonEnabled(true);
		}
	}
	
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (mToggle.onOptionsItemSelected(item)) {
			return true;}
		return super.onOptionsItemSelected(item);
	}

}
