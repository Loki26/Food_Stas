package com.test;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdaptor extends CursorAdapter
{

	public ProductAdaptor(Context context, Cursor c, int flags) 
	{
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) 
	{
		// TODO Auto-generated method stub
		TextView TextView2 = (TextView) arg0.findViewById(R.id.TV2);
		TextView TextView3 = (TextView) arg0.findViewById(R.id.TV3);
		ImageView ImageView1 = (ImageView) arg0.findViewById(R.id.ImV1);
		
		TextView2.setText(arg2.getString(1));
		TextView3.setText(arg2.getString(2) + "ъЪры");
		String imFileName = "pictures/" + arg2.getString(4) + ".png";
		ImageView1.setImageDrawable(getBitmapFromAssets(arg1, imFileName));
	}

	@Override
	public View newView(Context arg3, Cursor arg4, ViewGroup arg5) 
	{
		// TODO Auto-generated method stub
		
		int LayoutID = R.layout.product_item;
		
		View View = LayoutInflater.from(arg3).inflate(LayoutID, arg5, false);
		
		return View;
	}
	
	
	private Drawable getBitmapFromAssets(Context arg6, String arg7)
	{
		InputStream ims = null;
		try {
			ims = arg6.getAssets().open(arg7);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Drawable d = Drawable.createFromStream(ims, null);
		return d;
	}


}
