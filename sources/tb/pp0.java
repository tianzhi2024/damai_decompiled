package tb;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class pp0 {
    private final Handler a;

    /* compiled from: Taobao */
    /* renamed from: tb.pp0$b */
    /* loaded from: classes9.dex */
    private static class C9562b {
        static final pp0 a = new pp0();
    }

    public static pp0 a() {
        return C9562b.a;
    }

    public Handler b() {
        return this.a;
    }

    private pp0() {
        HandlerThread handlerThread = new HandlerThread("APM-FulltraceDump");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
    }
}
