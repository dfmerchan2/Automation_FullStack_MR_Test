package co.com.swaglabs.utils;

public class Utilities {


    public static String getDriver() {
        String[] drivers = {"chrome", "edge", "firefox"};
        int i = (int) (Math.random() * drivers.length);
        return drivers [i];
    }

}
