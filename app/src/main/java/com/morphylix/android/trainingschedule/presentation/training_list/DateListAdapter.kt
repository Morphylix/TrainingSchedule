package com.morphylix.android.trainingschedule.presentation.training_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morphylix.android.trainingschedule.databinding.DateItemBinding
import com.morphylix.android.trainingschedule.domain.model.domain.Training
import java.text.DateFormat
import java.util.*

class DateListAdapter(private val trainingList: List<Training>) :
    RecyclerView.Adapter<DateListViewHolder>() {

    private fun getDateList(trainingList: List<Training>): List<Date> {
        val dateSet = mutableSetOf<Date>()
        trainingList.forEach {
            dateSet.add(it.date)
        }
        return dateSet.toList().sorted()
    }

    private val dateList = getDateList(trainingList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder {
        val binding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {
        holder.bind(dateList[position], trainingList)
    }

    override fun getItemCount() = dateList.size

}

class DateListViewHolder(private val binding: DateItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(date: Date, trainingList: List<Training>) {
        val trainingListForCurrentDate = trainingList.filter { it.date == date }

        with(binding) {
            dateTextView.text = DateFormat.getDateInstance(DateFormat.FULL, Locale("ru")).format(date) // !hardcoded locale!
            trainingListRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
            trainingListRecyclerView.adapter = TrainingListAdapter(trainingListForCurrentDate)
            trainingListRecyclerView.isNestedScrollingEnabled = false
        }
    }

}