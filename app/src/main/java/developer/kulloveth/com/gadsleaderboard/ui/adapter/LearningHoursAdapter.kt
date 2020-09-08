package developer.kulloveth.com.gadsleaderboard.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour

class LearningHoursAdapter {


    companion object{
        private val HOUR_DIFF = object : DiffUtil.ItemCallback<LearnerByHour>(){
            override fun areItemsTheSame(oldItem: LearnerByHour, newItem: LearnerByHour): Boolean {
                oldItem.hours == newItem.hours
            }

            override fun areContentsTheSame(
                oldItem: LearnerByHour,
                newItem: LearnerByHour
            ): Boolean =
                oldItem == newItem
        }
    }
}