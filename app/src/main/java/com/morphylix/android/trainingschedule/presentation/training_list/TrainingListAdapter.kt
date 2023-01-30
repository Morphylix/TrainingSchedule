package com.morphylix.android.trainingschedule.presentation.training_list

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.morphylix.android.trainingschedule.R
import com.morphylix.android.trainingschedule.databinding.TrainingItemBinding
import com.morphylix.android.trainingschedule.domain.model.domain.Training

private const val TAG = "TrainingListAdapter"

class TrainingListAdapter(private val trainingList: List<Training>) :
    Adapter<TrainingListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingListViewHolder {
        val binding =
            TrainingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrainingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingListViewHolder, position: Int) {
        holder.bind(trainingList[position])
    }

    override fun getItemCount(): Int = trainingList.size
}

class TrainingListViewHolder(private val binding: TrainingItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var training: Training

    fun bind(training: Training) {
        this.training = training
        with(binding) {
            locationTextView.text = training.place
            trainingNameTextView.text = training.name
            trainingStartTimeTextView.text = training.startTime
            trainingEndTimeTextView.text = training.endTime
            trainingColorView.background = Color.parseColor(training.color).toDrawable()
            if (training.trainerName == null || training.trainerName!!.isEmpty()) {
                trainerNameTextView.text = root.context.getString(R.string.unknown_trainer)
                trainerNameTextView.setTextColor(root.context.resources.getColor(R.color.md_theme_light_error))
            } else {
                trainerNameTextView.text = training.trainerName
            }
            Log.i(TAG, "Color is ${training.color}")
        }
    }
}