package com.morphylix.android.trainingschedule.data

import android.util.Log
import com.morphylix.android.trainingschedule.data.network.TrainingApi
import com.morphylix.android.trainingschedule.domain.TrainingScheduleRepository
import com.morphylix.android.trainingschedule.domain.model.domain.Trainer
import com.morphylix.android.trainingschedule.domain.model.domain.Training
import com.morphylix.android.trainingschedule.domain.model.network.mappers.NetworkTrainerEntityMapper
import com.morphylix.android.trainingschedule.domain.model.network.mappers.NetworkTrainingEntityMapper
import javax.inject.Inject

private const val TAG = "TrainingSchedule"

class TrainingScheduleRepositoryImpl @Inject constructor(
    private val trainingApi: TrainingApi,
    private val networkTrainingEntityMapper: NetworkTrainingEntityMapper,
    private val networkTrainerEntityMapper: NetworkTrainerEntityMapper
) :
    TrainingScheduleRepository {

    override suspend fun fetchTrainingList(): List<Training> {
        val trainingNetworkEntityList = trainingApi.fetchTrainingList().lessons
        val trainerList = fetchTrainerList()
        val trainingList = networkTrainingEntityMapper.mapFromEntityList(trainingNetworkEntityList)

        trainingList.forEach { training ->
            trainerList.forEach { trainer ->
                if (trainer.id == training.coachId) training.trainerName = trainer.name
            }
        }
        return trainingList
    }

    override suspend fun fetchTrainerList(): List<Trainer> {
        val trainerNetworkEntityList = trainingApi.fetchTrainingList().trainers
        Log.i(TAG, "$trainerNetworkEntityList")
        return networkTrainerEntityMapper.mapFromEntityList(trainerNetworkEntityList)
    }

}