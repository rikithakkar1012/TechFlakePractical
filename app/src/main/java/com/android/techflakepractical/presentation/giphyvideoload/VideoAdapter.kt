package com.android.techflakepractical.presentation.giphyvideoload

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.techflakepractical.R
import com.android.techflakepractical.data.VideosModel
import com.android.techflakepractical.extenstion.inflate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_giphy_videos.view.*

class VideoAdapter(private val onItemSelected: (data: VideosModel.DataBean) -> Unit) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    var videos = ArrayList<VideosModel.DataBean>()
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(parent.inflate(R.layout.row_giphy_videos))
    }

    fun setList(predictions: ArrayList<VideosModel.DataBean>?, clear: Boolean = false , context: Context) {
        this.context = context
        if (clear) this.videos.clear()
        predictions?.let {
            this.videos.addAll(it)
        }
        notifyDataSetChanged()
    }


    fun clearList() {
        this.videos.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount() = videos.size


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(prediction: VideosModel.DataBean) {

            context?.let { Glide.with(it).load(prediction.images!!.img_to_load!!.url).into(itemView.imgVideoThumb) }

            //itemView.tvPlaceName.text = prediction.id
            itemView.setOnClickListener {
                onItemSelected(prediction)
            }
        }
    }
}