package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.playerservice.axp.DrmConfig;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.vpm.Callable;
import com.youku.vpm.constants.TableField;
import com.youku.youkuplayer.data.YKPlayerConfig;

/* compiled from: Taobao */
/* renamed from: tb.ws */
/* loaded from: classes6.dex */
public class C9878ws extends YKPlayerConfig {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.ws$a */
    /* loaded from: classes6.dex */
    public class C9879a implements Callable {
        private static transient /* synthetic */ IpChange $ipChange;

        C9879a(C9878ws c9878ws) {
        }

        @Override // com.youku.vpm.Callable
        /* renamed from: a */
        public String call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1526364606")) {
                return (String) ipChange.ipc$dispatch("1526364606", new Object[]{this, str});
            }
            str.hashCode();
            return (str.equals(TableField.IS_VIP) || str.equals("isLogin")) ? "false" : "";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ws$b */
    /* loaded from: classes6.dex */
    public class C9880b implements RemoteLogger.IRemoteAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        C9880b(C9878ws c9878ws) {
        }

        @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
        public void log(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021878461")) {
                ipChange.ipc$dispatch("-2021878461", new Object[]{this, str, str2});
            } else {
                db1.b(str, str2);
            }
        }
    }

    public C9878ws() {
        super(mu0.a().getApplicationContext());
    }

    public YKPlayerConfig a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1595524921")) {
            return (YKPlayerConfig) ipChange.ipc$dispatch("-1595524921", new Object[]{this});
        }
        YKPlayerConfig yKPlayerConfig = new YKPlayerConfig(mu0.a().getApplicationContext());
        yKPlayerConfig.setAppKey(AppConfig.c());
        yKPlayerConfig.setCCode("01010121");
        yKPlayerConfig.setDisableAd(true);
        yKPlayerConfig.putString("hardwareDecode", "1");
        yKPlayerConfig.setDrmConfig(new DrmConfig("DM-Android", ""));
        yKPlayerConfig.setDisableAd(true);
        yKPlayerConfig.setDynamicProperties(new C9879a(this));
        yKPlayerConfig.setNetworkType(PlayDefinition.NetworkType.HTTP);
        RemoteLogger.setRemoteAdapter(new C9880b(this));
        return yKPlayerConfig;
    }
}
