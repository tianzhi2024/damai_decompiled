package com.alibaba.gaiax.render.view.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.basic.GXItemContainer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.C8212k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fs0;
import tb.l81;
import tb.ld2;
import tb.os0;
import tb.qr0;
import tb.qs0;
import tb.vr0;
import tb.wq0;
import tb.wt2;
import tb.yq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", "Ltb/os0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "gxContainer", "<init>", "(Ltb/os0;Lcom/alibaba/gaiax/render/view/container/GXContainer;)V", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class GXContainerViewAdapter extends RecyclerView.Adapter<GXViewHolder> {
    @NotNull
    private final os0 a;
    @NotNull
    private final GXContainer b;
    private int c;
    public qr0 d;
    @NotNull
    private JSONArray e;
    @Nullable
    private GXTemplateEngine.C3347i f;
    private boolean g;
    @NotNull
    private final Map<Integer, GXTemplateEngine.C3347i> h;
    @NotNull
    private final Map<Integer, GXTemplateEngine.C3347i> i;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.GXContainerViewAdapter$a */
    /* loaded from: classes6.dex */
    public static final class C3369a implements GXTemplateEngine.GXIEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXContainerViewAdapter b;

        C3369a(int i, GXContainerViewAdapter gXContainerViewAdapter) {
            this.a = i;
            this.b = gXContainerViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull GXTemplateEngine.C3338b c3338b) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3338b, "gxAnimation");
            GXTemplateEngine.GXIEventListener.C3335a.a(this, c3338b);
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onAnimationEvent(c3338b);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull GXTemplateEngine.C3342e c3342e) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3342e, "gxGesture");
            GXTemplateEngine.GXIEventListener.C3335a.b(this, c3342e);
            c3342e.setIndex(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onGestureEvent(c3342e);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull GXTemplateEngine.C3344g c3344g) {
            GXTemplateEngine.GXIEventListener c;
            b41.i(c3344g, "gxScroll");
            GXTemplateEngine.GXIEventListener.C3335a.c(this, c3344g);
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (c = p.c()) == null) {
                return;
            }
            c.onScrollEvent(c3344g);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.GXContainerViewAdapter$b */
    /* loaded from: classes6.dex */
    public static final class C3370b implements GXTemplateEngine.GXITrackListener {
        final /* synthetic */ int a;
        final /* synthetic */ GXContainerViewAdapter b;

        C3370b(int i, GXContainerViewAdapter gXContainerViewAdapter) {
            this.a = i;
            this.b = gXContainerViewAdapter;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualClickTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onManualClickTrackEvent(c3349k);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onManualExposureTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onManualExposureTrackEvent(c3349k);
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXITrackListener
        public void onTrackEvent(@NotNull GXTemplateEngine.C3349k c3349k) {
            GXTemplateEngine.GXITrackListener f;
            b41.i(c3349k, "gxTrack");
            c3349k.e(Integer.valueOf(this.a));
            GXTemplateEngine.C3346h p = this.b.e().p();
            if (p == null || (f = p.f()) == null) {
                return;
            }
            f.onTrackEvent(c3349k);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.render.view.container.GXContainerViewAdapter$c */
    /* loaded from: classes6.dex */
    public static final class C3371c implements GXTemplateEngine.GXIDataListener {
        C3371c() {
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIDataListener
        @Nullable
        public CharSequence onTextProcess(@NotNull GXTemplateEngine.C3348j c3348j) {
            GXTemplateEngine.GXIDataListener b;
            b41.i(c3348j, "gxTextData");
            GXTemplateEngine.C3346h p = GXContainerViewAdapter.this.e().p();
            if (p == null || (b = p.b()) == null) {
                return null;
            }
            return b.onTextProcess(c3348j);
        }
    }

    public GXContainerViewAdapter(@NotNull os0 os0Var, @NotNull GXContainer gXContainer) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(gXContainer, "gxContainer");
        this.a = os0Var;
        this.b = gXContainer;
        this.e = new JSONArray();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
    }

    private final void a(GXViewHolder gXViewHolder) {
        JSONObject jSONObject;
        View f;
        GXTemplateEngine.C3347i a = gXViewHolder.a();
        if (a != null) {
            boolean d = b41.d(a, this.f);
            qs0 j = j(a);
            ld2<Float> h = h(d);
            GXTemplateEngine.C3343f i = i(h);
            FrameLayout.LayoutParams f2 = f(g(d, a, j, h));
            GXItemContainer gXItemContainer = (GXItemContainer) gXViewHolder.itemView;
            fs0 h2 = d().o().i().h();
            if (h2 != null && h2.j()) {
                gXItemContainer.setGravity(h2.f());
            }
            gXItemContainer.setLayoutParams(f2);
            int adapterPosition = gXViewHolder.getAdapterPosition();
            if (adapterPosition < this.e.size()) {
                jSONObject = this.e.getJSONObject(adapterPosition);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            GXRegisterCenter.GXIExtensionContainerItemBind f3 = GXRegisterCenter.Companion.a().f();
            if (f3 != null) {
                GXTemplateEngine.C3346h p = this.a.p();
                Object e = p == null ? null : p.e();
                GXTemplateEngine.C3341d c3341d = new GXTemplateEngine.C3341d();
                c3341d.g(Integer.valueOf(adapterPosition));
                c3341d.f(jSONObject2);
                c3341d.e(e());
                c3341d.h(j);
                wt2 wt2Var = wt2.INSTANCE;
                gXViewHolder.b(f3.bindViewHolder(e, gXItemContainer, i, a, c3341d));
                return;
            }
            if (gXItemContainer.getChildCount() != 0) {
                f = gXItemContainer.getChildAt(0);
            } else {
                GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
                GXTemplateEngine.v(c3337a.a(), a, i, null, 4, null);
                GXTemplateEngine a2 = c3337a.a();
                GXTemplateEngine.C3341d c3341d2 = new GXTemplateEngine.C3341d();
                c3341d2.g(Integer.valueOf(adapterPosition));
                c3341d2.f(jSONObject2);
                c3341d2.e(e());
                c3341d2.h(j);
                wt2 wt2Var2 = wt2.INSTANCE;
                os0 e2 = a2.e(a, i, c3341d2);
                if (e2 != null) {
                    f = c3337a.a().f(e2);
                    gXItemContainer.addView(f);
                } else {
                    throw new IllegalArgumentException("Create GXTemplateContext fail, please check");
                }
            }
            GXTemplateEngine.C3346h c3346h = new GXTemplateEngine.C3346h(jSONObject2);
            c3346h.h(new C3369a(adapterPosition, this));
            c3346h.k(new C3370b(adapterPosition, this));
            c3346h.g(new C3371c());
            if (f != null) {
                GXTemplateEngine.C3337a c3337a2 = GXTemplateEngine.Companion;
                c3337a2.a().b(f, c3346h, i);
                c3337a2.a().c(f, c3346h, i);
                gXItemContainer.getLayoutParams().width = f.getLayoutParams().width;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("templateItem is null");
    }

    private final GXViewHolder b(int i, ViewGroup viewGroup) {
        GXTemplateEngine.C3347i c3347i = this.h.get(Integer.valueOf(i));
        if (c3347i != null) {
            boolean d = b41.d(c3347i, this.f);
            FrameLayout.LayoutParams f = f(g(d, c3347i, j(c3347i), h(d)));
            Context context = viewGroup.getContext();
            b41.h(context, "parent.context");
            GXItemContainer gXItemContainer = new GXItemContainer(context);
            fs0 h = d().o().i().h();
            if (h != null && h.j()) {
                gXItemContainer.setGravity(h.f());
            }
            gXItemContainer.setLayoutParams(f);
            GXViewHolder gXViewHolder = new GXViewHolder(gXItemContainer);
            gXViewHolder.c(c3347i);
            return gXViewHolder;
        }
        throw new IllegalArgumentException("GXTemplateItem not exist, viewType = " + i + ", viewTypeMap = " + this.h);
    }

    private final GXTemplateEngine.C3347i c(int i) {
        Object obj;
        List<Pair<GXTemplateEngine.C3347i, qs0>> c = d().c();
        if (c == null) {
            return null;
        }
        if (c.size() > 1) {
            JSONObject jSONObject = this.e.getJSONObject(i);
            d().o().C();
            JSONObject h = d().o().h(jSONObject);
            if (h != null) {
                String g = yq0.g(h, b41.r("item-type.config.", yq0.g(h, vr0.ITEM_PATH)));
                Iterator<T> it = c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (b41.d(((GXTemplateEngine.C3347i) ((Pair) obj).getFirst()).d(), g)) {
                        break;
                    }
                }
                Pair pair = (Pair) obj;
                if (pair == null) {
                    return null;
                }
                return (GXTemplateEngine.C3347i) pair.getFirst();
            }
            return null;
        }
        Pair pair2 = (Pair) C8212k.R(c);
        if (pair2 == null) {
            return null;
        }
        return (GXTemplateEngine.C3347i) pair2.getFirst();
    }

    private final FrameLayout.LayoutParams f(l81 l81Var) {
        float d;
        int i;
        Integer valueOf;
        int i2 = -2;
        int e = l81Var == null ? -2 : (int) l81Var.e();
        fs0 h = d().o().i().h();
        if (h == null) {
            valueOf = null;
        } else if (h.j()) {
            if (l81Var != null && this.b.getLayoutParams().height < l81Var.d()) {
                d = l81Var.d();
                i = (int) d;
                valueOf = Integer.valueOf(i);
            } else {
                i = this.b.getLayoutParams().height;
                valueOf = Integer.valueOf(i);
            }
        } else if (l81Var != null) {
            d = l81Var.d();
            i = (int) d;
            valueOf = Integer.valueOf(i);
        } else {
            i = -2;
            valueOf = Integer.valueOf(i);
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        } else if (l81Var != null) {
            i2 = (int) l81Var.d();
        }
        return new FrameLayout.LayoutParams(e, i2);
    }

    private final l81 g(boolean z, GXTemplateEngine.C3347i c3347i, qs0 qs0Var, ld2<Float> ld2Var) {
        Object obj = this.e.get(this.c);
        JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        if (z) {
            return vr0.INSTANCE.l(this.a, ld2Var, c3347i, qs0Var, jSONObject2, this.c);
        }
        return vr0.INSTANCE.n(this.a, d(), jSONObject2, this.c);
    }

    private final ld2<Float> h(boolean z) {
        if (z) {
            return vr0.INSTANCE.m(this.a, d());
        }
        return vr0.INSTANCE.o(this.a, d());
    }

    private final GXTemplateEngine.C3343f i(ld2<Float> ld2Var) {
        return new GXTemplateEngine.C3343f(ld2Var.b(), ld2Var.a());
    }

    private final qs0 j(GXTemplateEngine.C3347i c3347i) {
        List<Pair<GXTemplateEngine.C3347i, qs0>> c = d().c();
        if (c == null) {
            return null;
        }
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (b41.d(((GXTemplateEngine.C3347i) pair.getFirst()).d(), c3347i.d())) {
                return (qs0) pair.getSecond();
            }
        }
        return null;
    }

    @NotNull
    public final qr0 d() {
        qr0 qr0Var = this.d;
        if (qr0Var != null) {
            return qr0Var;
        }
        b41.A("gxNode");
        return null;
    }

    @NotNull
    public final os0 e() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (k()) {
            return this.e.size() + 1;
        }
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        GXTemplateEngine.C3347i c3347i = this.f;
        if (this.g && c3347i != null && i == this.e.size()) {
            int hashCode = c3347i.hashCode();
            this.h.put(Integer.valueOf(hashCode), c3347i);
            this.i.put(Integer.valueOf(i), c3347i);
            return hashCode;
        }
        this.c = i;
        GXTemplateEngine.C3347i c = c(i);
        if (c != null) {
            int hashCode2 = c.d().hashCode();
            this.h.put(Integer.valueOf(hashCode2), c);
            this.i.put(Integer.valueOf(i), c);
            return hashCode2;
        }
        return super.getItemViewType(i);
    }

    public final boolean k() {
        return this.f != null && this.g;
    }

    public final void l() {
        GXTemplateEngine.C3346h p = this.a.p();
        JSONObject a = p == null ? null : p.a();
        if (a == null) {
            return;
        }
        JSONObject h = d().o().h(a);
        JSONObject jSONObject = h != null ? h.getJSONObject("item-footer-type") : null;
        if (jSONObject != null) {
            String string = jSONObject.getString("id");
            Context e = this.a.e();
            String a2 = this.a.r().a();
            b41.h(string, "templateId");
            this.f = new GXTemplateEngine.C3347i(e, a2, string);
            Boolean bool = jSONObject.getBoolean("hasMore");
            this.g = bool == null ? false : bool.booleanValue();
        }
    }

    public final boolean m(float f) {
        l81 h = d().h();
        return !b41.b(h == null ? null : Float.valueOf(h.e()), f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NotNull GXViewHolder gXViewHolder, int i) {
        b41.i(gXViewHolder, "holder");
        try {
            a(gXViewHolder);
        } catch (Exception e) {
            if (wq0.INSTANCE.b()) {
                wq0.INSTANCE.a(e);
                return;
            }
            throw e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o */
    public GXViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        b41.i(viewGroup, "parent");
        try {
            return b(i, viewGroup);
        } catch (Exception e) {
            if (wq0.INSTANCE.b()) {
                wq0.INSTANCE.a(e);
                Context context = viewGroup.getContext();
                b41.h(context, "parent.context");
                return new GXViewHolder(new GXItemContainer(context));
            }
            throw e;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void p(@NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "data");
        this.h.clear();
        this.i.clear();
        this.c = 0;
        GXRegisterCenter.GXIExtensionContainerDataUpdate e = GXRegisterCenter.Companion.a().e();
        if (e != null) {
            JSONArray jSONArray2 = this.e;
            this.e = jSONArray;
            e.update(this.a, this, jSONArray2, jSONArray);
            return;
        }
        this.e = jSONArray;
        notifyDataSetChanged();
    }

    public final void q(@NotNull qr0 qr0Var) {
        b41.i(qr0Var, "<set-?>");
        this.d = qr0Var;
    }
}
