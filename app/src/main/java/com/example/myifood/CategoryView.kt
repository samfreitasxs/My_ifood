package com.example.myifood

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.example.myifood.databinding.CategoryItemBinding

class CategoryView(viewGroup: ViewGroup): ATViewHolder <Category, CategoryItemBinding> (
    CategoryItemBinding::inflate,
    viewGroup
)   {

    override fun bind(item: Category) {
        binding.txtCategory.text = item.nome
        }

    }