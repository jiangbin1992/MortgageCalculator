package com.codebyte.instantloan.adutills;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionHelper {
    public static final String ADS_DATA = "ads_data";

    public static final String IS_NOTIFICATION_SEND = "is_notification_send";

    Context context = null;
    SharedPreferences.Editor editor = null;
    SharedPreferences sharedPreferences = null;

    public SessionHelper(Context context2) {
        this.context = context2;
        if (context2 != null) {
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences(ADS_DATA, 0);
            this.sharedPreferences = sharedPreferences2;
            this.editor = sharedPreferences2.edit();
        }
    }


    public String getStringData(String str) {
        return this.sharedPreferences.getString(str, "");
    }

    public void putBooleanData(String str, Boolean bool) {
        this.editor.putBoolean(str, bool.booleanValue());
        this.editor.commit();
    }

    public Boolean getBooleanData(String str) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(str, false));
    }
}
