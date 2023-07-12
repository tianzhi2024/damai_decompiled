package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface MaybeConverter<T, R> {
    @NonNull
    R apply(@NonNull AbstractC8148c<T> abstractC8148c);
}
