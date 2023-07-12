package com.youku.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.IAlixPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.youku.a.c */
/* loaded from: classes.dex */
public class C7794c implements InterfaceC7797f {
    private static int a = 12;
    private static int b = 6;
    private C7796e f;
    private C7796e j;
    private Context k;
    private ConcurrentHashMap<String, IAlixPlayer> c = null;
    private ConcurrentHashMap<String, IAlixPlayer> d = null;
    private ConcurrentHashMap<String, IAlixPlayer> e = null;
    private ConcurrentHashMap<String, IAlixPlayer> g = null;
    private ConcurrentHashMap<String, IAlixPlayer> h = null;
    private ConcurrentHashMap<String, IAlixPlayer> i = null;

    public C7794c(Context context) {
        this.k = context;
        a = C7795d.a();
        b = C7795d.b();
    }

    private void a(Map<String, IAlixPlayer> map) {
        if (map == null) {
            return;
        }
        C7793b.a("-----pool begin-----");
        for (String str : map.keySet()) {
            C7793b.a(str + WVUtils.URL_SEPARATOR + map.get(str).hashCode() + "--" + map.get(str).getCurrentState());
        }
        C7793b.a("-----pool end-----");
        C7793b.a("    ");
    }

    private void b(IAlixPlayer iAlixPlayer) {
        iAlixPlayer.setHolder(null);
        iAlixPlayer.setDisplay(null);
        iAlixPlayer.reset();
        C7793b.a("resetAlixPlayer:" + iAlixPlayer.hashCode());
    }

    public synchronized IAlixPlayer a(String str) {
        ConcurrentHashMap<String, IAlixPlayer> concurrentHashMap = this.g;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.containsKey(str) ? this.g.get(str) : null;
    }

    public synchronized void a() {
        if (this.c == null || this.d == null || this.e == null || this.f == null) {
            this.c = new ConcurrentHashMap<>();
            this.d = new ConcurrentHashMap<>();
            if (this.k != null) {
                for (int i = 0; i <= 2; i++) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    AlixPlayer alixPlayer = new AlixPlayer(this.k);
                    alixPlayer.setPlayerId(valueOf);
                    this.d.put(valueOf, alixPlayer);
                }
            }
            this.e = new ConcurrentHashMap<>();
            this.f = new C7796e(this, b);
            this.g = new ConcurrentHashMap<>();
            this.h = new ConcurrentHashMap<>();
            if (this.k != null) {
                for (int i2 = 0; i2 <= 2; i2++) {
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    AlixPlayer alixPlayer2 = new AlixPlayer(this.k);
                    alixPlayer2.setPlayerId(valueOf2);
                    this.h.put(valueOf2, alixPlayer2);
                }
            }
            this.i = new ConcurrentHashMap<>();
            this.j = new C7796e(this, b);
        }
    }

    public synchronized void a(IAlixPlayer iAlixPlayer) {
        String str;
        if (this.g != null && iAlixPlayer != null && !TextUtils.isEmpty(iAlixPlayer.getPlayerId())) {
            C7793b.a("returnAlixPlayer:" + iAlixPlayer.hashCode());
            String playerId = iAlixPlayer.getPlayerId();
            if (!playerId.endsWith("_longuse")) {
                if (this.g.containsKey(playerId)) {
                    b(iAlixPlayer);
                    this.g.remove(playerId);
                    this.j.a(playerId);
                    this.h.put(playerId, iAlixPlayer);
                } else if (this.h.containsKey(playerId)) {
                    b(iAlixPlayer);
                } else {
                    iAlixPlayer.release();
                    str = "releaseAlixPlayer:" + iAlixPlayer.hashCode();
                }
                C7793b.a("print inuse pool:");
                a(this.g);
                C7793b.a("print unuse pool:");
                a(this.h);
            }
            if (this.i.containsKey(playerId)) {
                this.i.remove(playerId);
            }
            iAlixPlayer.release();
            str = "releaseAlixPlayer:" + iAlixPlayer.hashCode();
            C7793b.a(str);
            C7793b.a("print inuse pool:");
            a(this.g);
            C7793b.a("print unuse pool:");
            a(this.h);
        }
    }

    public String b() {
        if (this.c == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.c.keySet()) {
            sb.append(str);
            sb.append(";");
        }
        return sb.toString();
    }

    public synchronized void b(String str) {
        ConcurrentHashMap<String, IAlixPlayer> concurrentHashMap = this.g;
        if (concurrentHashMap == null) {
            return;
        }
        if (concurrentHashMap.containsKey(str)) {
            IAlixPlayer iAlixPlayer = this.g.get(str);
            iAlixPlayer.stop();
            b(iAlixPlayer);
            this.g.remove(str);
            this.j.a(str);
            this.h.put(str, iAlixPlayer);
            C7793b.a("print inuse pool:");
            a(this.g);
        }
    }

    public synchronized IAlixPlayer c(String str) {
        ConcurrentHashMap<String, IAlixPlayer> concurrentHashMap = this.g;
        if (concurrentHashMap == null) {
            return null;
        }
        if (concurrentHashMap.containsKey(str)) {
            return this.g.get(str);
        }
        return null;
    }
}
