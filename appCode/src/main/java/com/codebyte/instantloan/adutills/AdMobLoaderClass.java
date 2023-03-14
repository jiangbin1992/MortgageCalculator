package com.codebyte.instantloan.adutills;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.codebyte.instantloan.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class AdMobLoaderClass {
    public static InterstitialAd sInterstitialAd;

    public static void loadad(Activity context) {
        AdRequest adRequest;
        adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(
                context,
                context.getResources().getString(R.string.interstail),
                adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        sInterstitialAd = interstitialAd;
                        Log.e("aaaaaaaaa", "onAdLoaded.");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.e("aaaaaaaaa", loadAdError.getMessage());
                        sInterstitialAd = null;
                    }
                });
    }

    public void showInterstitialAds(Activity activity, Intent intent) {
        InterstitialAd interstitialAd = sInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setFullScreenContentCallback(
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            loadad(activity);
                            Log.e("aaaaaaaaa", "The ad was dismissed.");
                            activity.startActivity(intent);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            Log.e("aaaaaaaaa", "The ad failed to show.");
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            Log.e("aaaaaaaaa", "The ad was shown.");
                        }
                    });
            interstitialAd.show(activity);
        } else {
            activity.startActivity(intent);
            loadad(activity);
        }

    }

    public void showInterstitialOnBackAds(Activity activity) {
        InterstitialAd interstitialAd = sInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setFullScreenContentCallback(
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            loadad(activity);
                            Log.e("aaaaaaaaa", "The ad was dismissed.");
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            Log.e("aaaaaaaaa", "The ad failed to show.");
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            Log.e("aaaaaaaaa", "The ad was shown.");
                        }
                    });
            interstitialAd.show(activity);
        } else {
            loadad(activity);
        }

    }

}
