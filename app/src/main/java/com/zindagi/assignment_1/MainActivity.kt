package com.zindagi.assignment_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InflateException
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isclear:Boolean=false
        val wi=findViewById<EditText>(R.id.weight)
        val hi=findViewById<EditText>(R.id.height)
        val calculateButton=findViewById<Button>(R.id.calculate)
        val BMi_value = findViewById<TextView>(R.id.BM_value)
        val under_value = findViewById<TextView>(R.id.status)
        calculateButton.setOnClickListener {
            if(hi.text.toString().isEmpty()&& wi.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please fill the Height and Wieght", Toast.LENGTH_SHORT).show()
            }
            if(hi.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please fill the Height", Toast.LENGTH_SHORT).show()
                hi.requestFocus()
                return@setOnClickListener
            }
            else if(wi.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please fill the weight", Toast.LENGTH_SHORT).show()
                wi.requestFocus()
                return@setOnClickListener
            }
            if (isclear)
            {
               isclear=false
               hi.text.clear()
               wi.text.clear()
                under_value.setText("")
                BMi_value.setText("")
                calculateButton.setText("Calculate")
                Toast.makeText(this, "clear karo", Toast.LENGTH_SHORT).show()

            }
            else
            {
                if(hi.text.toString().isNotEmpty()&& wi.text.toString().isNotEmpty())
                {
                    if (!isclear)
                    {
                        isclear=true
                        calculateButton.setText("clear")
                        Toast.makeText(this, "calculate karo", Toast.LENGTH_SHORT).show()
                        val hi=hi.text.toString().toDouble()
                        val wi=wi.text.toString().toDouble()
                        val he=hi/100
                        val answer=wi/(he*he)
                        val total=(answer*100).roundToInt()/100.0
//                        BMi_value.text=(round(total*100)/100.0).toString()
                        BMi_value.text="Your BMI value ="+total.toString()

                        if (total>25)
                        {
                            Toast.makeText(this, "You are over weighted", Toast.LENGTH_SHORT).show()
                            under_value.text="You are over Weight"

                        }
                        else if (total<18)
                        {
                            Toast.makeText(this, "You are under weighted", Toast.LENGTH_SHORT).show()
                            under_value.text="You are under Weight"

                        }
                        else
                        {
                            Toast.makeText(this, "You are fit", Toast.LENGTH_SHORT).show()

                            under_value.text="You are fit"
                        }


                    }


                }


            }

        }

    }


}
