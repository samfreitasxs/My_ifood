package com.example.myifood

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.example.myifood.databinding.FragmentRestaurantBinding

class RestaurantFrangment : Fragment(R.layout.fragment_restaurant){

    private var binding: FragmentRestaurantBinding? = null

    private val categoryAdapter = ATAdapter ({
        CategoryView(it)
    })

     private var filters = arrayOf(
         FilterItem(1,"Ordenar", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
         FilterItem(2,"Pra retirar", icon = R.drawable.ic_baseline_directions_walk_24),
         FilterItem(3,"Entrega gratis", ),
         FilterItem(4,"Vale-refeicao", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
         FilterItem(5,"Distancia",closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
         FilterItem(6,"Entrega Parceria"),
         FilterItem(7,"Super Restaurante"),
         FilterItem(8,"Filtros", closeIcon = R.drawable.ic_baseline_filter_list_24),
     )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(1, "https:ifood.com.br/static/images/categories/market.png", "Mercado", 0xFFB6D048)
        )

        binding = FragmentRestaurantBinding.bind(view)

        binding?.let {
            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }
}

