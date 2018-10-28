package com.tjudream.stock.util;

/**
 * Created by mengxiansen on 2018/10/28.
 */
public class Utils {
    private Utils() {

    }
    public static long parseData(String data) {
        long res = 0L;
        try {
            res = Long.parseLong(data) * Constant.TEN_THOUSAND;
        } catch (NumberFormatException e) {
            res = 0L;
        }
        return res;
    }
}
