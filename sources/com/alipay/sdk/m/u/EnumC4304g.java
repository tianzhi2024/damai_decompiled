package com.alipay.sdk.m.u;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.g */
/* loaded from: classes10.dex */
public enum EnumC4304g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, "none");
    
    public int a;
    public String b;

    EnumC4304g(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public static EnumC4304g a(int i) {
        EnumC4304g[] values;
        for (EnumC4304g enumC4304g : values()) {
            if (enumC4304g.a() == i) {
                return enumC4304g;
            }
        }
        return NONE;
    }
}
