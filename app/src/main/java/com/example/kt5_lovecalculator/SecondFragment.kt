package com.example.kt5_lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kt5_lovecalculator.databinding.FragmentSecondBinding
import com.example.kt5_lovecalculator.love.LoveModel


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        val loveModel: LoveModel = arguments?.getSerializable("Love") as LoveModel
        binding.firstName.text = loveModel.firstname
        binding.secondName.text = loveModel.secondname
        binding.result.text = loveModel.result
        binding.percent.text = loveModel.percentage
        binding.tryAgainBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}