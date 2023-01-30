package com.morphylix.android.trainingschedule.presentation.training_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.morphylix.android.trainingschedule.databinding.FragmentTrainingListBinding
import com.morphylix.android.trainingschedule.presentation.base.BaseFragment
import com.morphylix.android.trainingschedule.util.ErrorHandler
import kotlinx.coroutines.launch

private const val TAG = "TrainingListFragment"

class TrainingListFragment: BaseFragment<FragmentTrainingListBinding>({ inflater, container ->
    FragmentTrainingListBinding.inflate(inflater, container, false)
}) {

    private val trainingListViewModel: TrainingListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        trainingListViewModel.fetchTrainingList()

        lifecycleScope.launch {
            trainingListViewModel.state.collect { state ->

                when(state) {
                    is TrainingState.Initialized -> {}
                    is TrainingState.Loading -> {
                        with(binding) {
                            loadingProgressBar.visibility = View.VISIBLE
                        }
                    }
                    is TrainingState.Success -> {
                        with(binding) {
                            loadingProgressBar.visibility = View.GONE
                            dateListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                            dateListRecyclerView.adapter = DateListAdapter(state.trainingList)
                        }
                    }
                    is TrainingState.Error -> {
                        ErrorHandler.handleException(state.e, requireContext())
                    }
            }

            }
        }

    }

}