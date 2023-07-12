package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7614c;
import com.xiaomi.push.C7680j;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.ao;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.gz;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bv {
    private static bv a = new bv();

    /* renamed from: a  reason: collision with other field name */
    private static String f942a;

    /* renamed from: a  reason: collision with other field name */
    private ao.AbstractC7600b f943a;

    /* renamed from: a  reason: collision with other field name */
    private dw.C7634a f944a;

    /* renamed from: a  reason: collision with other field name */
    private List<AbstractC7745a> f945a = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.bv$a */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC7745a {
        public void a(dw.C7634a c7634a) {
        }

        public void a(dx.C7636b c7636b) {
        }
    }

    private bv() {
    }

    public static bv a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m1206a() {
        String str;
        synchronized (bv.class) {
            if (f942a == null) {
                SharedPreferences sharedPreferences = C7786v.m1245a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f942a = string;
                if (string == null) {
                    String a2 = C7680j.a(C7786v.m1245a(), false);
                    f942a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f942a).commit();
                    }
                }
            }
            str = f942a;
        }
        return str;
    }

    private void b() {
        if (this.f944a == null) {
            d();
        }
    }

    private void c() {
        if (this.f943a != null) {
            return;
        }
        bw bwVar = new bw(this);
        this.f943a = bwVar;
        gz.a(bwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.C7786v.m1245a()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            com.xiaomi.push.b r0 = com.xiaomi.push.C7605b.a(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            com.xiaomi.push.dw$a r0 = com.xiaomi.push.dw.C7634a.b(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f944a = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            com.xiaomi.push.C7594ab.a(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            com.xiaomi.push.dw$a r0 = r4.f944a
            if (r0 != 0) goto L4e
            com.xiaomi.push.dw$a r0 = new com.xiaomi.push.dw$a
            r0.<init>()
            r4.f944a = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            com.xiaomi.push.C7594ab.a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bv.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f944a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C7786v.m1245a().openFileOutput("XMCloudCfg", 0));
                C7614c a2 = C7614c.a(bufferedOutputStream);
                this.f944a.a(a2);
                a2.m715a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            AbstractC7535b.m586a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m1209a() {
        b();
        dw.C7634a c7634a = this.f944a;
        if (c7634a != null) {
            return c7634a.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dw.C7634a m1210a() {
        b();
        return this.f944a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m1211a() {
        this.f945a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(dx.C7636b c7636b) {
        AbstractC7745a[] abstractC7745aArr;
        if (c7636b.m798d() && c7636b.d() > m1209a()) {
            c();
        }
        synchronized (this) {
            List<AbstractC7745a> list = this.f945a;
            abstractC7745aArr = (AbstractC7745a[]) list.toArray(new AbstractC7745a[list.size()]);
        }
        for (AbstractC7745a abstractC7745a : abstractC7745aArr) {
            abstractC7745a.a(c7636b);
        }
    }

    public synchronized void a(AbstractC7745a abstractC7745a) {
        this.f945a.add(abstractC7745a);
    }
}
