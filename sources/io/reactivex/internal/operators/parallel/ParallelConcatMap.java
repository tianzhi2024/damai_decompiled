package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.AbstractC8161a;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ParallelConcatMap<T, R> extends AbstractC8161a<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final AbstractC8161a<T> source;

    public ParallelConcatMap(AbstractC8161a<T> abstractC8161a, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.source = abstractC8161a;
        this.mapper = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.prefetch = i;
        this.errorMode = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
    }

    @Override // io.reactivex.parallel.AbstractC8161a
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.AbstractC8161a
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableConcatMap.subscribe(subscriberArr[i], this.mapper, this.prefetch, this.errorMode);
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
