package com.codebyte.instantloan.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.activity.SplashActivity;
import com.codebyte.instantloan.adutills.SessionHelper;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (new SessionHelper(context).getBooleanData(SessionHelper.IS_NOTIFICATION_SEND).booleanValue()) {
            addNotification(context);
        } else {
            new SessionHelper(context).putBooleanData(SessionHelper.IS_NOTIFICATION_SEND, true);
        }
    }

    private void addNotification(Context context) {
        Log.e("fdgfdgfdgfdgfdg", "445454545454545");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notify_001");
        int flags;
        if (Build.VERSION.SDK_INT >= 31) {
            flags = PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT;
        } else {
            flags = PendingIntent.FLAG_UPDATE_CURRENT;
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, SplashActivity.class), flags);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Instant Loan Guide");
        builder.setSmallIcon(R.drawable.icon);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        builder.setContentTitle("Instant Loan Guide");
        builder.setContentText("Personal Instant Loan & Guide Online is an Personal Instant Loan Platform for all mobile users.");
        builder.setPriority(2);
        builder.setStyle(bigTextStyle);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("Your_channel_id", "Channel human readable title", NotificationManager.IMPORTANCE_HIGH));
            builder.setChannelId("Your_channel_id");
        }
        notificationManager.notify(0, builder.build());
    }
}
