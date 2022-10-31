package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var _binding:ActivityMainBinding?=null
    val binding get() = _binding!!

    private lateinit var firstFragment: FirstFragment

    private lateinit var secondFragment: SecondFragment

    private lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            setTabLayout()
        }

    }
    private fun changeFragment(message: String) {
        when (message) {
            "FirstFragment" -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.firstFrameLayout, FirstFragment())
                    commit()
                }
            }

            "SecondFragment" -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.secondFrameLayout, SecondFragment())
                    commit()
                }
            }

            "ThirdFragment" -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.thirdFrameLayout, ThirdFragment())
                    commit()
                }
            }

        }
    }

    private fun setTabLayout() {
        val tab1: TabLayout.Tab = binding.tabLayout.newTab()
        tab1.text = "timetable"

        val tab2: TabLayout.Tab = binding.tabLayout.newTab()
        tab2.text = "information"

        val tab3: TabLayout.Tab = binding.tabLayout.newTab()
        tab3.text = "tickeck"

        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addTab(tab3)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "timetable" -> {
                        changeFragment("FirstFragment")
                    }
                    "information" -> {
                        changeFragment("SecondFragment")
                    }
                    "tickeck" ->{
                        changeFragment("ThirdFragment")
                    }
                }
                transaction.commit()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
    fun openThirdFragment(message: String) {
        thirdFragment = ThirdFragment()

        val bundle = Bundle()
        bundle.putString("ThirdFragment", message)
        thirdFragment.arguments = bundle

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.thirdFrameLayout, thirdFragment)
            commit()
            Toast.makeText(
                applicationContext,
                "FirstFragment to ThirdFragment",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}