package com.project.marketkurly.mobileclientcommon.util;

import android.util.Log;

import static com.project.marketkurly.mobileclientcommon.util.ConstantData.DEBUG_MODE;

public class LogEx {
    public static void d(String message) {
        if (DEBUG_MODE) {
            try {
                String[] caller = getCallerInfo();
                Log.d(caller[0], "[" + caller[1] + "] " + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(Exception ex) {
        if (DEBUG_MODE) {
            try {
                String[] caller = getCallerInfo();
                Log.e(caller[0], "[" + caller[1] + "] " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(String message) {
        if (DEBUG_MODE) {
            try {
                String[] caller = getCallerInfo();
                Log.e(caller[0], "[" + caller[1] + "] " + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void w(String message) {
        if (DEBUG_MODE) {
            try {
                String[] caller = getCallerInfo();
                Log.w(caller[0], "[" + caller[1] + "] " + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void i(String message) {
        if (DEBUG_MODE) {
            try {
                String[] caller = getCallerInfo();
                Log.i(caller[0], "[" + caller[1] + "] " + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] getCallerInfo() {
        // 전전 호출 메소드에 대한 정보
        StackTraceElement el = new Throwable().fillInStackTrace().getStackTrace()[2];

        // Class Shot Name
        String className = el.getClassName();
        className = className.substring(className.lastIndexOf('.') + 1);
        String[] caller = new String[2];
        if (className.contains("$"))
            caller[0] = className.substring(0, className.lastIndexOf('$'));
        else
            caller[0] = className;
        caller[1] = className + "." + el.getMethodName() + "() Line " + el.getLineNumber();
        return caller;
    }
}
