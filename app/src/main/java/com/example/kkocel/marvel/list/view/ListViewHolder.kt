package com.example.kkocel.marvel.list.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kkocel.marvel.detail.view.ComicDetailActivity
import com.example.kkocel.marvel.model.Comic
import com.example.kkocel.marvel.view.ThumbnailUrlLoader
import kotlinx.android.synthetic.main.comic_list_content.view.*

class ListViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {

    fun bindComic(comic: Comic) {
        val context = itemView.context

        itemView.txtListComicName.text = comic.title

        Glide.with(context)
                .using(ThumbnailUrlLoader(context))
                .load(comic.imageUrl)
                .into(itemView.imgListComicThumbnail)

        itemView.setOnClickListener {
            context.startActivity(
                    Intent(context, ComicDetailActivity::class.java)
                            .putExtra(ComicDetailActivity.COMIC_ID, comic.id))
        }
    }
}