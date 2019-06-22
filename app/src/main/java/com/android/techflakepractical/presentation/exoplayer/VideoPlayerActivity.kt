package com.android.techflakepractical.presentation.exoplayer

import android.graphics.Color
import android.net.Uri
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import com.android.techflakepractical.R
import com.android.techflakepractical.domain.common.SafeObserver
import com.android.techflakepractical.presentation.common.BaseViewModelActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_video_player.*


class VideoPlayerActivity : BaseViewModelActivity<VideoPlayerViewModel>(), View.OnClickListener {

    private lateinit var player: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: com.google.android.exoplayer2.upstream.DataSource.Factory

    private var trackSelector: DefaultTrackSelector? = null
    private var lastSeenTrackGroupArray: TrackGroupArray? = null
    private val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory()
    private var currentWindow: Int = 0
    private var playbackPosition: Long = 0
    private var strUrl: String? = ""
    private var strId: String? = ""

    override fun getContentResource(): Int {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        return R.layout.activity_video_player
    }

    override fun buildViewModel(): VideoPlayerViewModel {
        return ViewModelProviders.of(this, VideoPlayerViewModelFactory(strId!!))[VideoPlayerViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        supportActionBar?.hide()
        imgUpvote.setOnClickListener(this)
        imgDownVote.setOnClickListener(this)
    }

    override fun getBundle() {
        super.getBundle()
        strId = intent?.extras?.getString("id", "")
        strUrl = intent?.extras?.getString("url", "")
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.imgUpvote -> {
                viewModel.increment()
            }
            R.id.imgDownVote -> {
                viewModel.decrement()

            }
        }
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.countLiveData.observe(this, SafeObserver(this::updateCount))
    }

    private fun updateCount(count: Int) {
        txtCount.text = "" + count
    }

    private fun initializePlayer() {
        trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        mediaDataSourceFactory = DefaultDataSourceFactory(this, Util.getUserAgent(this, "mediaPlayerSample"))
        val mediaSource = ExtractorMediaSource.Factory(mediaDataSourceFactory)
            .createMediaSource(Uri.parse(strUrl))
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        with(player) {
            prepare(mediaSource, false, false)
            playWhenReady = true
        }

        player.addListener(object : ExoPlayer.EventListener {
            override fun onLoadingChanged(isLoading: Boolean) {

            }

            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                when (playbackState) {
                    Player.STATE_READY -> progressBar?.visibility = View.GONE
                    Player.STATE_BUFFERING -> progressBar?.visibility = View.VISIBLE
                    Player.STATE_IDLE -> progressBar?.visibility = View.GONE
                    Player.STATE_ENDED -> {
                        progressBar?.visibility = View.GONE
                        player.seekTo(0)
                        player.playWhenReady = true
                    }

                }
            }

            fun onTimelineChanged(timeline: Timeline, manifest: Any) {

            }

            override fun onPlayerError(error: ExoPlaybackException?) {

            }

            fun onPositionDiscontinuity() {
                //THIS METHOD GETS CALLED FOR EVERY NEW SOURCE THAT IS PLAYED
                val latestWindowIndex = player.getCurrentWindowIndex()
                if (latestWindowIndex != currentWindow) {
                    // item selected in playlist has changed, handle here
                    currentWindow = latestWindowIndex
                    // ...
                }
            }
        })
        playerView?.setShutterBackgroundColor(Color.TRANSPARENT)
        playerView?.player = player
        playerView?.requestFocus()
        lastSeenTrackGroupArray = null
    }


    private fun updateStartPosition() {
        with(player) {
            playbackPosition = currentPosition
            currentWindow = currentWindowIndex
            playWhenReady = playWhenReady
        }
    }

    private fun releasePlayer() {
        updateStartPosition()
        player.release()
        trackSelector = null
    }

    public override fun onStart() {
        super.onStart()

        if (Util.SDK_INT > 23) initializePlayer()
    }

    public override fun onResume() {
        super.onResume()

        if (Util.SDK_INT <= 23) initializePlayer()
    }

    public override fun onPause() {
        super.onPause()

        if (Util.SDK_INT <= 23) releasePlayer()
    }

    public override fun onStop() {
        super.onStop()

        if (Util.SDK_INT > 23) releasePlayer()
    }

}