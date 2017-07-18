package com.example.sb823249.autolisttest;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity{

    DBTools dbTools;
    RadioGroup radioGroup;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbTools = new DBTools(this);
        ArrayList<String> theQuestions = dbTools.theHeadings();
        ArrayList<HashMap<String, String>> theStuff = new ArrayList<>();
        for (int a = 0; a < theQuestions.size(); a++){
            HashMap<String, String> eachQuestion = new HashMap<>();
            eachQuestion.put("question", theQuestions.get(a));
            ArrayList<String> answers = dbTools.theOptions(theQuestions.get(a));
            for (int b = 0; b < answers.size(); b++){
                eachQuestion.put("" + b + "", answers.get(b));
            }
            theStuff.add(eachQuestion);
        }

        

        //if (theStuff.size() != 0){
        //    ListView listView = getListView();
        //
        //}
        //if (theQuestions.size() != 0) {
        //    ListView listView = getListView();
        //    ListAdapter adapter = new SimpleAdapter(MainActivity.this, theQuestions, )
       // }
    }
}
