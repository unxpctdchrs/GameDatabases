package com.pandora.gamedatabases.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.pandora.gamedatabases.core.domain.model.Game
import com.pandora.gamedatabases.core.ui.GameAdapter
import com.pandora.gamedatabases.favorite.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        if (activity != null) {
            with(binding?.rvItems) {
                this?.layoutManager = GridLayoutManager(requireContext(), 2)
                this?.setHasFixedSize(true)
            }

            favoriteViewModel.favoriteGame.observe(viewLifecycleOwner) { game ->
                loadGames(game)
                binding?.tvNoData?.visibility = if (game.isNotEmpty()) View.GONE else View.VISIBLE
            }
        }
    }

    private fun loadGames(games: List<Game>) {
        val adapter = GameAdapter { game ->
            onGameClicked(game)
        }
        adapter.submitList(games)
        binding?.rvItems?.adapter = adapter
    }

    private fun onGameClicked(game: Game) {
        val toDetailFragment = FavoriteFragmentDirections.actionNavigationFavoriteToDetailFragment()
        toDetailFragment.data = game
        findNavController().navigate(toDetailFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}