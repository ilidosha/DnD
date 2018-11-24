package com.example.ilidosha.dnd.Utils;

import com.example.ilidosha.dnd.R;

public class RandomUtils {
    private static int changeTextColor = 1;

    public static int getNextTheme() {
        switch (changeTextColor) {
            case 0:
                changeTextColor++;
                return R.style.whiteText;
            default:
                changeTextColor = 0;
                return R.style.blackText;

        }
    }
}
