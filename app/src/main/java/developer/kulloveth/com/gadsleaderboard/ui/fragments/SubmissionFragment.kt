package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import developer.kulloveth.com.gadsleaderboard.databinding.FragmentSubmissionBinding
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import developer.kulloveth.com.gadsleaderboard.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubmissionFragment : Fragment() {

    private var binding: FragmentSubmissionBinding? = null
    private val viewModel:LearnersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSubmissionBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.submitBtn?.setOnClickListener {
           submission() }
    }

    private fun submission(){
        viewModel.submitForm(binding?.emailEt?.text.toString(),binding?.firstNameEt?.text.toString(),binding?.lastNameEt?.text.toString(),binding?.githubEt?.text.toString())
        viewModel.fLivedata.observe(requireActivity(), Observer {
            when (it.status){
                Status.SUCCESS->{
                    Toast.makeText(requireContext(),it.data,Toast.LENGTH_LONG).show()
                }
                Status.ERROR->{
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                }

                Status.LOADING->{

                }
            }
        })
    }
}