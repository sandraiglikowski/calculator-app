package com.sandra.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputTextView: TextView
    private lateinit var outputTextView: TextView

    private var input: String = ""
    private var opera: String = ""
    private var oparaOne: Double = 0.0
    private var oparaTwo: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.tv_input)
        outputTextView = findViewById(R.id.tv_output)

        val buttons = listOf<Button>(
            findViewById(R.id.mtb_one),
            findViewById(R.id.mtb_two),
            findViewById(R.id.mtb_three),
            findViewById(R.id.mtb_four),
            findViewById(R.id.mtb_five),
            findViewById(R.id.mtb_six),
            findViewById(R.id.mtb_seven),
            findViewById(R.id.mtb_eight),
            findViewById(R.id.mtb_nine),
            findViewById(R.id.mtb_zero),
            findViewById(R.id.mtb_clean),
            findViewById(R.id.mtb_para1),
            findViewById(R.id.mtb_para2),
            findViewById(R.id.mtb_divide),
            findViewById(R.id.mtb_multi),
            findViewById(R.id.mtb_sub),
            findViewById(R.id.mtb_add),
            findViewById(R.id.mtb_equals),
            findViewById(R.id.mtb_dot)
        )
    }
}
