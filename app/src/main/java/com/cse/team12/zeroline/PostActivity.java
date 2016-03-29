package com.cse.team12.zeroline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PostActivity extends AppCompatActivity {

    private Button mUpdate;
    private EditText mEdit;

    private TextView mView;
    private TextView mView1;
    private TextView mView2;
    private TextView mView3;
    private TextView mView4;
    int textViewCount = 5;
    int counter = 0;
    TextView[] TextViewArray = new TextView[textViewCount];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mUpdate = (Button) findViewById(R.id.updateButton);
        mEdit = (EditText)findViewById(R.id.lineUpdate);
        mView = (TextView) findViewById(R.id.lineStatus);
        mView1 = (TextView) findViewById(R.id.lineStatus2);
        mView2 = (TextView) findViewById(R.id.lineStatus3);
        mView3 = (TextView) findViewById(R.id.lineStatus4);
        mView4 = (TextView) findViewById(R.id.lineStatus5);
        TextViewArray[0] = mView;
        TextViewArray[1] = mView1;
        TextViewArray[2] = mView2;
        TextViewArray[3] = mView3;
        TextViewArray[4] = mView4;

        mUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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


}
