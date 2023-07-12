package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8201d0;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.e70;
import tb.f70;
import tb.fd2;
import tb.fj;
import tb.hj;
import tb.hp0;
import tb.i31;
import tb.ie0;
import tb.lj;
import tb.n31;
import tb.ni1;
import tb.p21;
import tb.ty1;
import tb.wq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class NotFoundClasses {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;
    @NotNull
    private final MemoizedFunctionToNotNull<hp0, PackageFragmentDescriptor> c;
    @NotNull
    private final MemoizedFunctionToNotNull<C8293a, ClassDescriptor> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$a */
    /* loaded from: classes3.dex */
    public static final class C8293a {
        @NotNull
        private final hj a;
        @NotNull
        private final List<Integer> b;

        public C8293a(@NotNull hj hjVar, @NotNull List<Integer> list) {
            b41.i(hjVar, "classId");
            b41.i(list, "typeParametersCount");
            this.a = hjVar;
            this.b = list;
        }

        @NotNull
        public final hj a() {
            return this.a;
        }

        @NotNull
        public final List<Integer> b() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C8293a) {
                C8293a c8293a = (C8293a) obj;
                return b41.d(this.a, c8293a.a) && b41.d(this.b, c8293a.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$b */
    /* loaded from: classes3.dex */
    public static final class C8294b extends fj {
        private final boolean h;
        @NotNull
        private final List<TypeParameterDescriptor> i;
        @NotNull
        private final lj j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8294b(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull ni1 ni1Var, boolean z, int i) {
            super(storageManager, declarationDescriptor, ni1Var, SourceElement.NO_SOURCE, false);
            n31 h;
            int q;
            Set c;
            b41.i(storageManager, "storageManager");
            b41.i(declarationDescriptor, "container");
            b41.i(ni1Var, "name");
            this.h = z;
            h = ty1.h(0, i);
            q = C8215n.q(h, 10);
            ArrayList arrayList = new ArrayList(q);
            Iterator<Integer> it = h.iterator();
            while (it.hasNext()) {
                int nextInt = ((i31) it).nextInt();
                arrayList.add(wq2.l(this, Annotations.Companion.b(), false, Variance.INVARIANT, ni1.f(b41.r("T", Integer.valueOf(nextInt))), nextInt, storageManager));
            }
            this.i = arrayList;
            List<TypeParameterDescriptor> d = TypeParameterUtilsKt.d(this);
            c = C8201d0.c(DescriptorUtilsKt.l(this).getBuiltIns().i());
            this.j = new lj(this, d, c, storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        /* renamed from: e */
        public MemberScope.C8499b getStaticScope() {
            return MemberScope.C8499b.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        @NotNull
        /* renamed from: f */
        public lj getTypeConstructor() {
            return this.j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // tb.wg1
        @NotNull
        /* renamed from: g */
        public MemberScope.C8499b b(@NotNull b81 b81Var) {
            b41.i(b81Var, "kotlinTypeRefiner");
            return MemberScope.C8499b.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            Set d;
            d = C8203e0.d();
            return d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public p21<fd2> getInlineClassRepresentation() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassDescriptor> getSealedSubclasses() {
            List g;
            g = C8214m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        @NotNull
        public f70 getVisibility() {
            f70 f70Var = e70.PUBLIC;
            b41.h(f70Var, "PUBLIC");
            return f70Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // tb.fj, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        @NotNull
        public String toString() {
            return "class " + getName() + " (not found)";
        }
    }

    public NotFoundClasses(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "module");
        this.a = storageManager;
        this.b = moduleDescriptor;
        this.c = storageManager.createMemoizedFunction(new Function1<hp0, PackageFragmentDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$packageFragments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final PackageFragmentDescriptor invoke(@NotNull hp0 hp0Var) {
                ModuleDescriptor moduleDescriptor2;
                b41.i(hp0Var, "fqName");
                moduleDescriptor2 = NotFoundClasses.this.b;
                return new ie0(moduleDescriptor2, hp0Var);
            }
        });
        this.d = storageManager.createMemoizedFunction(new Function1<C8293a, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final ClassDescriptor invoke(@NotNull NotFoundClasses.C8293a c8293a) {
                List<Integer> L;
                DeclarationDescriptorWithSource d;
                StorageManager storageManager2;
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                b41.i(c8293a, "$dstr$classId$typeParametersCount");
                hj a = c8293a.a();
                List<Integer> b = c8293a.b();
                if (!a.k()) {
                    hj g = a.g();
                    if (g == null) {
                        d = null;
                    } else {
                        NotFoundClasses notFoundClasses = NotFoundClasses.this;
                        L = CollectionsKt___CollectionsKt.L(b, 1);
                        d = notFoundClasses.d(g, L);
                    }
                    if (d == null) {
                        memoizedFunctionToNotNull = NotFoundClasses.this.c;
                        hp0 h = a.h();
                        b41.h(h, "classId.packageFqName");
                        d = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(h);
                    }
                    DeclarationDescriptorWithSource declarationDescriptorWithSource = d;
                    boolean l = a.l();
                    storageManager2 = NotFoundClasses.this.a;
                    ni1 j = a.j();
                    b41.h(j, "classId.shortClassName");
                    Integer num = (Integer) C8212k.R(b);
                    return new NotFoundClasses.C8294b(storageManager2, declarationDescriptorWithSource, j, l, num == null ? 0 : num.intValue());
                }
                throw new UnsupportedOperationException(b41.r("Unresolved local class: ", a));
            }
        });
    }

    @NotNull
    public final ClassDescriptor d(@NotNull hj hjVar, @NotNull List<Integer> list) {
        b41.i(hjVar, "classId");
        b41.i(list, "typeParametersCount");
        return this.d.invoke(new C8293a(hjVar, list));
    }
}
