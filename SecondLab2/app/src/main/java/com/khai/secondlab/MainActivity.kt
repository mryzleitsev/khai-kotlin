package com.khai.secondlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var buttonClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val clickCountTextView = findViewById<TextView>(R.id.clickCountTextView)

        button.setOnClickListener {
            textView.text = editText.text
            buttonClickCount++
            clickCountTextView.text = "Click Count: $buttonClickCount"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            val textView = findViewById<TextView>(R.id.textView)
            val editText = findViewById<EditText>(R.id.editText)
            putString("KEY", textView.text.toString())
            putString("KEY2", editText.text.toString())
            putInt("CLICK_COUNT", buttonClickCount)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val savedEditText = savedInstanceState.getString("KEY2")
        textView.text = savedInstanceState.getString("KEY")
        editText.setText(savedEditText)

        // Відновлення значення buttonClickCount
        buttonClickCount = savedInstanceState.getInt("CLICK_COUNT")

        // Оновлення відображення clickCountTextView
        val clickCountTextView = findViewById<TextView>(R.id.clickCountTextView)
        clickCountTextView.text = "Click Count: $buttonClickCount"
    }
}