package data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class DietaContract  {
	public static final String CONTENT_AUTHORITY = "com.test.app";
	public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+ CONTENT_AUTHORITY);
	
	public static final String PATH_PRODUCTS = "products";
	public static final String PATH_ELEMENTS = "elements";
	public static final String PATH_CATEGORIES = "Categoriy_produktiv";
	
	public final static class ProductEntry implements BaseColumns {
		// TABLE NAME
		public static final String TABLE_NAME = "products";
		// uri
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCTS).build();
		public static final String COLUMN_NAME = "Name";
		public static final String COLUMN_KALORIJ = "elem2";
		public static final String COLUMN_IMG = "img";
		public static final String COLUMN_CATEGORIES = "Category";
		
		public static Uri buildProductInCutUri(long id) {
			return ContentUris.withAppendedId(CONTENT_URI, id);
		}
		
		public static String getCategoryFromUri(Uri uri) {
			return uri.getPathSegments().get(1);
		}
	}
	
	public final static class ElementsEntry implements BaseColumns {
		// TABLE NAME
		public static final String TABLE_NAME = "elements";
		// uri
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_ELEMENTS).build();
		public static final String COLUMN_ELEM = "elem";
		
	}
	
	public final static class CategoriesEntry implements BaseColumns {
		// TABLE NAME
		public static final String TABLE_NAME = "Categoriy_produktiv";
		// uri
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CATEGORIES).build();
		public static final String COLUMN_CATEGORIES = "Category";

	}
}
