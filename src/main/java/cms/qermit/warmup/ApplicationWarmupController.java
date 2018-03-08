package cms.qermit.warmup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;


/**
 * A controller that calls itself to ensure all MVC loading is complete and
 * the application is fully primed to start receiving requests.
 */
@Controller
public class ApplicationWarmupController implements ApplicationListener<ApplicationStartedEvent> {

    private static final String WARMUP_CONTROLLER_URI = "/private/unsecured/warmup";

    private final String warmupUri;

    @Autowired
    public ApplicationWarmupController(@Value("${server.port}") final int port) {
        this.warmupUri = String.format("%s://localhost:%s%s", "http", port, WARMUP_CONTROLLER_URI);
    }

    @GetMapping(WARMUP_CONTROLLER_URI)
    @ResponseStatus(HttpStatus.OK)
    @SuppressWarnings("unused")
    public void getWarmup() {
        // no-op
    }

    @Override
    @SuppressWarnings("all")
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        new RestTemplate().getForObject(warmupUri, Void.class);
    }

}
