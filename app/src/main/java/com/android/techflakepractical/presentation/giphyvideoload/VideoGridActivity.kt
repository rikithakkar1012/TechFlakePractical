package com.android.techflakepractical.presentation.giphyvideoload

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.techflakepractical.R
import com.android.techflakepractical.data.VideosModel
import com.android.techflakepractical.domain.common.Resource
import com.android.techflakepractical.domain.common.SafeObserver
import com.android.techflakepractical.domain.common.Status
import com.android.techflakepractical.extenstion.hide
import com.android.techflakepractical.extenstion.show
import com.android.techflakepractical.presentation.common.BaseViewModelActivity
import com.android.techflakepractical.presentation.exoplayer.VideoPlayerActivity
import com.android.techflakepractical.utils.ToastUtils
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.activity_giphy_videos.*


class VideoGridActivity : BaseViewModelActivity<VideoGridViewModel>(),
    View.OnClickListener {

    private val giphyVideoAdapter by lazy { VideoAdapter(this::onItemSelected) }

    override fun getContentResource() = R.layout.activity_giphy_videos

    override fun buildViewModel(): VideoGridViewModel {
        return ViewModelProviders.of(this)[VideoGridViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        supportActionBar?.hide()
        rvGiphyVideos.setHasFixedSize(true)
        rvGiphyVideos.adapter = giphyVideoAdapter

        // call this method only once
        viewModel.configureAutoComplete()

        ivClear.setOnClickListener(this)
        ivBack.setOnClickListener(this)

        RxTextView.afterTextChangeEvents(etQuery)
            .skipInitialValue()
            .subscribe {
                viewModel.pageNumber = 1
                viewModel.onInputStateChanged(it.editable()?.trim().toString())
            }.collect()

        rvGiphyVideos.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = rvGiphyVideos.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!viewModel.isLoading && !viewModel.isLastPage) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                        viewModel.onInputStateChanged(etQuery.text.toString())
                    }
                }
            }
        })

    }


    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.showClearButtonLiveData.observe(
            this,
            SafeObserver(this::handleClearButtonVisibility)
        )
        viewModel.giphyResponseLiveData.observe(this, SafeObserver(this::handleAutoCompleteData))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> onBackPressed()
            R.id.ivClear -> etQuery.setText("")
        }
    }

    private fun handleClearButtonVisibility(visible: Boolean) {
        if (visible) ivClear.show()
        else ivClear.hide()
    }

    private fun handleAutoCompleteData(response: Resource<VideosModel>) {
        when (response.status) {
            Status.LOADING -> progressBar.show()
            Status.SUCCESS -> handleAutocompleteSuccessResponse(response.item)
            Status.ERROR -> handleAutocompleteErrorResponse(response)
        }
    }

    private fun handleAutocompleteSuccessResponse(result: VideosModel?) {
        progressBar.hide()
        result?.let { it ->
            giphyVideoAdapter.setList(it.data, viewModel.pageNumber == 1, this)

        }
    }

    private fun handleAutocompleteErrorResponse(response: Resource<VideosModel>) {
        progressBar.hide()
        response.throwable?.let {
            ToastUtils.showToast(this, it.message)
        }
    }

    private fun onItemSelected(selectedPlace: VideosModel.DataBean) {
        val intent = Intent(this@VideoGridActivity, VideoPlayerActivity::class.java)
        intent.putExtra("url", selectedPlace.images!!.original_mp4!!.mp4)
        intent.putExtra("id", selectedPlace.id)
        startActivity(intent)

    }
}