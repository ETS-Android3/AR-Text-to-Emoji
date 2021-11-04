/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.gms.samples.vision.ocrreader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
//import com.vdurmont.emoji.Emoji;
//import com.vdurmont.emoji.EmojiManager;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.content.Context;
import android.app.Activity;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Last Modified by Tia Chapple 04/11/21
 */


/**
 * Graphic instance for rendering TextBlock position, size, and ID within an associated graphic
 * overlay view.
 */
public class OcrGraphic extends GraphicOverlay.Graphic {
    private Context mContext;

    private int id;

    private static final int TEXT_COLOR = Color.WHITE;

    private static Paint rectPaint;
    private static Paint textPaint;
    private final TextBlock textBlock;
    private static Boolean rectBool;

    OcrGraphic(GraphicOverlay overlay, TextBlock text) {
        super(overlay);
        this.mContext = overlay.getContext();
        textBlock = text;

        //Grab user preferences and apply them to text and boxes
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("MySharedPref",MODE_PRIVATE);

        int fill_box_state_int = sharedPreferences.getInt("fill_border_state",1);
        int box_colour_int = sharedPreferences.getInt("box_colour",0);
        int txt_color_int = sharedPreferences.getInt("txt_colour",1);

        int TXT_COLOR = Color.parseColor( "#FFFFFF");
        int BOX_COLOR = Color.parseColor("#FFFFFF");

        if(box_colour_int ==0){
            BOX_COLOR = Color.parseColor("#FFFFFF");
        }else if(box_colour_int == 1){
            BOX_COLOR = Color.parseColor("#000000");
        }else if(box_colour_int ==2){
            BOX_COLOR = Color.parseColor("#003300");
        }else if(box_colour_int == 3){
            BOX_COLOR = Color.parseColor("#FF00FF");
        }

        if(txt_color_int ==0){
            TXT_COLOR = Color.parseColor("#FFFFFF");
        }else if(txt_color_int == 1){
            TXT_COLOR = Color.parseColor("#000000");
        }else if(txt_color_int ==2){
            TXT_COLOR = Color.parseColor("#003300");
        }else if(txt_color_int == 3){
            TXT_COLOR = Color.parseColor("#FF00FF");
        }

        rectPaint = new Paint();
        if(fill_box_state_int == 2){
            rectPaint.setColor(BOX_COLOR);
            rectPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            rectPaint.setStrokeWidth(6.0f);
            rectBool = true;
        } else if(fill_box_state_int == 1){
            rectPaint.setColor(BOX_COLOR);
            rectPaint.setStyle(Paint.Style.STROKE);
            rectPaint.setStrokeWidth(6.0f);
            rectBool = true;
        } else if(fill_box_state_int == 0) {
            rectBool = false;
        }

            textPaint = new Paint();
            textPaint.setColor(TXT_COLOR);

            int text_state_int = sharedPreferences.getInt("text_state",4);
            if(text_state_int == 2){
                Log.d("TAG", "OcrGraphic: 0");
                textPaint.setTextSize(78.0f);
            } else if(text_state_int == 1){
                Log.d("TAG", "OcrGraphic: 1");
                textPaint.setTextSize(54.0f);
            } else if(text_state_int == 0) {
                Log.d("TAG", "OcrGraphic: 2");
                textPaint.setTextSize(30.0f);
            } else {
                Log.d("TAG", "OcrGraphic: Else");
                textPaint.setTextSize(54.0f);
            }
//        }
        // Redraw the overlay, as this graphic has been added.
        postInvalidate();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextBlock getTextBlock() {
        return textBlock;
    }

    /**
     * Checks whether a point is within the bounding box of this graphic.
     * The provided point should be relative to this graphic's containing overlay.
     * @param x An x parameter in the relative context of the canvas.
     * @param y A y parameter in the relative context of the canvas.
     * @return True if the provided point is contained within this graphic's bounding box.
     */
    public boolean contains(float x, float y) {
        if (textBlock == null) {
            return false;
        }
        RectF rect = new RectF(textBlock.getBoundingBox());
        rect = translateRect(rect);
        return rect.contains(x, y);
    }

    static Integer count = 0;
    static final String checkConvertEmoji(String emoji, Context context){

        //Grab user preferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref",MODE_PRIVATE);
        boolean txt_play_state = sharedPreferences.getBoolean("text_on_play_state",true);
        boolean emoji_play_state = sharedPreferences.getBoolean("emoji_on_play_state",false);
        boolean txt_pause_state = sharedPreferences.getBoolean("text_on_pause_state",false);
        boolean emoji_pause_state = sharedPreferences.getBoolean("emoji_on_pause_state",true);

        Emoji word = EmojiManager.getForAlias(emoji.toLowerCase());
        Emoji word_s = EmojiManager.getForAlias(emoji.substring(0, emoji.length() - 1).toLowerCase());
        boolean press = OcrCaptureActivity.pressed;

        // Apply user settings
        if(!press) {
            if(!txt_play_state && !emoji_play_state){
                if (word != null) {
                    return word.getUnicode();
                }else if (word_s != null){
                    return word_s.getUnicode();
                }else {
                return emoji.replace("_", " ");
                }
            }else if(!txt_play_state){
                return emoji.replace("_", " ");
            }else if(!emoji_play_state){
                if (word != null) {
                    return word.getUnicode();
                }else if (word_s != null){
                    return word_s.getUnicode();
                }else {
                    return "";
                }
            }else{
                return "";
            }
        } else {
            if(!txt_pause_state && !emoji_pause_state){
                if (word != null) {
                    return word.getUnicode();
                }else if (word_s != null){
                    return word_s.getUnicode();
                }else {
                    return emoji.replace("_", " ");
                }
            }else if(!txt_pause_state){
                return emoji.replace("_", " ");
            }else if(!emoji_pause_state){
                if (word != null) {
                    return word.getUnicode();
                }else if (word_s != null){
                    return word_s.getUnicode();
                }else {
                    return "";
                }
            }else{
                return "";
            }
        }

    }


    /**
     * Draws the text block annotations for position, size, and raw value on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        if (textBlock == null) {
            return;
        }
        if(rectBool == true){
            // Draws the bounding box around the TextBlock.
            RectF rect = new RectF(textBlock.getBoundingBox());
            rect = translateRect(rect);
            canvas.drawRect(rect, rectPaint);
        }


        // Break the text into multiple lines and draw each one according to its own bounding box.
        List<? extends Text> textComponents = textBlock.getComponents();
        for(Text currentText : textComponents) {
            float left = translateX(currentText.getBoundingBox().left);
            float bottom = translateY(currentText.getBoundingBox().bottom);
            String[] text = currentText.getValue().split(" ");
            StringBuilder testString = new StringBuilder();
            for (String t : text){
                testString.append(t);
                testString.append("_");
            }
            testString.deleteCharAt(testString.length()-1);
            if(EmojiManager.getForAlias(testString.toString().toLowerCase()) != null){
                String convert_string = checkConvertEmoji(testString.toString(), mContext);
                canvas.drawText(convert_string, left, bottom, textPaint);
            }else {
                ArrayList<String> newText = new ArrayList<String>();
                for (String current : text) {
                    String convert_word = checkConvertEmoji(current, mContext);
                    count = count + 1;
                    newText.add(convert_word);
                }
                StringBuilder listString = new StringBuilder();
                for (String s : newText) {
                    listString.append(s);
                    listString.append("\t");
                }
                canvas.drawText(listString.toString(), left, bottom, textPaint);
            }
        }
    }
}
