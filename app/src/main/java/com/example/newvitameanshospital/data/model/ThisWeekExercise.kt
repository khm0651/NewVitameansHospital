package com.example.newvitameanshospital.data.model

data class ThisWeekExercise(
    val exerciseList: List<Exercise>,
    val fromWhere: String,
    val numberOfExercise: Int,
    val rank: Int
)
