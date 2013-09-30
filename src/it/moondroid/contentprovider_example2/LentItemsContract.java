package it.moondroid.contentprovider_example2;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * The contract class is used to define public constants, such as field names,
 * to help other applications access the data from your content provider
 */
public final class LentItemsContract {

	/**
	 * The authority of the lentitems provider.
	 */
	public static final String AUTHORITY =

	"it.moondroid.contentprovider.lentitems";

	/**
	 * The content URI for the top-level lentitems authority.
	 */
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	
	/**
     * A selection clause for ID based queries.
     */
    public static final String SELECTION_ID_BASED = BaseColumns._ID + " = ? ";

	/**
	 * Constants for the Items table of the lentitems provider.
	 */
	public static final class Items implements BaseColumns {

		/**
		 * The content URI for this table.
		 */
		public static final Uri CONTENT_URI = Uri.withAppendedPath(
				LentItemsContract.CONTENT_URI, "items");
		/**
		 * The mime type of a directory of items.
		 */
		public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
				+ "/vnd.it.moondroid.lentitems_items";
		/**
		 * The mime type of a single item.
		 */
		public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
				+ "/vnd.it.moondroid.lentitems_items";
		
		/**
		 * The name of the item.
		 */
		public static final String NAME = "item_name";
		/**
		 * The borrower of the item.
		 */
		public static final String BORROWER = "borrower";
		
		/**
		 * A projection of all columns in the items table.
		 */
		public static final String[] PROJECTION_ALL = { _ID, NAME, BORROWER };
		
		/**
		 * The default sort order for queries containing NAME fields.
		 */
		public static final String SORT_ORDER_DEFAULT = NAME + " ASC";
		
		/**
		 * Sort order by id
		 */
		public static final String SORT_ORDER_ID = _ID + " ASC";

	}

}
