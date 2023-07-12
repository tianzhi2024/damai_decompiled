package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.e80;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RegionView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATE_TIME = 300;
    private static final int DEFAULT_LEFT_RIGHT_MARGION = 15;
    private static final String TAG = "QILIN_REGION";
    private boolean firstScale;
    private Handler handler;
    private boolean isScaling;
    private int mClickPosition;
    private Bitmap mContentBitmap;
    private boolean mFirstDraw;
    GestureDetector mGestureDetector;
    private Paint mInvalidRegionBorderPaint;
    private Paint mInvalidRegionPaint;
    private int mLeftRightPadding;
    private OnRegionClickListener mListener;
    private float mMaxScale;
    private float mMinScale;
    private Paint mPaint;
    private Paint mRegionBorderPaint;
    private Path mRegionBorderPath;
    private C1731c mRegionConfig;
    private int mRegionImageHeight;
    private int mRegionImageWidth;
    private Bitmap mRegionLayerBitmap;
    private Canvas mRegionLayerCanvas;
    private Paint mRegionPaint;
    private Rect mRegionRect;
    private List<Region> mRegions;
    private boolean mReset;
    private int mScrollOffsetHeigh;
    private int mScrollOffsetWidth;
    private long mSelectedPriceId;
    private Rect mSrcBitmapRect;
    private Point mTempPoint;
    private int mViewHeight;
    private int mViewWidth;
    private float maxOffsetScale;
    private float minOffsetScale;
    private float offsetScale;
    ScaleGestureDetector scaleGestureDetector;
    private float scaleX;
    private float scaleY;
    private Runnable updateSelectedRegionRunnable;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnRegionClickListener {
        void onRegion(Region region);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$a */
    /* loaded from: classes16.dex */
    public class ScaleGestureDetector$OnScaleGestureListenerC1729a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ScaleGestureDetector$OnScaleGestureListenerC1729a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onScale(android.view.ScaleGestureDetector r8) {
            /*
                r7 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.seat.view.RegionView.ScaleGestureDetector$OnScaleGestureListenerC1729a.$ipChange
                java.lang.String r1 = "-1947645834"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L1e
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r4] = r7
                r2[r3] = r8
                java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                return r8
            L1e:
                float r0 = r8.getScaleFactor()
                cn.damai.seat.view.RegionView r1 = cn.damai.seat.view.RegionView.this
                float r1 = cn.damai.seat.view.RegionView.access$200(r1)
                float r2 = r0 * r1
                r5 = 1065353216(0x3f800000, float:1.0)
                int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r6 >= 0) goto L42
                cn.damai.seat.view.RegionView r6 = cn.damai.seat.view.RegionView.this
                float r6 = cn.damai.seat.view.RegionView.access$300(r6)
                int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r6 >= 0) goto L57
                cn.damai.seat.view.RegionView r0 = cn.damai.seat.view.RegionView.this
                float r0 = cn.damai.seat.view.RegionView.access$300(r0)
            L40:
                float r0 = r0 / r1
                goto L57
            L42:
                int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r6 <= 0) goto L57
                cn.damai.seat.view.RegionView r6 = cn.damai.seat.view.RegionView.this
                float r6 = cn.damai.seat.view.RegionView.access$400(r6)
                int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r6 <= 0) goto L57
                cn.damai.seat.view.RegionView r0 = cn.damai.seat.view.RegionView.this
                float r0 = cn.damai.seat.view.RegionView.access$400(r0)
                goto L40
            L57:
                cn.damai.seat.view.RegionView r1 = cn.damai.seat.view.RegionView.this
                boolean r1 = cn.damai.seat.view.RegionView.access$500(r1)
                if (r1 == 0) goto L76
                cn.damai.seat.view.RegionView r1 = cn.damai.seat.view.RegionView.this
                float r6 = r8.getFocusX()
                cn.damai.seat.view.RegionView.access$602(r1, r6)
                cn.damai.seat.view.RegionView r1 = cn.damai.seat.view.RegionView.this
                float r8 = r8.getFocusY()
                cn.damai.seat.view.RegionView.access$702(r1, r8)
                cn.damai.seat.view.RegionView r8 = cn.damai.seat.view.RegionView.this
                cn.damai.seat.view.RegionView.access$502(r8, r4)
            L76:
                int r8 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r8 <= 0) goto L84
                cn.damai.seat.view.RegionView r8 = cn.damai.seat.view.RegionView.this
                float r8 = cn.damai.seat.view.RegionView.access$400(r8)
                int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r8 < 0) goto L92
            L84:
                int r8 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r8 >= 0) goto L97
                cn.damai.seat.view.RegionView r8 = cn.damai.seat.view.RegionView.this
                float r8 = cn.damai.seat.view.RegionView.access$300(r8)
                int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r8 <= 0) goto L97
            L92:
                cn.damai.seat.view.RegionView r8 = cn.damai.seat.view.RegionView.this
                cn.damai.seat.view.RegionView.access$800(r8, r2)
            L97:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.seat.view.RegionView.ScaleGestureDetector$OnScaleGestureListenerC1729a.onScale(android.view.ScaleGestureDetector):boolean");
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "949786421")) {
                return ((Boolean) ipChange.ipc$dispatch("949786421", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            RegionView.this.isScaling = true;
            RegionView.this.firstScale = true;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1707069277")) {
                ipChange.ipc$dispatch("-1707069277", new Object[]{this, scaleGestureDetector});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$b */
    /* loaded from: classes16.dex */
    public class C1730b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a;
        private float b;

        C1730b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276781368")) {
                return ((Boolean) ipChange.ipc$dispatch("1276781368", new Object[]{this, motionEvent})).booleanValue();
            }
            this.a = RegionView.this.mRegionConfig.c;
            this.b = RegionView.this.mRegionConfig.d;
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "331010427")) {
                return ((Boolean) ipChange.ipc$dispatch("331010427", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (RegionView.this.isScaling) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1305119554")) {
                return ((Boolean) ipChange.ipc$dispatch("1305119554", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (!RegionView.this.isScaling) {
                RegionView.this.mTempPoint.x = (int) ((this.a + motionEvent2.getX()) - motionEvent.getX());
                RegionView.this.mTempPoint.y = (int) ((this.b + motionEvent2.getY()) - motionEvent.getY());
                RegionView regionView = RegionView.this;
                regionView.move(regionView.mTempPoint);
                return true;
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1336777720")) {
                ipChange.ipc$dispatch("1336777720", new Object[]{this, motionEvent});
            } else {
                super.onShowPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1927819764")) {
                return ((Boolean) ipChange.ipc$dispatch("-1927819764", new Object[]{this, motionEvent})).booleanValue();
            }
            RegionView.this.click(motionEvent.getX(), motionEvent.getY());
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$c */
    /* loaded from: classes16.dex */
    public class C1731c {
        private static transient /* synthetic */ IpChange $ipChange;
        float a;
        float b;
        float c;
        float d;
        float e;

        private C1731c() {
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 1.0f;
        }

        public void a(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1516011549")) {
                ipChange.ipc$dispatch("1516011549", new Object[]{this, Float.valueOf(f)});
                return;
            }
            this.a = f;
            this.e = f / RegionView.this.mRegionImageWidth;
            this.b = RegionView.this.mRegionImageHeight * this.e;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$d */
    /* loaded from: classes16.dex */
    public class C1732d implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1732d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1155390728")) {
                ipChange.ipc$dispatch("-1155390728", new Object[]{this, valueAnimator});
            } else {
                RegionView.this.move((Point) valueAnimator.getAnimatedValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$e */
    /* loaded from: classes16.dex */
    public class C1733e implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        C1733e(RegionView regionView) {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1889822892")) {
                return ipChange.ipc$dispatch("1889822892", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            return new Point((int) (xVar + ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) - xVar) * f)), (int) (yVar + (f * (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) - yVar))));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.view.RegionView$f */
    /* loaded from: classes16.dex */
    public class C1734f implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1734f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-926090230")) {
                ipChange.ipc$dispatch("-926090230", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2061841563")) {
                ipChange.ipc$dispatch("-2061841563", new Object[]{this, animator});
            } else {
                RegionView.this.autoScroll();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1387485385")) {
                ipChange.ipc$dispatch("1387485385", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1400746878")) {
                ipChange.ipc$dispatch("1400746878", new Object[]{this, animator});
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1266174774")) {
                ipChange.ipc$dispatch("1266174774", new Object[]{this, valueAnimator});
            } else {
                RegionView.this.zoom(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public RegionView(Context context) {
        super(context);
        this.offsetScale = 0.25f;
        this.mSelectedPriceId = -1L;
        this.firstScale = true;
        this.handler = new Handler();
        this.updateSelectedRegionRunnable = new Runnable() { // from class: cn.damai.seat.view.RegionView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2035531391")) {
                    ipChange.ipc$dispatch("-2035531391", new Object[]{this});
                    return;
                }
                RegionView.this.mClickPosition = -1;
                RegionView.this.invalidate();
            }
        };
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector$OnScaleGestureListenerC1729a());
        this.mGestureDetector = new GestureDetector(getContext(), new C1730b());
        init(context);
    }

    private boolean autoScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604360158")) {
            return ((Boolean) ipChange.ipc$dispatch("-604360158", new Object[]{this})).booleanValue();
        }
        float currentScale = getCurrentScale();
        float f = this.mMaxScale;
        if (currentScale > f) {
            zoomAnimate(currentScale, f);
            return true;
        }
        float f2 = this.mMinScale;
        if (currentScale < f2) {
            zoomAnimate(currentScale, f2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean autoScroll() {
        float width;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "741740473")) {
            return ((Boolean) ipChange.ipc$dispatch("741740473", new Object[]{this})).booleanValue();
        }
        float f = 0.0f;
        if (this.mRegionConfig.a <= getWidth()) {
            width = (getWidth() - this.mRegionConfig.a) / 2.0f;
        } else {
            C1731c c1731c = this.mRegionConfig;
            float f2 = c1731c.c;
            if (f2 < 0.0f && f2 + c1731c.a > getWidth()) {
                width = this.mRegionConfig.c;
            } else {
                C1731c c1731c2 = this.mRegionConfig;
                width = c1731c2.c + c1731c2.a <= ((float) getWidth()) ? getWidth() - this.mRegionConfig.a : 0.0f;
            }
        }
        if (this.mRegionConfig.b <= getHeight()) {
            f = (getHeight() - this.mRegionConfig.b) / 2.0f;
        } else {
            C1731c c1731c3 = this.mRegionConfig;
            float f3 = c1731c3.d;
            if (f3 < 0.0f && f3 + c1731c3.b > getHeight()) {
                f = this.mRegionConfig.d;
            } else {
                C1731c c1731c4 = this.mRegionConfig;
                if (c1731c4.d + c1731c4.b <= getHeight()) {
                    f = getHeight() - this.mRegionConfig.b;
                }
            }
        }
        C1731c c1731c5 = this.mRegionConfig;
        if (width == c1731c5.c && f == c1731c5.d) {
            return false;
        }
        Point point = new Point();
        C1731c c1731c6 = this.mRegionConfig;
        point.x = (int) c1731c6.c;
        point.y = (int) c1731c6.d;
        Point point2 = new Point();
        point2.x = (int) width;
        point2.y = (int) f;
        moveAnimate(point, point2);
        return true;
    }

    private boolean buildDrawArea() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113198082")) {
            return ((Boolean) ipChange.ipc$dispatch("-1113198082", new Object[]{this})).booleanValue();
        }
        C1731c c1731c = this.mRegionConfig;
        if (c1731c == null) {
            return false;
        }
        float max = Math.max(0.0f, c1731c.d);
        float max2 = Math.max(0.0f, this.mRegionConfig.c);
        C1731c c1731c2 = this.mRegionConfig;
        float min = Math.min(this.mViewHeight, c1731c2.b + c1731c2.d);
        C1731c c1731c3 = this.mRegionConfig;
        float min2 = Math.min(this.mViewWidth, c1731c3.c + c1731c3.a);
        C1731c c1731c4 = this.mRegionConfig;
        float f = c1731c4.e;
        float f2 = (min - max) / f;
        float f3 = (min2 - max2) / f;
        float f4 = c1731c4.d;
        float abs = max == f4 ? 0.0f : Math.abs(f4 / f);
        C1731c c1731c5 = this.mRegionConfig;
        float f5 = c1731c5.c;
        float abs2 = max2 != f5 ? Math.abs(f5 / c1731c5.e) : 0.0f;
        this.mSrcBitmapRect.set((int) abs2, (int) abs, (int) (abs2 + f3), (int) (abs + f2));
        this.mRegionRect.set((int) max2, (int) max, (int) min2, (int) min);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click(float f, float f2) {
        Region clickedRegion;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642888209")) {
            ipChange.ipc$dispatch("1642888209", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        try {
            if (this.mListener != null && (clickedRegion = getClickedRegion(f, f2)) != null && clickedRegion.state != 0) {
                this.mListener.onRegion(getClickedRegion(f, f2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawLayer(Rect rect, Rect rect2, Canvas canvas, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967269781")) {
            ipChange.ipc$dispatch("1967269781", new Object[]{this, rect, rect2, canvas, bitmap});
            return;
        }
        canvas.drawBitmap(bitmap, rect, rect2, this.mPaint);
        if (!this.mReset) {
            this.mRegionLayerBitmap.eraseColor(0);
            for (Region region : this.mRegions) {
                if (region.state == 0) {
                    ArrayList<RegionLocation> arrayList = region.regionLocationList;
                    this.mRegionBorderPath.reset();
                    for (int i = 0; i < arrayList.size(); i++) {
                        RegionLocation regionLocation = arrayList.get(i);
                        float f = regionLocation.x;
                        float f2 = regionLocation.y;
                        if (i == 0) {
                            this.mRegionBorderPath.moveTo(f, f2);
                        }
                        this.mRegionBorderPath.lineTo(f, f2);
                    }
                    this.mRegionBorderPath.close();
                    this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mInvalidRegionPaint);
                    this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mInvalidRegionBorderPaint);
                } else if (region.priceLevelIdList != null && this.mSelectedPriceId != -1) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= region.priceLevelIdList.size()) {
                            break;
                        } else if (region.priceLevelIdList.get(i2).longValue() == this.mSelectedPriceId) {
                            ArrayList<RegionLocation> arrayList2 = region.regionLocationList;
                            this.mRegionBorderPath.reset();
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                RegionLocation regionLocation2 = arrayList2.get(i3);
                                float f3 = regionLocation2.x;
                                float f4 = regionLocation2.y;
                                if (i3 == 0) {
                                    this.mRegionBorderPath.moveTo(f3, f4);
                                }
                                this.mRegionBorderPath.lineTo(f3, f4);
                            }
                            this.mRegionBorderPath.close();
                            this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mRegionPaint);
                            this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mRegionBorderPaint);
                        } else {
                            i2++;
                        }
                    }
                }
            }
            canvas.drawBitmap(this.mRegionLayerBitmap, rect, rect2, this.mPaint);
            this.mReset = true;
            return;
        }
        canvas.drawBitmap(this.mRegionLayerBitmap, rect, rect2, this.mPaint);
    }

    private Region getClickedRegion(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425424283")) {
            return (Region) ipChange.ipc$dispatch("-1425424283", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        }
        List<Region> list = this.mRegions;
        if (list == null || list.isEmpty()) {
            return null;
        }
        this.mClickPosition = -1;
        for (int i = 0; i < this.mRegions.size(); i++) {
            Region region = this.mRegions.get(i);
            C1731c c1731c = this.mRegionConfig;
            if (Boolean.valueOf(isPointInPolygon2(f, f2, c1731c.c, c1731c.d, c1731c.e, region.regionLocationList)).booleanValue()) {
                this.mClickPosition = i;
                return region;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCurrentScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754638498")) {
            return ((Float) ipChange.ipc$dispatch("754638498", new Object[]{this})).floatValue();
        }
        C1731c c1731c = this.mRegionConfig;
        if (c1731c == null) {
            return 1.0f;
        }
        return c1731c.e;
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517640295")) {
            ipChange.ipc$dispatch("1517640295", new Object[]{this, context});
            return;
        }
        setLayerType(1, null);
        initBaseData(context);
        initPaintData();
    }

    private void initBaseData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190965726")) {
            ipChange.ipc$dispatch("-1190965726", new Object[]{this, context});
            return;
        }
        this.mFirstDraw = true;
        this.mRegionConfig = new C1731c();
        this.mRegionRect = new Rect();
        this.mSrcBitmapRect = new Rect();
        this.mLeftRightPadding = m62.a(context, 15.0f);
        this.mTempPoint = new Point();
    }

    private void initPaintData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736930785")) {
            ipChange.ipc$dispatch("1736930785", new Object[]{this});
            return;
        }
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mRegionPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mRegionPaint.setColor(Color.parseColor("#9A000000"));
        Paint paint2 = new Paint(1);
        this.mRegionBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mRegionBorderPaint.setColor(Color.parseColor("#000000"));
        this.mRegionBorderPaint.setStrokeWidth(2.0f);
        this.mInvalidRegionPaint = new Paint(1);
        Paint paint3 = new Paint(1);
        this.mInvalidRegionPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mInvalidRegionPaint.setColor(Color.parseColor("#CCCCCCCC"));
        Paint paint4 = new Paint(1);
        this.mInvalidRegionBorderPaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.mInvalidRegionBorderPaint.setColor(Color.parseColor("#CCAAAAAA"));
        this.mInvalidRegionBorderPaint.setStrokeWidth(2.0f);
        this.mRegionBorderPath = new Path();
    }

    private void invalidateClickRect(Canvas canvas, Paint paint) throws InterruptedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076697646")) {
            ipChange.ipc$dispatch("-1076697646", new Object[]{this, canvas, paint});
            return;
        }
        int i = this.mClickPosition;
        if (i == -1 || i >= this.mRegions.size()) {
            return;
        }
        Region region = this.mRegions.get(this.mClickPosition);
        if (region.flag) {
            ArrayList<RegionLocation> arrayList = region.regionLocationList;
            this.mRegionBorderPath.reset();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Path path = this.mRegionBorderPath;
                float f = arrayList.get(i2).x;
                C1731c c1731c = this.mRegionConfig;
                float f2 = (f * c1731c.e) + c1731c.c;
                float f3 = arrayList.get(i2).y;
                C1731c c1731c2 = this.mRegionConfig;
                path.lineTo(f2, (f3 * c1731c2.e) + c1731c2.d);
            }
            this.mRegionBorderPath.close();
            paint.setColor(Color.parseColor(region.color));
            canvas.drawPath(this.mRegionBorderPath, paint);
            this.handler.postDelayed(this.updateSelectedRegionRunnable, 50L);
        }
    }

    public static boolean isPointInPolygon2(float f, float f2, float f3, float f4, float f5, List<RegionLocation> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412939745")) {
            return ((Boolean) ipChange.ipc$dispatch("-412939745", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), list})).booleanValue();
        }
        float f6 = f5 == 0.0f ? 1.0f : f5;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            RegionLocation regionLocation = list.get(i);
            i++;
            RegionLocation regionLocation2 = list.get(i % size);
            float f7 = (regionLocation.x * f6) + f3;
            float f8 = (regionLocation.y * f6) + f4;
            float f9 = (regionLocation2.x * f6) + f3;
            float f10 = (regionLocation2.y * f6) + f4;
            if (f8 != f10 && f2 >= Math.min(f8, f10) && f2 < Math.max(f8, f10) && (((f2 - f8) * (f9 - f7)) / (f10 - f8)) + f7 > f) {
                i2++;
            }
        }
        return i2 % 2 == 1;
    }

    private void keydown(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769748808")) {
            ipChange.ipc$dispatch("-769748808", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        for (int i = 0; i < this.mRegions.size(); i++) {
            try {
                Region region = this.mRegions.get(i);
                C1731c c1731c = this.mRegionConfig;
                if (Boolean.valueOf(isPointInPolygon2(f, f2, c1731c.c, c1731c.d, c1731c.e, region.regionLocationList)).booleanValue()) {
                    region.flag = true;
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void keyup() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376345439")) {
            ipChange.ipc$dispatch("376345439", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mRegions.size(); i++) {
            try {
                this.mRegions.get(i).flag = false;
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void move(Point point) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868423229")) {
            ipChange.ipc$dispatch("-1868423229", new Object[]{this, point});
            return;
        }
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        int i = this.mScrollOffsetWidth;
        if (xVar > i) {
            this.mRegionConfig.c = i;
        } else {
            C1731c c1731c = this.mRegionConfig;
            float f = c1731c.a;
            if (xVar + f < i) {
                c1731c.c = i - f;
            } else {
                c1731c.c = xVar;
            }
        }
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        int i2 = this.mScrollOffsetHeigh;
        if (yVar > i2) {
            this.mRegionConfig.d = i2;
        } else {
            C1731c c1731c2 = this.mRegionConfig;
            float f2 = c1731c2.b;
            if (yVar + f2 < i2) {
                c1731c2.d = i2 - f2;
            } else {
                c1731c2.d = yVar;
            }
        }
        invalidate();
    }

    private void moveAnimate(Point point, Point point2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402744235")) {
            ipChange.ipc$dispatch("-402744235", new Object[]{this, point, point2, Long.valueOf(j)});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new C1733e(this), point, point2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new C1732d());
        ofObject.setDuration(j);
        ofObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738003106")) {
            ipChange.ipc$dispatch("738003106", new Object[]{this, Float.valueOf(f)});
            return;
        }
        C1731c c1731c = this.mRegionConfig;
        float f2 = c1731c.c;
        float f3 = c1731c.d;
        float f4 = c1731c.a;
        float f5 = c1731c.b;
        c1731c.a(this.mRegionImageWidth * f);
        C1731c c1731c2 = this.mRegionConfig;
        float f6 = this.scaleX;
        c1731c2.c = f6 - (c1731c2.a * ((f6 - f2) / f4));
        float f7 = this.scaleY;
        c1731c2.d = f7 - (c1731c2.b * ((f7 - f3) / f5));
        invalidate();
    }

    private void zoomAnimate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101887179")) {
            ipChange.ipc$dispatch("1101887179", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        C1734f c1734f = new C1734f();
        ofFloat.addUpdateListener(c1734f);
        ofFloat.addListener(c1734f);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812052169")) {
            ipChange.ipc$dispatch("-1812052169", new Object[]{this, canvas});
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            List<Region> list = this.mRegions;
            if (list != null && !list.isEmpty() && (bitmap = this.mContentBitmap) != null && !bitmap.isRecycled()) {
                if (this.mFirstDraw) {
                    this.mViewWidth = getWidth();
                    int height = getHeight();
                    this.mViewHeight = height;
                    this.mScrollOffsetWidth = this.mViewWidth / 2;
                    this.mScrollOffsetHeigh = height / 2;
                    this.mRegionImageWidth = this.mContentBitmap.getWidth();
                    this.mRegionImageHeight = this.mContentBitmap.getHeight();
                    int i = this.mLeftRightPadding * 2;
                    this.mRegionConfig.a = e80.d() - i;
                    C1731c c1731c = this.mRegionConfig;
                    float f = c1731c.a;
                    int i2 = this.mRegionImageHeight;
                    int i3 = this.mRegionImageWidth;
                    float f2 = (f * i2) / i3;
                    c1731c.b = f2;
                    int i4 = this.mViewHeight;
                    if (f2 > i4 - i) {
                        float f3 = this.mViewWidth - i;
                        c1731c.b = f3;
                        c1731c.a = (f3 * i3) / i2;
                    }
                    c1731c.c = i / 2;
                    c1731c.d = (i4 - c1731c.b) / 2.0f;
                    float f4 = c1731c.a / i3;
                    this.mMinScale = f4;
                    c1731c.e = f4;
                    float f5 = 3.0f * f4;
                    this.mMaxScale = f5;
                    float f6 = this.offsetScale;
                    this.minOffsetScale = f4 * (1.0f - f6);
                    this.maxOffsetScale = f5 * (f6 + 1.0f);
                }
                if (buildDrawArea()) {
                    drawLayer(this.mSrcBitmapRect, this.mRegionRect, canvas, this.mContentBitmap);
                } else {
                    Rect rect = this.mRegionRect;
                    C1731c c1731c2 = this.mRegionConfig;
                    float f7 = c1731c2.c;
                    float f8 = c1731c2.d;
                    rect.set((int) f7, (int) f8, (int) (f7 + c1731c2.a), (int) (f8 + c1731c2.b));
                    drawLayer(null, this.mRegionRect, canvas, this.mContentBitmap);
                }
                if (this.mFirstDraw) {
                    this.mFirstDraw = false;
                }
                cb1.b(TAG, "----------------------------- draw region image cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862057264")) {
            return ((Boolean) ipChange.ipc$dispatch("-1862057264", new Object[]{this, motionEvent})).booleanValue();
        }
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.isScaling) {
                this.isScaling = false;
            }
            boolean autoScale = autoScale();
            boolean autoScroll = autoScroll();
            if (!autoScale && !autoScroll) {
                invalidate();
            }
        }
        return true;
    }

    public void setBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516227034")) {
            ipChange.ipc$dispatch("-516227034", new Object[]{this, bitmap});
            return;
        }
        this.mContentBitmap = bitmap;
        this.mRegionLayerBitmap = Bitmap.createBitmap(bitmap.getWidth(), this.mContentBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        this.mRegionLayerCanvas = new Canvas(this.mRegionLayerBitmap);
        this.mFirstDraw = true;
        this.mReset = false;
        invalidate();
    }

    public void setListener(OnRegionClickListener onRegionClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099536229")) {
            ipChange.ipc$dispatch("1099536229", new Object[]{this, onRegionClickListener});
        } else {
            this.mListener = onRegionClickListener;
        }
    }

    public void setPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144212267")) {
            ipChange.ipc$dispatch("-144212267", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSelectedPriceId = j;
        this.mReset = false;
        invalidate();
    }

    public void setRegions(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518062885")) {
            ipChange.ipc$dispatch("1518062885", new Object[]{this, list});
        } else {
            this.mRegions = list;
        }
    }

    private void moveAnimate(Point point, Point point2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372480591")) {
            ipChange.ipc$dispatch("1372480591", new Object[]{this, point, point2});
        } else {
            moveAnimate(point, point2, 300L);
        }
    }

    public RegionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offsetScale = 0.25f;
        this.mSelectedPriceId = -1L;
        this.firstScale = true;
        this.handler = new Handler();
        this.updateSelectedRegionRunnable = new Runnable() { // from class: cn.damai.seat.view.RegionView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2035531391")) {
                    ipChange.ipc$dispatch("-2035531391", new Object[]{this});
                    return;
                }
                RegionView.this.mClickPosition = -1;
                RegionView.this.invalidate();
            }
        };
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector$OnScaleGestureListenerC1729a());
        this.mGestureDetector = new GestureDetector(getContext(), new C1730b());
        init(context);
    }

    public RegionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offsetScale = 0.25f;
        this.mSelectedPriceId = -1L;
        this.firstScale = true;
        this.handler = new Handler();
        this.updateSelectedRegionRunnable = new Runnable() { // from class: cn.damai.seat.view.RegionView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2035531391")) {
                    ipChange.ipc$dispatch("-2035531391", new Object[]{this});
                    return;
                }
                RegionView.this.mClickPosition = -1;
                RegionView.this.invalidate();
            }
        };
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector$OnScaleGestureListenerC1729a());
        this.mGestureDetector = new GestureDetector(getContext(), new C1730b());
        init(context);
    }
}
