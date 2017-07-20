package com.example.sb823249.autolisttest;

import android.app.ListActivity;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends ListActivity{

    DBTools dbTools;
    radioButtonSetMaker radioButtonSet;
    RadioGroup radioGroup;
    SimpleCursorAdapter adapter;
    private static final ArrayList<HashMap<String, String>> theStuff = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView = (ListView) findViewById(R.id.list);
        dbTools = new DBTools(this);
        radioButtonSet = new radioButtonSetMaker();
        ArrayList<String> theQuestions = dbTools.theHeadings();
        //ArrayList<HashMap<String, String>>
                //theStuff = new ArrayList<>();
        for (int a = 0; a < theQuestions.size(); a++){
            HashMap<String, String> eachQuestion = new HashMap<>();
            eachQuestion.put("question", theQuestions.get(a));
            //Check to see that the headings are retreived.
            //they are
            //Toast.makeText(getApplicationContext(), "column: " + theQuestions.get(a) + "", Toast.LENGTH_SHORT).show();
            ArrayList<String> answers = dbTools.theOptions(theQuestions.get(a));
            for (int b = 0; b < answers.size(); b++){
                //another data getting check
                //Toast.makeText(getApplicationContext(), "answer: "+answers.get(b) + "", Toast.LENGTH_SHORT).show();
                eachQuestion.put("" + b + "", answers.get(b));
            }
            theStuff.add(eachQuestion);
        }
        //manually adding a question to ensure that there's somethign in teh list
        HashMap<String, String> finalBit = new HashMap<>();
        finalBit.put("question", "finalQuestion");
        finalBit.put("0", "finalAnswer");
        theStuff.add(finalBit);
        setListAdapter(new cleverAdapter());



        //if (theStuff.size() != 0){
        //    ListView listView = getListView();
        //
        //}
        //if (theQuestions.size() != 0) {
        //    ListView listView = getListView();
        //    ListAdapter adapter = new SimpleAdapter(MainActivity.this, theQuestions, )
       // }
    }

    class cleverAdapter extends ArrayAdapter<String>{
        cleverAdapter(){
            super(MainActivity.this, R.layout.entry, R.id.qestion);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View row = super.getView(position, convertView, parent);

            Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();

            for (int a = 0; a < theStuff.size(); a++) {
                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                HashMap<String, String> data = theStuff.get(a);
                //View row = super.getView(position, convertView, parent);
                Iterator iterator = data.keySet().iterator();
                ArrayList<String> options = new ArrayList<>();
                while (iterator.hasNext()){
                    String key = (String)iterator.next();
                    Toast.makeText(getApplicationContext(), "key: " + key + "", Toast.LENGTH_SHORT).show();
                    if (key.equals("question")){
                        TextView question = (TextView) findViewById(R.id.qestion);
                        question.setText(data.get("question"));
                    } else {
                        String value = (String)data.get(key);
                        options.add(value);
                    }
                }
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                //radioGroup.setOrientation(RadioGroup.VERTICAL);
                //ArrayList<RadioButton> radioButtonsList = new ArrayList<>();
                //final RadioButton[] radioButtonsList = new RadioButton[options.size()];
                //for (int b = 0; b < options.size(); b++){
                //    radioButtonsList[b] = new RadioButton(this);
                //}
                RadioGroup buttons = radioButtonSet.radioGroup(options);
                //radioGroup = radioButtonSet.radioGroup(options);
                radioGroup.addView(buttons);

            }
            return row;
        }
    }
}
