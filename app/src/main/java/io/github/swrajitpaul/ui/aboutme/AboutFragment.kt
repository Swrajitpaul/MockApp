package io.github.swrajitpaul.ui.aboutme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.swrajitpaul.databinding.FragmentAboutBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private lateinit var viewModel: AboutMeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(AboutMeViewModel::class.java)
        viewModel.aboutMeData.observe(this, Observer {
            binding.scrollableTextview.setText(HtmlCompat.fromHtml(it, 0))
        })

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}