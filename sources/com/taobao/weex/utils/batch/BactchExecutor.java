package com.taobao.weex.utils.batch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface BactchExecutor {
    void post(Runnable runnable);

    void setInterceptor(Interceptor interceptor);
}
