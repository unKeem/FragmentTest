package com.example.fragmenttest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragmenttest.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null

    private val binding get() = _binding!!

    private var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        binding.fr03Tv.setOnClickListener{
            Toast.makeText(container?.context,
                "Cancellation is possible up to 3 days in advance.", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}