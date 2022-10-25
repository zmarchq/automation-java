package owner;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config{
    @Key("browser")
    @DefaultValue("FIREFOX")
    String getBrowser();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("timeout")
    @DefaultValue("10000")
    int timeout();
}
