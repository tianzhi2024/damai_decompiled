package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.dh;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class di implements Runnable {
    private Context a;
    private dh b;
    private Cdo c;
    private a d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(String str, Cdo cdo);
    }

    public di(Context context) {
        this.a = context;
        if (this.b == null) {
            this.b = new dh(context, "");
        }
    }

    public void a(String str) {
        dh dhVar = this.b;
        if (dhVar != null) {
            dhVar.a(str);
        }
    }

    public void b() {
        ep.a().a(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                dh dhVar = this.b;
                if (dhVar != null) {
                    dh.a e = dhVar.e();
                    String str = null;
                    if (e != null && e.a != null) {
                        str = a(this.a) + "/custom_texture_data";
                        a(str, e.a);
                    }
                    a aVar = this.d;
                    if (aVar != null) {
                        aVar.a(str, this.c);
                    }
                }
                hd.a(this.a, eq.e());
            }
        } catch (Throwable th) {
            hd.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    private void a(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    private String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    public void a() {
        this.a = null;
        if (this.b != null) {
            this.b = null;
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(Cdo cdo) {
        this.c = cdo;
    }
}
