package com.morphylix.android.trainingschedule.presentation.training_list

import com.morphylix.android.trainingschedule.domain.model.domain.Trainer
import com.morphylix.android.trainingschedule.domain.model.domain.Training

sealed class TrainingState {

    object Initialized: TrainingState()

    object Loading: TrainingState()

    class Success(val trainingList: List<Training>): TrainingState()

    class Error(val e: Exception): TrainingState()

}