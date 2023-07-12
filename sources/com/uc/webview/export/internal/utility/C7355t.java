package com.uc.webview.export.internal.utility;

import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.t */
/* loaded from: classes11.dex */
final class C7355t implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(SolidMonitor.CHECK_TYPE_LIB) && str.endsWith("_kr_uc.so");
    }
}
