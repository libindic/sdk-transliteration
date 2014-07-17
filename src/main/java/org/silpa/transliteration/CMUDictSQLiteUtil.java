package org.silpa.transliteration;

/**
 * Note : CMU Dictionary SQLite database for transliteration module is made using
 * python script 'silpa_sdk_transliteration_make_database.py' which is found in root of this module.
 * SQLite database is stored in res/raw .
 *
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by sujith on 8/7/14.
 */
public class CMUDictSQLiteUtil {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "silpa_sdk_transliteration.db";
    // Table Name
    private static final String TABLE_NAME = "cmudict_0_7a_sphinx_40";
    // Field word
    private static final String TAG_WORD = "word";
    // Field phoneme codes
    private static final String TAG_PHONEMES = "phonemes";
    // context of application
    private final Context mContext;
    // database path
    private final String dbPath;

    // LOG TAG
    private static final String LOG_TAG = "Transliterator - SQLiteHelper";

    public CMUDictSQLiteUtil(Context context) {
        this.mContext = context;
        this.dbPath = mContext.getFilesDir() + File.separator + CMUDictSQLiteUtil.DATABASE_NAME;
        createDataBase();
    }

    /**
     * Copies database if it does not exist
     */
    private void createDataBase() {
        boolean dbExist = checkDataBase();

        if (!dbExist) {
            copyDataBase();
        }
    }

    /**
     * Check if the database already exist to avoid re-copying
     * the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(this.dbPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {

        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /**
     * This function is used to copy database from raw to storage directory
     */
    private void copyDataBase() {

        try {
            InputStream in = mContext.getResources().openRawResource(R.raw.silpa_sdk_transliteration);
            OutputStream out = new FileOutputStream(new File(this.dbPath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            out.close();
            in.close();
        } catch (IOException ioe) {
            Log.e(LOG_TAG, "Error while copying database : " + ioe.getMessage());
        }
    }


    /**
     * This function returns CMUDictObject
     * containing phonemes for given word.
     *
     * @param word word to fetch phonemes for
     * @return CMUDictObject
     */
    protected CMUDictObject getCMUDictionaryEntry(String word) {

        SQLiteDatabase transliteratorDatabase = SQLiteDatabase.openDatabase(this.dbPath, null, SQLiteDatabase.OPEN_READONLY);
        if (transliteratorDatabase == null) {
            return null;
        }
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE "
                + TAG_WORD + " = " + "'" + word + "'";

        Cursor cursor = transliteratorDatabase.rawQuery(query, null);

        CMUDictObject obj = null;
        if (cursor.moveToFirst()) {
            obj = new CMUDictObject(cursor.getString(0), cursor.getString(1));
        }
        cursor.close();
        transliteratorDatabase.close();

        return obj;
    }
}
