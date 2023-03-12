package com.example.programmer_calculator_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
class MainActivity : AppCompatActivity() {

    lateinit var clearInputBtn: Button
    lateinit var numberHexadicimal: EditText
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
        setListeners()

        clearInputBtn.setOnClickListener {
            clearInput()
        }


    }

    private fun initializeViews() {
        clearInputBtn = findViewById(R.id.btnClearInput)
        numberHexadicimal = findViewById(R.id.textInputHexadecimal)
        numberOctal = findViewById(R.id.textInputOctal)
        numberBinary = findViewById(R.id.textInputBinary)
        numberDecimal = findViewById(R.id.textInputDecimal)
    }

    private fun clearInput() {
        numberDecimal.text?.clear()
        numberBinary.text?.clear()
        numberOctal.text?.clear()
        numberHexadicimal.text?.clear()

    }

    private fun setListeners() {
        numberBinary.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val newDec = s.toString().toLongOrNull(2)
                if (newDec != null && newDec != dec) {
                    dec = s.toString().toLongOrNull(2)!!
                    oct = dec.toString(8)
                    hexa = dec.toString(16)

                    numberDecimal.setText(dec.toString())
                    numberOctal.setText(oct)
                    numberHexadicimal.setText(hexa)
                }
            }
        })

        numberDecimal.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val newDec = s.toString().toLongOrNull(10)
                if (newDec != null && newDec != dec) {
                    dec = s.toString().toLongOrNull(10)!!
                    oct = dec.toString(8)
                    hexa = dec.toString(16)
                    bin = dec.toString(2)

                    numberBinary.setText(bin)
                    numberOctal.setText(oct)
                    numberHexadicimal.setText(hexa)
                }
            }
        })

        numberHexadicimal.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val newDec = s.toString().toLongOrNull(16)
                if (newDec != null && newDec != dec) {
                    dec = s.toString().toLongOrNull(16)!!
                    oct = dec.toString(8)
                    bin = dec.toString(2)

                    numberDecimal.setText(dec.toString())
                    numberOctal.setText(oct)
                    numberBinary.setText(bin)
                }
            }
        })

        numberOctal.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val newDec = s.toString().toLongOrNull(8)
                if (newDec != null && newDec != dec) {
                    dec = s.toString().toLongOrNull(8)!!
                    hexa = dec.toString(16)
                    bin = dec.toString(2)

                    numberDecimal.setText(dec.toString())
                    numberBinary.setText(bin)
                    numberHexadicimal.setText(hexa)
                }
            }
        })

    }
}
