package cn.damai.uikit.banner.transformer;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ZoomInTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110490430")) {
            ipChange.ipc$dispatch("110490430", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float f2 = 0.0f;
        float abs = f < 0.0f ? f + 1.0f : Math.abs(1.0f - f);
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        if (f >= -1.0f && f <= 1.0f) {
            f2 = 1.0f - (abs - 1.0f);
        }
        view.setAlpha(f2);
    }
}
