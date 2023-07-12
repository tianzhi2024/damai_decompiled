package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import cn.damai.commonbusiness.R$anim;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMUpMarqueeView extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnItemClickListener onItemClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ List b;

        a(int i, List list) {
            this.a = i;
            this.b = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595522456")) {
                ipChange.ipc$dispatch("-1595522456", new Object[]{this, view});
            } else if (DMUpMarqueeView.this.onItemClickListener != null) {
                OnItemClickListener onItemClickListener = DMUpMarqueeView.this.onItemClickListener;
                int i = this.a;
                onItemClickListener.onItemClick(i, (View) this.b.get(i));
            }
        }
    }

    public DMUpMarqueeView(Context context) {
        super(context);
    }

    public void setAnimationDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642224112")) {
            ipChange.ipc$dispatch("-1642224112", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.damai_marquee_in);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            loadAnimation.setDuration(j);
        }
        setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R$anim.damai_marquee_out);
        if (i > 0) {
            loadAnimation2.setDuration(j);
        }
        setOutAnimation(loadAnimation2);
    }

    public void setItems(List<View> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13067491")) {
            ipChange.ipc$dispatch("-13067491", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOnClickListener(new a(i, list));
                ViewGroup viewGroup = (ViewGroup) list.get(i).getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                addView(list.get(i));
            }
            if (isFlipping()) {
                stopFlipping();
            }
            if (list.size() > 1) {
                startFlipping();
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1560735850")) {
            ipChange.ipc$dispatch("-1560735850", new Object[]{this, onItemClickListener});
        } else {
            this.onItemClickListener = onItemClickListener;
        }
    }

    public DMUpMarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
