package uz.azizbekxurramov.jaxonnoma.Fragmentslar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import uz.azizbekxurramov.jaxonnoma.Core.Const.hide
import uz.azizbekxurramov.jaxonnoma.Core.Const.show
import uz.azizbekxurramov.jaxonnoma.Core.adapters.NewsAdapters
import uz.azizbekxurramov.jaxonnoma.Core.models.NewsItem
import uz.azizbekxurramov.jaxonnoma.R
import uz.azizbekxurramov.jaxonnoma.UI.main.MainContrakt
import uz.azizbekxurramov.jaxonnoma.UI.main.MainPresenter
import uz.azizbekxurramov.jaxonnoma.databinding.FragmentNewsBinding
import kotlin.math.abs


class Fragment1 : Fragment(), MainContrakt.View {
    private lateinit var binding: FragmentNewsBinding
   private lateinit var pager: ViewPager2
    private var adapters:NewsAdapters = NewsAdapters()
    private var presenter: MainPresenter?=null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pader1FragmentNews.adapter = adapters
        presenter = MainPresenter(this)
        presenter?.loadTopHeadline("us", this.getString(R.string.api_key))


        binding.pader1FragmentNews.clipToPadding=false
        binding.pader1FragmentNews.clipChildren=false
        binding.pader1FragmentNews.offscreenPageLimit=2
        binding.pader1FragmentNews.getChildAt(0).overScrollMode= RecyclerView.OVER_SCROLL_NEVER


        val compPageTransf =CompositePageTransformer()
        compPageTransf.addTransformer(MarginPageTransformer(7))
        compPageTransf.addTransformer(ViewPager2.PageTransformer{ page, position ->
            val r = 1- abs(position)
            page.scaleY = 0.85f+r*0.35f
        })
        binding.pader1FragmentNews.setPageTransformer(compPageTransf)


    }

    override fun showProgres() {
        binding.progres.show()
    }

    override fun hideProgres() {
        binding.progres.hide()
    }

    override fun sendData(data: List<NewsItem>?) {
        adapters.data=data
    }

    override fun setMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}