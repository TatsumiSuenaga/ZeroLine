package com.cse.team12.zeroline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tatsumi on 3/4/16.
 */
public class MenuFragment extends Fragment {

    private TextView mExample;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_menu, container, false);


        mExample = (TextView) v.findViewById(R.id.example);


        return v;
    }
}
