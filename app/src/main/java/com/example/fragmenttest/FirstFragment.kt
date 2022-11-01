package com.example.fragmenttest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmenttest.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
    override fun onCreateView(
        layoutInflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentFirstBinding.inflate(layoutInflater, container, false)
        if(arguments?.getString("key")!=null){
            binding.fr01Tv01.text = this.arguments?.getString("key")
        }

        if(requireArguments().containsKey("key")) {

        }


        binding.apply {
            fr01Btn01.text = arguments?.getString("FirstFragment")
            transferData()
        }

        return binding.root
    }
    private fun transferData() {
        binding.fr01Btn01.setOnClickListener {
            mainActivity?.openThirdFragment(binding.fr01Tv01.text.toString())
        }
    }

}