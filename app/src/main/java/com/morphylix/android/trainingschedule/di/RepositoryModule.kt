package com.morphylix.android.trainingschedule.di

import com.morphylix.android.trainingschedule.data.TrainingScheduleRepositoryImpl
import com.morphylix.android.trainingschedule.data.network.TrainingApi
import com.morphylix.android.trainingschedule.domain.TrainingScheduleRepository
import com.morphylix.android.trainingschedule.domain.model.network.mappers.NetworkTrainerEntityMapper
import com.morphylix.android.trainingschedule.domain.model.network.mappers.NetworkTrainingEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        trainingApi: TrainingApi,
        networkTrainingEntityMapper: NetworkTrainingEntityMapper,
        networkTrainerEntityMapper: NetworkTrainerEntityMapper
    ): TrainingScheduleRepository {
        return TrainingScheduleRepositoryImpl(
            trainingApi,
            networkTrainingEntityMapper,
            networkTrainerEntityMapper
        )
    }

}