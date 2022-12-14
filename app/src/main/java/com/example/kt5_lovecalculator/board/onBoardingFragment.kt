package com.example.kt5_lovecalculator.board
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.kt5_lovecalculator.R
import com.example.kt5_lovecalculator.databinding.FragmentBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment  : Fragment() {
    private lateinit var binding: FragmentBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter( requireContext(), findNavController() )
        binding.viewpager.adapter = adapter
        binding.viewpager.adapter = adapter
        binding.wormDotsIndicator.setViewPager2(binding.viewpager)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()

        }
        adapter.addItem(
            OnBoard(
                R.raw.lottione,
                "Good luck",
                "Find time to help others"
            )
        )
        adapter.addItem(
            OnBoard(
                R.raw.lotti2,
                "Give out love",
                "You can't give love anymore"
            )
        )
        adapter.addItem(
            OnBoard(
                R.raw.lotti3,
                "Broke up?",
                "We have changed something for you.\nDating is waiting for you!"
            )
        )
        adapter.addItem(OnBoard(R.raw.lotti4, "", "These are fans, friends and more"))

    }
}