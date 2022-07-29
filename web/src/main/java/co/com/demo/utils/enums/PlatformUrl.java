package co.com.demo.utils.enums;

public enum PlatformUrl {
    PLATFORM_SWAG_LABS("https://www.saucedemo.com/"),
    PLATFORM_DEMO_BLAZE("https://www.demoblaze.com/index.html"),
    PLATFORM_U_TEST("https://www.utest.com/");

    private final String url;

    PlatformUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
