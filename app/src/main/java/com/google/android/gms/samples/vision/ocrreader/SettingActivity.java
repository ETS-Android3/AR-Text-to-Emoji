package com.google.android.gms.samples.vision.ocrreader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * File added by Tia Chapple
 * Last Modified by Tia Chapple 04/11/21
 */

public class SettingActivity extends AppCompatActivity {

    // Adds previous setting options to display
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Button boxWhite = findViewById(R.id.smallButton);
        Button boxBlack = findViewById(R.id.blackBox);
        Button boxGreen = findViewById(R.id.greenBox);
        Button boxBlue = findViewById(R.id.pinkBox);
        Button allExample = findViewById(R.id.exampleAll);
        Button boxExample = findViewById(R.id.boxExample);
        Button txtWhite = findViewById(R.id.whiteTxt);
        Button txtBlack = findViewById(R.id.blackTxt);
        Button txtGreen = findViewById(R.id.greenTxt);
        Button txtBlue = findViewById(R.id.pinkTxt);
        TextView txtExample = findViewById(R.id.textView);

        boxWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        boxBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        boxGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        txtWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        txtBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        txtGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setTextColor(Color.parseColor( "#003300"));
        boxExample.setTextColor(Color.parseColor( "#003300"));
        int box_colour_int = sharedPreferences.getInt("box_colour", 0);
        int txt_colour_int = sharedPreferences.getInt("txt_colour", 1);
        if(box_colour_int == 0){
            boxWhite.setBackground(getResources().getDrawable(R.drawable.white_on));
            allExample.setBackground(getResources().getDrawable(R.drawable.white_off));
            boxExample.setBackground(getResources().getDrawable(R.drawable.white_off));
        }else if(box_colour_int == 1){
            boxBlack.setBackground(getResources().getDrawable(R.drawable.black_on));
            allExample.setBackground(getResources().getDrawable(R.drawable.black_off));
            boxExample.setBackground(getResources().getDrawable(R.drawable.black_off));
        }else if(box_colour_int == 2){
            boxGreen.setBackground(getResources().getDrawable(R.drawable.green_on));
            allExample.setBackground(getResources().getDrawable(R.drawable.green_off));
            boxExample.setBackground(getResources().getDrawable(R.drawable.green_off));
        }else if(box_colour_int == 3){
            boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_on));
            allExample.setBackground(getResources().getDrawable(R.drawable.pink_off));
            boxExample.setBackground(getResources().getDrawable(R.drawable.pink_off));
        }

        if(txt_colour_int == 0){
            txtWhite.setBackground(getResources().getDrawable(R.drawable.white_on));
            allExample.setTextColor(Color.parseColor( "#FFFFFF"));
            txtExample.setTextColor(Color.parseColor( "#FFFFFF"));
        }else if(txt_colour_int == 1){
            txtBlack.setBackground(getResources().getDrawable(R.drawable.black_on));
            allExample.setTextColor(Color.parseColor( "#000000"));
            txtExample.setTextColor(Color.parseColor( "#000000"));
        }else if(txt_colour_int == 2){
            txtGreen.setBackground(getResources().getDrawable(R.drawable.green_on));
            allExample.setTextColor(Color.parseColor( "#003300"));
            txtExample.setTextColor(Color.parseColor( "#003300"));
        }else if(txt_colour_int == 3){
            txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_on));
            allExample.setTextColor(Color.parseColor( "#FF00FF"));
            txtExample.setTextColor(Color.parseColor( "#FF00FF"));
        }

    }

    // Go to first settings page
    public void backtofirstSettings(View view) {
        startActivity(new Intent(SettingActivity.this, MainSettings.class));
        finish();
    }

    // Set box colour to white
    public void whiteBox(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("box_colour", 0);
        myEdit.apply();
        Button boxWhite = findViewById(R.id.smallButton);
        Button boxBlack = findViewById(R.id.blackBox);
        Button boxGreen = findViewById(R.id.greenBox);
        Button boxBlue = findViewById(R.id.pinkBox);
        Button allExample = findViewById(R.id.exampleAll);
        Button boxExample = findViewById(R.id.boxExample);
        boxWhite.setBackground(getResources().getDrawable(R.drawable.white_on));
        boxBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        boxGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setBackground(getResources().getDrawable(R.drawable.white_off));
        boxExample.setBackground(getResources().getDrawable(R.drawable.white_off));
    }

    // Set box colour to black
    public void blackBox(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("box_colour", 1);
        myEdit.apply();
        Button boxWhite = findViewById(R.id.smallButton);
        Button boxBlack = findViewById(R.id.blackBox);
        Button boxGreen = findViewById(R.id.greenBox);
        Button boxBlue = findViewById(R.id.pinkBox);
        Button allExample = findViewById(R.id.exampleAll);
        Button boxExample = findViewById(R.id.boxExample);
        boxWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        boxBlack.setBackground(getResources().getDrawable(R.drawable.black_on));
        boxGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setBackground(getResources().getDrawable(R.drawable.black_off));
        boxExample.setBackground(getResources().getDrawable(R.drawable.black_off));
    }

    // Set box colour to green
    public void greenBox(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("box_colour", 2);
        myEdit.apply();
        Button boxWhite = findViewById(R.id.smallButton);
        Button boxBlack = findViewById(R.id.blackBox);
        Button boxGreen = findViewById(R.id.greenBox);
        Button boxBlue = findViewById(R.id.pinkBox);
        Button allExample = findViewById(R.id.exampleAll);
        Button boxExample = findViewById(R.id.boxExample);
        boxWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        boxBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        boxGreen.setBackground(getResources().getDrawable(R.drawable.green_on));
        boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setBackground(getResources().getDrawable(R.drawable.green_off));
        boxExample.setBackground(getResources().getDrawable(R.drawable.green_off));

    }

    // Set box colour to pink
    public void pinkBox(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("box_colour", 3);
        myEdit.apply();
        Button boxWhite = findViewById(R.id.smallButton);
        Button boxBlack = findViewById(R.id.blackBox);
        Button boxGreen = findViewById(R.id.greenBox);
        Button boxBlue = findViewById(R.id.pinkBox);
        Button allExample = findViewById(R.id.exampleAll);
        Button boxExample = findViewById(R.id.boxExample);
        boxWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        boxBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        boxGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        boxBlue.setBackground(getResources().getDrawable(R.drawable.pink_on));
        allExample.setBackground(getResources().getDrawable(R.drawable.pink_off));
        boxExample.setBackground(getResources().getDrawable(R.drawable.pink_off));
    }

    // Set text colour to white
    public void whiteTxt(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("txt_colour", 0);
        myEdit.apply();
        Button txtWhite = findViewById(R.id.whiteTxt);
        Button txtBlack = findViewById(R.id.blackTxt);
        Button txtGreen = findViewById(R.id.greenTxt);
        Button txtBlue = findViewById(R.id.pinkTxt);
        TextView allExample = findViewById(R.id.textView);
        Button boxExample = findViewById(R.id.exampleAll);
        txtWhite.setBackground(getResources().getDrawable(R.drawable.white_on));
        txtBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        txtGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setTextColor(Color.parseColor( "#FFFFFF"));
        boxExample.setTextColor(Color.parseColor( "#FFFFFF"));
    }

    // Set text colour black white
    public void blackTxt(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("txt_colour", 1);
        myEdit.apply();
        Button txtWhite = findViewById(R.id.whiteTxt);
        Button txtBlack = findViewById(R.id.blackTxt);
        Button txtGreen = findViewById(R.id.greenTxt);
        Button txtBlue = findViewById(R.id.pinkTxt);
        TextView allExample = findViewById(R.id.textView);
        Button boxExample = findViewById(R.id.exampleAll);
        txtWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        txtBlack.setBackground(getResources().getDrawable(R.drawable.black_on));
        txtGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setTextColor(Color.parseColor( "#000000"));
        boxExample.setTextColor(Color.parseColor( "#000000"));
    }

    // Set text colour to green
    public void greenTxt(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("txt_colour", 2);
        myEdit.apply();
        Button txtWhite = findViewById(R.id.whiteTxt);
        Button txtBlack = findViewById(R.id.blackTxt);
        Button txtGreen = findViewById(R.id.greenTxt);
        Button txtBlue = findViewById(R.id.pinkTxt);
        TextView allExample = findViewById(R.id.textView);
        Button boxExample = findViewById(R.id.exampleAll);
        txtWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        txtBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        txtGreen.setBackground(getResources().getDrawable(R.drawable.green_on));
        txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_off));
        allExample.setTextColor(Color.parseColor( "#003300"));
        boxExample.setTextColor(Color.parseColor( "#003300"));
    }

    // Set text colour to pink
    public void pinkTxt(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("txt_colour", 3);
        myEdit.apply();
        Button txtWhite = findViewById(R.id.whiteTxt);
        Button txtBlack = findViewById(R.id.blackTxt);
        Button txtGreen = findViewById(R.id.greenTxt);
        Button txtBlue = findViewById(R.id.pinkTxt);
        TextView allExample = findViewById(R.id.textView);
        Button boxExample = findViewById(R.id.exampleAll);
        txtWhite.setBackground(getResources().getDrawable(R.drawable.white_off));
        txtBlack.setBackground(getResources().getDrawable(R.drawable.black_off));
        txtGreen.setBackground(getResources().getDrawable(R.drawable.green_off));
        txtBlue.setBackground(getResources().getDrawable(R.drawable.pink_on));
        allExample.setTextColor(Color.parseColor( "#FF00FF"));
        boxExample.setTextColor(Color.parseColor( "#FF00FF"));
    }


}