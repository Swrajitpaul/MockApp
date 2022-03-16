package io.github.swrajitpaul.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.github.swrajitpaul.R
import io.github.swrajitpaul.SharedViewModel
import io.github.swrajitpaul.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.aboutButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_to_aboutFragment)
        }

        binding.resumeButton.setOnClickListener {
            viewModel.urlString.value = "https://github.com/Swrajitpaul/Pages/blob/main/myresume2.pdf"
            findNavController().navigate(R.id.action_nav_to_webviewFragment)
        }

        binding.projectButton.setOnClickListener {
            viewModel.urlString.value = "https://swrajitpaul.github.io/Pages/projects.html"
            findNavController().navigate(R.id.action_nav_to_projectsFragment)
        }

        binding.githubButton.setOnClickListener {
            viewModel.urlString.value = "https://github.com/Swrajitpaul?tab=repositories"
            findNavController().navigate(R.id.action_nav_to_webviewFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}