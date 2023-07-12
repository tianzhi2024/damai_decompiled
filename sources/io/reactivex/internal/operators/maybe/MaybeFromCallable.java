package io.reactivex.internal.operators.maybe;

import io.reactivex.AbstractC8148c;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.C8151a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeFromCallable<T> extends AbstractC8148c<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.callable.call();
    }

    @Override // io.reactivex.AbstractC8148c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = C8151a.b();
        maybeObserver.onSubscribe(b);
        if (b.isDisposed()) {
            return;
        }
        try {
            Object obj = (T) this.callable.call();
            if (b.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (Throwable th) {
            dg0.b(th);
            if (!b.isDisposed()) {
                maybeObserver.onError(th);
            } else {
                i42.u(th);
            }
        }
    }
}
