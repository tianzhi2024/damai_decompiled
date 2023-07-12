package com.taobao.android.dinamicx.widget.recycler.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.expose.C6513b;
import java.util.ArrayList;
import java.util.Iterator;
import tb.nz;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXRecyclerView extends RecyclerView {
    C6513b exposeHelper;
    ArrayList<RecyclerView.OnScrollListener> mExtraScrollerListeners;

    public DXRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.addOnScrollListener(onScrollListener);
        if (this.mExtraScrollerListeners == null) {
            this.mExtraScrollerListeners = new ArrayList<>();
        }
        this.mExtraScrollerListeners.add(onScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void clearOnScrollListeners() {
        super.clearOnScrollListeners();
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public C6513b getExposeHelper() {
        return this.exposeHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.exposeHelper != null) {
            nz.b("DXRecyclerView", "exposeHelper.attach();");
            this.exposeHelper.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.exposeHelper != null) {
            nz.b("DXRecyclerView", "exposeHelper.detach();");
            this.exposeHelper.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        DXRecyclerLayout j;
        try {
            super.onLayout(z, i, i2, i3, i4);
            C6513b c6513b = this.exposeHelper;
            if (c6513b != null) {
                c6513b.d();
            }
        } catch (Throwable th) {
            ry.b(th);
            try {
                String str = nz.TAG;
                String str2 = "null";
                if ((getAdapter() instanceof RecyclerAdapter) && (j = ((RecyclerAdapter) getAdapter()).j()) != null && j.getDXRuntimeContext() != null) {
                    str = j.getDXRuntimeContext().getBizType();
                    str2 = j.getUserId();
                }
                C6368e c6368e = new C6368e(str);
                C6368e.C6369a c6369a = new C6368e.C6369a("native", "native_crash", C6368e.DX_NATIVE_CRASH_14);
                c6369a.e = "userId： " + str2 + " stack： " + ry.a(th);
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
            } catch (Throwable unused) {
                ry.b(th);
            }
        }
    }

    public void onScrollStateChangedExtra(int i) {
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            Iterator<RecyclerView.OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScrollStateChanged(this, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        super.removeOnScrollListener(onScrollListener);
        ArrayList<RecyclerView.OnScrollListener> arrayList = this.mExtraScrollerListeners;
        if (arrayList != null) {
            arrayList.remove(onScrollListener);
        }
    }

    public void setExposeHelper(C6513b c6513b) {
        this.exposeHelper = c6513b;
    }

    public DXRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
