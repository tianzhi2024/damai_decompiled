package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yw extends AbstractC6375a {
    public static final long DX_PARSER_MIN = 523351935;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object a = tz.a(objArr, 1);
        if (a instanceof Boolean) {
            if (((Boolean) a).booleanValue()) {
                return uz.h(objArr[1]);
            }
            return uz.h(objArr[0]);
        }
        return null;
    }
}