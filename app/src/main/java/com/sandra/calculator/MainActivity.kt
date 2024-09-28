package com.sandra.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputTextView: TextView
    private lateinit var outputTextView: TextView

    private var input: String = ""
    private var operator: String = ""
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

        buttons.forEach { buttons ->
            buttons.setOnClickListener(View.OnClickListener {
                handleButtonClick(buttons.text.toString())// é chamado com o texto do botão como argumento.
            })
        }

    }

    private fun appendInput(value: String) {
        input += value
        inputTextView.text = input
        //acrescenta a string fornecida a string de entrada
        //e exibe a entrada atualizada
    }

    private fun appendDecimal() {
        if (!input.contains(".")) {
            input += "."
            inputTextView.text = input
        }
    }

    private fun handleOperator(op: String) {
        operator = op
        oparaOne = input.toDouble()
        input = ""
        inputTextView.text = ""
    }

    private fun calculateResult() {
        if (input.isNotEmpty()) {
            oparaTwo = input.toDouble()
            val result = when (operator) {
                "+" -> oparaOne + oparaTwo
                "-" -> oparaOne - oparaTwo
                "x" -> oparaOne * oparaTwo
                "/" -> oparaOne / oparaTwo
                else -> throw IllegalStateException("Invalid operation!")
            }
            outputTextView.text = result.toString()
            input = result.toString()
            inputTextView.text = input
        }
    }

    private fun clearInput() {
        input = ""
        oparaOne = 0.0
        oparaTwo = 0.0
        operator = ""
        inputTextView.text = ""
        outputTextView.text = ""
    }

    private fun handlePercentage() {
        if (input.isNotEmpty()) {
            val value = input.toDouble() / 100
            input = value.toString()
            inputTextView.text = input
        }
    }

    private fun toggleSign() {
        //altera o sinal do número
        if (input.isNotEmpty() && input != "0") {
            val value = input.toDouble() * -1
            input = value.toString()
            inputTextView.text = input
        }
    }

    private fun String.isNumeric(): Boolean {
        //verifica se a string representa um número
        //isNumeric é definida como uma extensão da classe String
        return try {
            this.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun handleButtonClick(value: String) {
        when {
            value.isNumeric() -> appendInput(value)
            value == "." -> appendDecimal()
            value in setOf("+", "-", "x", "/") -> handleOperator(value)
            value == "=" -> calculateResult()
            value == "C" -> clearInput()
            value == "%" -> handlePercentage()
            value == "+/-" -> toggleSign()
        }
    }

}
