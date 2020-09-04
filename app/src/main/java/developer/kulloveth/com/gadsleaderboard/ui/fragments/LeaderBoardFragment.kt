package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import developer.kulloveth.com.gadsleaderboard.R
import developer.kulloveth.com.gadsleaderboard.data.model.Status
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaderBoardFragment : Fragment() {

    private val leaderViewModel:LearnersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_leader_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leaderViewModel.getLearnersByHours().observe(requireActivity(), Observer {
            when(it.status){
                Status.ERROR-> Log.e("error","${it.message}")
                Status.SUCCESS -> Log.d("success","${it.data}")
            }
        })
    }


}