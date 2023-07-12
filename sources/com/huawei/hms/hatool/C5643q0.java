package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.q0 */
/* loaded from: classes10.dex */
public class C5643q0 {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - C5621g0.a(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                C5653y.f("hmsSdk", "not have read phone permission!");
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) != 0) {
            C5653y.f("hmsSdk", "not have read phone permission!");
            return true;
        } else {
            return false;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(Context context, String str, int i) {
        String str2 = C5621g0.c(context, str) + ".xml";
        long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length > i) {
            C5653y.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
            return true;
        }
        return false;
    }

    public static boolean a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException unused) {
            C5653y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}