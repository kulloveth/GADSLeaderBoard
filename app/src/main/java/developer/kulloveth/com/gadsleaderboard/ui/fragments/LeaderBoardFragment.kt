package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import developer.kulloveth.com.gadsleaderboard.databinding.FragmentLeaderBoardBinding
import developer.kulloveth.com.gadsleaderboard.ui.adapter.PagerAdapter
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import developer.kulloveth.com.gadsleaderboard.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class LeaderBoardFragment : Fragment() {

    private val leaderViewModel: LearnersViewModel by viewModel()
    private var viewPager2: ViewPager2? = null
    private var pagerAdapter: PagerAdapter? = null

    private var binding: FragmentLeaderBoardBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeaderBoardBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager2 = binding?.viewPager2
        pagerAdapter = PagerAdapter(this)
        val tabLayout = binding?.tab
        viewPager2?.adapter = pagerAdapter
        TabLayoutMediator(
            tabLayout!!, viewPager2!!
        ) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        leaderViewModel.getLearnersByHours().observe(requireActivity(), Observer {
            when (it.status) {
                Status.ERROR -> Log.e("error", "${it.message}")
                Status.SUCCESS -> Log.d("success", "${it.data}")
            }
        })

        leaderViewModel.getLearnersBySkill().observe(requireActivity(), Observer {
            when (it.status) {
                Status.ERROR -> Log.e("error", "${it.message}")
                Status.SUCCESS -> Log.d("success", "${it.data}")
            }
        })
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            PagerAdapter.HOUR_BOARD_FRAGMENT -> "LearningLeaders"
            PagerAdapter.SKILL_BOARD_FRAGMENT -> "SkillIqLeaders"
            else -> ""
        }
    }

}