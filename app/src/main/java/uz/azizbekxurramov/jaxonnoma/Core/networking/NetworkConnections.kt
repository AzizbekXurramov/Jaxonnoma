package uz.azizbekxurramov.jaxonnoma.Core.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.azizbekxurramov.jaxonnoma.Core.Const.BASE_URL

fun getRetrofit():Retrofit{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}