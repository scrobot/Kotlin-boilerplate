package ru.five_dots.kotlin_boilerplate

import ru.five_dots.kotlin_boilerplate.network.Book
import ru.five_dots.kotlin_boilerplate.network.Service
import ru.five_dots.kotlin_boilerplate.util.network.RetrofitService
import rus.pifpaf.client.util.rx.RxDecorator
import rx.Observable
import rx.functions.Func1



/**
 * Created by aleksejskrobot on 21.02.17.
 */
class Repository {

    private val http = RetrofitService().retrofit().create(Service::class.java)

    private fun books(offset: Int): Observable<List<Book>> {
        return RxDecorator<List<Book>>().decorate(http.books(offset, 1))
    }

    fun loadPerPage(page: Int): Observable<List<Book>>? {
        var counter = page

        return books(page)
                .concatMap(Func1<List<Book>, Observable<List<Book>>> { response ->
                    // Terminal case.
                    if (response.isEmpty()) {
                        return@Func1 Observable.just(response)
                    }

                    counter++

                    Observable.just(response)
                            .concatWith(loadPerPage(counter))
                })
    }

}