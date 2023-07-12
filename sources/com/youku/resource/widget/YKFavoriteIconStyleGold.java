package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.youku.middlewareservice.provider.youku.YoukuDeviceInfoProviderProxy;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKFavoriteIconStyleGold extends FrameLayout {
    private boolean animate;
    private boolean clicked;
    private LottieAnimationView lottieAnimationView;

    public YKFavoriteIconStyleGold(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.lottieAnimationView = (LottieAnimationView) LayoutInflater.from(context).inflate(R.layout.resource_yk_fav_icon, (ViewGroup) this, true).findViewById(R.id.favorite_icon);
        if (!Utils.isDebug(context) && YoukuDeviceInfoProviderProxy.getDeviceScore() <= 80) {
            this.animate = false;
        } else {
            this.animate = true;
        }
    }

    public void changeState() {
        if (this.animate) {
            if (this.clicked) {
                this.lottieAnimationView.setImageAssetsFolder("images");
                this.lottieAnimationView.setAnimation(Utils.getFavCancelIconGoldPath(), LottieAnimationView.CacheStrategy.Strong);
                this.lottieAnimationView.playAnimation();
                this.clicked = false;
                return;
            }
            this.lottieAnimationView.setImageAssetsFolder("images");
            this.lottieAnimationView.setAnimation(Utils.getFavConfirmIconGoldPath(), LottieAnimationView.CacheStrategy.Strong);
            this.lottieAnimationView.playAnimation();
            this.clicked = true;
        } else if (this.clicked) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_cancel);
            this.clicked = false;
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_confirm_gold);
            this.clicked = true;
        }
    }

    public void setInitState(boolean z) {
        if (z) {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_confirm_gold);
        } else {
            this.lottieAnimationView.setImageResource(R.drawable.yk_icon_fav_cancel);
        }
        this.clicked = z;
    }

    public YKFavoriteIconStyleGold(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
