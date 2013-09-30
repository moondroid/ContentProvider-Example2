package it.moondroid.contentprovider_example2;

import android.provider.BaseColumns;

/**
 * A helper interface which defines constants for work with the DB.
 *
 */
/* package private */ interface DbSchema {

        String DB_NAME = "lentitems.db";
        
        String TBL_ITEMS = "items";
        
        String COL_ID = BaseColumns._ID;
        String COL_ITEM_NAME = "item_name";
        String COL_BORROWER = "borrower";
       
        
        // BE AWARE: Normally you would store the LOOKUP_KEY
        // of a contact from the device. But this would
        // have needless complicated the sample. Thus I
        // omitted it.
        String DDL_CREATE_TBL_ITEMS = 
                        "CREATE TABLE items (" +
                        "_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
                        "item_name     TEXT,\n" +
                        "borrower      TEXT \n" +
                        ")";

               
        String DDL_DROP_TBL_ITEMS =
                        "DROP TABLE IF EXISTS items";

        String DML_WHERE_ID_CLAUSE = "_id = ?";
        
        String DEFAULT_TBL_ITEMS_SORT_ORDER = "name ASC";
        
}