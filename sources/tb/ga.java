package tb;

import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ga {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.ga$a */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC9168a {
        public byte[] a;
        public int b;

        AbstractC9168a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.ga$b */
    /* loaded from: classes5.dex */
    public static class C9169b extends AbstractC9168a {
        private static final int[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int c;
        private int d;
        private final int[] e;

        public C9169b(int i, byte[] bArr) {
            this.a = bArr;
            this.e = (i & 8) == 0 ? f : g;
            this.c = 0;
            this.d = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.c;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.d;
            byte[] bArr2 = this.a;
            int[] iArr = this.e;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i7++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.c = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i6 << 6);
                        bArr2[i7 + 2] = (byte) i13;
                        bArr2[i7 + 1] = (byte) (i13 >> 8);
                        bArr2[i7] = (byte) (i13 >> 16);
                        i7 += 3;
                        i6 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i7 + 1] = (byte) (i6 >> 2);
                        bArr2[i7] = (byte) (i6 >> 10);
                        i7 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        this.c = 6;
                        return false;
                    }
                    i8++;
                    i6 = i12;
                } else {
                    if (i12 < 0) {
                        if (i12 != -1) {
                            this.c = 6;
                            return false;
                        }
                    }
                    i8++;
                    i6 = i12;
                }
                i9 = i11;
            }
            if (!z) {
                this.c = i8;
                this.d = i6;
                this.b = i7;
                return true;
            } else if (i8 != 1) {
                if (i8 == 2) {
                    bArr2[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i14 = i7 + 1;
                    bArr2[i7] = (byte) (i6 >> 10);
                    i7 = i14 + 1;
                    bArr2[i14] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    this.c = 6;
                    return false;
                }
                this.c = i8;
                this.b = i7;
                return true;
            } else {
                this.c = 6;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.ga$c */
    /* loaded from: classes5.dex */
    public static class C9170c extends AbstractC9168a {
        public static final int LINE_GROUPS = 19;
        private static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, km1.OP_MAX_COUNT, 47};
        private static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        private final byte[] c;
        int d;
        private int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        private final byte[] i;

        public C9170c(int i, byte[] bArr) {
            this.a = bArr;
            this.f = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.g = z;
            this.h = (i & 4) != 0;
            this.i = (i & 8) == 0 ? j : k;
            this.c = new byte[2];
            this.d = 0;
            this.e = z ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.ga.C9170c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        C9169b c9169b = new C9169b(i3, new byte[(i2 * 3) / 4]);
        if (c9169b.a(bArr, i, i2, true)) {
            int i4 = c9169b.b;
            byte[] bArr2 = c9169b.a;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] c(byte[] bArr, int i) {
        return d(bArr, 0, bArr.length, i);
    }

    public static byte[] d(byte[] bArr, int i, int i2, int i3) {
        C9170c c9170c = new C9170c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (c9170c.f) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        }
        if (c9170c.g && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (c9170c.h ? 2 : 1);
        }
        c9170c.a = new byte[i4];
        c9170c.a(bArr, i, i2, true);
        return c9170c.a;
    }

    public static String e(byte[] bArr, int i) {
        try {
            return new String(c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
