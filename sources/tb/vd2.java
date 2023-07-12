package tb;

import android.text.TextUtils;
import anet.channel.request.C0193a;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import com.taobao.slide.core.C6889b;
import com.taobao.slide.task.UpdateTask;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vd2 implements Interceptor {
    private C6889b a;

    /* compiled from: Taobao */
    /* renamed from: tb.vd2$a */
    /* loaded from: classes11.dex */
    class C9816a implements Callback {
        final /* synthetic */ Interceptor.Chain a;

        C9816a(Interceptor.Chain chain) {
            this.a = chain;
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onDataReceiveSize(int i, int i2, he heVar) {
            this.a.callback().onDataReceiveSize(i, i2, heVar);
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onFinish(DefaultFinishEvent defaultFinishEvent) {
            this.a.callback().onFinish(defaultFinishEvent);
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onResponseCode(int i, Map<String, List<String>> map) {
            List<String> b;
            if (map != null && (b = vd2.b(map, "A-SLIDER-P")) != null && !b.isEmpty()) {
                String d = nl.d(b.get(0));
                if (!TextUtils.isEmpty(d)) {
                    il2.b(new UpdateTask(vd2.this.a, false, false, d));
                }
            }
            this.a.callback().onResponseCode(i, map);
        }
    }

    public vd2(C6889b c6889b) {
        this.a = c6889b;
    }

    public static List<String> b(Map<String, List<String>> map, String str) {
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override // anetwork.channel.interceptor.Interceptor
    public Future intercept(Interceptor.Chain chain) {
        boolean z;
        C0193a request = chain.request();
        Callback callback = chain.callback();
        try {
            if (UpdateTask.isAllow() && !TextUtils.isEmpty(request.h())) {
                for (String str : this.a.b().getProbeHosts()) {
                    if (request.h().contains(str)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                String format = String.format("%s=%s&%s=%s", "appKey", this.a.b().getAppKey(), "ver", this.a.f());
                if (!TextUtils.isEmpty(format)) {
                    request = chain.request().u().I("A-SLIDER-Q", nl.e(format)).J();
                }
                callback = new C9816a(chain);
            }
        } catch (Throwable th) {
            m42.d("SlideInterceptor", "intercept", th, new Object[0]);
        }
        return chain.proceed(request, callback);
    }
}
