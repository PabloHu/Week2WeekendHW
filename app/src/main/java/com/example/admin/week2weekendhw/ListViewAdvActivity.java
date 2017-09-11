package com.example.admin.week2weekendhw;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdvActivity extends ListActivity {
    List<ListViewObject> listViewObjectList = new ArrayList<ListViewObject>();
String [] TitleForArray;

    static final String[] MOBILE_OS = new String[] { "Android", "iOS",
            "WindowsMobile", "Blackberry"};
    static final String TAG = "MainActivityTAG";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListViewObject listViewObject = new ListViewObject();


        for (int i = 0; i < MOBILE_OS.length ; i++) {

            listViewObject = new ListViewObject();
            listViewObject.setId(i);
            listViewObject.setFavorite(false);
            listViewObject.setName(MOBILE_OS[i].toString());
            listViewObject.setIcon("R.drawable.boa_icon");
            listViewObjectList.add(listViewObject);

        }

        for (int i = 0; i <listViewObjectList.size(); i++) {

            Log.d(TAG, "onCreate: "+listViewObjectList.get(i).getName().toString());

        }

        setListAdapter(new MobileArrayAdapter(this,MOBILE_OS, listViewObjectList ));


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();




    }

}