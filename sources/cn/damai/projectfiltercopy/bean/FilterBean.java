package cn.damai.projectfiltercopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterBean implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean isSelected;
    public String name;
    public String option;
    public String value;

    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1458983939") ? ipChange.ipc$dispatch("-1458983939", new Object[]{this}) : super.clone();
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171465287")) {
            return ((Boolean) ipChange.ipc$dispatch("-1171465287", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FilterBean filterBean = (FilterBean) obj;
        return nm1.a(this.value, filterBean.value) && nm1.a(this.option, filterBean.option);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "309420400") ? ((Integer) ipChange.ipc$dispatch("309420400", new Object[]{this})).intValue() : nm1.b(this.value, this.option);
    }
}
