package com.test;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Product_Adaptor extends CursorAdapter {

	public Product_Adaptor(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		// TODO Auto-generated method stub
		// bindView - привязать вид
		TextView tv1 = (TextView) arg0.findViewById(R.id.TV2);
		ImageView iv1 = (ImageView) arg0.findViewById(R.id.ImV1);
		
		
		tv1.setText(arg2.getString(1));
		String imFile = "pictures/" + arg2.getString(3) + ".png";
		iv1.setImageDrawable(getBitmapFromAssets(arg1, imFile));
		
	}

	@Override
	public View newView(Context context, Cursor arg1, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		int layoutId = R.layout.product_item;
		
		View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
		
		return view;
	}
	
	private Drawable getBitmapFromAssets(Context context, String strName)
	{
		InputStream ims = null;
		try {
			ims = context.getAssets().open(strName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Drawable d = Drawable.createFromStream(ims, null);
		return d;
	}

	
}
