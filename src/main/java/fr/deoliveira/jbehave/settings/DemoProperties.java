package fr.deoliveira.jbehave.settings;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

@ConfigurationProperties("demo")
public class DemoProperties {

    @Getter
    @Setter
    private String seleniumUrl;

    @Getter
    @Setter
    private String applicationUrl;

}
