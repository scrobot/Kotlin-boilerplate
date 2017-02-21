package rus.pifpaf.client.util.rx

import net.vgorodke.vgorodke.util.rx.RxSchedulers
import rx.Observable

/**
 * Created by aleksejskrobot on 26.11.16.
 */
class RxDecorator<T> {

    fun decorate(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(RxSchedulers().getIOScheduler()).observeOn(RxSchedulers().getMainThreadScheduler())
    }

}