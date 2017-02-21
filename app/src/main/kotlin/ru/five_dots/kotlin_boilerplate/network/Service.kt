package ru.five_dots.kotlin_boilerplate.network

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by aleksejskrobot on 21.02.17.
 */
interface Service {

    @GET("/api/books")
    fun books(@Query("page") page: Int, @Query("pageSize") size: Int): Observable<List<Book>>

}