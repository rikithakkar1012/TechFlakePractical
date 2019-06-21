package com.android.techflakepractical.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VideosModel {

    // var pagination: PaginationBean? = null
    var meta: MetaBean? = null
    var data: ArrayList<DataBean>? = null

//    class PaginationBean {
//        /**
//         * total_count : 95353
//         * count : 25
//         * offset : 0
//         */
//
//        var total_count: Int = 0L̥
//        var count: Int = 0
//        var offset: Int = 0
//    }

    class MetaBean {
        /**
         * status : 200
         * msg : OK
         * response_id : 5d065c9445773744639285cc
         */

        var status: Int = 0
        var msg: String? = null
        var response_id: String? = null
    }

    class DataBean {

        //var type: String? = null
        var id: String? = null
        //        var slug: String? = null
//        var url: String? = null
//        var bitly_gif_url: String? = null
//        var bitly_url: String? = null
//        var embed_url: String? = null
//        var username: String? = null
//        var source: String? = null
//        var rating: String? = null
//        var content_url: String? = null
//        var source_tld: String? = null
//        var source_post_url: String? = null
//        var is_sticker: Int = 0
//        var import_datetime: String? = null
//        var trending_datetime: String? = null
        var images: ImagesBean? = null
//        var title: String? = null
//        var analytics: AnalyticsBean? = null
//        var user: UserBean? = null

        class ImagesBean {

            //            var fixed_height_still: FixedHeightStillBean? = null
//            var original_still: OriginalStillBean? = null
//            var fixed_width: FixedWidthBean? = null
//            var fixed_height_small_still: FixedHeightSmallStillBean? = null
//            var fixed_height_downsampled: FixedHeightDownsampledBean? = null
//            var preview: PreviewBean? = null
//            var fixed_height_small: FixedHeightSmallBean? = null
//            var downsized_still: DownsizedStillBean? = null
//            var downsized: DownsizedBean? = null
//            var downsized_large: DownsizedLargeBean? = null
//            var fixed_width_small_still: FixedWidthSmallStillBean? = null
//            var preview_webp: PreviewWebpBean? = null
//            var fixed_width_still: FixedWidthStillBean? = null
//            var fixed_width_small: FixedWidthSmallBean? = null
//            var downsized_small: DownsizedSmallBean? = null
//            var fixed_width_downsampled: FixedWidthDownsampledBean? = null
//            var downsized_medium: DownsizedMediumBean? = null
//            var original: OriginalBean? = null
//            var fixed_height: FixedHeightBean? = null
//            var looping: LoopingBean? = null
            var original_mp4: OriginalMp4Bean? = null
            //var preview_gif: PreviewGifBean? = null
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


//            class FixedHeightStillBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/200_s.gif?cid=01a056e65d065c9445773744639285cc&rid=200_s.gif
//                 * width : 200
//                 * height : 200
//                 * size : 14369
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class OriginalStillBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/giphy_s.gif?cid=01a056e65d065c9445773744639285cc&rid=giphy_s.gif
//                 * width : 200
//                 * height : 200
//                 * size : 14369
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class FixedWidthBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/200w.gif?cid=01a056e65d065c9445773744639285cc&rid=200w.gif
//                 * width : 200
//                 * height : 200
//                 * size : 132910
//                 * mp4 : https://media1.giphy.com/media/mlvseq9yvZhba/200w.mp4?cid=01a056e65d065c9445773744639285cc&rid=200w.mp4
//                 * mp4_size : 16843
//                 * webp : https://media1.giphy.com/media/mlvseq9yvZhba/200w.webp?cid=01a056e65d065c9445773744639285cc&rid=200w.webp
//                 * webp_size : 165070
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class FixedHeightSmallStillBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/100_s.gif?cid=01a056e65d065c9445773744639285cc&rid=100_s.gif
//                 * width : 100
//                 * height : 100
//                 * size : 4400
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class FixedHeightDownsampledBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/200_d.gif?cid=01a056e65d065c9445773744639285cc&rid=200_d.gif
//                 * width : 200
//                 * height : 200
//                 * size : 73055
//                 * webp : https://media1.giphy.com/media/mlvseq9yvZhba/200_d.webp?cid=01a056e65d065c9445773744639285cc&rid=200_d.webp
//                 * webp_size : 76088
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class PreviewBean {
//                /**
//                 * width : 200
//                 * height : 200
//                 * mp4 : https://media1.giphy.com/media/mlvseq9yvZhba/giphy-preview.mp4?cid=01a056e65d065c9445773744639285cc&rid=giphy-preview.mp4
//                 * mp4_size : 41111
//                 */
//
//                var width: String? = null
//                var height: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//            }

//            class FixedHeightSmallBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/100.gif?cid=01a056e65d065c9445773744639285cc&rid=100.gif
//                 * width : 100
//                 * height : 100
//                 * size : 33264
//                 * mp4 : https://media1.giphy.com/media/mlvseq9yvZhba/100.mp4?cid=01a056e65d065c9445773744639285cc&rid=100.mp4
//                 * mp4_size : 6437
//                 * webp : https://media1.giphy.com/media/mlvseq9yvZhba/100.webp?cid=01a056e65d065c9445773744639285cc&rid=100.webp
//                 * webp_size : 53830
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class DownsizedStillBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/giphy-downsized_s.gif?cid=01a056e65d065c9445773744639285cc&rid=giphy-downsized_s.gif
//                 * width : 200
//                 * height : 200
//                 * size : 14369
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class DownsizedBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/giphy-downsized.gif?cid=01a056e65d065c9445773744639285cc&rid=giphy-downsized.gif
//                 * width : 200
//                 * height : 200
//                 * size : 132937
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class DownsizedLargeBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/giphy.gif~c200?cid=01a056e65d065c9445773744639285cc&rid=giphy.gif~c200
//                 * width : 200
//                 * height : 200
//                 * size : 132937
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class FixedWidthSmallStillBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/100w_s.gif?cid=01a056e65d065c9445773744639285cc&rid=100w_s.gif
//                 * width : 100
//                 * height : 100
//                 * size : 4400
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class PreviewWebpBean {
//                /**
//                 * url : https://media1.giphy.com/media/mlvseq9yvZhba/giphy-preview.webp?cid=01a056e65d065c9445773744639285cc&rid=giphy-preview.webp
//                 * width : 148
//                 * height : 148
//                 * size : 49660
//                 */
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class FixedWidthStillBean {
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class FixedWidthSmallBean {
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class DownsizedSmallBean {
//                var width: String? = null
//                var height: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//            }

//            class FixedWidthDownsampledBean {
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class DownsizedMediumBean {
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

//            class OriginalBean {
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var frames: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//                var hash: String? = null
//            }

//            class FixedHeightBean {
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//                var mp4: String? = null
//                var mp4_size: String? = null
//                var webp: String? = null
//                var webp_size: String? = null
//            }

//            class LoopingBean {
//
//
//                var mp4: String? = null
//                var mp4_size: String? = null
//            }

            class OriginalMp4Bean {


                var width: String? = null
                var height: String? = null
                var mp4: String? = null
                var mp4_size: String? = null
            }

//            class PreviewGifBean {
//
//
//                var url: String? = null
//                var width: String? = null
//                var height: String? = null
//                var size: String? = null
//            }

        }

//        class AnalyticsBean {
//
//            var onload: OnloadBean? = null
//            var onclick: OnclickBean? = null
//            var onsent: OnsentBean? = null
//
//            class OnloadBean {
//                var url: String? = null
//            }
//
//            class OnclickBean {
//                var url: String? = null
//            }
//
//            class OnsentBean {
//                var url: String? = null
//            }
//        }

//        class UserBean {
//            var avatar_url: String? = null
//            var banner_url: String? = null
//            var banner_image: String? = null
//            var profile_url: String? = null
//            var username: String? = null
//            var display_name: String? = null
//            var isIs_verified: Boolean = false
//        }
    }
}
