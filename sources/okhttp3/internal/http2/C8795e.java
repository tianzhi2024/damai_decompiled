package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.C8816l;
import okhttp3.internal.C8753a;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.C8857o;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.e */
/* loaded from: classes2.dex */
public final class C8795e {
    long a = 0;
    long b;
    final int c;
    final Http2Connection d;
    private final Deque<C8816l> e;
    private boolean f;
    private final C8797b g;
    final C8796a h;
    final C8798c i;
    final C8798c j;
    @Nullable
    ErrorCode k;
    @Nullable
    IOException l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$a */
    /* loaded from: classes2.dex */
    public final class C8796a implements Sink {
        private final Buffer a = new Buffer();
        private C8816l b;
        boolean c;
        boolean d;

        C8796a() {
        }

        private void a(boolean z) throws IOException {
            C8795e c8795e;
            long min;
            C8795e c8795e2;
            boolean z2;
            synchronized (C8795e.this) {
                C8795e.this.j.enter();
                while (true) {
                    c8795e = C8795e.this;
                    if (c8795e.b > 0 || this.d || this.c || c8795e.k != null) {
                        break;
                    }
                    c8795e.r();
                }
                c8795e.j.exitAndThrowIfTimedOut();
                C8795e.this.c();
                min = Math.min(C8795e.this.b, this.a.size());
                c8795e2 = C8795e.this;
                c8795e2.b -= min;
            }
            c8795e2.j.enter();
            if (z) {
                try {
                    if (min == this.a.size()) {
                        z2 = true;
                        C8795e c8795e3 = C8795e.this;
                        c8795e3.d.G(c8795e3.c, z2, this.a, min);
                        C8795e.this.j.exitAndThrowIfTimedOut();
                    }
                } catch (Throwable th) {
                    C8795e.this.j.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            z2 = false;
            C8795e c8795e32 = C8795e.this;
            c8795e32.d.G(c8795e32.c, z2, this.a, min);
            C8795e.this.j.exitAndThrowIfTimedOut();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (C8795e.this) {
                if (this.c) {
                    return;
                }
                if (!C8795e.this.h.d) {
                    boolean z = this.a.size() > 0;
                    if (this.b != null) {
                        while (this.a.size() > 0) {
                            a(false);
                        }
                        C8795e c8795e = C8795e.this;
                        c8795e.d.H(c8795e.c, true, C8753a.J(this.b));
                    } else if (z) {
                        while (this.a.size() > 0) {
                            a(true);
                        }
                    } else {
                        C8795e c8795e2 = C8795e.this;
                        c8795e2.d.G(c8795e2.c, true, null, 0L);
                    }
                }
                synchronized (C8795e.this) {
                    this.c = true;
                }
                C8795e.this.d.flush();
                C8795e.this.b();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (C8795e.this) {
                C8795e.this.c();
            }
            while (this.a.size() > 0) {
                a(false);
                C8795e.this.d.flush();
            }
        }

        @Override // okio.Sink
        public C8857o timeout() {
            return C8795e.this.j;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.a.write(buffer, j);
            while (this.a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$b */
    /* loaded from: classes2.dex */
    public final class C8797b implements Source {
        private final Buffer a = new Buffer();
        private final Buffer b = new Buffer();
        private final long c;
        private C8816l d;
        boolean e;
        boolean f;

        C8797b(long j) {
            this.c = j;
        }

        private void f(long j) {
            C8795e.this.d.F(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (C8795e.this) {
                this.e = true;
                size = this.b.size();
                this.b.clear();
                C8795e.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            C8795e.this.b();
        }

        void e(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (C8795e.this) {
                    z = this.f;
                    z2 = true;
                    z3 = this.b.size() + j > this.c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    C8795e.this.f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.a, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (C8795e.this) {
                            if (this.e) {
                                j2 = this.a.size();
                                this.a.clear();
                            } else {
                                if (this.b.size() != 0) {
                                    z2 = false;
                                }
                                this.b.writeAll(this.a);
                                if (z2) {
                                    C8795e.this.notifyAll();
                                }
                                j2 = 0;
                            }
                        }
                        if (j2 > 0) {
                            f(j2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
            r11 = -1;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r11, long r12) throws java.io.IOException {
            /*
                r10 = this;
                r0 = 0
                int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r2 < 0) goto La8
            L6:
                r2 = 0
                okhttp3.internal.http2.e r3 = okhttp3.internal.http2.C8795e.this
                monitor-enter(r3)
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r4 = r4.i     // Catch: java.lang.Throwable -> La5
                r4.enter()     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r5 = r4.k     // Catch: java.lang.Throwable -> L9c
                if (r5 == 0) goto L25
                java.io.IOException r2 = r4.l     // Catch: java.lang.Throwable -> L9c
                if (r2 == 0) goto L1c
                goto L25
            L1c:
                okhttp3.internal.http2.StreamResetException r2 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r4 = r4.k     // Catch: java.lang.Throwable -> L9c
                r2.<init>(r4)     // Catch: java.lang.Throwable -> L9c
            L25:
                boolean r4 = r10.e     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L94
                okio.Buffer r4 = r10.b     // Catch: java.lang.Throwable -> L9c
                long r4 = r4.size()     // Catch: java.lang.Throwable -> L9c
                r6 = -1
                int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r8 <= 0) goto L6b
                okio.Buffer r4 = r10.b     // Catch: java.lang.Throwable -> L9c
                long r8 = r4.size()     // Catch: java.lang.Throwable -> L9c
                long r12 = java.lang.Math.min(r12, r8)     // Catch: java.lang.Throwable -> L9c
                long r11 = r4.read(r11, r12)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                long r4 = r13.a     // Catch: java.lang.Throwable -> L9c
                long r4 = r4 + r11
                r13.a = r4     // Catch: java.lang.Throwable -> L9c
                if (r2 != 0) goto L80
                okhttp3.internal.http2.Http2Connection r13 = r13.d     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.h r13 = r13.s     // Catch: java.lang.Throwable -> L9c
                int r13 = r13.d()     // Catch: java.lang.Throwable -> L9c
                int r13 = r13 / 2
                long r8 = (long) r13     // Catch: java.lang.Throwable -> L9c
                int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r13 < 0) goto L80
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Connection r4 = r13.d     // Catch: java.lang.Throwable -> L9c
                int r5 = r13.c     // Catch: java.lang.Throwable -> L9c
                long r8 = r13.a     // Catch: java.lang.Throwable -> L9c
                r4.L(r5, r8)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                r13.a = r0     // Catch: java.lang.Throwable -> L9c
                goto L80
            L6b:
                boolean r4 = r10.f     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L7f
                if (r2 != 0) goto L7f
                okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> L9c
                r2.r()     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r2 = r2.i     // Catch: java.lang.Throwable -> La5
                r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                goto L6
            L7f:
                r11 = r6
            L80:
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r13 = r13.i     // Catch: java.lang.Throwable -> La5
                r13.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r13 == 0) goto L90
                r10.f(r11)
                return r11
            L90:
                if (r2 != 0) goto L93
                return r6
            L93:
                throw r2
            L94:
                java.io.IOException r11 = new java.io.IOException     // Catch: java.lang.Throwable -> L9c
                java.lang.String r12 = "stream closed"
                r11.<init>(r12)     // Catch: java.lang.Throwable -> L9c
                throw r11     // Catch: java.lang.Throwable -> L9c
            L9c:
                r11 = move-exception
                okhttp3.internal.http2.e r12 = okhttp3.internal.http2.C8795e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r12 = r12.i     // Catch: java.lang.Throwable -> La5
                r12.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                throw r11     // Catch: java.lang.Throwable -> La5
            La5:
                r11 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                throw r11
            La8:
                java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8795e.C8797b.read(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public C8857o timeout() {
            return C8795e.this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$c */
    /* loaded from: classes2.dex */
    public class C8798c extends AsyncTimeout {
        C8798c() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            C8795e.this.f(ErrorCode.CANCEL);
            C8795e.this.d.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8795e(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable C8816l c8816l) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.i = new C8798c();
        this.j = new C8798c();
        Objects.requireNonNull(http2Connection, "connection == null");
        this.c = i;
        this.d = http2Connection;
        this.b = http2Connection.t.d();
        C8797b c8797b = new C8797b(http2Connection.s.d());
        this.g = c8797b;
        C8796a c8796a = new C8796a();
        this.h = c8796a;
        c8797b.f = z2;
        c8796a.d = z;
        if (c8816l != null) {
            arrayDeque.add(c8816l);
        }
        if (j() && c8816l != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!j() && c8816l == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean e(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.f && this.h.d) {
                return false;
            }
            this.k = errorCode;
            this.l = iOException;
            notifyAll();
            this.d.A(this.c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void b() throws IOException {
        boolean z;
        boolean k;
        synchronized (this) {
            C8797b c8797b = this.g;
            if (!c8797b.f && c8797b.e) {
                C8796a c8796a = this.h;
                if (c8796a.d || c8796a.c) {
                    z = true;
                    k = k();
                }
            }
            z = false;
            k = k();
        }
        if (z) {
            d(ErrorCode.CANCEL, null);
        } else if (k) {
        } else {
            this.d.A(this.c);
        }
    }

    void c() throws IOException {
        C8796a c8796a = this.h;
        if (!c8796a.c) {
            if (!c8796a.d) {
                if (this.k != null) {
                    IOException iOException = this.l;
                    if (iOException == null) {
                        throw new StreamResetException(this.k);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void d(ErrorCode errorCode, @Nullable IOException iOException) throws IOException {
        if (e(errorCode, iOException)) {
            this.d.J(this.c, errorCode);
        }
    }

    public void f(ErrorCode errorCode) {
        if (e(errorCode, null)) {
            this.d.K(this.c, errorCode);
        }
    }

    public int g() {
        return this.c;
    }

    public Sink h() {
        synchronized (this) {
            if (!this.f && !j()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    public Source i() {
        return this.g;
    }

    public boolean j() {
        return this.d.a == ((this.c & 1) == 1);
    }

    public synchronized boolean k() {
        if (this.k != null) {
            return false;
        }
        C8797b c8797b = this.g;
        if (c8797b.f || c8797b.e) {
            C8796a c8796a = this.h;
            if (c8796a.d || c8796a.c) {
                if (this.f) {
                    return false;
                }
            }
        }
        return true;
    }

    public C8857o l() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(BufferedSource bufferedSource, int i) throws IOException {
        this.g.e(bufferedSource, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0009, B:10:0x0018, B:11:0x001c, B:12:0x0023, B:8:0x000f), top: B:19:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(okhttp3.C8816l r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f     // Catch: java.lang.Throwable -> L2e
            r1 = 1
            if (r0 == 0) goto Lf
            if (r4 != 0) goto L9
            goto Lf
        L9:
            okhttp3.internal.http2.e$b r0 = r2.g     // Catch: java.lang.Throwable -> L2e
            okhttp3.internal.http2.C8795e.C8797b.d(r0, r3)     // Catch: java.lang.Throwable -> L2e
            goto L16
        Lf:
            r2.f = r1     // Catch: java.lang.Throwable -> L2e
            java.util.Deque<okhttp3.l> r0 = r2.e     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
        L16:
            if (r4 == 0) goto L1c
            okhttp3.internal.http2.e$b r3 = r2.g     // Catch: java.lang.Throwable -> L2e
            r3.f = r1     // Catch: java.lang.Throwable -> L2e
        L1c:
            boolean r3 = r2.k()     // Catch: java.lang.Throwable -> L2e
            r2.notifyAll()     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L2d
            okhttp3.internal.http2.Http2Connection r3 = r2.d
            int r4 = r2.c
            r3.A(r4)
        L2d:
            return
        L2e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C8795e.n(okhttp3.l, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void o(ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    public synchronized C8816l p() throws IOException {
        this.i.enter();
        while (this.e.isEmpty() && this.k == null) {
            r();
        }
        this.i.exitAndThrowIfTimedOut();
        if (!this.e.isEmpty()) {
        } else {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        return this.e.removeFirst();
    }

    public synchronized C8816l q() throws IOException {
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        C8797b c8797b = this.g;
        if (!c8797b.f || !c8797b.a.exhausted() || !this.g.b.exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.g.d != null ? this.g.d : C8753a.EMPTY_HEADERS;
    }

    void r() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public C8857o s() {
        return this.j;
    }
}
