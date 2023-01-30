package com.morphylix.android.trainingschedule.presentation.training_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morphylix.android.trainingschedule.domain.usecase.FetchTrainingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingListViewModel @Inject
constructor(
    private val fetchTrainingListUseCase: FetchTrainingListUseCase
) :
    ViewModel() {

    private val _state: MutableStateFlow<TrainingState> = MutableStateFlow(TrainingState.Loading)
    val state: StateFlow<TrainingState>
        get() = _state

    fun fetchTrainingList() {
        viewModelScope.launch {
            try {
                _state.value = TrainingState.Success(fetchTrainingListUseCase.execute())
            } catch (e: Exception) {
                _state.value = TrainingState.Error(e)
            }
        }
    }
}