package it.moondroid.contentprovider_example2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;

public class FragmentItemsList extends ListFragment implements
		LoaderCallbacks<Cursor> {

	private static final int LOADER_ID = 0; //A unique ID that identifies the loader
	private SimpleCursorAdapter mAdapter; //cursor adapter for this ListFragment

	public interface ItemsListListener {
		void onItemClick (long id);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//LoaderManager is an abstract class associated with an Activity or Fragment for managing one or more Loader instance
		LoaderManager manager = getLoaderManager();
		
		manager.initLoader(LOADER_ID, null, this); // id, bundle, loadercallback

		// Create an empty adapter we will use to display the loaded data.
		mAdapter = new SimpleCursorAdapter(getActivity()
				.getApplicationContext(), R.layout.list_item, null,
				new String[] { LentItemsContract.Items._ID,
						LentItemsContract.Items.NAME }, new int[] {
						R.id.idLabel, R.id.nameLabel },
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

		setListAdapter(mAdapter);
		
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		//text to display for the list when there're no items
		setEmptyText("there are no items");
	}
	
	//Called when calling initLoader, instantiate and return a new Loader for the given ID
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {

		//The most common use of Loaders is with a CursorLoader, 
		//however applications are free to write their own loaders for loading other types of data.
		//CursorLoader is a subclass of AsyncTaskLoader that queries the ContentResolver on a background thread and returns a Cursor.
		CursorLoader cl = new CursorLoader(getActivity()
				.getApplicationContext(), LentItemsContract.Items.CONTENT_URI,
				new String[] {LentItemsContract.Items._ID,
						LentItemsContract.Items.NAME}, null, null, 
						LentItemsContract.Items.SORT_ORDER_ID);

		return cl;
	}

	// Called when a loader has finished its load, after a data change (insert, delete, ecc.)
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
		mAdapter.swapCursor(c);
	}

	// Called when a previously created loader is being reset
	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mAdapter.swapCursor(null);
	}

	
	//onListItemClick implements onclick listener for the list
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		
		ItemsListListener activity = (ItemsListListener) getActivity();
		activity.onItemClick(id);
	}

	
}
