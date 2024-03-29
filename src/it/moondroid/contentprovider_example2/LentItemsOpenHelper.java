package it.moondroid.contentprovider_example2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The SQLiteOpenhelper implementation for lent items.
 *
 */
class LentItemsOpenHelper extends SQLiteOpenHelper {

        private static final String NAME = DbSchema.DB_NAME;
        private static final int VERSION = 1;
        
        public LentItemsOpenHelper(Context context) {
                super(context, NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
                db.execSQL(DbSchema.DDL_CREATE_TBL_ITEMS);
               
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // this is no sample for how to handle SQLite databases
                // thus I simply drop and recreate the database here.
                //
                // NEVER do this in real apps. Your users wouldn't like
                // loosing data just because you decided to change the schema
                db.execSQL(DbSchema.DDL_DROP_TBL_ITEMS);

                onCreate(db);
        }

}
