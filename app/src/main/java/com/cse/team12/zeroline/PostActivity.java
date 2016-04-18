package com.cse.team12.zeroline;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class PostActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Button mUpdate;
    private EditText mEdit;

    private TextView mView;
    private TextView mView1;
    private TextView mView2;
    private TextView mView3;
    private TextView mView4;
    private TextView mRest;
    int textViewCount = 5;
    int counter = 0;
    TextView[] TextViewArray = new TextView[textViewCount];
    String tName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        createDB();
        Intent intent = getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRest = (TextView) findViewById(R.id.name);
        mUpdate = (Button) findViewById(R.id.updateButton);
        mEdit = (EditText) findViewById(R.id.lineUpdate);
        mView = (TextView) findViewById(R.id.lineStatus);
        mView1 = (TextView) findViewById(R.id.lineStatus2);
        mView2 = (TextView) findViewById(R.id.lineStatus3);
        mView3 = (TextView) findViewById(R.id.lineStatus4);
        mView4 = (TextView) findViewById(R.id.lineStatus5);

        String rName = intent.getExtras().getString("name");
        mRest.setText(rName);
        tName = rName; //setting global string to db table name for onclicklistener

        TextViewArray[0] = mView;
        TextViewArray[1] = mView1;
        TextViewArray[2] = mView2;
        TextViewArray[3] = mView3;
        TextViewArray[4] = mView4;
        String [] data = getPosts(rName);
        if (data.length > 0) {
            for (int i = 0; i < data.length-1 && i < 5; i++)
            {
                TextViewArray[i].setText(data[i]);
                if (i > 4) {
                    i = data.length + 1;
                }
            }
        }

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String query = "INSERT INTO posts (post) VALUES(Very Busy);";
                //db.execSQL(query);


                if (v == mUpdate) {
                    insertIntoDB(tName);
                }

                if (mEdit.getText().toString() != "") {
                    if (counter == 5) {

                        counter = 0;
                    }
                    TextViewArray[counter].setText(mEdit.getText().toString());
                    mEdit.setText("");
                    counter++;
                }

            }

        });

    }

    protected void createDB() {

        db = openOrCreateDatabase("PostsDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Chipotle(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "post VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS BlazePizza(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "post VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Diaspora(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "post VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Bibipop(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "post VARCHAR);");

    }

    protected void insertIntoDB(String name) {
        String post = mEdit.getText().toString().trim();
        if (post.equals("")) {
            Toast.makeText(getApplicationContext(), "Please fill all fields",
                    Toast.LENGTH_LONG).show();
            return;
        }

        String query = "INSERT INTO '" + name + "'(post) VALUES('" + post + "');";
        db.execSQL(query);
        Toast.makeText(getApplicationContext(), "Post Saved!", Toast.LENGTH_LONG).show();

    }

    protected String[] getPosts(String tableName) {

        //final String TableName = "posts";
        String selectQuery = "Select post FROM " + tableName;
        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = new String[100];

        int i = 0;

        if(cursor.moveToFirst()) {
            do {
                data[i] = cursor.getString(cursor.getColumnIndex("post"));
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;


    }


}
