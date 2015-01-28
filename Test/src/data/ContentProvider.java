package data;

import data.DietaContract.CategoriesEntry;
import data.DietaContract.ElementsEntry;
import data.DietaContract.ProductEntry;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ContentProvider extends android.content.ContentProvider {

	private static final int ALL_PRODUCTS = 100;
	private static final int ALL_CATEGORIES = 200;
	private static final int ALL_ELEMENTS = 300;
	private static final int PRODUCTS_IN_CATEGORY = 400;

	private static final UriMatcher sUriMatcher = buildUriMatcher();

	private static UriMatcher buildUriMatcher() {
		final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
		final String authority = DietaContract.CONTENT_AUTHORITY;
		matcher.addURI(authority, DietaContract.PATH_PRODUCTS, ALL_PRODUCTS);
		matcher.addURI(authority, DietaContract.PATH_CATEGORIES, ALL_CATEGORIES);
		matcher.addURI(authority, DietaContract.PATH_ELEMENTS, ALL_ELEMENTS);
		matcher.addURI(authority, DietaContract.PATH_PRODUCTS + "/#",
				PRODUCTS_IN_CATEGORY);
		return matcher;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		DBHelperCopy mHelperCopy = new DBHelperCopy(getContext());
		SQLiteDatabase db = mHelperCopy.getReadableDatabase();
		Cursor retCursor;
		// TODO Auto-generated method stub
		switch (sUriMatcher.match(uri)) {
		// Перечень всех продуктов.
		case ALL_PRODUCTS:
			retCursor = db.query(ProductEntry.TABLE_NAME, projection,
					selection, selectionArgs, null, null, null);
			break;
		// Категории продуктов.
		case ALL_CATEGORIES:
			retCursor = db.query(CategoriesEntry.TABLE_NAME, projection,
					selection, selectionArgs, null, null, null);
			break;
		// Категории элементов.
		case ALL_ELEMENTS:
			retCursor = db.query(ElementsEntry.TABLE_NAME, projection,
					selection, selectionArgs, null, null, null);
			break;
		case PRODUCTS_IN_CATEGORY:
			selection = ProductEntry.COLUMN_CATEGORIES + " = ? AND "
					+ ProductEntry.COLUMN_NAME + " LIKE ? ";
			selectionArgs = new String[] { ProductEntry.getCategoryFromUri(uri), "%Яблоко%" };
			retCursor = db.query(ProductEntry.TABLE_NAME, projection,
					selection, selectionArgs, null, null, null);
			break;
		default:
			throw new UnsupportedOperationException("Unknown uri: " + uri);
		}
		return retCursor;

	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
