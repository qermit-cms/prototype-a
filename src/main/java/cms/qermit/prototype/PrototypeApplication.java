package cms.qermit.prototype;

import cms.qermit.prototype.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.Random;

@SpringBootApplication
public class PrototypeApplication implements ApplicationListener<ApplicationStartedEvent> {

    private final String warmupUri;
    private final TokenRepository tokenRepository;

    @Autowired
    public PrototypeApplication(final TokenRepository tokenRepository, @Value("${custom.warmup.uri}") final String warmupUri) {
        this.tokenRepository = tokenRepository;
        this.warmupUri = warmupUri;
    }


    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
    }

    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        // Ensure application is warmed up
        tokenRepository.findById("");
        new RestTemplate().getForObject(warmupUri, String.class);
    }

}
