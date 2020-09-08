package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.findNavController
import developer.kulloveth.com.gadsleaderboard.R

class SplashFragment : Fragment() {

    private val handler = Handler()
    private val runnable = Runnable {
        requireView().findNavController()
            .navigate(R.id.action_splashFragment_to_leaderBoardFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }


}