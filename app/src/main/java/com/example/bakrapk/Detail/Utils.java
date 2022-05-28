package com.example.bakrapk.Detail;

import android.content.Context;

public class Utils {

    public static String getResourceNameFromId(Context context, int resourceId) {
        return context.getResources().getResourceEntryName(resourceId);
    }

    public static int getResourceIdFromName(Context context, String resourceName) {
        return context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
    }
}
