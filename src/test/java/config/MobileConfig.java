package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/mobile.properties"
})
public interface MobileConfig extends Config {

    @Key("platform")
    @DefaultValue("android")
    String platform();

    @Key("browserstack.user")
    String browserStackUser();

    @Key("browserstack.key")
    String browserStackKey();

    @Key("browserstack.url")
    String browserStackUrl();

    @Key("browserstack.project")
    String projectName();

    @Key("browserstack.build")
    String buildName();

    @Key("browserstack.session")
    String sessionName();

    @Key("browserstack.appium.version")
    String appiumVersion();

    @Key("android.device.name")
    String androidDeviceName();

    @Key("android.os.version")
    String androidOsVersion();

    @Key("android.app")
    String androidApp();

    @Key("android.automation.name")
    String androidAutomationName();

    @Key("ios.device.name")
    String iosDeviceName();

    @Key("ios.os.version")
    String iosOsVersion();

    @Key("ios.app")
    String iosApp();

    @Key("ios.automation.name")
    String iosAutomationName();
}
