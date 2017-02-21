package ru.five_dots.kotlin_boilerplate.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by aleksejskrobot on 30.09.16.
 */

public class Converter {

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public static int DoubleStringToInt(String d) {
        return (int) Double.parseDouble(d);
    }
}
