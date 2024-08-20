package com.pandora.gamedatabases.detail

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.pandora.gamedatabases.R
import com.pandora.gamedatabases.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = DetailFragmentArgs.fromBundle(arguments as Bundle)

        binding?.tvTitle?.text = data.data?.name
        Glide.with(requireContext())
            .load(data.data!!.backgroundImage)
            .into(binding!!.ivPoster)
        binding?.tvReleaseDate?.text = getString(R.string.release_date_s, data.data!!.released)
        binding?.tvRating?.text = getString(R.string.rating_s, data.data!!.rating.toString())
        binding?.tvMetacritic?.text = getString(R.string.metacritic_d, data.data!!.metacritic)

        var statusFavorite = data.data!!.isFavorite
        setStatusFavorite(statusFavorite)
        binding?.btnFavorite?.setOnClickListener {
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteGame(data.data!!, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(b: Boolean) {
        if (b) {
            binding?.btnFavorite?.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
            binding?.btnFavorite?.text = getString(R.string.remove_from_favorites)
        } else {
            binding?.btnFavorite?.iconTint = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white))
            binding?.btnFavorite?.text = getString(R.string.add_to_favorites)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}