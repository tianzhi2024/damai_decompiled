package com.loc;

import android.content.Context;
import tb.v33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class w1 {
    private static w1 c;
    private final Context a;
    private final String b = v33.d(v1.v("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private w1(Context context) {
        this.a = context.getApplicationContext();
    }

    public static w1 a(Context context) {
        if (c == null) {
            synchronized (w1.class) {
                if (c == null) {
                    c = new w1(context);
                }
            }
        }
        return c;
    }

    public final synchronized void b() {
        try {
            if (C5861o.G() == null) {
                C5861o.z(C5805c.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        C5904z.b(this.a).d(this.b);
        C5904z.b(this.a).g(str);
    }
}
