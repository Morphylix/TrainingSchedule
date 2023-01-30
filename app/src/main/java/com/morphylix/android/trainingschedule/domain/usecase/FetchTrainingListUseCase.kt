package com.morphylix.android.trainingschedule.domain.usecase

import com.morphylix.android.trainingschedule.domain.TrainingScheduleRepository
import com.morphylix.android.trainingschedule.domain.model.domain.Training
import javax.inject.Inject

class FetchTrainingListUseCase @Inject constructor(private val trainingScheduleRepository: TrainingScheduleRepository) {

    suspend fun execute(): List<Training> {
        return trainingScheduleRepository.fetchTrainingList()
    }

}