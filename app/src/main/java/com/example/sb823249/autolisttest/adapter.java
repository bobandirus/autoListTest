package com.example.sb823249.autolisttest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sb823249 on 21/07/2017.
 */

public class adapter extends ArrayAdapter<HashMap<String, String>>{
    public adapter( ArrayList<HashMap<String, String>> resource, Context context) {
        super(context, R.layout.entry, resource);
    }

    private static class ViewHolder {
        TextView question;
        RadioGroup options;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        HashMap<String, String> theData = getItem(position);

        ViewHolder viewHolder;

        final View result;

        radioButtonSetMaker radioButtonSet = new radioButtonSetMaker();

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.entry, parent, false);
            viewHolder.question = (TextView) convertView.findViewById(R.id.question);
            viewHolder.options = (RadioGroup) convertView.findViewById(R.id.radioGroup);
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        ArrayList<String> options = new ArrayList<>();
        Iterator iterator = theData.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            if (key.equals("question")){
                viewHolder.question.setText(theData.get("question"));
            } else {
                String value = (String)theData.get(key);
                options.add(value);
            }
        }
        //RadioGroup buttons = radioButtonSet.(options);
        //viewHolder.options = radioButtonSet.radioButtonSetMaker(options);
        //viewHolder.question.setText();
        //RadioButton[] tempButtons = radioButtonSet.radioGroup(options);
        //viewHolder.options.addView(radioButtonSet.radioGroup(options));
        //viewHolder.options.addView(tempButtons);
        //for (int a = 0; a < tempButtons.length; a++){
        //    viewHolder.options.addView(tempButtons[a]);
        //}
        viewHolder.options.addView(radioButtonMaker(options));
        return convertView;
    }

    private RadioGroup radioButtonMaker(ArrayList<String> options){
        //final ArrayList<RadioButton> radioButtons = new ArrayList<>();
        final RadioButton[] radioButtons = new RadioButton[options.size()];
        RadioGroup radioGroup = new RadioGroup(getContext());
        radioGroup.setOrientation(RadioGroup.VERTICAL);
        for (int a = 0; a < options.size(); a++){
            System.out.print("radioButtonMaker: " + options.get(a) + "");
            radioButtons[a] = new RadioButton(getContext());
            radioGroup.addView(radioButtons[a]);
            radioButtons[a].setText(options.get(a));
        }
        return radioGroup;
    }
}
