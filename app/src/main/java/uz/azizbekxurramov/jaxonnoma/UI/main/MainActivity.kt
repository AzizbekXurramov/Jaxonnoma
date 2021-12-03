package uz.azizbekxurramov.jaxonnoma.UI.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import uz.azizbekxurramov.jaxonnoma.Core.adapters.NewsAdapters
import uz.azizbekxurramov.jaxonnoma.Core.adapters.PageAdapter
import uz.azizbekxurramov.jaxonnoma.R
import uz.azizbekxurramov.jaxonnoma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

     lateinit var binding: ActivityMainBinding

    private var presenter: MainPresenter? = null
    private var adapters: NewsAdapters = NewsAdapters()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewPager.adapter = PageAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)


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