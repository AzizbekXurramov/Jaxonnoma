package uz.azizbekxurramov.jaxonnoma.Core.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.azizbekxurramov.jaxonnoma.Core.models.NewsResponse

interface NewsServis {

    @GET("v2/top-headlines")

    fun loadTopHeadline(
        // &- belgiga vergul quyamiz
        //@Query--uzgardigan soha bulishi mn
        @Query("country") country:String,
        @Query("apiKey") apiKey:String

    ):Call<NewsResponse>
}