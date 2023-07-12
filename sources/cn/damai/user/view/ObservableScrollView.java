package cn.damai.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ObservableScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollChangedListener mOnScrollChangedListener;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082012337")) {
            ipChange.ipc$dispatch("-2082012337", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedListener onScrollChangedListener = this.mOnScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1112354362")) {
            ipChange.ipc$dispatch("1112354362", new Object[]{this, onScrollChangedListener});
        } else {
            this.mOnScrollChangedListener = onScrollChangedListener;
        }
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
