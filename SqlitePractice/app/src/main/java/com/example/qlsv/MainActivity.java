package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    private final String DB_NAME = "QLSV";
    private final String TABLE_NAME = "Student";

    private final String KEY_ID = "id";
    private final String KEY_NAME = "name";
    private final String KEY_EMAIL = "email";
    private final String KEY_DOB = "dob";

    private SQLiteDatabase db;
    private ListView listInfo;
    private EditText searchBox;

    private StudentAdapter listAdapter;

    private String[] listColumns = {KEY_ID, KEY_NAME};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDatabase();
        createTable();

        listInfo = findViewById(R.id.listInfo);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        searchBox = findViewById(R.id.searchBox);

        listAdapter = new StudentAdapter(this, R.layout.list_item, getAll());
        listInfo.setAdapter(listAdapter);

        listInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // view detail;
            }
        });


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listAdapter.setItems(search(searchBox.getText().toString()));
            }
        });

        //populate data on ui
    }

    private void initializeDatabase() {
        String path = getFilesDir() + "/" + DB_NAME;
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTable() {
        db.beginTransaction();
        try {
            db.execSQL("create table " + TABLE_NAME + "(" +
                    KEY_ID + " integer PRIMARY KEY autoincrement," +
                    KEY_NAME + " text," +
                    KEY_EMAIL + " text," +
                    KEY_DOB + " text)");

            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194000", "AAA", "aaa@gmail.com", "2001-2-19"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194002", "MMM", "mmm@gmail.com", "2001-12-9"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194020", "AA", "aa@gmail.com", "2000-3-7"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194012", "Vu Xuan Bac", "vuxuanbac@gmail.com", "2001-3-17"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194024", "Hi", "hi712@gmail.com", "2001-6-7"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194021", "Test", "abc123@gmail.com", "2000-3-9"));
            db.execSQL(String.format("insert into %s values('%s', '%s', '%s', '%s')", TABLE_NAME, "20194220", "Hello World", "world.hello@gmail.com", "2002-6-28"));


            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    private Cursor search(String hints){
//        String query = String.format("SELECT %s, %s FROM %s WHERE %s = '%s' OR %s = '%s'",
//                KEY_ID, KEY_NAME, TABLE_NAME, KEY_ID, hints, KEY_NAME, hints);
//        return db.rawQuery(query, null);
        return db.query(TABLE_NAME, listColumns,
                KEY_ID + " = ? OR " + KEY_NAME + " = ?", new String[]{hints, hints},
                null, null ,null);
    }

    private Cursor getAll() {
        return db.query(TABLE_NAME, listColumns,
                null, null, null, null ,null);
    }
}