package com.test;

import java.io.IOException;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import data.DBHelperCopy;
import data.DietaContract;
import data.DietaContract.ProductEntry;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);

		DBHelperCopy mydbhelper = new DBHelperCopy(getActivity());

		try {
			mydbhelper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydbhelper.openDataBase();

		String projection1[] = new String[] { ProductEntry._ID,
				ProductEntry.COLUMN_NAME, ProductEntry.COLUMN_CATEGORIES,
				ProductEntry.COLUMN_KALORIJ, ProductEntry.COLUMN_IMG };
		Cursor cursor = getActivity().getContentResolver().query(
				DietaContract.ProductEntry.CONTENT_URI, projection1, null,
				null, null);

		Cursor catCursor = getActivity().getContentResolver().query(
				ProductEntry.buildProductInCutUri(1), projection1, null,
				null, null);
		if (catCursor.moveToFirst()) {
			do {
				int cat = catCursor.getInt(2);
				Log.d(MainActivity.LOG_TAG, "Name = " + catCursor.getString(1)
						+ ", Category = " + cat);
			} while (catCursor.moveToNext());
		}

		mydbhelper.close();

		ListView listView1 = (ListView) rootView.findViewById(R.id.LV1);
		ProductAdaptor mAdaptor = new ProductAdaptor(getActivity(), cursor,
				0);
		listView1.setAdapter(mAdaptor);
		return rootView;
	}

}