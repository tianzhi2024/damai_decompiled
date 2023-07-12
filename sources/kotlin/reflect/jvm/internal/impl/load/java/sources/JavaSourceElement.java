package kotlin.reflect.jvm.internal.impl.load.java.sources;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaSourceElement extends SourceElement {
    @NotNull
    JavaElement getJavaElement();
}
