package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.w */
/* loaded from: classes10.dex */
public final class C4462w extends AbstractC4379b<UploadInfo, Integer> {
    private Context k;
    private UploadInfo l;

    public C4462w(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.k = context;
        this.l = uploadInfo;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return j();
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(this.k));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.l.getUserID());
        LatLonPoint point = this.l.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((int) (point.getLongitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((int) (point.getLatitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.l.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.d() + "/nearby/data/create";
    }
}
