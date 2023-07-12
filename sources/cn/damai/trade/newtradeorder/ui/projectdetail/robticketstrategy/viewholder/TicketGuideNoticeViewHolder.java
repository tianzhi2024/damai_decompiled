package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.C0511b;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuideNoticeBean;
import cn.damai.uikit.view.DashedLine;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TicketGuideNoticeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private DashedLine e;
    private int f;
    private Context g;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideNoticeViewHolder$a */
    /* loaded from: classes8.dex */
    public class C2421a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2421a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-748408352")) {
                ipChange.ipc$dispatch("-748408352", new Object[]{this, c0501d});
            } else {
                TicketGuideNoticeViewHolder.this.d.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideNoticeViewHolder$b */
    /* loaded from: classes8.dex */
    public class C2422b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectTickGuideNoticeBean a;
        final /* synthetic */ String b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuideNoticeViewHolder$b$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2423a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2423a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1775728388")) {
                    ipChange.ipc$dispatch("-1775728388", new Object[]{this, view});
                    return;
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(C2422b.this.a.imageUrl)) {
                    return;
                }
                PicInfo picInfo = new PicInfo();
                picInfo.setPicUrl(C2422b.this.a.imageUrl);
                arrayList.add(picInfo);
                Bundle bundle = new Bundle();
                bundle.putString("projectId", C2422b.this.b);
                bundle.putParcelableArrayList("pic_info", arrayList);
                bundle.putInt("position", 0);
                DMNav.from(TicketGuideNoticeViewHolder.this.g).withExtras(bundle).toUri(cs.e());
            }
        }

        C2422b(ProjectTickGuideNoticeBean projectTickGuideNoticeBean, String str) {
            this.a = projectTickGuideNoticeBean;
            this.b = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "592657269")) {
                ipChange.ipc$dispatch("592657269", new Object[]{this, c0502e});
            } else if (c0502e == null || (drawable = c0502e.a) == null) {
                TicketGuideNoticeViewHolder.this.d.setImageResource(R$drawable.uikit_default_image_bg_grey);
            } else {
                TicketGuideNoticeViewHolder ticketGuideNoticeViewHolder = TicketGuideNoticeViewHolder.this;
                ticketGuideNoticeViewHolder.f(ticketGuideNoticeViewHolder.d, TicketGuideNoticeViewHolder.this.f, (int) (((drawable.getIntrinsicHeight() * TicketGuideNoticeViewHolder.this.f) * 1.0f) / c0502e.a.getIntrinsicWidth()));
                TicketGuideNoticeViewHolder.this.d.setImageDrawable(c0502e.a);
                TicketGuideNoticeViewHolder.this.d.setOnClickListener(new View$OnClickListenerC2423a());
            }
        }
    }

    public TicketGuideNoticeViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_ticket_guide_notice, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
        this.g = context;
        this.a = this.itemView.findViewById(R$id.top_line);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_notice_title);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_notice_desc);
        this.d = (ImageView) this.itemView.findViewById(R$id.iv_notice_image);
        this.e = (DashedLine) this.itemView.findViewById(R$id.bottom_line);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392469179")) {
            ipChange.ipc$dispatch("-392469179", new Object[]{this, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.setLayoutParams(imageView.getLayoutParams());
    }

    public void e(ProjectTickGuideNoticeBean projectTickGuideNoticeBean, boolean z, boolean z2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961410178")) {
            ipChange.ipc$dispatch("961410178", new Object[]{this, projectTickGuideNoticeBean, Boolean.valueOf(z), Boolean.valueOf(z2), str});
        } else if (projectTickGuideNoticeBean == null) {
        } else {
            this.a.setVisibility(z ? 8 : 0);
            this.e.setVisibility(z2 ? 8 : 0);
            this.b.setText(projectTickGuideNoticeBean.notice);
            if (TextUtils.isEmpty(projectTickGuideNoticeBean.desc)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.c.setText(projectTickGuideNoticeBean.desc);
            }
            DMImageStrategyConfig b = C0511b.b(projectTickGuideNoticeBean.imageUrl, -1, -1);
            if (b != null) {
                b.b = false;
            }
            DMImageCreator g = C0504a.b().g(projectTickGuideNoticeBean.imageUrl, b);
            int i = R$drawable.uikit_default_image_bg_grey;
            g.i(i).c(i).n(new C2422b(projectTickGuideNoticeBean, str)).e(new C2421a()).f();
        }
    }
}