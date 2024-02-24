package config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})
public interface DataConfig extends Config {
    String name();
    String email();
    String currentAddress();
    String permanentAddress();
}
