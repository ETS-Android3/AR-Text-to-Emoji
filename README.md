# Thesis: AR Replacing Text By Emojis
*This is was app was made for EGH400 Engineering Research Project* 

## How to get it? 
Download source code here on github 

## How to run it?
* Download source code here on github 
* Open it with android studion and build it on your Android device
* Or download and run the apk file 
   * [Link to apk](app/build/outputs/apk/debug)
   * Open linux terminal and install apk file
 ```xml
  adb install app-debug.apk  
```

## How to use it 
* Open application on your phone
* Go to settings and change the application to match your preferences 
* Find text in your local grocery store and watch as words change to emojis!
* Press the screen to pause the camera

## Settings Page 1
* Change what box around text/emoji
  * No Border
  * Border with no Background
  * Border with Background  
  
* Change size of text/emoji
  * Small
  * Medium
  * Large
  
* Change what happens when the camera is running 
  * Text On/Off
  * Emoji On/Off

* Change what happens when the camera is paused 
  * Text On/Off
  * Emoji On/Off
  
## Settings Page 2
* Change colour of box 
  * White
  * Black
  * Green 
  * Pink 
  
* Change colour of text 
  * White
  * Black
  * Green 
  * Pink






### Credits
Originally made up of the combinations of 
**emoji-java** provided by the https://github.com/Coding/emoji-java and **android-vision** provided by the https://github.com/googlesamples/android-vision

The JSON file within the emoji library has been modified to fullfill the purpose of the application 
EmojiManager  `getForAlias` is used without the code to convert text to emojis

Googles Android Vision used to detect and read the text. Modifications were made to fullfill the purpose of this application  

Files which have been modified or added have this comment at the top of the file 
 ```xml
/**
 * File added by Tia Chapple
 * Last Modified by Tia Chapple 04/11/21
 */
```
