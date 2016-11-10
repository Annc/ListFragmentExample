package com.example.dou.listfragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewItemFragment.OnNewItemAddListener {
    private ArrayList<String> data;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        MyListFragment myListFragment = (MyListFragment)getFragmentManager().findFragmentById(R.id.fragment_list);
        myListFragment.setListAdapter(adapter);
    }

    @Override
    public void NewItemAdd(String content) {
        //Toast.makeText(this, content, 3000).show();
        data.add(content);
        adapter.notifyDataSetChanged();

    }
}
