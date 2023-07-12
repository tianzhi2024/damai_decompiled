package com.alibaba.pictures.bricks.util.blur;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Cache<K, V> {
    void clear();

    V get(K k);

    void save(K k, V v);
}
