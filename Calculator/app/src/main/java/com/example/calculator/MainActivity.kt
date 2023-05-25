package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var results = 0.0f
    private var bool1 : Boolean = false
    private var bool2 : Boolean = true
    private var bool3 : Boolean = true
    private var operations = ""
    private var values = ""
    private var a = ""
    private var b = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val one: TextView = findViewById(R.id.one)
        val two: TextView = findViewById(R.id.two)
        val three: TextView = findViewById(R.id.three)
        val four: TextView = findViewById(R.id.four)
        val five: TextView = findViewById(R.id.five)
        val six: TextView = findViewById(R.id.six)
        val seven: TextView = findViewById(R.id.seven)
        val eight: TextView = findViewById(R.id.eight)
        val nine: TextView = findViewById(R.id.nine)
        val zero: TextView = findViewById(R.id.zero)
        val back: LinearLayout = findViewById(R.id.back)
        val delAll: TextView = findViewById(R.id.delall)
        val plus: TextView = findViewById(R.id.plus)
        val minus: TextView = findViewById(R.id.minus)
        val multiply: TextView = findViewById(R.id.multiply)
        val divide: TextView = findViewById(R.id.divide)
        val equal: TextView = findViewById(R.id.equal)
        val doubleZero: TextView = findViewById(R.id.doublezero)
        val value: TextView = findViewById(R.id.value)
        val factorial: TextView = findViewById(R.id.factorial)
        val result: TextView = findViewById(R.id.result)
        val toggle: ToggleButton = findViewById(R.id.toggle)
        toggle.setOnCheckedChangeListener { _, _ ->
            val app: ConstraintLayout = findViewById(R.id.app)
            val grid: GridLayout = findViewById(R.id.gridLayout)
            val user: ConstraintLayout = findViewById(R.id.edit1)
            val view: View = findViewById(R.id.view)
            if (toggle.isChecked){
                app.setBackgroundColor(ContextCompat.getColor(this,android.R.color.black))
                grid.setBackgroundColor(ContextCompat.getColor(this,android.R.color.black))
                toggle.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white))
                toggle.setTextColor(ContextCompat.getColor(this,android.R.color.black))
                user.setBackgroundColor(ContextCompat.getColor(this,android.R.color.black))
                view.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white))
                value.setTextColor(ContextCompat.getColor(this,android.R.color.white))
                result.setTextColor(ContextCompat.getColor(this,android.R.color.white))
            }else{
                app.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white))
                grid.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white))
                toggle.setBackgroundColor(ContextCompat.getColor(this,android.R.color.black))
                toggle.setTextColor(ContextCompat.getColor(this,android.R.color.white))
                user.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white))
                view.setBackgroundColor(ContextCompat.getColor(this,android.R.color.black))
                value.setTextColor(ContextCompat.getColor(this,android.R.color.black))
                result.setTextColor(ContextCompat.getColor(this,android.R.color.black))
            }
        }
        one.setOnClickListener {
            b += "1"
            update(value,result)
        }
        two.setOnClickListener {
            b += "2"
            update(value,result)
        }
        three.setOnClickListener {
            b += "3"
            update(value,result)
        }
        four.setOnClickListener {
            b += "4"
            update(value,result)
        }
        five.setOnClickListener {
            b += "5"
            update(value,result)
        }
        six.setOnClickListener {
            b += "6"
            update(value,result)
        }
        seven.setOnClickListener {
            b += "7"
            update(value,result)
        }
        eight.setOnClickListener {
            b += "8"
            update(value,result)
        }
        nine.setOnClickListener {
            b += "9"
            update(value,result)
        }
        zero.setOnClickListener {
            b += "0"
            update(value,result)
        }
        doubleZero.setOnClickListener {
            b += "00"
            update(value,result)
        }
        minus.setOnClickListener {
            if (a != "" || b != ""){
                if (operations.isNotEmpty()){
                    if (operations != "!"){
                        a = results.toString()
                        b = ""
                    }
                }
                operations = "-"
                process()
                update(value,result)
            }
        }
        plus.setOnClickListener {
            if (a != "" || b != ""){
                if (operations.isNotEmpty()){
                    if (operations != "!"){
                        a = results.toString()
                        b = ""
                    }
                }
                operations = "-"
                process()
                update(value,result)
            }
            operations = "+"
            process()
            update(value,result)
        }
        multiply.setOnClickListener {
            if (a != "" || b != ""){
                if (operations.isNotEmpty()){
                    if (operations != "!"){
                        a = results.toString()
                        b = ""
                    }
                }
                operations = "-"
                process()
                update(value,result)
            }
            operations = "*"
            process()
            update(value,result)
        }
        divide.setOnClickListener {
            if (a != "" || b != ""){
                if (operations.isNotEmpty()){
                    if (operations != "!"){
                        a = results.toString()
                        b = ""
                    }
                }
                operations = "-"
                process()
                update(value,result)
            }
            operations = "/"
            process()
            update(value,result)
        }
        equal.setOnClickListener {
            a = results.toString()
            b = ""
            operations = ""
            process()
            update(value,result)
        }
        delAll.setOnClickListener {
            delAll()
            update(result,value)

        }
        back.setOnClickListener {
            if (values.length >1){
                if (b == "!"){
                    b = b.dropLast(1)
                    bool3 = false
                }
                if (b != "" && bool3){
                    b = b.dropLast(1)
                    bool3 = false
                }
                if (operations != "" && bool3){
                    operations = ""
                    bool3 = false
                }
                if (bool3){
                    a = a.dropLast(1)
                    results = a.toFloat()
                }
                bool3 = true
                process()
                update(value,result)
            }else{
                delAll()
                update(value,result)
            }
        }
        factorial.setOnClickListener {
            operations = "!"
            process()
            update(value,result)
        }
    }
    private fun equal(){
        when(operations){
            "-"-> results = (a.toFloat()-b.toFloat())
            "+"-> results = (a.toFloat()+b.toFloat())
            "/"-> results = (a.toFloat()/b.toFloat())
            "*"-> results = (a.toFloat()*b.toFloat())
            "!"-> {
                var str = 1
                for (i in 1..a.toInt()){
                    str *=i
                }
                results = str.toFloat()
            }
        }
    }
    private fun delAll(){
        a = ""
        b = ""
        operations = ""
        results = 0.0f
        bool2 = true

    }
    private fun update(value:TextView,result:TextView){
        if (operations != ""){
            if (b == ""){
                b = when(operations){
                    "-","+" -> {"0"}
                    "/","*","!" -> {"1"}
                    else -> {""}
                }
                bool1 = true
            }
            equal()
            if (bool1){
                b = ""
                bool1 = false
            }

        }
        values = "$a$operations$b"
        value.text = values
        result.text = results.toString()
    }
    private fun process(){
        if (bool2){
            a = b
            b = ""
            bool2 = false
        }
    }
    fun onToggleClicked(view: View) {
        // This method is defined in the XML layout file
    }
}
