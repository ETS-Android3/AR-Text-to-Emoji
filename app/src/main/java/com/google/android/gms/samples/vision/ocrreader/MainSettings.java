package com.google.android.gms.samples.vision.ocrreader;

/**
    * File added by Tia Chapple
    * Last Modified by Tia Chapple 04/11/21
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSettings extends AppCompatActivity {

    // Adds previous setting options to display
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int text_state_int = sharedPreferences.getInt("text_state", 1);
        Button btnTextSmall = findViewById(R.id.smallButton);
        Button btnTextMedium = findViewById(R.id.mediumlButton);
        Button btnTextLarge = findViewById(R.id.largeButton);

        if (text_state_int == 0) {
            btnTextSmall.setBackground(getResources().getDrawable(R.drawable.button_on));
            btnTextMedium.setBackground(getResources().getDrawable(R.drawable.button_off));
            btnTextLarge.setBackground(getResources().getDrawable(R.drawable.button_off));
        } else if (text_state_int == 1) {
            btnTextSmall.setBackground(getResources().getDrawable(R.drawable.button_off));
            btnTextMedium.setBackground(getResources().getDrawable(R.drawable.button_on));
            btnTextLarge.setBackground(getResources().getDrawable(R.drawable.button_off));
        } else if (text_state_int == 2) {
            btnTextSmall.setBackground(getResources().getDrawable(R.drawable.button_off));
            btnTextMedium.setBackground(getResources().getDrawable(R.drawable.button_off));
            btnTextLarge.setBackground(getResources().getDrawable(R.drawable.button_on));
        }

        Button btnfb = findViewById(R.id.button_around_fb);
        Button btnb = findViewById(R.id.button_around_b);
        Button btnNofb = findViewById(R.id.button_around_nofb);
        int fbstate = sharedPreferences.getInt("fill_border_state", 1);
        if (fbstate == 0) {
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnNofb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));
        } else if (fbstate == 1) {
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));
            btnNofb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
        }else if (fbstate == 2) {
            btnfb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));
            btnb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnNofb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
        }

        Button btnTBLine = findViewById(R.id.textBoundryLine);
        Button btnTxtPlay = findViewById(R.id.TextOnPlay);
        Button btnEBLine = findViewById(R.id.emojiBoundryLine);
        Button btnEmojiPlay = findViewById(R.id.EmojiOnPlay);
        boolean play_txt_state = sharedPreferences.getBoolean("text_on_play_state", true);
        boolean emoji_txt_state = sharedPreferences.getBoolean("emoji_on_play_state", false);
        if(play_txt_state) {
            btnTBLine.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnTxtPlay.setBackground(getResources().getDrawable(R.drawable.button_off));
        }else{
            btnTBLine.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnTxtPlay.setBackground(getResources().getDrawable(R.drawable.button_on));
            }
        if(emoji_txt_state) {
            btnEBLine.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnEmojiPlay.setBackground(getResources().getDrawable(R.drawable.button_off));
        }else{
            btnEBLine.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnEmojiPlay.setBackground(getResources().getDrawable(R.drawable.button_on));
        }

        Button btnTBLinePs = findViewById(R.id.textBoundryLine2);
        Button btnTxtPlayPs = findViewById(R.id.textOnPause);
        Button btnEBLinePs = findViewById(R.id.emojiBoundryLine2);
        Button btnEmojiPlayPs = findViewById(R.id.emojiOnPause);
        boolean pause_txt_state = sharedPreferences.getBoolean("text_on_pause_state", true);
        boolean pause_emoji_state = sharedPreferences.getBoolean("emoji_on_pause_state", false);
        if(pause_txt_state) {
            btnTBLinePs.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnTxtPlayPs.setBackground(getResources().getDrawable(R.drawable.button_off));
        }else{
            btnTBLinePs.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnTxtPlayPs.setBackground(getResources().getDrawable(R.drawable.button_on));
        }
        if(pause_emoji_state) {
            btnEBLinePs.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnEmojiPlayPs.setBackground(getResources().getDrawable(R.drawable.button_off));
        }else{
            btnEBLinePs.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnEmojiPlayPs.setBackground(getResources().getDrawable(R.drawable.button_on));
        }


    }

    // Go to second settings page
    public void toSecondSettings(View view) {
        startActivity(new Intent(MainSettings.this, SettingActivity.class));
        finish();
    }

    // Go back to main display
    public void backtomain(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        setContentView(R.layout.ocr_capture);
        Button btPause = findViewById(R.id.buttonPause);
        btPause.setBackground(getResources().getDrawable(R.drawable.pause2));
        OcrCaptureActivity.pressed = false;
        startActivity(new Intent(MainSettings.this, OcrCaptureActivity.class));
        finish();
    }

    // Change how the text appears when camera is on
    public void textOnPlayFn(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean txtOnPlay = sharedPreferences.getBoolean("text_on_play_state", true);
        if(txtOnPlay){
            myEdit.putBoolean("text_on_play_state", false);
            myEdit.apply();
            Button btnfb = findViewById(R.id.textBoundryLine);
            Button btnchange = findViewById(R.id.TextOnPlay);
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_on));
        }else {
            myEdit.putBoolean("text_on_play_state", true);
            myEdit.apply();
            Button btnfb = findViewById(R.id.textBoundryLine);
            Button btnchange = findViewById(R.id.TextOnPlay);
            btnfb.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    }

    // Change how the emoji appears when camera is on
    public void emojiOnPlayFn(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean emojiOnPlay = sharedPreferences.getBoolean("emoji_on_play_state", true);
        if(emojiOnPlay){
            myEdit.putBoolean("emoji_on_play_state", false);
            myEdit.apply();
            Button btnfb = findViewById(R.id.emojiBoundryLine);
            Button btnchange = findViewById(R.id.EmojiOnPlay);
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_on));
        }else {
            myEdit.putBoolean("emoji_on_play_state", true);
            myEdit.apply();
            Button btnfb = findViewById(R.id.emojiBoundryLine);
            Button btnchange = findViewById(R.id.EmojiOnPlay);
            btnfb.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    }

    // Change how the text appears when camera is paused
    public void textOnPauseFn(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean txtOnPlay = sharedPreferences.getBoolean("text_on_pause_state", true);
        if(txtOnPlay){
            myEdit.putBoolean("text_on_pause_state", false);
            myEdit.apply();
            Button btnfb = findViewById(R.id.textBoundryLine2);
            Button btnchange = findViewById(R.id.textOnPause);
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_on));
        }else {
            myEdit.putBoolean("text_on_pause_state", true);
            myEdit.apply();
            Button btnfb = findViewById(R.id.textBoundryLine2);
            Button btnchange = findViewById(R.id.textOnPause);
            btnfb.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    }

    // Change how the text appears when camera is paused
    public void emojiOnPauseFn(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        boolean emojiOnPause = sharedPreferences.getBoolean("emoji_on_pause_state", true);
        if(emojiOnPause){
            myEdit.putBoolean("emoji_on_pause_state", false);
            myEdit.apply();
            Button btnfb = findViewById(R.id.emojiBoundryLine2);
            Button btnchange = findViewById(R.id.emojiOnPause);
            btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_on));
        }else {
            myEdit.putBoolean("emoji_on_pause_state", true);
            myEdit.apply();
            Button btnfb = findViewById(R.id.emojiBoundryLine2);
            Button btnchange = findViewById(R.id.emojiOnPause);
            btnfb.setBackground(getResources().getDrawable(R.drawable.line_button));
            btnchange.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    }

    // Setting which allows user to select no box or border
    public void noBorderOrFill(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putInt("fill_border_state", 0);
        myEdit.apply();

        Button btnfb = findViewById(R.id.button_around_fb);
        btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));

        Button btnb = findViewById(R.id.button_around_b);
        btnb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));

        Button btnNofb = findViewById(R.id.button_around_nofb);
        btnNofb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));
    }

    // Setting which allows user to select border
    public void border(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putInt("fill_border_state", 1);
        myEdit.apply();

        Button btnfb = findViewById(R.id.button_around_fb);
        btnfb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));

        Button btnb = findViewById(R.id.button_around_b);
        btnb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));

        Button btnNofb = findViewById(R.id.button_around_nofb);
        btnNofb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
    }

    // Setting which allows user to select box and border
    public void borderOrFill(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putInt("fill_border_state", 2);
        myEdit.apply();

        Button btnfb = findViewById(R.id.button_around_fb);
        btnfb.setBackground(getResources().getDrawable(R.drawable.button_top_selected));

        Button btnb = findViewById(R.id.button_around_b);
        btnb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));

        Button btnNofb = findViewById(R.id.button_around_nofb);
        btnNofb.setBackground(getResources().getDrawable(R.drawable.no_backgroumd));
    }

    // Setting to set text and emojis to be small size
    public void smallText(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putInt("text_state", 0);
        myEdit.apply();

        Button smallBtn = findViewById(R.id.smallButton);
        smallBtn.setBackground(getResources().getDrawable(R.drawable.button_on));

        Button mediumBtn = findViewById(R.id.mediumlButton);
        mediumBtn.setBackground(getResources().getDrawable(R.drawable.button_off));

        Button largeBtn = findViewById(R.id.largeButton);
        largeBtn.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    // Setting to set text and emojis to be medium size
    public void mediumText(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putInt("text_state", 1);
        myEdit.apply();

        Button smallBtn = findViewById(R.id.smallButton);
        smallBtn.setBackground(getResources().getDrawable(R.drawable.button_off));

        Button mediumBtn = findViewById(R.id.mediumlButton);
        mediumBtn.setBackground(getResources().getDrawable(R.drawable.button_on));

        Button largeBtn = findViewById(R.id.largeButton);
        largeBtn.setBackground(getResources().getDrawable(R.drawable.button_off));
        }

    // Setting to set text and emojis to be large size
        public void largeText(View view) {
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            myEdit.putInt("text_state", 2);
            myEdit.apply();

            Button smallBtn = findViewById(R.id.smallButton);
            smallBtn.setBackground(getResources().getDrawable(R.drawable.button_off));

            Button mediumBtn = findViewById(R.id.mediumlButton);
            mediumBtn.setBackground(getResources().getDrawable(R.drawable.button_off));

            Button largeBtn = findViewById(R.id.largeButton);
            largeBtn.setBackground(getResources().getDrawable(R.drawable.button_on));
        }
    }
