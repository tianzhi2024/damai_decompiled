package io.reactivex.internal.operators.single;

import io.reactivex.AbstractC8152e;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.C8151a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleFromCallable<T> extends AbstractC8152e<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // io.reactivex.AbstractC8152e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable b = C8151a.b();
        singleObserver.onSubscribe(b);
        if (b.isDisposed()) {
            return;
        }
        try {
            Object obj = (Object) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
            if (b.isDisposed()) {
                return;
            }
            singleObserver.onSuccess(obj);
        } catch (Throwable th) {
            dg0.b(th);
            if (!b.isDisposed()) {
                singleObserver.onError(th);
            } else {
                i42.u(th);
            }
        }
    }
}
