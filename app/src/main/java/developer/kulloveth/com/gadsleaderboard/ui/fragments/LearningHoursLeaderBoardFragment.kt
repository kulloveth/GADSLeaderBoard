package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import developer.kulloveth.com.gadsleaderboard.R
import developer.kulloveth.com.gadsleaderboard.databinding.FragmentLearningHoursLeaderBoardBinding
import developer.kulloveth.com.gadsleaderboard.ui.adapter.LearningHoursAdapter
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import developer.kulloveth.com.gadsleaderboard.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class LearningHoursLeaderBoardFragment : Fragment() {
    private val leaderViewModel: LearnersViewModel by viewModel()
    private var binding:FragmentLearningHoursLeaderBoardBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLearningHoursLeaderBoardBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayLearnersByHours()
    }

    private fun displayLearnersByHours(){
        leaderViewModel.getLearnersByHours().observe(requireActivity(), Observer {
            when (it.status) {
                Status.ERROR -> {Log.e("error", "${it.message}")
                }
                Status.SUCCESS -> {
                    binding?.lottyIcon?.visibility = View.GONE
                    val adapter = LearningHoursAdapter()
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