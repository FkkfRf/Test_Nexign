package config;

import org.aeonbits.owner.Config;


public interface BaseTestConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://nexign.com/ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();
}

