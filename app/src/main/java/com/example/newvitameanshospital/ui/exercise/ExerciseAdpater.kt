package com.example.newvitameanshospital.ui.exercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.ItemExerciseRecyclerBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

class ExerciseAdpater() :RecyclerView.Adapter<ExerciseAdpater.CustomViewHolder>()
{


    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExerciseAdpater.CustomViewHolder {


        return CustomViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),R.layout.item_exercise_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseAdpater.CustomViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 3
    }

    inner class CustomViewHolder(private val binding: ItemExerciseRecyclerBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(){
            binding.apply {
            }
        }

    }
}