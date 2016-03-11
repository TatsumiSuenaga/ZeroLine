package com.cse.team12.zeroline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tatsumi on 3/4/16.
 */
public class MenuFragment extends Fragment {

    private Button mRest;
    private Button mBar;
    private Button mStore;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_menu, container, false);


        //mExample = (TextView) v.findViewById(R.id.example);
        mRest = (Button) v.findViewById(R.id.restaurants);
        mRest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), RestaurantActivity.class);
                startActivity(i);
            }
        });

        mBar = (Button) v.findViewById(R.id.bars);
        mBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), RestaurantActivity.class);
                startActivity(i);
            }
        });


        mStore = (Button) v.findViewById(R.id.stores);
        mStore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), RestaurantActivity.class);
                startActivity(i);
            }
        });


        return v;
    }
}
