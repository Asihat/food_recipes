package com.example.foodrecipes.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.foodrecipes.R
import com.example.foodrecipes.databinding.FragmentOverviewBinding
import com.example.foodrecipes.models.Result
import com.example.foodrecipes.utils.Constants.Companion.RECIPE_RESULT_KEY
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        binding.mainImageView.load(myBundle?.image)
        binding.timeTextView.text = myBundle?.title
        binding.likesTextView.text = myBundle?.aggregateLikes.toString()
        binding.timeTextView.text = myBundle?.readyInMinutes.toString()
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            binding.summaryTextView.text = summary
        }

        if (myBundle?.vegetarian == true) {
            binding.veganImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.veganTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.vegan == true) {
            binding.vegetarianImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.vegetarianTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.glutenFree == true) {
            binding.glutenfreeImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.glutenFreeTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }


        if (myBundle?.dairyFree == true) {
            binding.dairyFreeImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.dairyFreeTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.veryHealthy == true) {
            binding.healthyImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.healthyTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }

        if (myBundle?.cheap == true) {
            binding.cheapImageView.setColorFilter(ContextCompat.getColor(requireContext(),
                R.color.green))
            binding.cheapTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.green))
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}