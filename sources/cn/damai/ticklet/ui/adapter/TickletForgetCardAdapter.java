package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletForgetCardResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.py2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletForgetCardAdapter extends RecyclerView.Adapter<a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<TickletForgetCardResult.TickletForgetCardData> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        View a;
        TextView b;
        TextView c;
        TextView d;
        LinearLayout e;
        ImageView f;

        public a(TickletForgetCardAdapter tickletForgetCardAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R$id.ticklet_forget_card_list_num);
            this.c = (TextView) view.findViewById(R$id.ticklet_forget_card_corresponding_code);
            this.d = (TextView) view.findViewById(R$id.ticklet_line);
            this.e = (LinearLayout) view.findViewById(R$id.ticklet_forget_card_seat);
            this.f = (ImageView) view.findViewById(R$id.iv_zxing_state);
        }
    }

    public TickletForgetCardAdapter(Context context) {
        this.a = context;
    }

    private void c(a aVar, TickletForgetCardResult.TickletForgetCardData tickletForgetCardData, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716827124")) {
            ipChange.ipc$dispatch("716827124", new Object[]{this, aVar, tickletForgetCardData, Integer.valueOf(i)});
        } else if (tickletForgetCardData != null) {
            ViewGroup.LayoutParams layoutParams = aVar.b.getLayoutParams();
            int i2 = i + 1;
            if (i2 < 9) {
                layoutParams.height = t60.a(this.a, 16.0f);
                layoutParams.width = t60.a(this.a, 16.0f);
            } else if (i2 < 99) {
                layoutParams.height = t60.a(this.a, 20.0f);
                layoutParams.width = t60.a(this.a, 20.0f);
            } else {
                layoutParams.height = t60.a(this.a, 26.0f);
                layoutParams.width = t60.a(this.a, 26.0f);
            }
            aVar.b.setLayoutParams(layoutParams);
            aVar.b.setText(String.valueOf(i2));
            py2.F(aVar.c, tickletForgetCardData.code);
            py2.z(tickletForgetCardData.state, aVar.c, "#111111", "#DDDDDD");
            aVar.e.removeAllViews();
            d(aVar.e, tickletForgetCardData.state, tickletForgetCardData.seatInfo);
            py2.B(tickletForgetCardData.state, aVar.f);
            if (i != getItemCount() - 1) {
                aVar.d.setVisibility(0);
            } else {
                aVar.d.setVisibility(8);
            }
        }
    }

    private void d(LinearLayout linearLayout, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139023213")) {
            ipChange.ipc$dispatch("2139023213", new Object[]{this, linearLayout, str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            linearLayout.setVisibility(0);
            TextView textView = new TextView(this.a);
            textView.setGravity(17);
            textView.setTextSize(1, 12.0f);
            py2.z(str, textView, "#666666", "#dbdbdbd");
            textView.setText(str2);
            linearLayout.addView(textView);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774443553")) {
            ipChange.ipc$dispatch("-774443553", new Object[]{this, aVar, Integer.valueOf(i)});
        } else {
            c(aVar, this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1667070025") ? (a) ipChange.ipc$dispatch("-1667070025", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new a(this, LayoutInflater.from(this.a).inflate(R$layout.ticklet_forget_card_item, viewGroup, false));
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889484037")) {
            ipChange.ipc$dispatch("1889484037", new Object[]{this});
            return;
        }
        this.b.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1652141317") ? ((Integer) ipChange.ipc$dispatch("1652141317", new Object[]{this})).intValue() : this.b.size();
    }

    public void setData(List<TickletForgetCardResult.TickletForgetCardData> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709648247")) {
            ipChange.ipc$dispatch("1709648247", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
