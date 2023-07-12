package com.alibaba.mobsec.privacydoublelist.c;

import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.mobsec.privacydoublelist.f.C3439a;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.c.a */
/* loaded from: classes6.dex */
public class C3426a {
    public static volatile C3426a c;
    public final Map<String, C3427a> a;
    public final Set<String> b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.c.a$a */
    /* loaded from: classes6.dex */
    public static class C3427a {
        public final int a;
        public final String[] b;

        public C3427a(int i, String... strArr) {
            this.a = i;
            this.b = strArr;
        }

        public boolean a(Invocation invocation) {
            Object obj;
            Object[] objArr = invocation.args;
            int length = objArr.length;
            int i = this.a;
            if (length <= i || (obj = objArr[i]) == null) {
                return false;
            }
            boolean z = false;
            for (String str : this.b) {
                z = C3439a.a(obj).equals(str);
                if (z) {
                    break;
                }
            }
            return z;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.c.a$b */
    /* loaded from: classes6.dex */
    public static class C3428b {
        public static final C3428b b = new C3428b(true);
        public static final C3428b c = new C3428b(false);
        public final boolean a;

        public C3428b(boolean z) {
            this.a = z;
        }
    }

    public C3426a() {
        HashMap hashMap = new HashMap(2);
        this.a = hashMap;
        Set<String> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        this.b = newSetFromMap;
        hashMap.put(PrivacyDoubleList.Methods.Settings_Secure_getString_ContentResolver_String, new C3427a(1, "android_id"));
        hashMap.put(PrivacyDoubleList.Methods.SystemProperties_get_String, new C3427a(0, "ro.serialno"));
        hashMap.put(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int_boolean, new C3427a(0, "18", Constants.VIA_ACT_TYPE_NINETEEN));
        hashMap.put(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int, new C3427a(0, "18", Constants.VIA_ACT_TYPE_NINETEEN));
        newSetFromMap.addAll(Arrays.asList(PrivacyDoubleList.Fields.Build_getMODEL, PrivacyDoubleList.Fields.Build_getPRODUCT, PrivacyDoubleList.Methods.TelephonyManager_getImei, PrivacyDoubleList.Methods.TelephonyManager_getImei_int, PrivacyDoubleList.Methods.TelephonyManager_getDeviceId, PrivacyDoubleList.Methods.TelephonyManager_getDeviceId_int, PrivacyDoubleList.Methods.TelephonyManager_getMeid, PrivacyDoubleList.Methods.TelephonyManager_getMeid_int, PrivacyDoubleList.Methods.TelephonyManager_getSubscriberId, "android.telephony.TelephonyManager.getSimSerialNumber()", PrivacyDoubleList.Methods.WifiInfo_getMacAddress, PrivacyDoubleList.Methods.NetworkInterface_getHardwareAddress, PrivacyDoubleList.Methods.Settings_Secure_getString_ContentResolver_String, PrivacyDoubleList.Methods.AdvertisingIdClient_getAdvertisingIdInfo_Context, PrivacyDoubleList.Methods.SystemProperties_get_String, PrivacyDoubleList.Fields.Build_getSERIAL, PrivacyDoubleList.Methods.Build_getSerial, PrivacyDoubleList.Methods.TelephonyManager_getSimOperator, PrivacyDoubleList.Methods.TelephonyManager_getSimOperatorName, PrivacyDoubleList.Methods.BluetoothAdapter_getAddress, PrivacyDoubleList.Fields.Build_VERSION_getRELEASE, PrivacyDoubleList.Fields.Build_VERSION_getRELEASE_OR_CODENAME, PrivacyDoubleList.Fields.DisplayMetrics_getwidthPixels, PrivacyDoubleList.Fields.DisplayMetrics_getheightPixels, PrivacyDoubleList.Fields.Point_getx, PrivacyDoubleList.Fields.Point_gety, "android.graphics.Rect.width()", "android.graphics.Rect.height()", PrivacyDoubleList.Fields.Build_getBRAND, PrivacyDoubleList.Fields.Build_getMANUFACTURER, PrivacyDoubleList.Fields.Build_getCPU_ABI, PrivacyDoubleList.Methods.TelephonyManager_getNetworkType, PrivacyDoubleList.Methods.TelephonyManager_getDataNetworkType, PrivacyDoubleList.Methods.Location_getLongitude, PrivacyDoubleList.Methods.Location_getLatitude, PrivacyDoubleList.Methods.Location_getAltitude, PrivacyDoubleList.Methods.IdSupplier_GetOAID, PrivacyDoubleList.Methods.CoolPad_GetOAID, PrivacyDoubleList.Methods.HEYTAP_GetOAID, PrivacyDoubleList.Methods.HUAWEI_GetOAID, PrivacyDoubleList.Methods.MEIZU_GetOAID, PrivacyDoubleList.Methods.SAMSUNG_GetOAID, PrivacyDoubleList.Methods.VIVO_GetOAID, PrivacyDoubleList.Methods.ZUI_GetOAID, PrivacyDoubleList.Methods.ASUS_GetOAID, PrivacyDoubleList.Methods.NUBIA_GetOAID, PrivacyDoubleList.Methods.XIAOMI_GetOAID, "com.alibaba.openid.OpenDeviceId.getOAID(android.content.Context)"));
    }

    public static C3426a a() {
        if (c == null) {
            synchronized (C3426a.class) {
                if (c == null) {
                    c = new C3426a();
                }
            }
        }
        return c;
    }

    public void a(String str) {
        try {
            this.b.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.b.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            if (PdlEnvUtils.a) {
                e.printStackTrace();
            }
        }
    }
}
