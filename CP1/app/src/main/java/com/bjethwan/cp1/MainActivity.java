package com.bjethwan.cp1;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bjethwan.cp1.databases.NationDbHelper;

public class MainActivity extends Activity implements View.OnClickListener{

    SQLiteDatabase db;
    EditText etCountry, etContinent;
    Button btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NationDbHelper nationDbHelper = new NationDbHelper(this);
        db = nationDbHelper.getWritableDatabase();

        etCountry = (EditText)findViewById(R.id.etCountry);
        etContinent = (EditText)findViewById(R.id.etContinent);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnInsert:
                String country = etCountry.getText().toString();
                String continent = etContinent.getText().toString();

                Toast.makeText(this, country +" - "+ continent, Toast.LENGTH_SHORT).show();

                ContentValues contentValues = new ContentValues();
                contentValues.put("country", country);
                contentValues.put("continent", continent);
                db.insert("countries", null, contentValues);
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
