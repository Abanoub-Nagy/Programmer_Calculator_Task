package com.example.programmer_calculator_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var convertButton: Button
    lateinit var clearInputBtn: Button
    lateinit var numberHexadecimal: EditText
    lateinit var numberOctal: EditText
    lateinit var numberBinary: EditText
    lateinit var numberDecimal: EditText

    var bin: String = ""
    var dec: Long = 0
    var oct: String = ""
    var hexa: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        clearInputBtn.setOnClickListener {
            clearInput()
        }

        convertButton.setOnClickListener {
            convert(numberDecimal, 10)
            convert(numberBinary, 2)
            convert(numberOctal, 8)
            convert(numberHexadecimal, 16)
        }
    }

    private fun initializeViews() {
        convertButton = findViewById(R.id.btnConvert)
        clearInputBtn = findViewById(R.id.btnClearInput)
        numberHexadecimal = findViewById(R.id.textInputHexadecimal)
        numberOctal = findViewById(R.id.textInputOctal)
        numberBinary = findViewById(R.id.textInputBinary)
        numberDecimal = findViewById(R.id.textInputDecimal)
    }

    private fun clearInput() {
        numberDecimal.text?.clear()
        numberBinary.text?.clear()
        numberOctal.text?.clear()
        numberHexadecimal.text?.clear()
    }

    private fun convert(view: EditText, base: Int) {
        val newDec = view.text.toString().toLongOrNull(base)
        if (newDec != null && newDec != dec) {
            dec = newDec
            oct = dec.toString(8)
            hexa = dec.toString(16)
            bin = dec.toString(2)

            if (view != numberBinary) {
                numberBinary.setText(bin)
            }
            if (view != numberDecimal) {
                numberDecimal.setText(dec.toString())
            }
            if (view != numberOctal) {
                numberOctal.setText(oct)
            }
            if (view != numberHexadecimal) {
                numberHexadecimal.setText(hexa)
            }
        }
    }
}