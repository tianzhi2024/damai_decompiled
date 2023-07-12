package anet.channel.detect;

import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.detect.NetworkDetector;
import anet.channel.request.C0193a;
import anet.channel.session.HttpSession;
import anet.channel.statist.NetworkDiagnosticStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.android.netutil.C8874a;
import org.android.netutil.C8875b;
import org.android.netutil.NetUtils;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONException;
import tb.C9708t9;
import tb.he;
import tb.hu0;
import tb.jn1;
import tb.o01;
import tb.x6;
import tb.y90;
import tb.zm;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ExceptionDetector {
    private long a;
    private String b;
    private String c;
    private String d;
    private int e = 0;
    private LimitedQueue<Pair<String, Integer>> f = new LimitedQueue<>(10);

    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.ExceptionDetector$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ NetworkDetector.INetworkDiagnosisCallback val$callback;

        AnonymousClass3(NetworkDetector.INetworkDiagnosisCallback iNetworkDiagnosisCallback) {
            this.val$callback = iNetworkDiagnosisCallback;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x0140
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                Method dump skipped, instructions count: 418
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.detect.ExceptionDetector.AnonymousClass3.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class LimitedQueue<E> extends LinkedList<E> {
        private int limit;

        public LimitedQueue(int i) {
            this.limit = i;
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
        public boolean add(E e) {
            boolean add = super.add(e);
            while (add && size() > this.limit) {
                super.remove();
            }
            return add;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private interface TaskType {
        public static final int MTU_1000 = 2;
        public static final int MTU_1200 = 3;
        public static final int MTU_1460 = 4;
        public static final int PING = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.ExceptionDetector$a */
    /* loaded from: classes.dex */
    public class C0166a implements RequestCb {
        final /* synthetic */ long a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;
        final /* synthetic */ CountDownLatch d;

        C0166a(ExceptionDetector exceptionDetector, long j, JSONObject jSONObject, String str, CountDownLatch countDownLatch) {
            this.a = j;
            this.b = jSONObject;
            this.c = str;
            this.d = countDownLatch;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(he heVar, boolean z) {
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            this.b.put("detectUrl", (Object) this.c);
            this.b.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, (Object) Integer.valueOf(i));
            this.b.put("errorMsg", (Object) str);
            this.b.put("requestTime", (Object) Long.valueOf(currentTimeMillis));
            this.d.countDown();
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.detect.ExceptionDetector$b */
    /* loaded from: classes.dex */
    public class C0167b {
        String a;
        String b;
        String c;
        long d;
        Future<C8875b> e;
        Future<C8875b> f;
        Future<C8875b> g;
        Future<C8875b> h;

        private C0167b(ExceptionDetector exceptionDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, JSONObject jSONObject, NetworkDetector.INetworkDiagnosisCallback iNetworkDiagnosisCallback) {
        if (iNetworkDiagnosisCallback == null || jSONObject == null) {
            return;
        }
        jSONObject.put("type", (Object) str);
        jSONObject.put("isFinish", (Object) Boolean.FALSE);
        ALog.e("anet.ExceptionDetector", "networkDiagnosisCallbackData :" + jSONObject.toString(), null, new Object[0]);
        iNetworkDiagnosisCallback.onNetworkDiagnosisFinished(jSONObject);
    }

    private ArrayList<String> C(String str, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            C8875b c8875b = null;
            try {
                c8875b = new PingTask(str, 0, 1, 0, i2).launch().get();
            } catch (Exception unused) {
            }
            StringBuilder sb = new StringBuilder();
            if (c8875b != null) {
                String c = c8875b.c();
                double d = c8875b.e()[0].a;
                int b = c8875b.b();
                if (TextUtils.isEmpty(c)) {
                    c = jn1.MUL;
                }
                sb.append("hop=");
                sb.append(c);
                sb.append(",rtt=");
                sb.append(d);
                sb.append(",errCode=");
                sb.append(b);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    static /* synthetic */ void b(ExceptionDetector exceptionDetector, String str, JSONObject jSONObject, NetworkDetector.INetworkDiagnosisCallback iNetworkDiagnosisCallback) {
        exceptionDetector.A(str, jSONObject, iNetworkDiagnosisCallback);
    }

    static /* synthetic */ JSONObject d(ExceptionDetector exceptionDetector, NetworkStatusHelper.NetworkStatus networkStatus) {
        return exceptionDetector.u(networkStatus);
    }

    static /* synthetic */ C0167b e(ExceptionDetector exceptionDetector, String str, String str2) {
        return exceptionDetector.p(str, str2);
    }

    static /* synthetic */ JSONObject f(ExceptionDetector exceptionDetector, C0167b c0167b) {
        return exceptionDetector.x(c0167b);
    }

    static /* synthetic */ JSONObject g(ExceptionDetector exceptionDetector) {
        return exceptionDetector.t();
    }

    static /* synthetic */ JSONObject h(ExceptionDetector exceptionDetector, String str) {
        return exceptionDetector.y(str);
    }

    static /* synthetic */ JSONObject o(ExceptionDetector exceptionDetector, NetworkStatusHelper.NetworkStatus networkStatus) {
        return exceptionDetector.v(networkStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0167b p(String str, String str2) {
        C0167b c0167b = new C0167b();
        c0167b.a = str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            c0167b.b = InetAddress.getByName(str).getHostAddress();
            c0167b.d = System.currentTimeMillis() - currentTimeMillis;
        } catch (UnknownHostException unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            c0167b.c = str2;
        } else {
            List<IConnStrategy> connStrategyListByHost = C0213a.a().getConnStrategyListByHost(str);
            if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
                c0167b.c = connStrategyListByHost.get(0).getIp();
            }
        }
        String str3 = !TextUtils.isEmpty(c0167b.c) ? c0167b.c : c0167b.b;
        if (!TextUtils.isEmpty(str3)) {
            String str4 = str3;
            c0167b.e = new PingTask(str4, 1000, 3, 0, 0).launch();
            c0167b.f = new PingTask(str4, 1000, 3, 972, 0).launch();
            c0167b.g = new PingTask(str4, 1000, 3, 1172, 0).launch();
            c0167b.h = new PingTask(str4, 1000, 3, 1432, 0).launch();
        }
        return c0167b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject r() throws JSONException {
        ALog.e("anet.ExceptionDetector", "[network_diagnosis_auto]start.", null, new Object[0]);
        SpdyAgent.getInstance(hu0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        JSONObject jSONObject = new JSONObject();
        NetworkStatusHelper.NetworkStatus i = NetworkStatusHelper.i();
        jSONObject.put("networkInfo", (Object) v(i));
        jSONObject.put("localDetect", (Object) u(i));
        C0167b p = p(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN, this.b);
        C0167b p2 = p("gw.alicdn.com", this.d);
        C0167b p3 = p("msgacs.m.taobao.com", this.c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(x(p));
        jSONArray.add(x(p2));
        jSONArray.add(x(p3));
        jSONObject.put("internetDetect", (Object) jSONArray);
        jSONObject.put("bizDetect", (Object) t());
        ALog.e("anet.ExceptionDetector", "[network_diagnosis_auto]finish.", null, "result", jSONObject.toString());
        x6.b().commitStat(new NetworkDiagnosticStat(2));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<Pair<String, Integer>> it = this.f.iterator();
        while (it.hasNext()) {
            Pair<String, Integer> next = it.next();
            jSONObject2.put((String) next.first, next.second);
        }
        jSONObject.put("bizDetect", (Object) jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject u(NetworkStatusHelper.NetworkStatus networkStatus) {
        String defaultGateway = networkStatus.isWifi() ? NetUtils.getDefaultGateway("114.114.114.114") : NetUtils.getPreferNextHop("114.114.114.114", 2);
        Future<C8875b> launch = TextUtils.isEmpty(defaultGateway) ? null : new PingTask(defaultGateway, 1000, 3, 0, 0).launch();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nextHop", (Object) defaultGateway);
        jSONObject.put("ping", (Object) w(1, launch));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject v(NetworkStatusHelper.NetworkStatus networkStatus) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) networkStatus.getType());
        jSONObject.put("subType", (Object) NetworkStatusHelper.e());
        if (networkStatus != NetworkStatusHelper.NetworkStatus.NO) {
            if (networkStatus.isMobile()) {
                jSONObject.put("apn", (Object) NetworkStatusHelper.b());
                jSONObject.put(y90.CARRIER, (Object) NetworkStatusHelper.c());
            } else {
                jSONObject.put(y90.BSSID, (Object) NetworkStatusHelper.k());
                jSONObject.put("ssid", (Object) NetworkStatusHelper.m());
            }
            jSONObject.put("proxy", (Object) NetworkStatusHelper.f());
            jSONObject.put("ipStack", (Object) Integer.valueOf(Inet64Util.n()));
        }
        return jSONObject;
    }

    private JSONObject w(int i, Future<C8875b> future) {
        C8874a[] e;
        JSONObject jSONObject = new JSONObject();
        if (future == null) {
            return jSONObject;
        }
        C8875b c8875b = null;
        try {
            c8875b = future.get();
        } catch (Exception unused) {
        }
        if (c8875b == null) {
            return jSONObject;
        }
        jSONObject.put("errCode", Integer.valueOf(c8875b.b()));
        int f = c8875b.f();
        if (f > 0) {
            if (i == 2) {
                this.e = Math.max(this.e, 1000);
            } else if (i == 3) {
                this.e = Math.max(this.e, 1200);
            } else if (i == 4) {
                this.e = Math.max(this.e, 1460);
            }
        }
        jSONObject.put("successCnt", Integer.valueOf(f));
        JSONArray jSONArray = new JSONArray();
        for (C8874a c8874a : c8875b.e()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("seq", (Object) Integer.valueOf(c8874a.b));
            jSONObject2.put("hop", (Object) Integer.valueOf(c8874a.c));
            jSONObject2.put("rtt", (Object) Double.valueOf(c8874a.a));
            jSONArray.add(jSONObject2);
        }
        jSONObject.put("pingCnt", Integer.valueOf(jSONArray.size()));
        jSONObject.put("response", (Object) jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject x(C0167b c0167b) {
        JSONObject jSONObject = new JSONObject();
        if (c0167b != null && c0167b.e != null) {
            jSONObject.put("host", (Object) c0167b.a);
            jSONObject.put("currentIp", (Object) c0167b.c);
            jSONObject.put("localIp", (Object) c0167b.b);
            jSONObject.put("dnsTime", (Object) Long.valueOf(c0167b.d));
            jSONObject.put("ping", (Object) w(1, c0167b.e));
            jSONObject.put("MTU1000", (Object) w(2, c0167b.f));
            jSONObject.put("MTU1200", (Object) w(3, c0167b.g));
            jSONObject.put("MTU1460", (Object) w(4, c0167b.h));
            if (MtopUnitStrategy.GUIDE_ONLINE_DOMAIN.equals(c0167b.a)) {
                ArrayList<String> C = C(!TextUtils.isEmpty(c0167b.c) ? c0167b.c : c0167b.b, 5);
                JSONObject jSONObject2 = new JSONObject();
                int i = 0;
                while (i < C.size()) {
                    int i2 = i + 1;
                    jSONObject2.put(String.valueOf(i2), (Object) C.get(i));
                    i = i2;
                }
                jSONObject.put("traceRoute", (Object) jSONObject2);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject y(String str) {
        o01 g = o01.g(str);
        JSONObject jSONObject = new JSONObject();
        if (g == null) {
            return jSONObject;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new HttpSession(hu0.c(), new zm(g.d(), "exceptionDetect", null)).w(new C0193a.C0195b().a0(g).R("GET").J(), new C0166a(this, System.currentTimeMillis(), jSONObject, str, countDownLatch));
        try {
            countDownLatch.await(20000L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        if (this.f.size() != 10) {
            return false;
        }
        if (NetworkStatusHelper.i() == NetworkStatusHelper.NetworkStatus.NO) {
            ALog.e("anet.ExceptionDetector", "no network", null, new Object[0]);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.a) {
            return false;
        }
        Iterator<Pair<String, Integer>> it = this.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next().second).intValue();
            if (intValue == -202 || intValue == -400 || intValue == -401 || intValue == -405 || intValue == -406) {
                i++;
            }
        }
        boolean z = i * 2 > 10;
        if (z) {
            this.a = currentTimeMillis + ConfigStorage.DEFAULT_SMALL_MAX_AGE;
        }
        return z;
    }

    public void B() {
        NetworkStatusHelper.a(new NetworkStatusHelper.INetworkStatusChangeListener() { // from class: anet.channel.detect.ExceptionDetector.1
            @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
            public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
                ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.detect.ExceptionDetector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExceptionDetector.this.f.clear();
                        ExceptionDetector.this.a = 0L;
                        ExceptionDetector.this.e = 0;
                    }
                });
            }
        });
    }

    public void q(final RequestStatistic requestStatistic) {
        if (!C9708t9.J()) {
            ALog.f("anet.ExceptionDetector", "exception detect closed.", null, new Object[0]);
        } else {
            ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.detect.ExceptionDetector.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        RequestStatistic requestStatistic2 = requestStatistic;
                        if (requestStatistic2 == null) {
                            return;
                        }
                        if (!TextUtils.isEmpty(requestStatistic2.ip) && requestStatistic.ret == 0) {
                            if (MtopUnitStrategy.GUIDE_ONLINE_DOMAIN.equalsIgnoreCase(requestStatistic.host)) {
                                ExceptionDetector.this.b = requestStatistic.ip;
                            } else if ("msgacs.m.taobao.com".equalsIgnoreCase(requestStatistic.host)) {
                                ExceptionDetector.this.c = requestStatistic.ip;
                            } else if ("gw.alicdn.com".equalsIgnoreCase(requestStatistic.host)) {
                                ExceptionDetector.this.d = requestStatistic.ip;
                            }
                        }
                        if (!TextUtils.isEmpty(requestStatistic.url)) {
                            ExceptionDetector.this.f.add(Pair.create(requestStatistic.url, Integer.valueOf(requestStatistic.statusCode)));
                        }
                        if (ExceptionDetector.this.z()) {
                            ExceptionDetector.this.r();
                        }
                    } catch (Throwable th) {
                        ALog.d("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
                    }
                }
            });
        }
    }

    public int s() {
        return this.e;
    }
}
