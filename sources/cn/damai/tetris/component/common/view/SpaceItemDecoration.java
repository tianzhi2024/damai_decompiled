package cn.damai.tetris.component.common.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    int a;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483179288")) {
            ipChange.ipc$dispatch("-1483179288", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        int i = this.a;
        rect.left = i;
        rect.right = i;
        rect.bottom = 0;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = 0;
        }
    }
}