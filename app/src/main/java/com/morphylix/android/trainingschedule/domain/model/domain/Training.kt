package com.morphylix.android.trainingschedule.domain.model.domain

import java.util.*

data class Training(
    val name: String,
    val place: String,
    val coachId: String,
    val startTime: String,
    val endTime: String,
    val date: Date,
    val color: String,
    var trainerName: String? = null
    )
