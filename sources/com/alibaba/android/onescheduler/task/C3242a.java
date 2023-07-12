package com.alibaba.android.onescheduler.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.OneDependentTask;
import com.alibaba.android.onescheduler.OneTaskBuilder;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.onescheduler.task.a */
/* loaded from: classes5.dex */
public class C3242a implements OneTaskBuilder {
    Runnable d;
    Callable e;
    CallableCallback f;
    boolean h;
    Executor i;
    TaskTracker j;
    long k;
    Priority a = Priority.NORMAL;
    @Nullable
    String b = null;
    @Nullable
    String c = null;
    TaskType g = TaskType.NORMAL;

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: a */
    public C3242a setAnchorTask(boolean z) {
        this.h = z;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: b */
    public C3242a setCallable(Callable<?> callable, CallableCallback<?> callableCallback) {
        this.e = callable;
        this.f = callableCallback;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneCommonTask buildCommonTask() {
        return new OneCommonTaskImpl(this);
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneDependentTask buildDependentTask() {
        return new OneDependentTaskImpl(this);
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: c */
    public C3242a setExecutor(Executor executor) {
        this.i = executor;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: d */
    public C3242a setPriority(Priority priority) {
        this.a = priority;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: e */
    public C3242a setRunnable(Runnable runnable) {
        this.d = runnable;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: f */
    public C3242a setTaskGroup(String str) {
        this.b = str;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: g */
    public C3242a setTaskName(String str) {
        this.c = str;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: h */
    public C3242a setTaskTracker(TaskTracker taskTracker) {
        this.j = taskTracker;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    /* renamed from: i */
    public C3242a setTaskType(TaskType taskType) {
        this.g = taskType;
        return this;
    }

    @Override // com.alibaba.android.onescheduler.OneTaskBuilder
    @NonNull
    public OneTaskBuilder setDelayTime(long j) {
        this.k = j;
        return this;
    }
}
