package com.alibaba.motu.tbrest.logger;

import com.taobao.tao.log.TLog;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class LoggerAdapter {
    private static String format2String(Object... objArr) {
        String obj;
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2 instanceof Map) {
                    obj = map2Json((Map) obj2);
                } else {
                    obj = obj2.toString();
                }
                sb.append("->");
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static void log(String str, Object... objArr) {
        try {
            TLog.loge("tbrest", str, format2String(objArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String map2Json(Map map) {
        return new JSONObject(map).toString();
    }
}
