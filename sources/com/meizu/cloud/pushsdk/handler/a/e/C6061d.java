package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.AbstractC6033a;
import com.meizu.cloud.pushsdk.handler.a.AbstractC6034a;
import com.meizu.cloud.pushsdk.notification.InterfaceC6080c;
import com.meizu.cloud.pushsdk.platform.message.C6100a;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.util.C6102b;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.e.d */
/* loaded from: classes10.dex */
public class C6061d extends AbstractC6034a<SubAliasStatus> {
    public C6061d(Context context, AbstractC6033a abstractC6033a) {
        super(context, abstractC6033a);
    }

    private void c(String str) {
        C6102b.h(d(), d().getPackageName(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public int a() {
        return 4096;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    public void a(SubAliasStatus subAliasStatus, InterfaceC6080c interfaceC6080c) {
        if (c() == null || subAliasStatus == null) {
            return;
        }
        c().a(d(), subAliasStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.InterfaceC6069c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(k(intent));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.AbstractC6034a
    /* renamed from: l */
    public SubAliasStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        SubAliasStatus d = !TextUtils.isEmpty(stringExtra) ? C6100a.d(stringExtra) : (SubAliasStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
        if ("200".equals(d.getCode())) {
            c(d.getAlias());
        }
        return d;
    }
}
