package tb;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractC6407a;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureCenter;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner;
import com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pz1<ExposeKey, ExposeData> extends AbstractC6407a<ExposeKey, ExposeData> {
    private final RecyclerView b;
    private pz1<ExposeKey, ExposeData>.View$OnAttachStateChangeListenerC9585c c;
    private final Set<String> d;

    /* compiled from: Taobao */
    /* renamed from: tb.pz1$b */
    /* loaded from: classes11.dex */
    public static class C9584b<ExposeKey, ExposeData> extends AbstractC6407a.AbstractC6408a<ExposeKey, ExposeData, AbstractExposure.C6406a<ExposeData>> {
        private final RecyclerView e;

        public C9584b(@NonNull RecyclerView recyclerView, @NonNull RecyclerViewZone.OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback) {
            this(recyclerView, onRecyclerViewExposeCallback, new o50());
        }

        @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractC6407a.AbstractC6408a
        @NonNull
        protected IExposureEngine<ExposeKey, ExposeData> b(@NonNull IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner, @NonNull Collection<IExposureZone<ExposeKey, ExposeData>> collection) {
            return new pz1(this.e, iExposureZoneRunner);
        }

        public C9584b(@NonNull RecyclerView recyclerView, @NonNull RecyclerViewZone.OnRecyclerViewExposeCallback<ExposeKey, ExposeData> onRecyclerViewExposeCallback, @Nullable IExposureCenter<ExposeKey, ExposeData, AbstractExposure.C6406a<ExposeData>> iExposureCenter) {
            super(new RecyclerViewZone.C6409a(recyclerView).c(onRecyclerViewExposeCallback), iExposureCenter);
            this.e = recyclerView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.pz1$c */
    /* loaded from: classes11.dex */
    public class View$OnAttachStateChangeListenerC9585c implements View.OnAttachStateChangeListener {
        private View$OnAttachStateChangeListenerC9585c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            for (String str : pz1.this.d) {
                ((AbstractC6407a) pz1.this).a.runZone(str);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ((AbstractC6407a) pz1.this).a.stopZone();
        }
    }

    public pz1(RecyclerView recyclerView, IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner) {
        super(iExposureZoneRunner);
        this.d = new HashSet();
        this.b = recyclerView;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void start() {
        start(null);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void stop() {
        stop(null);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void start(@Nullable String str) {
        if (str == null) {
            for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
                this.d.add(iExposureZone.key());
            }
        } else {
            this.d.add(str);
        }
        if (this.c == null) {
            pz1<ExposeKey, ExposeData>.View$OnAttachStateChangeListenerC9585c view$OnAttachStateChangeListenerC9585c = new View$OnAttachStateChangeListenerC9585c();
            this.c = view$OnAttachStateChangeListenerC9585c;
            this.b.addOnAttachStateChangeListener(view$OnAttachStateChangeListenerC9585c);
        } else if (str == null) {
            this.a.runZone();
        } else {
            this.a.runZone(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractC6407a, com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void stop(@Nullable String str) {
        super.stop(str);
        if (str == null) {
            this.d.clear();
        } else {
            this.d.remove(str);
        }
        if (this.c == null || !this.d.isEmpty()) {
            return;
        }
        this.b.removeOnAttachStateChangeListener(this.c);
    }
}
