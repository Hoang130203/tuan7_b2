package com.example.shownumber

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.shownumber.ui.theme.ShowNumberTheme

class MainActivity : ComponentActivity() {
    private  lateinit var textinput : EditText
    private  lateinit var radioButton1: RadioButton
    private  lateinit var radioButton2: RadioButton
    private  lateinit var radioButton3: RadioButton
    private lateinit var  buttonShow : Button
    private  lateinit var  listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        textinput= findViewById(R.id.input)
        radioButton1=findViewById(R.id.radio_chan)
        radioButton2=findViewById(R.id.radio_le)
        radioButton3=findViewById(R.id.radio_cp)
        buttonShow=findViewById(R.id.showButton)
        listView=findViewById(R.id.listNumber)

        buttonShow.setOnClickListener {
            showNumber()
        }
    }

    private fun showNumber() {
        val inputText = textinput.text.toString()
        val numbersList = mutableListOf<String>()

        try {
            val n = inputText.toInt()

            when {
                radioButton1.isChecked -> {
                    for (i in 1..n) {
                        if (i % 2 == 0) numbersList.add(i.toString())
                    }
                }

                radioButton2.isChecked -> {
                    for (i in 1..n) {
                        if (i % 2 != 0) numbersList.add(i.toString())
                    }
                }

                radioButton3.isChecked -> {
                    for (i in 1..n) {
                        val sqrt = Math.sqrt(i.toDouble())
                        if (sqrt == sqrt.toInt().toDouble()) numbersList.add(i.toString())
                    }
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbersList)
            listView.adapter = adapter

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Vui lòng nhập một số hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShowNumberTheme {
        Greeting("Android")
    }
}