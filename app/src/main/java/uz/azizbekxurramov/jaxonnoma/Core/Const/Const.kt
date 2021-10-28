package uz.azizbekxurramov.jaxonnoma.Core.Const

import android.view.View

val BASE_URL = "https://newsapi.org/"

fun View?.show(){
    this?.visibility = View.VISIBLE

}

fun View?.hide(){
    this?.visibility = View.GONE

}