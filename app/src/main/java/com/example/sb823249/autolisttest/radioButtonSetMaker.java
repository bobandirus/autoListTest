package com.example.sb823249.autolisttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by sb823249 on 19/07/2017.
 */

public class radioButtonSetMaker extends AppCompatActivity{

    public void radioButtonSetMaker(Context application){
        //super(application, null, null, ){
        //
        //}
    }

    public void onCreate(){

    }

    //public RadioButton[] radioButtonArray(ArrayList<String> options){
    //
    //}

    public RadioGroup radioGroup (ArrayList<String> options){
        RadioGroup temp = new RadioGroup(this);
        temp.setOrientation(RadioGroup.VERTICAL);
        RadioButton[] tempButtons = new RadioButton[options.size()];
        for (int a = 0; a < options.size(); a++){
            tempButtons[a] = new RadioButton(this);
            temp.addView(tempButtons[a]);
            tempButtons[a].setText(options.get(a));
        }
        return temp;
    }

}
