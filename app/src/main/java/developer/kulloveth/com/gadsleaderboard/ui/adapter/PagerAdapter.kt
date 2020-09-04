package developer.kulloveth.com.gadsleaderboard.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import developer.kulloveth.com.gadsleaderboard.ui.fragments.LearningHoursLeaderBoardFragment
import developer.kulloveth.com.gadsleaderboard.ui.fragments.SkillIqLeaderBoardFragment

class PagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    private val createTabFragment: Map<Int, ()->Fragment> = mapOf(
        HOUR_BOARD_FRAGMENT to {LearningHoursLeaderBoardFragment()},
        SKILL_BOARD_FRAGMENT to {SkillIqLeaderBoardFragment()})

    override fun getItemCount(): Int  = createTabFragment.size

    override fun createFragment(position: Int) = createTabFragment[position]?.invoke() ?: throw IndexOutOfBoundsException()

    companion object{
        const val HOUR_BOARD_FRAGMENT =0
        const val SKILL_BOARD_FRAGMENT = 1
    }
}