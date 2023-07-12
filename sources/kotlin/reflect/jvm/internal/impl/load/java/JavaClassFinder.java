package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hj;
import tb.hp0;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaClassFinder {
    @Nullable
    JavaClass findClass(@NotNull C8328a c8328a);

    @Nullable
    JavaPackage findPackage(@NotNull hp0 hp0Var);

    @Nullable
    Set<String> knownClassNamesInPackage(@NotNull hp0 hp0Var);

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$a */
    /* loaded from: classes3.dex */
    public static final class C8328a {
        @NotNull
        private final hj a;
        @Nullable
        private final byte[] b;
        @Nullable
        private final JavaClass c;

        public C8328a(@NotNull hj hjVar, @Nullable byte[] bArr, @Nullable JavaClass javaClass) {
            b41.i(hjVar, "classId");
            this.a = hjVar;
            this.b = bArr;
            this.c = javaClass;
        }

        @NotNull
        public final hj a() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C8328a) {
                C8328a c8328a = (C8328a) obj;
                return b41.d(this.a, c8328a.a) && b41.d(this.b, c8328a.b) && b41.d(this.c, c8328a.c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.c;
            return hashCode2 + (javaClass != null ? javaClass.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.c + ')';
        }

        public /* synthetic */ C8328a(hj hjVar, byte[] bArr, JavaClass javaClass, int i, k50 k50Var) {
            this(hjVar, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : javaClass);
        }
    }
}
