package com.morphylix.android.trainingschedule.domain.model.network

import java.util.Date

data class TrainingNetworkEntity (
    val name: String,
    val place: String,
    val coach_id: String,
    val startTime: String,
    val endTime: String,
    val date: Date,
    val color: String
)
