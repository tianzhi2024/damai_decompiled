package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LinearPullToRefreshView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing;
    private final Handler handler;
    private int headerHeight;
    private PullToRefreshHeaderView headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged;
    private boolean isPullToRefreshEnabled;
    private float lastAddMontionY;
    private float lastMotionX;
    private float lastMotionY;
    private OnRefreshListener onRefreshListener;
    private OnUpOrDownListener onUpOrDownListener;
    private int state;
    private int touchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnUpOrDownListener {
        void ondown();

        void onup();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class SmoothScrollRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int ANIMATION_DURATION_MS = 190;
        static final int ANIMATION_FPS = 16;
        private final Handler handler;
        private final int scrollFromY;
        private final int scrollToY;
        private boolean continueRunning = true;
        private long startTime = -1;
        private int currentY = -1;
        private final Interpolator interpolator = new AccelerateDecelerateInterpolator();

        public SmoothScrollRunnable(Handler handler, int i, int i2) {
            this.handler = handler;
            this.scrollFromY = i;
            this.scrollToY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1057746747")) {
                ipChange.ipc$dispatch("1057746747", new Object[]{this});
                return;
            }
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int round = this.scrollFromY - Math.round((this.scrollFromY - this.scrollToY) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L)) / 1000.0f));
                this.currentY = round;
                LinearPullToRefreshView.this.setHeaderScroll(round);
            }
            if (!this.continueRunning || this.scrollToY == this.currentY) {
                return;
            }
            this.handler.postDelayed(this, 16L);
        }

        public void stop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-707648478")) {
                ipChange.ipc$dispatch("-707648478", new Object[]{this});
                return;
            }
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public LinearPullToRefreshView(Context context) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109160282")) {
            ipChange.ipc$dispatch("2109160282", new Object[]{this});
            return;
        }
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        this.headerLayout = PullToRefreshHeaderView.getInstance(getContext());
        addView(this.headerLayout, 0, new LinearLayout.LayoutParams(-1, -2));
        measureView(this.headerLayout);
        int measuredHeight = this.headerLayout.getMeasuredHeight();
        this.headerHeight = measuredHeight;
        setPadding(0, -measuredHeight, 0, 0);
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972484395")) {
            ipChange.ipc$dispatch("-1972484395", new Object[]{this, view});
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private boolean pullEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345840175")) {
            return ((Boolean) ipChange.ipc$dispatch("345840175", new Object[]{this})).booleanValue();
        }
        int scrollY = getScrollY();
        int round = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        setHeaderScroll(round);
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        pullToRefreshHeaderView.onStart(false, pullToRefreshHeaderView.getMeasuredHeight(), 0);
        if (round != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(round)) {
                this.state = 1;
                this.headerLayout.onRelease();
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(round)) {
                this.state = 0;
                this.headerLayout.onRelease();
                return true;
            }
        }
        this.headerLayout.onMove(false, false, Math.abs(round));
        return scrollY != round;
    }

    public void clearLoadingDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136611165")) {
            ipChange.ipc$dispatch("136611165", new Object[]{this});
            return;
        }
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.clearLoadingDrawable();
        }
    }

    protected final int getHeaderHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "675965065") ? ((Integer) ipChange.ipc$dispatch("675965065", new Object[]{this})).intValue() : this.headerHeight;
    }

    public final PullToRefreshHeaderView getHeaderLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1657862251") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("1657862251", new Object[]{this}) : this.headerLayout;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "79838723") ? ((Boolean) ipChange.ipc$dispatch("79838723", new Object[]{this})).booleanValue() : this.disableScrollingWhileRefreshing;
    }

    public final boolean isPullToRefreshEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1505700546") ? ((Boolean) ipChange.ipc$dispatch("-1505700546", new Object[]{this})).booleanValue() : this.isPullToRefreshEnabled;
    }

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913482275")) {
            return ((Boolean) ipChange.ipc$dispatch("-1913482275", new Object[]{this})).booleanValue();
        }
        int i = this.state;
        return i == 2 || i == 3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnUpOrDownListener onUpOrDownListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319143259")) {
            return ((Boolean) ipChange.ipc$dispatch("1319143259", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.isPullToRefreshEnabled) {
            if (isRefreshing() && this.disableScrollingWhileRefreshing) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 3 && action != 1) {
                if (action == 0 || !this.isBeingDragged) {
                    if (action == 0) {
                        this.lastAddMontionY = motionEvent.getY();
                        float y = motionEvent.getY();
                        this.initialMotionY = y;
                        this.lastMotionY = y;
                        this.lastMotionX = motionEvent.getX();
                        this.isBeingDragged = false;
                    } else if (action == 2) {
                        if (motionEvent.getY() - this.lastAddMontionY > 20.0f) {
                            OnUpOrDownListener onUpOrDownListener2 = this.onUpOrDownListener;
                            if (onUpOrDownListener2 != null) {
                                onUpOrDownListener2.ondown();
                            }
                        } else if (motionEvent.getY() - this.lastAddMontionY < -20.0f && (onUpOrDownListener = this.onUpOrDownListener) != null) {
                            onUpOrDownListener.onup();
                        }
                        float y2 = motionEvent.getY();
                        float f = y2 - this.lastMotionY;
                        float abs = Math.abs(f);
                        float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                        if (abs > this.touchSlop && abs > abs2) {
                            if (f >= 1.0E-4f) {
                                this.lastMotionY = y2;
                                this.isBeingDragged = true;
                            } else if (f <= 1.0E-4f) {
                                this.lastMotionY = y2;
                                this.isBeingDragged = false;
                            }
                        }
                    }
                    return this.isBeingDragged;
                }
                return true;
            }
            this.isBeingDragged = false;
            return false;
        }
        return false;
    }

    public final void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859811029")) {
            ipChange.ipc$dispatch("-1859811029", new Object[]{this});
        } else if (this.state != 0) {
            resetHeader();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r0 != 3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.view.LinearPullToRefreshView.$ipChange
            java.lang.String r1 = "-1547635863"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            boolean r0 = r6.isPullToRefreshEnabled
            if (r0 != 0) goto L23
            return r5
        L23:
            boolean r0 = r6.isRefreshing()
            if (r0 == 0) goto L2e
            boolean r0 = r6.disableScrollingWhileRefreshing
            if (r0 == 0) goto L2e
            return r4
        L2e:
            int r0 = r7.getAction()
            if (r0 != 0) goto L3b
            int r0 = r7.getEdgeFlags()
            if (r0 == 0) goto L3b
            return r5
        L3b:
            int r0 = r7.getAction()
            if (r0 == 0) goto L7f
            if (r0 == r4) goto L57
            if (r0 == r3) goto L49
            r7 = 3
            if (r0 == r7) goto L57
            goto L7e
        L49:
            boolean r0 = r6.isBeingDragged
            if (r0 == 0) goto L7e
            float r7 = r7.getY()
            r6.lastMotionY = r7
            r6.pullEvent()
            return r4
        L57:
            boolean r7 = r6.isBeingDragged
            if (r7 == 0) goto L7e
            r6.isBeingDragged = r5
            int r7 = r6.state
            if (r7 != r4) goto L7a
            com.alibaba.pictures.bricks.view.LinearPullToRefreshView$OnRefreshListener r7 = r6.onRefreshListener
            if (r7 == 0) goto L7a
            r6.setRefreshingInternal(r4)
            com.alibaba.pictures.bricks.view.PullToRefreshHeaderView r7 = r6.headerLayout
            r0 = 10000(0x2710, float:1.4013E-41)
            r7.onMove(r5, r5, r0)
            com.alibaba.pictures.bricks.view.PullToRefreshHeaderView r7 = r6.headerLayout
            r7.onRefresh()
            com.alibaba.pictures.bricks.view.LinearPullToRefreshView$OnRefreshListener r7 = r6.onRefreshListener
            r7.onRefresh()
            goto L7d
        L7a:
            r6.smoothScrollTo(r5)
        L7d:
            return r4
        L7e:
            return r5
        L7f:
            float r7 = r7.getY()
            r6.initialMotionY = r7
            r6.lastMotionY = r7
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.view.LinearPullToRefreshView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829263708")) {
            ipChange.ipc$dispatch("-829263708", new Object[]{this});
            return;
        }
        this.state = 0;
        this.isBeingDragged = false;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onReset();
        }
        smoothScrollTo(0);
        this.headerLayout.onComplete();
    }

    public void setBackgroundColorBg(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1894917521")) {
            ipChange.ipc$dispatch("1894917521", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.setBackgroundColorBg(i);
        }
        setBackgroundColor(i);
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660352691")) {
            ipChange.ipc$dispatch("1660352691", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.disableScrollingWhileRefreshing = z;
        }
    }

    protected final void setHeaderScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "807257311")) {
            ipChange.ipc$dispatch("807257311", new Object[]{this, Integer.valueOf(i)});
        } else {
            scrollTo(0, i);
        }
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681919306")) {
            ipChange.ipc$dispatch("1681919306", new Object[]{this, onRefreshListener});
        } else {
            this.onRefreshListener = onRefreshListener;
        }
    }

    public final void setOnUpOrDownListener(OnUpOrDownListener onUpOrDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599982764")) {
            ipChange.ipc$dispatch("-1599982764", new Object[]{this, onUpOrDownListener});
        } else {
            this.onUpOrDownListener = onUpOrDownListener;
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071745436")) {
            ipChange.ipc$dispatch("2071745436", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isPullToRefreshEnabled = z;
        }
    }

    public final void setRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-450991529")) {
            ipChange.ipc$dispatch("-450991529", new Object[]{this});
            return;
        }
        setRefreshing(true);
        this.headerLayout.onRefresh();
    }

    protected void setRefreshingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381157306")) {
            ipChange.ipc$dispatch("1381157306", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.state = 2;
        PullToRefreshHeaderView pullToRefreshHeaderView = this.headerLayout;
        if (pullToRefreshHeaderView != null) {
            pullToRefreshHeaderView.onRefresh();
        }
        if (z) {
            smoothScrollTo(-this.headerHeight);
        }
    }

    protected final void smoothScrollTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773766927")) {
            ipChange.ipc$dispatch("773766927", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095789731")) {
            ipChange.ipc$dispatch("-1095789731", new Object[]{this, Boolean.valueOf(z)});
        } else if (isRefreshing()) {
        } else {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public LinearPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBeingDragged = false;
        this.state = 0;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.handler = new Handler();
        init();
    }
}
