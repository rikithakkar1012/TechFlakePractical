package com.android.techflakepractical.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VideosModel {

    // var pagination: PaginationBean? = null
    @Expose
    var meta: MetaBean? = null
    @Expose
    var data: ArrayList<DataBean>? = null

    class MetaBean {
        @Expose
        var status: Int = 0
        @Expose
        var msg: String? = null
        @Expose
        var response_id: String? = null
    }

    class DataBean {
        @Expose
        var id: String? = null
        @Expose
        var images: ImagesBean? = null

        class ImagesBean {
            @Expose
            var original_mp4: OriginalMp4Bean? = null
            //var preview_gif: PreviewGifBean? = null
            @Expose
            @SerializedName("480w_still")
            var img_to_load: _480wStill? = null

            inner class _480wStill {

                @SerializedName("url")
                @Expose
                var url: String? = null
                @SerializedName("width")
                @Expose
                var width: String? = null
                @SerializedName("height")
                @Expose
                var height: String? = null
            }

            class OriginalMp4Bean {
                @Expose
                var width: String? = null
                @Expose
                var height: String? = null
                @Expose
                var mp4: String? = null
                @Expose
                var mp4_size: String? = null
            }
        }
    }
}
