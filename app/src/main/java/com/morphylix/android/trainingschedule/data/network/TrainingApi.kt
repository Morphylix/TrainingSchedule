package com.morphylix.android.trainingschedule.data.network

import com.morphylix.android.trainingschedule.domain.model.network.TrainingObject
import retrofit2.http.GET

interface TrainingApi {

    @GET("?club_id=2")
    suspend fun fetchTrainingList(): TrainingObject

}