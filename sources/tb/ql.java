package tb;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ql {
    @NotNull
    public static final ql INSTANCE = new ql();
    @NotNull
    private static final Set<hj> a;

    static {
        int q;
        List n0;
        List n02;
        List<hp0> n03;
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        q = C8215n.q(set, 10);
        ArrayList arrayList = new ArrayList(q);
        for (PrimitiveType primitiveType : set) {
            arrayList.add(C8277c.c(primitiveType));
        }
        hp0 l = C8277c.C8278a.string.l();
        b41.h(l, "string.toSafe()");
        n0 = CollectionsKt___CollectionsKt.n0(arrayList, l);
        hp0 l2 = C8277c.C8278a._boolean.l();
        b41.h(l2, "_boolean.toSafe()");
        n02 = CollectionsKt___CollectionsKt.n0(n0, l2);
        hp0 l3 = C8277c.C8278a._enum.l();
        b41.h(l3, "_enum.toSafe()");
        n03 = CollectionsKt___CollectionsKt.n0(n02, l3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (hp0 hp0Var : n03) {
            linkedHashSet.add(hj.m(hp0Var));
        }
        a = linkedHashSet;
    }

    private ql() {
    }

    @NotNull
    public final Set<hj> a() {
        return a;
    }

    @NotNull
    public final Set<hj> b() {
        return a;
    }
}
