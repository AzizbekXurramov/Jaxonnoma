package uz.azizbekxurramov.jaxonnoma.UI.main

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.azizbekxurramov.jaxonnoma.Core.models.NewsResponse
import uz.azizbekxurramov.jaxonnoma.Core.networking.NewsServis
import uz.azizbekxurramov.jaxonnoma.Core.networking.getRetrofit

class MainPresenter(val view: MainContrakt.View) : MainContrakt.Presentr {

    private var servise : NewsServis?=null


    init {

        servise = getRetrofit().create(NewsServis::class.java)

    }



    override fun loadTopHeadline(country: String, apiKey: String) {
        view.showProgres()
        servise?.let {
            it.loadTopHeadline(country,apiKey).enqueue(object : Callback<NewsResponse>{
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful){
                        view.sendData(response.body()?.articles)
                    }
                    view.hideProgres()
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    view.setMessage(t.message)
                    view.hideProgres()
                }

            })
        }
    }

    override fun searchNews(search: String, apiKey: String) {
        view.showProgres()
    }

    override fun loadNewsByCategory(country: String, category: String, apiKey: String) {
        view.showProgres()
    }
}