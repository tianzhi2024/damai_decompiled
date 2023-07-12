package com.taobao.android.dinamicx.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.thread.DXMonitorRunnable;
import com.youku.arch.v3.data.Constants;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;
import tb.nz;
import tb.ry;
import tb.s00;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXAppMonitor {
    private static IDXAppMonitor a;
    private static int b;

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, String str2, DXTemplateItem dXTemplateItem, Map<String, String> map, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        sb.append(str);
        sb.append("]:");
        sb.append(str2);
        sb.append("|");
        JSONObject jSONObject = new JSONObject();
        if (dXTemplateItem != null) {
            jSONObject.put(Constants.TEMPLATE, (Object) dXTemplateItem.name);
            jSONObject.put("version", (Object) Long.valueOf(dXTemplateItem.version));
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        if (str3 != null) {
            jSONObject.put("error", (Object) str3);
        }
        sb.append(jSONObject.toJSONString());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject f(String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bizName", (Object) nz.TAG);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("sceneName", (Object) str);
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("serviceId", (Object) str3);
        } else {
            jSONObject.put("serviceId", (Object) "DX_Default_Service_Id");
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("featureType", (Object) str2);
        }
        jSONObject.put("version", (Object) i());
        jSONObject.put("samplingRate", (Object) "1.0");
        if (dXTemplateItem != null) {
            if (!TextUtils.isEmpty(dXTemplateItem.name)) {
                jSONObject.put("templateName", (Object) dXTemplateItem.name);
            }
            jSONObject.put("templateVersion", (Object) (dXTemplateItem.version + ""));
            if (!TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
                jSONObject.put("templateUrl", (Object) dXTemplateItem.templateUrl);
            }
            jSONObject.put("templateType", (Object) Integer.valueOf(dXTemplateItem.getTemplateType()));
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    jSONObject.put(entry.getKey(), (Object) entry.getValue());
                }
            }
        }
        return jSONObject;
    }

    public static Map g(float f) {
        return new HashMap<String, String>(f) { // from class: com.taobao.android.dinamicx.monitor.DXAppMonitor.4
            final /* synthetic */ float val$consumingTime;

            {
                this.val$consumingTime = f;
                put("ConsumingTime", String.valueOf(f / 1000000.0f));
            }
        };
    }

    public static boolean h() {
        return 0.001d > Math.random();
    }

    private static String i() {
        return LiveFullInfo.VER;
    }

    public static void j(IDXAppMonitor iDXAppMonitor) {
        a = iDXAppMonitor;
    }

    private static void k(@NonNull final C6368e c6368e, final boolean z) {
        List<C6368e.C6369a> list;
        try {
            if (a != null && c6368e != null && c6368e.a != null && (list = c6368e.c) != null && list.size() > 0) {
                y00.g(new DXMonitorRunnable() { // from class: com.taobao.android.dinamicx.monitor.DXAppMonitor.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C6368e c6368e2 = C6368e.this;
                        String str = c6368e2.a;
                        List<C6368e.C6369a> list2 = c6368e2.c;
                        int size = list2.size();
                        for (int i = 0; i < size; i++) {
                            C6368e.C6369a c6369a = list2.get(i);
                            if (c6369a != null && !TextUtils.isEmpty(c6369a.b)) {
                                if (c6369a.f == null) {
                                    c6369a.f = new HashMap();
                                }
                                c6369a.f.put("eventId", C6368e.this.a());
                                if (z) {
                                    c6369a.c = "SimplePipeline" + c6369a.c;
                                }
                                DXAppMonitor.r(str, C6368e.this.b, c6369a.c, c6369a.b, c6369a.f, c6369a.d, c6369a.e, c6369a.a);
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    private static void l(int i, @NonNull final String str, final String str2, @NonNull final String str3, final DXTemplateItem dXTemplateItem, final Map<String, String> map, final double d, final boolean z) {
        try {
            if (b == i || 2 == i) {
                y00.g(new DXMonitorRunnable() { // from class: com.taobao.android.dinamicx.monitor.DXAppMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str4;
                        if (str3 == null) {
                            return;
                        }
                        if (dXTemplateItem == null) {
                            str4 = "";
                        } else {
                            str4 = dXTemplateItem.name + "_:" + dXTemplateItem.version;
                        }
                        if (!"Detail_RenderWidget_CreateView_Once".equals(str3) && !"Detail_RenderWidget_RenderView_Once".equals(str3)) {
                            nz.r(str2, jn1.ARRAY_START_STR + str + "]：" + str2 + "性能埋点: " + str3 + ": " + (d / 1000000.0d) + "ms templateinfo: " + str4);
                        } else {
                            Map map2 = map;
                            if (map2 != null && map2.containsKey("ViewSimpleName")) {
                                nz.r(str2, jn1.ARRAY_START_STR + str + "]：" + str2 + "性能埋点: " + str3 + ": [" + ((String) map.get("ViewSimpleName")) + "]:" + (d / 1000000.0d) + "ms templateinfo: " + str4);
                            }
                        }
                        if (DXAppMonitor.a == null) {
                            return;
                        }
                        if (DXAppMonitor.h() && !DinamicXEngine.x()) {
                            JSONObject f = DXAppMonitor.f(str, str2, str3, dXTemplateItem, map);
                            DXAppMonitor.a.alarm_commitSuccess("Page_Umbrella_Govern", nz.TAG, f.toString());
                            if (d > 0.0d) {
                                DXAppMonitor.a.counter_commit("Page_Umbrella_Govern", nz.TAG, f.toString(), d / 1000000.0d);
                            }
                        }
                        if (z) {
                            s00.f(nz.TAG, nz.TAG, DXAppMonitor.e(str, str3, dXTemplateItem, map, ""));
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void m(int i, @NonNull final String str, final String str2, @NonNull final String str3, final Map<String, String> map) {
        try {
            if (b != i) {
                return;
            }
            y00.g(new DXMonitorRunnable() { // from class: com.taobao.android.dinamicx.monitor.DXAppMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!DXAppMonitor.h() || DinamicXEngine.x()) {
                        return;
                    }
                    DXAppMonitor.f(str, str2, str3, null, map);
                }
            });
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void n(@NonNull C6368e c6368e) {
        o(c6368e, false);
    }

    public static void o(@NonNull C6368e c6368e, boolean z) {
        k(c6368e, z);
        u(c6368e, z);
        RuntimeProfilingInfoCollector.c().a(c6368e, z);
    }

    public static void p(DXRuntimeContext dXRuntimeContext, String str, String str2, int i, String str3) {
        try {
            C6368e c6368e = new C6368e(dXRuntimeContext.getBizType());
            if (dXRuntimeContext.getDxError() != null) {
                c6368e.b(dXRuntimeContext.getDxError().a());
            }
            c6368e.b = dXRuntimeContext.getDxTemplateItem();
            C6368e.C6369a c6369a = new C6368e.C6369a(str, str2, i);
            c6369a.e = str3;
            c6368e.c.add(c6369a);
            n(c6368e);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void q(String str, DXTemplateItem dXTemplateItem, String str2, String str3, int i, String str4) {
        try {
            C6368e c6368e = new C6368e(str);
            c6368e.b = dXTemplateItem;
            C6368e.C6369a c6369a = new C6368e.C6369a(str2, str3, i);
            c6369a.e = str4;
            c6368e.c.add(c6369a);
            n(c6368e);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(@NonNull String str, DXTemplateItem dXTemplateItem, String str2, @NonNull String str3, Map<String, String> map, int i, String str4, long j) {
        JSONObject f = f(str, str2, str3, dXTemplateItem, map);
        if (f != null) {
            f.put("timeStamp", (Object) Long.valueOf(j));
            if (str4 != null) {
                f.put("errorMsg", (Object) str4);
            }
        }
        if (!DinamicXEngine.x()) {
            IDXAppMonitor iDXAppMonitor = a;
            String jSONString = f.toJSONString();
            iDXAppMonitor.alarm_commitFail("Page_Umbrella_Govern", nz.TAG, jSONString, i + "", str4);
        }
        s00.d(nz.TAG, nz.TAG, e(str, str3, dXTemplateItem, map, "errorCode:" + i + "_errorMsg:" + str4));
    }

    public static void s(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d, boolean z) {
        l(i, str, str2, str3, dXTemplateItem, map, d, z);
        t(i, str, str2, str3, dXTemplateItem, map, d);
        RuntimeProfilingInfoCollector.c().b(i, str, str2, str3, dXTemplateItem, d);
    }

    private static void t(int i, @NonNull String str, String str2, @NonNull String str3, DXTemplateItem dXTemplateItem, Map<String, String> map, double d) {
        DXUmbrellaUtil.k(i, str, str2, str3, dXTemplateItem, map, d);
    }

    private static void u(@NonNull C6368e c6368e, boolean z) {
        DXUmbrellaUtil.i(c6368e, z);
    }
}
