package com.minal.navisampleapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minal.navisampleapp.data.model.Git
import com.minal.navisampleapp.databinding.ItemGitBinding

/**
 * Adapter for the [RecyclerView] in [GitActivity].
 */
class GitAdapter : ListAdapter<Git, GitAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val git = getItem(position)
        holder.apply {
            bind(git)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGitBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }


    class ViewHolder(
        private val binding: ItemGitBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind( item: Git) {
            binding.apply {
                viewmodel = GitItemViewModel(this.root.context, item)
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Git>() {

    override fun areItemsTheSame(oldItem: Git, newItem: Git): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Git, newItem: Git): Boolean {
        return oldItem.id == newItem.id
    }
}