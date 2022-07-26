package com.example.scalevalueselector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kevalpatel2106.rulerpicker.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rulerValuePicker:RulerValuePicker=findViewById(R.id.ruler_picker)

        var textView: TextView = findViewById(R.id.textView)

        rulerValuePicker.selectValue(170 /* Initial value */);

        rulerValuePicker.setValuePickerListener(object : RulerValuePickerListener {
            override fun onValueChange(selectedValue: Int) {
                //Value changed and the user stopped scrolling the ruler.
                //Application can consider this value as final selected value.
                textView.text = selectedValue.toString()
            }

            override fun onIntermediateValueChange(selectedValue: Int) {
                //Value changed but the user is still scrolling the ruler.
                //This value is not final value. You can utilize this value to display the current selected value.
                textView.text=selectedValue.toString()
            }
        })
    }

}