package developer.kulloveth.com.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import developer.kulloveth.com.gadsleaderboard.R
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.databinding.RvItemLayoutBinding

class LearningHoursAdapter :
    ListAdapter<LearnerByHour, LearningHoursAdapter.LearningHourViewHolder>(
        HOUR_DIFF
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningHourViewHolder {
        val binding =
            RvItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LearningHourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LearningHourViewHolder, position: Int) {
        val hour = getItem(position)
        holder.bindView(hour)
    }


    inner class LearningHourViewHolder(private val binding: RvItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(hour: LearnerByHour) {
            binding.nameTv.text = hour.name.toString()
            binding.durationTv.text = String.format(
                binding.root.context.getString(R.string.hours_txt),
                hour.hours,
                hour.country
            )
            binding.ivLeader.load(hour.badgeUrl) {
                transformations(CircleCropTransformation())
            }
        }
    }


    companion object {
        private val HOUR_DIFF = object : DiffUtil.ItemCallback<LearnerByHour>() {
            override fun areItemsTheSame(oldItem: LearnerByHour, newItem: LearnerByHour): Boolean =
                oldItem.hours == newItem.hours

            override fun areContentsTheSame(
                oldItem: LearnerByHour,
                newItem: LearnerByHour
            ): Boolean =
                oldItem == newItem
        }
    }
}