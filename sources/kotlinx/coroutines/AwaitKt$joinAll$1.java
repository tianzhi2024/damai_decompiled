package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@"}, d2 = {"", "Lkotlinx/coroutines/Job;", "jobs", "Lkotlin/coroutines/Continuation;", "Ltb/wt2;", "continuation", "", "joinAll"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0}, l = {55}, m = "joinAll", n = {"jobs", "$this$forEach$iv", "element$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4"})
/* loaded from: classes8.dex */
public final class AwaitKt$joinAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AwaitKt$joinAll$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.d(null, this);
    }
}
