package uz.azizbekxurramov.jaxonnoma.UI.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import uz.azizbekxurramov.jaxonnoma.Core.adapters.AdapterPagerView
import uz.azizbekxurramov.jaxonnoma.Core.adapters.NewsAdapters
import uz.azizbekxurramov.jaxonnoma.Fragmentslar.Fragment1
import uz.azizbekxurramov.jaxonnoma.Fragmentslar.Fragment2
import uz.azizbekxurramov.jaxonnoma.R
import uz.azizbekxurramov.jaxonnoma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

     lateinit var binding: ActivityMainBinding
     private lateinit var adapterPage : AdapterPagerView
     private var arrayFragment : ArrayList<Fragment> = ArrayList()
    private var arratTitle:ArrayList<String> = ArrayList()


     private var presenter:MainPresenter?=null
   // private var adapters = NewsAdapters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapterPage = AdapterPagerView(fragmentManager = supportFragmentManager)
        binding.pagerMain.adapter = adapterPage

        arratTitle.add("oxirgi holat")
        arratTitle.add("kategoriyalar")
       // arratTitle.add("tugadi")


        adapterPage.SetFragment(loadFragment(),arratTitle)

    }

    private fun loadFragment():ArrayList<Fragment>{

        var frag_1 : Fragment = Fragment1()
        var frag_2 : Fragment = Fragment2()


        arrayFragment.add(frag_1)
        arrayFragment.add(frag_2)


        return arrayFragment
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.davlatlar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.ru -> {
                presenter?.loadTopHeadline("ru", this.getString(R.string.api_key))

            }

            R.id.tr -> {
                presenter?.loadTopHeadline("tr", this.getString(R.string.api_key))

            }

        }
        return super.onOptionsItemSelected(item)
    }
}