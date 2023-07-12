package cn.damai.baseview.abcpullrefresh.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import cn.damai.baseview.abcpullrefresh.library.C0284d;
import cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullToRefreshLayout extends cn.damai.baseview.abcpullrefresh.library.PullToRefreshLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public PullToRefreshLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshLayout
    public PullToRefreshAttacher createPullToRefreshAttacher(Activity activity, C0284d c0284d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1501682505") ? (PullToRefreshAttacher) ipChange.ipc$dispatch("1501682505", new Object[]{this, activity, c0284d}) : new C0275a(activity, c0284d);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
