package com.minal.navisampleapp.util

import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.minal.navisampleapp.R
import com.minal.navisampleapp.base.MyAppGlideModule
import de.hdodenhof.circleimageview.CircleImageView

    @BindingAdapter("hideIfFalse")
    fun hideIfFalse(view: View, boo: Boolean) {
        if (boo) view.visibility = View.VISIBLE else view.visibility = View.GONE
    }

    @BindingAdapter("invisibleIfFalse")
    fun invisibleIfFalse(view: View, boo: Boolean) {
        if (boo) view.visibility = View.VISIBLE else view.visibility = View.INVISIBLE
    }

    @BindingAdapter("hideIfTrue")
    fun hideIfTrue(view: View, boo: Boolean) {
        if (!boo) view.visibility = View.VISIBLE else view.visibility = View.GONE
    }

    @BindingAdapter("invisibleIfTrue")
    fun invisibleIfTrue(view: View, boo: Boolean) {
        if (!boo) view.visibility = View.VISIBLE else view.visibility = View.INVISIBLE
    }


    @BindingAdapter("glideImage")
    fun setImage(imageView: ImageView, url: String?) {

        Glide.with(imageView.context)
            .load(url)
            .placeholder(ColorDrawable(ContextCompat.getColor(imageView.context, R.color.white)))
            .error(ColorDrawable(ContextCompat.getColor(imageView.context, R.color.white)))
            .apply(MyAppGlideModule.requestOptions)
            .into(imageView);
    }

    @BindingAdapter("glideImage")
    fun setImage(imageView: CircleImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(ColorDrawable(ContextCompat.getColor(imageView.context, R.color.white)))
            .error(ColorDrawable(ContextCompat.getColor(imageView.context, R.color.white)))
            .apply(MyAppGlideModule.requestOptions)
            .into(imageView);
    }
