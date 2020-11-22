package com.cjz.guitarmemory.util;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

    private static Toast toast;

    /**
     * 弹出Toast
     *
     * @param context      上下文对象
     * @param text         提示的文本
     * @param isLongLength 持续时间（false：短；true：长）
     */
    public static void showToast(Context context, String text, boolean isLongLength) {
        int length;
        if (isLongLength) {
            length = Toast.LENGTH_LONG;
        } else {
            length = Toast.LENGTH_SHORT;
        }
        if (toast == null) {
            toast = Toast.makeText(context, text, length);
        } else {
            toast.setText(text);
            toast.setDuration(length);
        }
        toast.show();
    }

    /**
     * 弹出Toast
     *
     * @param context      上下文对象
     * @param text         提示的文本
     * @param isLongLength 持续时间（false：短；true：长）
     * @param gravity      位置（Gravity.CENTER;Gravity.TOP;...）
     */
    public static void showToast(Context context, String text, boolean isLongLength, int gravity) {
        int length;
        if (isLongLength) {
            length = Toast.LENGTH_LONG;
        } else {
            length = Toast.LENGTH_SHORT;
        }
        if (toast == null) {
            toast = Toast.makeText(context, text, length);
        } else {
            toast.setText(text);
            toast.setDuration(length);
        }
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

    /**
     * 关闭Toast
     */
    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }


}
