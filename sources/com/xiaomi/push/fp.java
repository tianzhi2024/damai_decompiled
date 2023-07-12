package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fp {
    public static final byte[] a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    private byte f381a;

    /* renamed from: a  reason: collision with other field name */
    private int f382a;

    /* renamed from: a  reason: collision with other field name */
    private short f383a;
    private byte[] b;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fp$a */
    /* loaded from: classes11.dex */
    public static class C7655a {
        public static final C7657c a = new C7657c();

        /* renamed from: a  reason: collision with other field name */
        public static final C7658d f384a = new C7658d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f384a);
        }

        public static byte[] a(byte[] bArr, InterfaceC7656b interfaceC7656b) {
            if (fp.m899a(bArr)) {
                fp a2 = fp.a(bArr);
                return (a2.f381a == 0 || a2.f381a != interfaceC7656b.a()) ? a2.b : interfaceC7656b.a(a2.b, a2.f382a);
            }
            return bArr;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fp$b */
    /* loaded from: classes11.dex */
    public interface InterfaceC7656b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fp$c */
    /* loaded from: classes11.dex */
    public static final class C7657c {
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fp$d */
    /* loaded from: classes11.dex */
    public static final class C7658d implements InterfaceC7656b {
        @Override // com.xiaomi.push.fp.InterfaceC7656b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.fp.InterfaceC7656b
        public byte[] a(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    protected fp(byte b, int i, byte[] bArr) {
        this((short) 1, b, i, bArr);
    }

    protected fp(short s, byte b, int i, byte[] bArr) {
        this.f383a = (short) 1;
        this.f383a = s;
        this.f381a = b;
        this.f382a = i;
        this.b = bArr;
    }

    public static fp a(byte b, int i, byte[] bArr) {
        return new fp(b, i, bArr);
    }

    public static fp a(short s, byte b, int i, byte[] bArr) {
        return new fp(s, b, i, bArr);
    }

    public static fp a(byte[] bArr) {
        if (m899a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m899a(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
