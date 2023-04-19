package com.example.tvshowapp.repository

import com.example.tvshowapp.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor( private val serviseApi: ApiService ) {
    suspend fun getTvShows() = serviseApi.getTvShows()





}