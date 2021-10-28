package uz.azizbekxurramov.jaxonnoma.Fragmentslar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.azizbekxurramov.jaxonnoma.databinding.Fragment2SiklfragBinding

class Fragment2 : Fragment() {
 private lateinit var binding:Fragment2SiklfragBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2SiklfragBinding.inflate(inflater, container, false)
        return binding.root
    }
}