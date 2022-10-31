package owner;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final WebDriverConfig webDriverConfig = ConfigFactory.create(
            WebDriverConfig.class,
            System.getProperties()
    );

    public WebDriverConfig read() {
        return webDriverConfig;
    }
}
