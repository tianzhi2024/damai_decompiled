package me.ele.altriax.launcher.biz.launcher;

import android.app.Application;
import com.taobao.android.launcher.biz.task.TaggedTask;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.impl.DMInitLoginSDKTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitLoginSDK extends TaggedTask {
    public DMInitLoginSDK(String str) {
        super(str);
    }

    @Override // com.taobao.android.launcher.biz.task.TaggedRunnable
    public void run(Application application, HashMap<String, Object> hashMap) {
        new DMInitLoginSDKTask().init(application, hashMap);
    }
}
