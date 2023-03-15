package com.codebyte.instantloan.adutills;

import static com.best.now.myad.utils.Constant.AD_INTERSTITIAL_ID;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codebyte.instantloan.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;


public class AdUtils {

    private static String TAG = "AdsUtils_pkms";


    public static void bannerAd(Activity activity, FrameLayout frameLayout, String str, Boolean bool) {
        googleBanner(activity, frameLayout, str, bool);
    }


    public static void googleBanner(final Activity activity, final FrameLayout frameLayout, final String str, final Boolean bool) {
        AdView adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AD_INTERSTITIAL_ID);
        frameLayout.addView(adView);
        AdRequest build = new AdRequest.Builder().build();
        if (adView.getAdSize() == null && adView.getAdUnitId() == null) {
            adView.setVisibility(View.GONE);
            return;
        }
        adView.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.e(AdUtils.TAG, "onAdClosed Google Banner");
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Log.e(AdUtils.TAG, "onAdOpened Google Banner");
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.e(AdUtils.TAG, "onAdLoaded Google Banner");
            }
        });
        adView.loadAd(build);
    }


    public static void nativeAd(Activity activity, FrameLayout frameLayout, Boolean bool, Boolean bool2) {
        googleNative(activity, frameLayout, bool, bool2);

    }

    public static void googleNative(final Activity activity, final FrameLayout frameLayout, final Boolean bool, final Boolean bool2) {
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_INTERSTITIAL_ID);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {


            @Override
            public void onNativeAdLoaded(NativeAd nativeAd) {
                NativeAdView nativeAdView = (NativeAdView) LayoutInflater.from(activity).inflate(R.layout.admob_native_tt, (ViewGroup) null);
                AdUtils.populateUnifiedNativeAdView(nativeAd, nativeAdView, bool2);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
            }
        });
        builder.withAdListener(new AdListener() {


            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public static void populateUnifiedNativeAdView(NativeAd nativeAd, NativeAdView nativeAdView, Boolean bool) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        RelativeLayout relativeLayout = (RelativeLayout) nativeAdView.findViewById(R.id.iv_relative);
        if (bool.booleanValue()) {
            relativeLayout.setVisibility(View.GONE);
        } else {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        nativeAdView.setNativeAd(nativeAd);
    }
}
