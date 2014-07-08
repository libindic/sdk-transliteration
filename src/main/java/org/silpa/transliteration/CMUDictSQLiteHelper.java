package org.silpa.transliteration;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by sujith on 8/7/14.
 */
public class CMUDictSQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "silpa_sdk_cmudict_db";
    // Table Name
    private static final String TABLE_NAME = "cmudict_0_7a_sphinx_40";
    // Field word
    private static final String TAG_WORD = "word";
    // Field phoneme codes
    private static final String TAG_PHONEMES = "phonemes";

    // LOG TAG
    private static final String LOG_TAG = "Transliterator - SQLiteHelper";

    public CMUDictSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "
                + TAG_WORD + " TEXT PRIMARY KEY , " + TAG_PHONEMES + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // create fresh table
        this.onCreate(db);
    }

    /**
     * This function is used to add an entry to database.
     * This was used to make sqlite database.
     *
     * @param obj CMUDictObject to add
     */
    protected void addCMUDictionaryEntry(CMUDictObject obj) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TAG_WORD, obj.getWord());
        values.put(TAG_PHONEMES, obj.getPhonemes());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    /**
     * This function returns CMUDictObject
     * containing phonemes for given word.
     *
     * @param db   Database to fetch from
     * @param word word to feteh for
     * @return CMUDictObject
     */
    protected static CMUDictObject getCMUDictionaryEntry(SQLiteDatabase db, String word) {

        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE "
                + TAG_WORD + " = " + "'" + word + "'";

        Cursor cursor = db.rawQuery(query, null);

        CMUDictObject obj = null;
        if (cursor.moveToFirst()) {
            obj = new CMUDictObject(cursor.getString(0), cursor.getString(1));
        }
        cursor.close();

        return obj;
    }

    /**
     * This function returns cmu database copied from assets
     *
     * @param context context
     * @return SQLiteDatabase
     */
    protected static SQLiteDatabase getCMUDatabase(Context context) {
        return SQLiteDatabase.openDatabase(context.getFilesDir() + File.separator + DATABASE_NAME,
                null, SQLiteDatabase.OPEN_READONLY);
    }

    /**
     * This function is to copy database from
     * assets to phone
     *
     * @param context context
     */
    protected static void copyDatabase(Context context) {

        String[] files = null;
        AssetManager assetManager = context.getAssets();

        try {
            files = assetManager.list("");
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        }

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(DATABASE_NAME);
            File outFile = new File(context.getFilesDir() + File.separator + DATABASE_NAME);
            if (outFile.exists()) {
                in.close();
                return;
            }
            out = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            Log.v(LOG_TAG, "Asset database copy successful.");
        } catch (IOException e) {
            Log.e(LOG_TAG, "Failed to copy asset database file: " + DATABASE_NAME, e);
        }
    }

    /**
     * This function was used to make the database for cmudict database
     * Rename 'cmudict.0.7a_SPHINX_40' file to 'silpa_sdk_cmudict_0_7a_sphinx_40' and
     * place it in resources to make database.
     * Check database details at top for more information.
     *
     * @param context context
     */
    protected static void makeDatabase(Context context) {
        CMUDictSQLiteHelper csql = new CMUDictSQLiteHelper(context);
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(context.getResources().
                    openRawResource(R.raw.silpa_sdk_cmudict_0_7a_sphinx_40)));

            String line = br.readLine();
            int k = 0;
            while (line != null) {
                line = line.trim();
                if (line.startsWith(";;; #")) {
                    line = br.readLine();
                    continue;
                }
                String[] arr = line.split("[ \t]", 2);
                csql.addCMUDictionaryEntry(new CMUDictObject(arr[0], arr[1]));
                line = br.readLine();
                System.out.println(k++);
            }
            br.close();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        }
    }
}
