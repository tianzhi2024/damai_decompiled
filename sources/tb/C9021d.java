package tb;

import android.app.Application;
import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.alibaba.pictures.abtest.provider.ABTestUpdateOperator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Constants;
import java.util.List;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: tb.d */
/* loaded from: classes7.dex */
public final class C9021d {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9022a Companion = new C9022a(null);
    public static Application a;
    public static C9024b b;
    public static ABTestUpdateOperator c;

    /* compiled from: Taobao */
    /* renamed from: tb.d$a */
    /* loaded from: classes7.dex */
    public static final class C9022a {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: tb.d$a$a */
        /* loaded from: classes7.dex */
        public static final class C9023a implements ABTestUpdateOperator {
            private static transient /* synthetic */ IpChange $ipChange;

            C9023a() {
            }

            @Override // com.alibaba.pictures.abtest.provider.ABTestUpdateOperator
            public void doNotifyUserLogin(@Nullable String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2013825875")) {
                    ipChange.ipc$dispatch("2013825875", new Object[]{this, str});
                    return;
                }
                C9022a c9022a = C9021d.Companion;
                c9022a.b().g(str);
                ABTestProvider.m(ABTestProvider.INSTANCE, c9022a.b().c(), null, 2, null);
            }

            @Override // com.alibaba.pictures.abtest.provider.ABTestUpdateOperator
            public void doNotifyUserLogout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-770993426")) {
                    ipChange.ipc$dispatch("-770993426", new Object[]{this});
                    return;
                }
                C9022a c9022a = C9021d.Companion;
                c9022a.b().g(null);
                ABTestProvider.m(ABTestProvider.INSTANCE, c9022a.b().c(), null, 2, null);
            }
        }

        private C9022a() {
        }

        private final void d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2095452788")) {
                ipChange.ipc$dispatch("-2095452788", new Object[]{this});
            } else {
                f(new C9023a());
            }
        }

        @NotNull
        public final Application a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1724766353")) {
                return (Application) ipChange.ipc$dispatch("1724766353", new Object[]{this});
            }
            Application application = C9021d.a;
            if (application == null) {
                b41.A("application");
            }
            return application;
        }

        @NotNull
        public final C9024b b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1922005280")) {
                return (C9024b) ipChange.ipc$dispatch("-1922005280", new Object[]{this});
            }
            C9024b c9024b = C9021d.b;
            if (c9024b == null) {
                b41.A(Constants.CONFIG);
            }
            return c9024b;
        }

        @JvmStatic
        public final void c(@NotNull Application application, @NotNull C9024b c9024b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1732105517")) {
                ipChange.ipc$dispatch("-1732105517", new Object[]{this, application, c9024b});
                return;
            }
            b41.i(application, "application");
            b41.i(c9024b, Constants.CONFIG);
            g(application);
            h(c9024b);
            d();
            if (c9024b.a()) {
                ABTestProvider.m(ABTestProvider.INSTANCE, C9021d.Companion.b().c(), null, 2, null);
            }
            C9063e.INSTANCE.a();
        }

        public final boolean e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1123054647") ? ((Boolean) ipChange.ipc$dispatch("-1123054647", new Object[]{this})).booleanValue() : b().d();
        }

        public final void f(@NotNull ABTestUpdateOperator aBTestUpdateOperator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343964006")) {
                ipChange.ipc$dispatch("-343964006", new Object[]{this, aBTestUpdateOperator});
                return;
            }
            b41.i(aBTestUpdateOperator, "<set-?>");
            C9021d.c = aBTestUpdateOperator;
        }

        public final void g(@NotNull Application application) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "374609873")) {
                ipChange.ipc$dispatch("374609873", new Object[]{this, application});
                return;
            }
            b41.i(application, "<set-?>");
            C9021d.a = application;
        }

        public final void h(@NotNull C9024b c9024b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "575582762")) {
                ipChange.ipc$dispatch("575582762", new Object[]{this, c9024b});
                return;
            }
            b41.i(c9024b, "<set-?>");
            C9021d.b = c9024b;
        }

        public /* synthetic */ C9022a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.d$b */
    /* loaded from: classes7.dex */
    public static final class C9024b {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        public static final C9024b INSTANCE = new C9024b();
        private static boolean a;
        @Nullable
        private static List<String> b;
        @Nullable
        private static String c;
        private static boolean d;

        private C9024b() {
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1104957545") ? ((Boolean) ipChange.ipc$dispatch("-1104957545", new Object[]{this})).booleanValue() : d;
        }

        @Nullable
        public final String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "973050184") ? (String) ipChange.ipc$dispatch("973050184", new Object[]{this}) : c;
        }

        @Nullable
        public final List<String> c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-124844635") ? (List) ipChange.ipc$dispatch("-124844635", new Object[]{this}) : b;
        }

        public final boolean d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "739185345") ? ((Boolean) ipChange.ipc$dispatch("739185345", new Object[]{this})).booleanValue() : a;
        }

        public final void e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-719193448")) {
                ipChange.ipc$dispatch("-719193448", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public final void f(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-472897771")) {
                ipChange.ipc$dispatch("-472897771", new Object[]{this, Boolean.valueOf(z)});
            } else {
                d = z;
            }
        }

        public final void g(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1865420242")) {
                ipChange.ipc$dispatch("-1865420242", new Object[]{this, str});
            } else {
                c = str;
            }
        }

        public final void h(@Nullable List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-779553081")) {
                ipChange.ipc$dispatch("-779553081", new Object[]{this, list});
            } else {
                b = list;
            }
        }
    }

    @NotNull
    public static final ABTestUpdateOperator f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815479542")) {
            return (ABTestUpdateOperator) ipChange.ipc$dispatch("815479542", new Object[0]);
        }
        ABTestUpdateOperator aBTestUpdateOperator = c;
        if (aBTestUpdateOperator == null) {
            b41.A("abTestUpdateOperator");
        }
        return aBTestUpdateOperator;
    }
}