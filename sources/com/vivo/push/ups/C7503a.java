package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.ups.a */
/* loaded from: classes11.dex */
final class C7503a implements IPushActionListener {
    final /* synthetic */ UPSRegisterCallback a;
    final /* synthetic */ Context b;
    final /* synthetic */ VUpsManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7503a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.c = vUpsManager;
        this.a = uPSRegisterCallback;
        this.b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new TokenResult(i, PushClient.getInstance(this.b).getRegId()));
    }
}
