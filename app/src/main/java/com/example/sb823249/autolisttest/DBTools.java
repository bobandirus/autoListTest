package com.example.sb823249.autolisttest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sb823249 on 18/07/2017.
 */

public class DBTools extends SQLiteOpenHelper{
    public DBTools (Context application){
        super(application, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String createDatabase = "CREATE TABLE food (specificId INGEGER PRIMARY KEY, name TEXT, good_breakfast TEXT, best_sauce TEXT, favourite_plant_type TEXT)";
        database.execSQL(createDatabase);
        String insert_1  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (7, 'werdna', 'sgge', 'oyam', 'dihcro')";
        database.execSQL(insert_1);
        String insert_2  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (2, 'ayiwzs', 'nocab', 'oyam', 'chilli')";
        database.execSQL(insert_2);
        String insert_3  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (3, 'nadroj', 'sgge', 'qbb', 'sffad')";
        database.execSQL(insert_3);
        String insert_4  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (4, 'airam', 'seotamot', 'oyam', 'selppa')";
        database.execSQL(insert_4);
        String insert_5  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (5, 'namlak', 'seotamot', 'oyam', 'arennug')";
        database.execSQL(insert_5);
        String insert_6  =  "INSERT INTO food (specificId, name, good_breakfast, best_sauce, favourite_plant_type) values (6, 'riatsala', 'sgge', 'puhctek', 'spartylf')";
        database.execSQL(insert_6);

        /**String createDatabase = "CREATE TABLE fernsTest (specificId INGEGER PRIMARY KEY, Species TEXT, ridge_shape TEXT, cone_location TEXT, cone_tip_shape TEXT, sheeth_colour TEXT, Teeth_shape TEXT, teeth_colour TEXT, normal_stem_colour TEXT, fertile_stem_colour TEXT, first_internode_relative_to_sheath_length_ TEXT, border_width TEXT)";
        database.execSQL(createDatabase);
        String insert_1  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (1, 'elameyh', 'delgna2', 'stoohsetatigevlamron', 'etalucipa', 'mottobdnapottadnabkcalbhtiwhsietihw', 'egasaffonellafotdnuordnallams', 'kcalb', 'neergeulb', 'neergeulb', 'sehcnarbon', 'enon')";database.execSQL(insert_1); String insert_2  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (2, 'ieroomx', 'delgna2', 'stoohsetatigevlamron', 'etalucipa', 'mottobdnapottadnabkcalbhtiwhsietihw', 'thgiartsworran', 'kcalb', 'neergwolley', 'neergwolley', 'sehcnarbon', 'worranotenon')";database.execSQL(insert_2); String insert_3  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (3, 'nodoyhcartx', 'delgna2yletuca', 'stoohsetatigevlamron', 'etalucipa', 'mottobdnapottadnabkcalbhtiwhsietihw', 'gnirepatdnagnol', 'kcalb', 'tnitegnaroneergkrad', 'tnitegnaroneergkrad', 'sehcnarbon', 'ediwotenon')";database.execSQL(insert_3); String insert_4  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (4, 'mumissisomar', 'dednuor', 'stoohsetatigevlamron', 'etalucipaotesutbo', 'mottobtadnabkradhtiwnworbgnimocebneerg', 'gnoldnaworran', 'redrobelaphtiwkcalb', 'neerg', 'neerg', 'retrohs', 'worran')";database.execSQL(insert_4); String insert_5  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (5, 'mutageirav', 'delgna2', 'stoohsetatigevlamron', 'etalucipayltnulb', 'xepatadnabkcalbhtiwneerg', 'trohsdnaralugnairt', 'birdimkcalbredrobelapdaorb', 'neergeulb', 'neergeulb', 'regnolotemas', 'ediw')";database.execSQL(insert_5); String insert_6  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (6, 'elitaivulf', 'wolyrev', 'stoohsevitatigevdehcnarbsselretrohs', 'dednuor', 'metsotesolcneerg', 'trohsdnaralugnairt', 'spitkcalb', 'wolleyneerg', 'wolleyneerg', 'emasotretrohs', 'worran')";database.execSQL(insert_6); String insert_7  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (7, 'elarotilx', 'wol', 'stoohsetatigevlamron', 'dednuor', 'xepatakcalbhteetdnaesoolneerg', 'trohsdnaralugnairt', 'spitkcalb', 'egnaroneergwolleyyssolg', 'egnaroneergwolleyyssolg', 'regnol', 'worran')";database.execSQL(insert_7); String insert_8  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (8, 'esnevra', 'dednuor', 'smetsnworbdehcnarbnulaiceps', 'dednuor', 'neerg', 'trohsdnaralugnairt', 'snigramelaponspitkcalb', 'etihwotneerg', 'knipotetihwyrovi', 'regnol', 'worran')";database.execSQL(insert_8); String insert_9  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (9, 'esnetarp', 'dednuor', 'stoohselapretrohs', 'dednuor', 'neergyltsom', 'thgiartsdnaenif', 'redrobelapelbaciton', 'neerg', 'relap', 'emasotretrohs', 'worran')";database.execSQL(insert_9); String insert_10  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (10, 'mucitavlys', 'deppot-talf', 'stoohselapretrohs', 'dednuor', 'wolebneerg', 'enigramsuonarbmemhtiwgnol', 'rehtegotgnikcitsoteudypirtsraepparedrobelapdaorb', 'neergelap', 'rekcihtdnarelap', 'regnol', 'ediw')";database.execSQL(insert_10); String insert_11  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (11, 'ertsulap', 'dednuor', 'stoohsevitatigevdehcnarbsselretrohs', 'dednuor', 'esooldnaneerg', 'ralugnairtworran', 'redrobelapelbaciton', 'eergdim', 'neergdim', 'retrohs', 'ediw')";database.execSQL(insert_11); String insert_12  =  "INSERT INTO fernsTest (specificId, Species, ridge_shape, cone_location, cone_tip_shape, sheeth_colour, Teeth_shape, teeth_colour, normal_stem_colour, fertile_stem_colour, first_internode_relative_to_sheath_length_, border_width) values (12, 'aietamlet', 'wolyrev', 'smetsnworbdehcnarbnulaiceps', 'dednuor', 'pottakradwolebelap', 'rednelsdnagnol', 'krad', 'etihwyrovi', 'nworb', 'retrohs', 'ediw')";database.execSQL(insert_12);
    **/}

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS food";
        db.execSQL(query);
        onCreate(db);
    }

