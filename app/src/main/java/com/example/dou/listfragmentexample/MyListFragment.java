package com.example.dou.listfragmentexample;

import android.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Dou on 2016/4/27.
 */
public class MyListFragment extends ListFragment {
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(),""+l.getItemIdAtPosition(position),3000).show();
    }
}
