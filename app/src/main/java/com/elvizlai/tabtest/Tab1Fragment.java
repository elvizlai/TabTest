package com.elvizlai.tabtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Elvizlai on 14-9-10.
 */
public class Tab1Fragment extends Fragment {
    private ListView mListView;

    private String[] data = new String[100];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 100; i++) {
            data[i] = "" + i;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.tab1_fragment_layout, container, false);

        mListView = (ListView) fragmentView.findViewById(R.id.list);
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        return fragmentView;
    }
}
