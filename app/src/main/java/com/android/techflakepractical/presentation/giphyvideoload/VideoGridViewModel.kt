package com.android.techflakepractical.presentation.giphyvideoload

import androidx.lifecycle.MutableLiveData
import com.android.techflakepractical.data.VideosModel
import com.android.techflakepractical.domain.common.Resource
import com.android.techflakepractical.domain.common.Status
import com.android.techflakepractical.domain.repository.WebApiClient
import com.android.techflakepractical.presentation.common.BaseViewModel
import com.android.techflakepractical.utils.KeyUtils
import com.android.techflakepractical.utils.Logger
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class VideoGridViewModel : BaseViewModel() {
    val TAG = VideoGridViewModel::class.java.simpleName
    val autoCompleteLiveData = MutableLiveData<Resource<VideosModel>>()
    val showClearButtonLiveData = MutableLiveData<Boolean>()
    private val autoCompletePublishSubject = PublishRelay.create<String>()
    private var hashMap = HashMap<String, String>().apply {
        put(KeyUtils.API_KEY, KeyUtils.API_VALUE)
    }

    var isLoading = false
    var isLastPage = false
    private val PAGE_LIMIT = 25
    var pageNumber = 1

    fun configureAutoComplete() {
        autoCompletePublishSubject
            .debounce(KeyUtils.DEBOUNCE_INTERVAL, TimeUnit.MILLISECONDS)
            .filter { it.trim().length >= KeyUtils.DEFAULT_MIN_CHAR }
            .flatMap {
                isLastPage = false
                hashMap.apply {
                    put(KeyUtils.QUERY, it)
                    put(KeyUtils.OFFSET, pageNumber.toString())
                    put(KeyUtils.LIMIT, PAGE_LIMIT.toString())
                }
                callAutoCompleteAPI()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                onAutoCompleteResultReceived(result)
            }, {
                autoCompleteLiveData.value = Resource(Status.ERROR, it)
                Logger.e(TAG, "Failed to get search results $it")
            }).collect()
    }

    private fun onAutoCompleteResultReceived(result: VideosModel) {
        isLoading = false
        if (result.meta?.status == KeyUtils.HTTP_SUCCESS) {
            if (result.data?.size!! < PAGE_LIMIT) {
                isLastPage = true
            }
            autoCompleteLiveData.value = Resource(Status.SUCCESS, result)
            pageNumber += 1
        } else {
            autoCompleteLiveData.value = Resource(Status.ERROR, result)
        }
    }

    fun onInputStateChanged(query: String) {
        showClearButtonLiveData.value = query.isNotEmpty() // query.length > 0 with empty check
        if (query.length >= KeyUtils.DEFAULT_MIN_CHAR) {
            isLoading = true
            autoCompleteLiveData.value = Resource(Status.LOADING)
        } else {
            isLoading = false
            autoCompleteLiveData.value = Resource(Status.ERROR)
        }
        autoCompletePublishSubject.accept(query.trim())
    }

    private fun callAutoCompleteAPI(): Observable<VideosModel> {
        return WebApiClient.webApi.searchGiphyVideos(hashMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}