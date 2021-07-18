package com.example.newvitameanshospital.data.model

data class User(
    val latestBloodPressure: LatestBloodPressure,
    val latestBloodSugar: LatestBloodSugar,
    val latestWeight: LatestWeight,
    val thisWeekDiet: ThisWeekDiet,
    val thisWeekExercise: ThisWeekExercise,
    val thisWeekManageScroe: ThisWeekManageScroe,
    val username: String,
    val weather: String
)
