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
    private Button mButton;

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

        mButton = (Button) v.findViewById(R.id.temp1);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), RestaurantActivity.class);
                startActivity(i);
            }
        });

        return  v;
    }
}


