package com.example.kt5_lovecalculator.love

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.kt5_lovecalculator.App
import com.example.kt5_lovecalculator.R
import com.example.kt5_lovecalculator.databinding.FragmentLoveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding
    private lateinit var navController: NavController

    val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = NavHostFragment.findNavController(this)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                val firstname = firstEt.text.toString()
                val secondname = secondEt.text.toString()
                viewModel.getLiveLoveViewModel(firstname, secondname).observe(
                    viewLifecycleOwner
                ) { loveModel ->
                    Log.e("ololo", "initClickers:${loveModel}")
                    App.dp.historyDao().insert(loveModel)
                }

            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }

        }


    }
    private fun rename() {
        val editText = arguments?.getString("key1")
        binding.firstEt.setText(editText)
    }
}

