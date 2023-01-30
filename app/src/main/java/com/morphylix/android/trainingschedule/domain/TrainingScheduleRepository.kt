package com.morphylix.android.trainingschedule.domain

import com.morphylix.android.trainingschedule.domain.model.domain.Trainer
import com.morphylix.android.trainingschedule.domain.model.domain.Training

interface TrainingScheduleRepository {

    suspend fun fetchTrainingList(): List<Training>

    suspend fun fetchTrainerList(): List<Trainer>

}