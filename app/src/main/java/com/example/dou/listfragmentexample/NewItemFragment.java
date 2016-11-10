package com.example.dou.listfragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dou on 2016/4/27.
 */
public class NewItemFragment extends Fragment {
//声明一个接口，定义你要向activity传值的方法
    public interface OnNewItemAddListener{
        public void NewItemAdd(String content);
    }
    //声明接口引用变量
    private OnNewItemAddListener onNewItemAddListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //要求该绑定的activity实现接口
        try{
            onNewItemAddListener = (OnNewItemAddListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implent OnNewItemAddListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_item_fragment,container,false);
        final EditText editText = (EditText)view.findViewById(R.id.exit_new_item);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        String conten = editText.getText().toString();
                        Toast.makeText(getActivity(),conten,3000).show();
                        onNewItemAddListener.NewItemAdd(conten);
                        editText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }
}