    public ArrayList<String> theHeadings(){
      ArrayList<String> theHeadings = new ArrayList<>();
        //String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'food' ORDER BY ORDINAL_POSITION";
       // String query = "SELECT COLUMN_NAME FROM 'food'";
       String query = "PRAGMA table_info(food)";
        //String query = "PRAGMA column_info(food)";
        //String query = "SELECT sql FROM sqlite_master WHERE tbl_name = 'food' AND type = 'table'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                //ArrayList<String> names = new ArrayList<>();
                //getting string one, because the sql command gets and array of options, and the column name is help as string one
                String name = new StringBuilder(cursor.getString(1)).toString();
                theHeadings.add(name);
            }while (cursor.moveToNext());

            /**do {
             String[] names = new String[0];
             String name = new StringBuilder(cursor.getString)
             }**/
        }
        return theHeadings;
    }

    public ArrayList<String> theOptions(String column){
        ArrayList<String> theOptions = new ArrayList<>();
        String query = "SELECT DISTINCT " + column + " FROM food";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                String name = new StringBuilder(cursor.getString(0)).reverse().toString();
                theOptions.add(name);
            }while (cursor.moveToNext());
        }
        //to hopefully ensure that the check at the main activity has somethign to find
        //it does, and it finds this.
        //String extra = "extra";
        //theOptions.add(extra);
        return theOptions;
    }


}
