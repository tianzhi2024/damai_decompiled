package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.p */
/* loaded from: classes5.dex */
public class C3228p {
    double a;
    double b;
    double c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3228p(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3228p a(C3222l c3222l) {
        double d = this.a;
        double d2 = this.b;
        double d3 = this.c;
        double d4 = c3222l.a;
        double d5 = c3222l.b;
        double d6 = c3222l.c;
        double d7 = c3222l.d;
        double d8 = ((d7 * d) + (d5 * d3)) - (d6 * d2);
        double d9 = ((d7 * d2) + (d6 * d)) - (d4 * d3);
        double d10 = ((d7 * d3) + (d4 * d2)) - (d5 * d);
        double d11 = -d4;
        double d12 = ((d * d11) - (d2 * d5)) - (d3 * d6);
        double d13 = -d6;
        double d14 = -d5;
        this.a = (((d8 * d7) + (d12 * d11)) + (d9 * d13)) - (d10 * d14);
        this.b = (((d9 * d7) + (d12 * d14)) + (d10 * d11)) - (d8 * d13);
        this.c = (((d10 * d7) + (d12 * d13)) + (d8 * d14)) - (d9 * d11);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }
}