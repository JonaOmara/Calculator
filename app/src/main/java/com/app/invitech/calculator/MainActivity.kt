package com.app.invitech.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buClick(view:View){
        if (newop){
            etShowTxt.setText("")
        }
        newop=false
        //Identifying buttons by ids!
        var buSelect = view as Button
        var buClickView:String =etShowTxt.text.toString()
        when(buSelect.id){
            buplusmin.id->{
                buClickView ="-"+buClickView
            }
            butper.id->{
                buClickView+="%"
            }

            bu7.id->{
                buClickView+="7"
            }
            bu8.id->{
                buClickView+="8"
            }
            bu9.id->{
                buClickView+="9"
            }

            bu4.id->{
                buClickView+="4"
            }
            bu5.id->{
                buClickView+="5"
            }
            bu6.id->{
                buClickView+="6"
            }
            bu1.id->{
                buClickView+="1"
            }
            bu2.id->{
                buClickView+="2"
            }
            bu3.id->{
                buClickView+="3"
            }

            bu0.id->{
                buClickView+="0"
            }
            buDot.id->{
                //TODO prevent adding more than one dot
                buClickView+="."
            }

        }
        etShowTxt.setText(buClickView)
    }
    var op = "*"
    var oldnumber = ""
    var newop = true
    //Creating operations
    fun opEvent( view:View){
        var buSelect = view as Button
        when(buSelect.id){
            bumin.id->{
                op= "-"
            }
            buMul.id->{
                op= "*"
            }
            buDiv.id->{
                op= "/"
            }
            buplus.id->{
                op= "+"
            }
        }
        oldnumber = etShowTxt.text.toString()
        newop = true
    }
    //function for eqauls
    fun equalEvent(view: View){
        var newnumber = etShowTxt.text.toString()
        var finalnumber:Double?=null
        when(op){
            "*"->{
                finalnumber = oldnumber.toDouble()*newnumber.toDouble()
            }
            "+"->{
                finalnumber = oldnumber.toDouble()+newnumber.toDouble()
            }
            "/"->{
                finalnumber = oldnumber.toDouble()/newnumber.toDouble()
            }
            "-"->{
                finalnumber = oldnumber.toDouble()-newnumber.toDouble()
            }
        }
        etShowTxt.setText(finalnumber.toString())
        newop=true
    }
    //function for percentage
    fun bupercent(view: View){
        val number = etShowTxt.text.toString().toDouble()/100
        etShowTxt.setText(number.toString())
        newop =true
    }
    //function for AC
    fun buClean(view: View){
        etShowTxt.setText("0")
        newop=true
    }
}
