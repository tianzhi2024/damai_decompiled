package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.ae */
/* loaded from: classes11.dex */
final class C7721ae extends XMPushService.AbstractC7707j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f874a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f875a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7721ae(int i, XMPushService xMPushService, Cif cif, String str, String str2) {
        super(i);
        this.f874a = xMPushService;
        this.a = cif;
        this.f875a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        try {
            Cif a = C7782y.a((Context) this.f874a, this.a);
            a.f618a.a("error", this.f875a);
            a.f618a.a("reason", this.b);
            ah.a(this.f874a, a);
        } catch (gh e) {
            AbstractC7535b.a(e);
            this.f874a.a(10, e);
        }
    }
}
