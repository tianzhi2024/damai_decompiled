package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.ad */
/* loaded from: classes11.dex */
final class C7720ad extends XMPushService.AbstractC7707j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f872a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7720ad(int i, XMPushService xMPushService, Cif cif, String str) {
        super(i);
        this.f872a = xMPushService;
        this.a = cif;
        this.f873a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            Cif a = C7782y.a((Context) this.f872a, this.a);
            a.m1022a().a("absent_target_package", this.f873a);
            ah.a(this.f872a, a);
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.f872a.a(10, e);
        }
    }
}
