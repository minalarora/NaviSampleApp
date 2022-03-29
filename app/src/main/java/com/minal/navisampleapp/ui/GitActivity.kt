package com.minal.navisampleapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.minal.navisampleapp.R
import com.minal.navisampleapp.base.Result.*
import com.minal.navisampleapp.databinding.ActivityGitBinding
import com.minal.navisampleapp.di.Injectable
import com.minal.navisampleapp.di.injectViewModel
import com.minal.navisampleapp.ui.adapter.GitAdapter
import javax.inject.Inject

class GitActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GitViewModel
    private lateinit var binding: ActivityGitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        binding = DataBindingUtil.setContentView<ActivityGitBinding?>(this,R.layout.activity_git).apply {
            isLoading = ObservableBoolean(true)
            lifecycleOwner = this@GitActivity
        }

        binding.recyclerView.adapter = GitAdapter()

        subscribeUi(binding, viewModel)
    }

    private fun subscribeUi(binding: ActivityGitBinding, viewModel: GitViewModel) {
        viewModel.pullRequests.observe(this) { result ->
            when (result.status) {

                Status.SUCCESS -> {
                    binding.isLoading?.set(false)
                    result.data?.let { (binding.recyclerView.adapter as GitAdapter).submitList(it) }
                }

                Status.LOADING -> binding.isLoading?.set(true)

                Status.ERROR -> {
                    binding.isLoading?.set(false)
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }

            }
        }
    }
}