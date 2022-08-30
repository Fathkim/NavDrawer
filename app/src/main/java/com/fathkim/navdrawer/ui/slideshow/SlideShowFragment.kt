package com.fathkim.navdrawer.ui.slideshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.fathkim.navdrawer.R
import com.fathkim.navdrawer.databinding.FragmentSlideShowBinding

class SlideShowFragment : Fragment() {

    private var _binding: FragmentSlideShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val slideShowViewModel =
            ViewModelProvider(this).get(SlideShowViewModel::class.java)

        _binding = FragmentSlideShowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideShowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}