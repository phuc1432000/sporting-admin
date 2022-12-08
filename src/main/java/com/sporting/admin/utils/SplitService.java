package com.sporting.admin.utils;

public class SplitService {
    public static String splitSubOption(String subOption) {
        String[] arrOfStr = subOption.split(">", 2);
        return arrOfStr[0];
    }
}
