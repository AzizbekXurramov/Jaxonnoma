package uz.azizbekxurramov.jaxonnoma.UI.main

import uz.azizbekxurramov.jaxonnoma.Core.models.NewsItem

interface MainContrakt {

    interface View{
        fun showProgres()
        fun hideProgres()
        fun sendData( data :List<NewsItem>?)
        fun setMessage(message: String?)
    }

    interface Presentr{
        fun loadTopHeadline(country:String, apiKey:String)
        fun searchNews(search:String,apiKey:String)
        fun loadNewsByCategory(country:String, category:String, apiKey:String)
    }
}