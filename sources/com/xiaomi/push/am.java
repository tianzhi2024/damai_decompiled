package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class am extends al.RunnableC7598b {
    final /* synthetic */ al a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f91a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f92a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, al.AbstractRunnableC7597a abstractRunnableC7597a, boolean z, String str) {
        super(abstractRunnableC7597a);
        this.a = alVar;
        this.f92a = z;
        this.f91a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.al.RunnableC7598b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.al.RunnableC7598b
    void b() {
        SharedPreferences sharedPreferences;
        if (this.f92a) {
            return;
        }
        sharedPreferences = this.a.f87a;
        sharedPreferences.edit().putLong(this.f91a, System.currentTimeMillis()).commit();
    }
}
