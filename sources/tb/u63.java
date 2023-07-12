package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.alibaba.security.common.d.AbstractC3806c;
import com.heytap.mcssdk.C5462c;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class u63 {
    private Context a;
    private SharedPreferences b;
    private Object c;

    /* compiled from: Taobao */
    /* renamed from: tb.u63$b */
    /* loaded from: classes10.dex */
    private static class C9765b {
        static u63 a = new u63();
    }

    private u63() {
        this.c = new Object();
        Context k = C5462c.m().k();
        if (k != null) {
            this.a = a(k);
        }
        Context context = this.a;
        if (context != null) {
            this.b = context.getSharedPreferences("shared_msg_sdk", 0);
        }
    }

    private Context a(Context context) {
        boolean b = b33.b();
        z53.a("fbeVersion is " + b);
        return (!b || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static u63 f() {
        return C9765b.a;
    }

    private SharedPreferences g() {
        Context context;
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.c) {
            SharedPreferences sharedPreferences2 = this.b;
            if (sharedPreferences2 != null || (context = this.a) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("shared_msg_sdk", 0);
            this.b = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public void b(boolean z) {
        SharedPreferences g = g();
        if (g != null) {
            g.edit().putBoolean("hasDefaultChannelCreated", z).commit();
        }
    }

    public boolean c() {
        SharedPreferences g = g();
        if (g != null) {
            return g.getBoolean("hasDefaultChannelCreated", false);
        }
        return false;
    }

    public void d(String str) {
        SharedPreferences g = g();
        if (g != null) {
            g.edit().putString("decryptTag", str).commit();
        }
    }

    public String e() {
        SharedPreferences g = g();
        return g != null ? g.getString("decryptTag", AbstractC3806c.a) : AbstractC3806c.a;
    }
}
