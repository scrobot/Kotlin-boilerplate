package com.github.scrobot.kotlin_boilerplate.global


import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.business.entities.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by alexscrobot on 16.11.17.
 */
interface BackendApi {

    // Service Queries
    @GET("character")
    fun charactersList(@Query("page") page: Int? = null): Observable<ResponseWrapper<CartoonCharacter>>

    @GET("character/{id}")
    fun character(@Path("id") characterId: Long): Observable<CartoonCharacter>

}