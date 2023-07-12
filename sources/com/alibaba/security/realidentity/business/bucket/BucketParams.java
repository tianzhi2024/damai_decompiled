package com.alibaba.security.realidentity.business.bucket;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BucketParams implements Serializable {
    public boolean isSuccessful = false;
    protected ErrorCode mCurrentErrorCode;
    public String mVerifyToken;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ErrorCode implements Serializable {
        public RPResult audit;
        public String errorCode;
        public String errorMsg;
        public int globalErrorCode;

        public ErrorCode() {
        }

        public static ErrorCode createAuditNotCode() {
            ErrorCode errorCode = new ErrorCode();
            errorCode.audit = RPResult.AUDIT_NOT;
            return errorCode;
        }

        public static ErrorCode createAuditPassCode() {
            ErrorCode errorCode = new ErrorCode();
            errorCode.audit = RPResult.AUDIT_PASS;
            return errorCode;
        }

        public ErrorCode(RPResult rPResult, String str, String str2, int i) {
            this.audit = rPResult;
            this.errorCode = str;
            this.errorMsg = str2;
            this.globalErrorCode = i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.bucket.BucketParams$a */
    /* loaded from: classes8.dex */
    public interface InterfaceC3872a {
        void a();
    }

    public BucketParams() {
        ErrorCode errorCode = new ErrorCode();
        this.mCurrentErrorCode = errorCode;
        errorCode.globalErrorCode = -10000;
        errorCode.errorCode = String.valueOf(-10000);
    }

    public boolean dispatch(C3873c c3873c) {
        this.mVerifyToken = c3873c.b();
        onDelivering(c3873c);
        return true;
    }

    public boolean finishTask(Context context, boolean z, InterfaceC3872a interfaceC3872a, Object... objArr) {
        return true;
    }

    public Bundle getBundle() {
        return new Bundle();
    }

    public ErrorCode getErrorCode() {
        return this.mCurrentErrorCode;
    }

    public BusinessHttpWrapper getRpcRequest() {
        return null;
    }

    public String getVerifyToken() {
        return this.mVerifyToken;
    }

    public abstract boolean onDelivering(C3873c c3873c);

    public abstract ErrorCode parseErrorCode();

    public void setCurrentErrorCode(ErrorCode errorCode) {
        this.mCurrentErrorCode = errorCode;
    }

    public void setVerifyToken(String str) {
        this.mVerifyToken = str;
    }
}
