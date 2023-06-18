package com.example.pandicazoovrt.constants;

public class Prices {
    public static int CHILDREN_ZOO = 200;
    public static int CHILDREN_AQ = 250;
    public static int CHILDREN_FEED = 400;
    public static int CHILDREN_FULL = 700;
    public static int ADULT_ZOO = 800;
    public static int ADULT_AQ = 1000;
    public static int ADULT_FEED = 1200;
    public static int ADULT_FULL = 1500;
    public static int GROUP_ZOO = 500;
    public static int GROUP_AQ = 700;
    public static int GROUP_FEED = 1000;
    public static int GROUP_FULL = 1200;

    private final int value;

    Prices(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
