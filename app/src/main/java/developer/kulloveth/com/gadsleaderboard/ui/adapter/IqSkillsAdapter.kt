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
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkill
import developer.kulloveth.com.gadsleaderboard.databinding.RvItemLayoutBinding

class IqSkillsAdapter :
    ListAdapter<LearnerByIqSkill, IqSkillsAdapter.IqSkilViewHolder>(
        IQSKILL_DIFF
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IqSkilViewHolder {
        val binding =
            RvItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IqSkilViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IqSkilViewHolder, position: Int) {
        val hour = getItem(position)
        holder.bindView(hour)
    }


    inner class IqSkilViewHolder(private val binding: RvItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(hour: LearnerByIqSkill) {
            binding.nameTv.text = hour.name.toString()
            binding.durationTv.text = String.format(
                binding.root.context.getString(R.string.score_txt),
                hour.score,
                hour.country
            )
            binding.ivLeader.load(hour.badgeUrl)
        }
    }


    companion object {
        private val IQSKILL_DIFF = object : DiffUtil.ItemCallback<LearnerByIqSkill>() {
            override fun areItemsTheSame(oldItem: LearnerByIqSkill, newItem: LearnerByIqSkill): Boolean =
                oldItem.score == newItem.score

            override fun areContentsTheSame(
                oldItem: LearnerByIqSkill,
                newItem: LearnerByIqSkill
            ): Boolean =
                oldItem == newItem
        }
    }
}