package io.github.swrajitpaul.ui.webviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.swrajitpaul.SharedViewModel
import io.github.swrajitpaul.databinding.FragmentWebviewBinding


class WebviewFragment : Fragment() {
    private var binding: FragmentWebviewBinding? = null
    private lateinit var viewModel: SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebviewBinding.inflate(inflater, container, false )

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        viewModel.urlString.observe(this, Observer {
            binding?.webView?.settings?.javaScriptEnabled = true
            binding?.webView?.loadUrl(it)

        })


        return binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}