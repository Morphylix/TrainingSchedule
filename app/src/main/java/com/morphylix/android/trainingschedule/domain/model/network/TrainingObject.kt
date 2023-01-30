package com.morphylix.android.trainingschedule.domain.model.network

data class TrainingObject(
    val lessons: List<TrainingNetworkEntity>,
    val trainers: List<TrainerNetworkEntity>
)
