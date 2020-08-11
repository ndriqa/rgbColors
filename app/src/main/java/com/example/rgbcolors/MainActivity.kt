package com.example.rgbcolors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    //variables holding 0-255 values of their representative colors
    var red: Int = 0
    var green: Int = 0
    var blue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = R.layout.activity_main
        setContentView(view)

        //give this listener to seek bars
        redBar.setOnSeekBarChangeListener(this)
        greenBar.setOnSeekBarChangeListener(this)
        blueBar.setOnSeekBarChangeListener(this)
    }

    //method called when any seek bar changes
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        when(seekBar){
            redBar -> red = redBar.progress
            greenBar -> green = greenBar.progress
            blueBar -> blue = blueBar.progress
        }
        updateColor()
    }

    //set the color of the button
    private fun updateColor() = canvasButton.setBackgroundColor(Color.parseColor("#${getHex(red)}${getHex(green)}${getHex(blue)}"))

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }
    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    //Get hex code (00->FF) of an Int(0->255).
    val hexadeci = 16
    fun getHex(dec: Int): String = "${getHexDigit(dec/hexadeci)}${getHexDigit(dec%hexadeci)}"

    //get single digit hex code(0->F) of an Int(0->15)
    fun getHexDigit(dec: Int): String{
        return when(dec){
            in 0..9 -> "$dec"
            in 10..15 -> "${('A' + (dec-10))}"
            else -> "0"
        }
    }
}