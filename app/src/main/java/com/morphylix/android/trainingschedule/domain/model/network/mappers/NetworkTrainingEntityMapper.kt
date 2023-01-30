package com.morphylix.android.trainingschedule.domain.model.network.mappers

import com.morphylix.android.trainingschedule.domain.model.domain.Training
import com.morphylix.android.trainingschedule.domain.model.network.TrainingNetworkEntity
import com.morphylix.android.trainingschedule.util.EntityMapper
import javax.inject.Inject

class NetworkTrainingEntityMapper @Inject constructor(): EntityMapper<TrainingNetworkEntity, Training> {

    override fun mapFromEntity(entity: TrainingNetworkEntity): Training {
        return Training(
            name = entity.name,
            place = entity.place,
            coachId = entity.coach_id,
            startTime = entity.startTime,
            endTime = entity.endTime,
            date = entity.date,
            color = entity.color // drop # before color code
        )
    }

    override fun mapToEntity(model: Training): TrainingNetworkEntity {
        return TrainingNetworkEntity(
            name = model.name,
            place = model.place,
            coach_id = model.coachId,
            startTime = model.startTime,
            endTime = model.endTime,
            date = model.date,
            color = model.color
        )
    }

    fun mapFromEntityList(entityList: List<TrainingNetworkEntity>): List<Training> {
        return entityList.map {
            mapFromEntity(it)
        }
    }

}