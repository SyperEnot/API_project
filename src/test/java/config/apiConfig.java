package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:auth.properties")
public interface apiConfig extends Config{
    @Key("AUTH_EMAIL")
    String authEmail();

    @Key("AUTH_PASSWORD")
    String authPassword();
}
