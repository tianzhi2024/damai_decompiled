package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class StringsKt___StringsKt$chunkedSequence$1 extends Lambda implements Function1<CharSequence, String> {
    public static final StringsKt___StringsKt$chunkedSequence$1 INSTANCE = new StringsKt___StringsKt$chunkedSequence$1();

    StringsKt___StringsKt$chunkedSequence$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String invoke(@NotNull CharSequence charSequence) {
        b41.i(charSequence, AdvanceSetting.NETWORK_TYPE);
        return charSequence.toString();
    }
}
