package com.cse.team12.zeroline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by tatsumi on 3/11/16.
 */
public class MyListFragment extends Fragment {

    private RecyclerView mList;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        /**mList = (RecyclerView) v.findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] temp = new String[] {"Chipotle", "Raising Canes", "Diaspora",
                "McDonald's", "Noodles & Company", "Moe's", "Qdoba", "Jimmy Kang's Dreams of Sushi"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, temp );

        //Temporary adapter just for UI, this will be later made into different fragment probably
        mList.setAdapter(adapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ch = (String) mList.getItemAtPosition(position);
                Intent i = new Intent();

            });**/

        mButton1 = (Button) v.findViewById(R.id.temp1);
        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rName = "Chipotle";
                Intent i = new Intent(getActivity(), PostActivity.class);
                i.putExtra("name",rName );
                startActivity(i);
            }
        });
        mButton2 = (Button) v.findViewById(R.id.temp2);
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rName = "Blaze Pizza";
                Intent i = new Intent(getActivity(), PostActivity.class);
                i.putExtra("name",rName );
                startActivity(i);
            }
        });
        mButton3 = (Button) v.findViewById(R.id.temp3);
        mButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rName = "Bibipop";
                Intent i = new Intent(getActivity(), PostActivity.class);
                i.putExtra("name",rName );
                startActivity(i);
            }
        });
        mButton4 = (Button) v.findViewById(R.id.temp4);
        mButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String rName = "Diaspora";
                Intent i = new Intent(getActivity(), PostActivity.class);
                i.putExtra("name",rName );
                startActivity(i);
            }
        });
        return  v;
    }
}


