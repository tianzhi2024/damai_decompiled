package tb;

import java.util.List;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class tj extends GivenFunctionsMemberScope {
    @NotNull
    public static final C9727a Companion = new C9727a(null);
    @NotNull
    private static final ni1 d;

    /* compiled from: Taobao */
    /* renamed from: tb.tj$a */
    /* loaded from: classes3.dex */
    public static final class C9727a {
        private C9727a() {
        }

        public /* synthetic */ C9727a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ni1 a() {
            return tj.d;
        }
    }

    static {
        ni1 f = ni1.f("clone");
        b41.h(f, "identifier(\"clone\")");
        d = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tj(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        super(storageManager, classDescriptor);
        b41.i(storageManager, "storageManager");
        b41.i(classDescriptor, "containingClass");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    public List<FunctionDescriptor> b() {
        List<? extends TypeParameterDescriptor> g;
        List<ValueParameterDescriptor> g2;
        List<FunctionDescriptor> e;
        cd2 F = cd2.F(e(), Annotations.Companion.b(), d, CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        ReceiverParameterDescriptor thisAsReceiverParameter = e().getThisAsReceiverParameter();
        g = C8214m.g();
        g2 = C8214m.g();
        F.l(null, thisAsReceiverParameter, g, g2, DescriptorUtilsKt.g(e()).i(), Modality.OPEN, e70.PROTECTED);
        e = C8213l.e(F);
        return e;
    }
}
