package uz.azizbekxurramov.jaxonnoma.Core.Const

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val BASE_URL = "https://newsapi.org/"

fun View?.show() {
    this?.visibility = View.VISIBLE

}

fun View?.hide() {
    this?.visibility = View.GONE

}

fun RecyclerView.setLiner() {
    layoutManager = LinearLayoutManager(this.context)
}