package uz.azizbekxurramov.jaxonnoma.Fragmentslar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.azizbekxurramov.jaxonnoma.Core.Const.hide
import uz.azizbekxurramov.jaxonnoma.Core.Const.setLiner
import uz.azizbekxurramov.jaxonnoma.Core.Const.show

import uz.azizbekxurramov.jaxonnoma.Core.adapters.NewsAdapters
import uz.azizbekxurramov.jaxonnoma.Core.models.NewsItem
import uz.azizbekxurramov.jaxonnoma.R
import uz.azizbekxurramov.jaxonnoma.UI.main.MainContrakt
import uz.azizbekxurramov.jaxonnoma.UI.main.MainPresenter
import uz.azizbekxurramov.jaxonnoma.databinding.Fragment8Binding

class Fragment8 : Fragment(), MainContrakt.View {
    private lateinit var binding: Fragment8Binding
    private var adapters: NewsAdapters = NewsAdapters()
    private var presenter: MainPresenter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment8Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenter(this)
        presenter?.loadNewsByCategory("tr", "science", this.getString(R.string.api_key))

        binding.userList.setLiner()
        binding.userList.adapter = adapters
    }

    override fun showProgres() {
        binding.progres.show()
    }

    override fun hideProgres() {
        binding.progres.hide()
    }

    override fun sendData(data: List<NewsItem>?) {
        adapters.data = data
    }

    override fun setMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}