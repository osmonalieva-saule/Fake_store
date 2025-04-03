package com.example.myapplication.presentation.fragment

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.view_model.ProductViewModel
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private val viewModel: ProductViewModel by viewModel()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            lifecycleScope.launch {
                viewModel.products.collect { products ->
                    adapter = ProductAdapter(products)
                    recyclerView.adapter = adapter
                }
            }
        }
    }


