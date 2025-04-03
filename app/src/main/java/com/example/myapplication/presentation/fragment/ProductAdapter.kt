package com.example.myapplication.presentation.fragment
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.model.ProductDto

class ProductAdapter(private val products: List<ProductDto>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.productTitle)
        private val price: TextView = view.findViewById(R.id.productPrice)
        private val image: ImageView = view.findViewById(R.id.productImage)

        @SuppressLint("SetTextI18n")
        fun bind(product: ProductDto) {
            title.text = product.title
            price.text = "$${product.price}"
            Glide.with(image.context).load(product.image).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size
}