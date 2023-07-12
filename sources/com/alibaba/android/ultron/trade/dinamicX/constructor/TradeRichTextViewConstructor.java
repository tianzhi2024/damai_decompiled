package com.alibaba.android.ultron.trade.dinamicX.constructor;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.q4;
import tb.rk;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class TradeRichTextViewConstructor extends DTextViewConstructor {
    private static final String D_RICH_TEXT = "dRichText";
    private static final String EVENT = "event";
    private static final String E_OPEN_URL = "openUrl";
    private static final String STYLE = "style";
    private static final String S_BOLD = "bold";
    private static final String S_COLOR = "color";
    private static final String S_ITALIC = "italic";
    private static final String S_SIZE = "size";
    private static final String S_STRIKE_THROUGH = "strikeThrough";
    private static final String TEXT = "text";
    private static final String TV_TEXT_COLOR = "dTextColor";
    public static final String VIEW_TAG = "TradeRichTextView";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.trade.dinamicX.constructor.TradeRichTextViewConstructor$a */
    /* loaded from: classes15.dex */
    public static class C3247a {
        public int a;
        public int b;
        public int c = 33;
        public List<Object> d = new ArrayList();
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.trade.dinamicX.constructor.TradeRichTextViewConstructor$b */
    /* loaded from: classes15.dex */
    public static class C3248b extends ClickableSpan {
        private String a;
        private int b;

        public C3248b(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            q4.c().from(view.getContext()).toUri(this.a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.b);
            textPaint.setUnderlineText(false);
        }
    }

    private Object getBoldSpan(JSONObject jSONObject) {
        if (jSONObject != null && Boolean.parseBoolean(jSONObject.getString("bold"))) {
            return new StyleSpan(1);
        }
        return null;
    }

    private Object getColorSpan(JSONObject jSONObject) {
        int e;
        if (jSONObject == null || (e = rk.e(jSONObject.getString("color"), -1)) == -1) {
            return null;
        }
        return new ForegroundColorSpan(e);
    }

    private JSONObject getEventObj(JSONObject jSONObject) {
        return jSONObject.getJSONObject("event");
    }

    private C3247a getEventSpan(Map<String, Object> map, JSONObject jSONObject, String str, String str2, C3247a c3247a) {
        Object obj;
        if (jSONObject == null) {
            return null;
        }
        JSONObject eventObj = getEventObj(jSONObject);
        C3247a c3247a2 = new C3247a();
        int indexOf = str.indexOf(str2);
        c3247a2.a = indexOf;
        c3247a2.b = indexOf + str2.length();
        ForegroundColorSpan richTextColor = getRichTextColor(c3247a);
        int i = -16776961;
        if (map != null && (obj = map.get("dTextColor")) != null) {
            i = rk.e(obj.toString(), -16776961);
        }
        if (richTextColor != null) {
            i = richTextColor.getForegroundColor();
        }
        Object openUrlSpan = getOpenUrlSpan(eventObj, i);
        if (openUrlSpan != null) {
            c3247a2.d.add(openUrlSpan);
        }
        if (c3247a2.d.size() > 0) {
            return c3247a2;
        }
        return null;
    }

    private Object getItalicSpan(JSONObject jSONObject) {
        if (jSONObject != null && Boolean.parseBoolean(jSONObject.getString("italic"))) {
            return new StyleSpan(2);
        }
        return null;
    }

    private Object getOpenUrlSpan(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString(E_OPEN_URL);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C3248b(string, i);
    }

    private SpannableString getRichText(Map<String, Object> map, JSONArray jSONArray) {
        String str = "";
        if (jSONArray != null) {
            ArrayList<C3247a> arrayList = new ArrayList();
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("text");
                    if (!TextUtils.isEmpty(string)) {
                        str = str + string;
                        C3247a styleSpan = getStyleSpan(map, jSONObject, str, string);
                        if (styleSpan != null) {
                            arrayList.add(styleSpan);
                        }
                        C3247a eventSpan = getEventSpan(map, jSONObject, str, string, styleSpan);
                        if (eventSpan != null) {
                            arrayList.add(eventSpan);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                SpannableString spannableString = new SpannableString(str);
                for (C3247a c3247a : arrayList) {
                    for (Object obj : c3247a.d) {
                        spannableString.setSpan(obj, c3247a.a, c3247a.b, c3247a.c);
                    }
                }
                return spannableString;
            }
        }
        return new SpannableString(str);
    }

    private ForegroundColorSpan getRichTextColor(C3247a c3247a) {
        List<Object> list;
        if (c3247a != null && (list = c3247a.d) != null && list.size() > 0) {
            for (Object obj : c3247a.d) {
                if (obj instanceof ForegroundColorSpan) {
                    return (ForegroundColorSpan) obj;
                }
            }
        }
        return null;
    }

    private Object getSizeSpan(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new RelativeSizeSpan(Float.parseFloat(jSONObject.getString("size")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Object getStrikeThroughSpan(JSONObject jSONObject) {
        if (jSONObject != null && Boolean.parseBoolean(jSONObject.getString(S_STRIKE_THROUGH))) {
            return new StrikethroughSpan();
        }
        return null;
    }

    private JSONObject getStyleObj(JSONObject jSONObject) {
        return jSONObject.getJSONObject("style");
    }

    private C3247a getStyleSpan(Map<String, Object> map, JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject styleObj = getStyleObj(jSONObject);
        C3247a c3247a = new C3247a();
        int indexOf = str.indexOf(str2);
        c3247a.a = indexOf;
        c3247a.b = indexOf + str2.length();
        Object sizeSpan = getSizeSpan(styleObj);
        if (sizeSpan != null) {
            c3247a.d.add(sizeSpan);
        }
        Object colorSpan = getColorSpan(styleObj);
        if (colorSpan != null) {
            c3247a.d.add(colorSpan);
        }
        Object boldSpan = getBoldSpan(styleObj);
        if (boldSpan != null) {
            c3247a.d.add(boldSpan);
        }
        Object italicSpan = getItalicSpan(styleObj);
        if (italicSpan != null) {
            c3247a.d.add(italicSpan);
        }
        Object strikeThroughSpan = getStrikeThroughSpan(styleObj);
        if (strikeThroughSpan != null) {
            c3247a.d.add(strikeThroughSpan);
        }
        if (c3247a.d.size() > 0) {
            return c3247a;
        }
        return null;
    }

    private void setMovement(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setTextInternal(TextView textView, CharSequence charSequence) {
        if (textView == null || charSequence == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        TextView textView = new TextView(context, attributeSet);
        setMovement(textView);
        return textView;
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (arrayList.contains(D_RICH_TEXT)) {
            Object obj = map.get(D_RICH_TEXT);
            if (obj == null) {
                setTextInternal(textView, "");
                return;
            }
            try {
                setTextInternal(textView, getRichText(map, JSON.parseArray(obj.toString())));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor
    public void setText(TextView textView, String str) {
    }
}
