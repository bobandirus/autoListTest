package com.example.sb823249.autolisttest;

import android.app.ListActivity;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class MainActivity extends AppCompatActivity{

    DBTools dbTools;
    radioButtonSetMaker radioButtonSet;
    RadioGroup radioGroup;
    SimpleCursorAdapter adapter;
    public static final ArrayList<HashMap<String, String>> theStuff = new ArrayList<>();
    //public static final HashMap<Stri>
    private static adapter cleverAdapter;
    //private static CustomAdaptor

    //this feels like a hack
    //public static final ArrayList<HashMap<String, String>> questions = new ArrayList<>();
    //public static final ArrayList<HashMap<String, RadioButton[]>> theAnswers = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView = (ListView) findViewById(R.id.list);
        dbTools = new DBTools(this);
        radioButtonSet = new radioButtonSetMaker();
        ArrayList<String> theQuestions = dbTools.theHeadings();
        listView = (ListView) findViewById(R.id.list);
        //ArrayList<HashMap<String, String>>
                //theStuff = new ArrayList<>();
        for (int a = 0; a < theQuestions.size(); a++){
            if (theQuestions.get(a).equals(String.valueOf("specificId"))){
                //Toast.makeText(getApplicationContext(), "horray", Toast.LENGTH_SHORT).show();
            } else {
                HashMap<String, String> eachQuestion = new HashMap<>();
                eachQuestion.put("question", theQuestions.get(a));
                //Check to see that the headings are retreived.
                //they are
                //Toast.makeText(getApplicationContext(), "column: " + theQuestions.get(a) + " number: " + a + "", Toast.LENGTH_SHORT).show();
                ArrayList<String> answers = dbTools.theOptions(theQuestions.get(a));
               // RadioButton[] temp = radioButtonSet.radioGroup(answers);

                for (int b = 0; b < answers.size(); b++) {
                    //another data getting check
                    //Toast.makeText(getApplicationContext(), "The question: " + theQuestions.get(a) + "number :" + a + "answer: " + answers.get(b) + " number: " + b + "", Toast.LENGTH_SHORT).show();
                    System.out.print("The question: " + theQuestions.get(a) + "number :" + a + "answer: " + answers.get(b) + " number: " + b + "\r\n");
                    eachQuestion.put("" + b + "", answers.get(b));
                }
                theStuff.add(eachQuestion);


                ///**HashMap<String, String> eachQuestion = new HashMap<>();
                //HashMap<String, RadioButton[]> eachAnswerSet = new HashMap<>();
                //eachQuestion.put("question", theQuestions.get(a));
                //ArrayList<String> answers = dbTools.theOptions(theQuestions.get(a));
                //RadioButton[] temp = radioButtonSet.radioGroup(answers);
                //questions.add(eachQuestion);
                //theAnswers.add(eachAnswerSet);**/
            }
        }
        //theAnswers = new HashMap<>()
        //manually adding a question to ensure that there's somethign in teh list
        //HashMap<String, String> finalBit = new HashMap<>();
        //finalBit.put("question", "finalQuestion");
        //finalBit.put("0", "finalAnswer");
        //theStuff.add(finalBit);
        cleverAdapter = new adapter(theStuff, getApplicationContext());
        //cleverAdapter = new adapter(questions, theAnswers, getApplicationContext());
        //setListAdapter(new cleverAdapter());
        listView.setAdapter(cleverAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.print("jkl");
                Toast.makeText(getApplicationContext(), "hello there", Toast.LENGTH_SHORT).show();
            }
        });


        //if (theStuff.size() != 0){
        //    ListView listView = getListView();
        //
        //}
        //if (theQuestions.size() != 0) {
        //    ListView listView = getListView();
        //    ListAdapter adapter = new SimpleAdapter(MainActivity.this, theQuestions, )
       // }
    }

    public void results(View view){
        String temp = cleverAdapter.theSearchQuery();
        Toast.makeText(getApplicationContext(), "" + temp + "", Toast.LENGTH_SHORT).show();
    }





    /**
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
     **/
}
