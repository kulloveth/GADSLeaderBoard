package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import developer.kulloveth.com.gadsleaderboard.R
import developer.kulloveth.com.gadsleaderboard.databinding.FragmentSkillIqLeaderBoardBinding
import developer.kulloveth.com.gadsleaderboard.ui.adapter.IqSkillsAdapter
import developer.kulloveth.com.gadsleaderboard.ui.adapter.LearningHoursAdapter
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import developer.kulloveth.com.gadsleaderboard.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class SkillIqLeaderBoardFragment : Fragment() {

    private val leaderViewModel: LearnersViewModel by viewModel()
    private var binding:FragmentSkillIqLeaderBoardBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIqLeaderBoardBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayLearnersBySkill()
    }


    private fun displayLearnersBySkill(){
        leaderViewModel.getLearnersBySkill().observe(requireActivity(), Observer {
            when (it.status) {
                Status.ERROR -> Log.e("error", "${it.message}")
                Status.SUCCESS -> {
                    binding?.lottyIcon?.visibility = View.GONE
                    val adapter = IqSkillsAdapter()
                    binding?.rv?.adapter = adapter
                    adapter.submitList(it.data)
                }
                Status.LOADING ->{
                    binding?.lottyIcon?.visibility = View.VISIBLE
                }
            }
        })
    }
}