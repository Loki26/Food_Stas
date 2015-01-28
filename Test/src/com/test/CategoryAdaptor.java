package com.test;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class CategoryAdaptor extends CursorAdapter {

	public CategoryAdaptor(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		// TODO Auto-generated method stub
		TextView TV4 = (TextView) arg0.findViewById(R.id.TV4);
		
		TV4.setText(arg2.getString(1));
	}

	@Override
	public View newView(Context arg3, Cursor arg4, ViewGroup arg5) {
		// TODO Auto-generated method stub
		int LayoutID = R.layout.cat_shablon;
		
		View View = LayoutInflater.from(arg3).inflate(LayoutID, arg5, false);
		
		return View;
	}

}
