package amazon.factories;

import java.net.MalformedURLException;
import java.net.URL;

import com.typesafe.config.Config;

import amazon.choices.Host;
import amazon.config.EnvFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class URLFactory {
    private static Config config = EnvFactory.getInstance().getConfig();

    private URLFactory() {
        throw new IllegalStateException("Static factory class");
    }

    public static URL getHostURL(Host host) {
        log.info("Getting hostURL for Host: {}", host);
        try {
            return new URL(config.getString("HOST_URI"));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(String.format("%s is Malformed host URL.", config.getString("HOST_URI")), e);
        }
    }
}
