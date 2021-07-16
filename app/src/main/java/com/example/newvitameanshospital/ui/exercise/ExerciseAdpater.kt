package com.example.newvitameanshospital.ui.exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.ItemExerciseRecyclerBinding

class ExerciseAdpater() : RecyclerView.Adapter<ExerciseAdpater.CustomViewHolder>() {

    // 뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExerciseAdpater.CustomViewHolder {

        return CustomViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_exercise_recycler, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExerciseAdpater.CustomViewHolder, position: Int) {

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class CustomViewHolder(private val binding: ItemExerciseRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            binding.apply {
                if (position == 1) {
                    ivWeatherIcon.setImageResource(R.drawable.ic_baseline_cloud_queue_24)
                    tvDateExercise.setText("21.06.21")
                    tvDegreeExercise.setText("적정")
                    tvKindExercise.setText("런닝")
                    tvKindExercise2.setVisibility(View.GONE)
                    ivWatchIcon2.setVisibility(View.GONE)
                    tvTimeExercise2.setVisibility(View.GONE)
                } else if (position == 2) {
                    tvDateExercise.setText("21.06.19")
                    tvDegreeExercise.setText("저강도")
                    tvKindExercise.setText("근력운동")
                    tvTimeExercise1.setText("15분")
                    tvKindExercise2.setVisibility(View.GONE)
                    ivWatchIcon2.setVisibility(View.GONE)
                    tvTimeExercise2.setVisibility(View.GONE)
                }
            }
        }
    }
}
