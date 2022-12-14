package com.example.kt5_lovecalculator.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kt5_lovecalculator.Prefs
import com.example.kt5_lovecalculator.databinding.ItemBoardingBinding
import javax.inject.Inject

class BoardAdapter (val context:Context, val navController: NavController ) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
    private val data = arrayListOf<OnBoard>()



    @Inject
    private lateinit var prefs: Prefs


    inner class BoardViewHolder(private var binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: OnBoard) {
            board.lottie?.let { binding.lottione.setAnimation(it) }
            binding.tvTitle.text = board.title.toString()
            binding.tvDescription.text = board.desc
            if (data.lastIndexOf(   board) == data.lastIndex){
                binding.btnStart.visibility = View.VISIBLE

            } else {
                binding.btnStart.visibility = View.INVISIBLE

                binding.btnStart.setOnClickListener {
                    prefs.isShown()
                    navController.navigateUp()


                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardingBinding.inflate
                (
                LayoutInflater.from
                    (parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
    fun addItem(board: OnBoard) {
        data.add(board)
    }


}