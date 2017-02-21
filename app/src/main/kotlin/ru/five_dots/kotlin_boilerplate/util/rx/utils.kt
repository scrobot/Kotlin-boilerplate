package rus.pifpaf.client.util.rx

import rx.Subscription

fun Subscription?.unSubscribeIfNotNull() {
    this?.unsubscribe()
}