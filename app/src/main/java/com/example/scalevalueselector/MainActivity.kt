package com.example.scalevalueselector

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kevalpatel2106.rulerpicker.RulerValuePicker
import com.kevalpatel2106.rulerpicker.RulerValuePickerListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rulerValuePicker: RulerValuePicker = findViewById(R.id.ruler_picker)

        var textView: TextView = findViewById(R.id.textView)

        rulerValuePicker.selectValue(170 /* Initial value */);

        rulerValuePicker.setValuePickerListener(object : RulerValuePickerListener {
            override fun onValueChange(selectedValue: Int) {
                //Value changed and the user stopped scrolling the ruler.
                //Application can consider this value as final selected value.
                if (selectedValue > 200) {
                    textView.text = "200"
                    rulerValuePicker.selectValue(200)

                } else {
                    textView.text = selectedValue.toString()
                }
            }

            override fun onIntermediateValueChange(selectedValue: Int) {
                //Value changed but the user is still scrolling the ruler.
                //This value is not final value. You can utilize this value to display the current selected value.
                if (selectedValue > 200) {
                    textView.text = "200"
                    rulerValuePicker.selectValue(200)

                } else {
                    textView.text = selectedValue.toString()
                }
            }
        })
    }

}