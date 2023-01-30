package com.morphylix.android.trainingschedule.domain.model.network.mappers

import com.morphylix.android.trainingschedule.domain.model.domain.Trainer
import com.morphylix.android.trainingschedule.domain.model.network.TrainerNetworkEntity
import com.morphylix.android.trainingschedule.util.EntityMapper
import javax.inject.Inject

class NetworkTrainerEntityMapper @Inject constructor(): EntityMapper<TrainerNetworkEntity, Trainer> {
    override fun mapFromEntity(entity: TrainerNetworkEntity): Trainer {
        return Trainer(entity.id, entity.full_name)
    }

    override fun mapToEntity(model: Trainer): TrainerNetworkEntity {
        return TrainerNetworkEntity(model.id, model.name)
    }

    fun mapFromEntityList(entityList: List<TrainerNetworkEntity>): List<Trainer> {
        return entityList.map {
            mapFromEntity(it)
        }
    }
}