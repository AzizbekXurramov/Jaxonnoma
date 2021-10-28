package uz.azizbekxurramov.jaxonnoma.Core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.with
import com.squareup.picasso.Picasso
import uz.azizbekxurramov.jaxonnoma.Core.Const.BASE_URL
import uz.azizbekxurramov.jaxonnoma.Core.models.NewsItem
import uz.azizbekxurramov.jaxonnoma.databinding.NewsTopHeadlineBinding

class NewsAdapters:RecyclerView.Adapter<NewsAdapters.ViewHolder>() {

     var data:List<NewsItem>?=null
         set(value) {
        field=value
        notifyDataSetChanged()

    }



    inner class ViewHolder(var binding: NewsTopHeadlineBinding):RecyclerView.ViewHolder(binding.root){

         fun binData(model:NewsItem){
             binding.sana.text = model.publishedAt
             binding.title.text = model.title
            Glide.with(binding.images).load(model.urlToImage).into(binding.images)


         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsTopHeadlineBinding.inflate(LayoutInflater.from(parent.context), parent, false  ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.binData(data!![position])
        data?.let { holder.binData(it[position]) }
    }

    override fun getItemCount(): Int {

        return if (data!=null)data!!.size else 0

    }
}