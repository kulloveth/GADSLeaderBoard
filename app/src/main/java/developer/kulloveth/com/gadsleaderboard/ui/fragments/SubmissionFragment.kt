package developer.kulloveth.com.gadsleaderboard.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import developer.kulloveth.com.gadsleaderboard.R
import developer.kulloveth.com.gadsleaderboard.databinding.FragmentSubmissionBinding
import developer.kulloveth.com.gadsleaderboard.ui.viewmodel.LearnersViewModel
import developer.kulloveth.com.gadsleaderboard.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class SubmissionFragment : Fragment() {

    private var binding: FragmentSubmissionBinding? = null
    private val viewModel: LearnersViewModel by viewModel()

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
            submission()
        }
    }

    private fun submission() {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = LayoutInflater.from(requireActivity())
        val view = inflater.inflate(R.layout.confirm_submission_layout, null)
        builder.setView(view)
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
        val metrics = resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        view.findViewById<ImageView>(R.id.cancel).setOnClickListener {
            alertDialog.dismiss()
        }
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            if (binding?.emailEt?.text.isNullOrEmpty() || binding?.firstNameEt?.text.isNullOrEmpty() ||
                binding?.lastNameEt?.text.isNullOrEmpty() || binding?.githubEt?.text.isNullOrEmpty()
            ) {
                Toast.makeText(requireContext(), "field must not be empty", Toast.LENGTH_LONG)
                    .show()
            } else {
                viewModel.submitForm(
                    binding?.emailEt?.text.toString(),
                    binding?.firstNameEt?.text.toString(),
                    binding?.lastNameEt?.text.toString(),
                    binding?.githubEt?.text.toString()
                )
            }
        }
        viewModel.fLivedata.observe(requireActivity(), Observer {
            when (it.status) {

                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), it.data, Toast.LENGTH_LONG).show()
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                Status.LOADING -> {
                }
            }
        })
    }
}