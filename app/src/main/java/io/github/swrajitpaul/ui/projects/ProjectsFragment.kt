package io.github.swrajitpaul.ui.projects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.swrajitpaul.R
import io.github.swrajitpaul.data.Projects
import io.github.swrajitpaul.databinding.FragmentProjectsBinding


class ProjectsFragment : Fragment(), ProjectRecyclerAdapter.ProjectItemListener {
    private var _binding: FragmentProjectsBinding? = null
    private lateinit var viewModel: SharedViewModel
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        recyclerView = binding.projectRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.projectsList.observe(this, Observer {
            val adapter = ProjectRecyclerAdapter(requireContext(), it, this)
            recyclerView.adapter = adapter
        })
        return binding.root
    }

    override fun onProjectItemClick(projects: Projects) {
        viewModel.project.value = projects
        findNavController().navigate(R.id.action_nav_to_detailsFragment)
    }

}