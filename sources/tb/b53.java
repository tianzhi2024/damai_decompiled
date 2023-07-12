package tb;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.C5462c;
import com.heytap.mcssdk.d.InterfaceC5465d;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class b53 implements InterfaceC5465d {
    public static List<BaseMode> a(Context context, Intent intent) {
        BaseMode a;
        if (intent == null) {
            return null;
        }
        int i = 4096;
        try {
            i = Integer.parseInt(f43.f(intent.getStringExtra("type")));
        } catch (Exception e) {
            z53.b("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
        }
        z53.a("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (InterfaceC5465d interfaceC5465d : C5462c.m().q()) {
            if (interfaceC5465d != null && (a = interfaceC5465d.a(context, i, intent)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
}
