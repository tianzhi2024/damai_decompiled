package com.youku.alixplayer.opensdk.statistics.param;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class CustomParams implements IParams<String, String> {
    private Map<String, String> mStringMap;

    public CustomParams(String str) {
        this(str, ";", "=");
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public Map<String, String> getData() {
        return this.mStringMap;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public String getString() {
        return this.mStringMap.toString();
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public String getValue(String str) {
        return this.mStringMap.get(str);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.param.IParams
    public void putAll(IParams iParams) {
        this.mStringMap.putAll(iParams.getData());
    }

    public CustomParams(String str, String str2, String str3) {
        this.mStringMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            for (String str4 : str.split(str2)) {
                String[] split = str4.split(str3, 2);
                if (split.length == 2) {
                    this.mStringMap.put(split[0], split[1]);
                }
            }
            return;
        }
        throw new IllegalArgumentException("params is null");
    }
}
