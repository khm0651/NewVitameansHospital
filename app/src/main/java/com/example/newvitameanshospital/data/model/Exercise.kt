package com.example.newvitameanshospital.data.model

data class Exercise(
    val exerciseIntensity: String,
    val exerciseType: List<ExerciseType>,
    val weather: String
)
