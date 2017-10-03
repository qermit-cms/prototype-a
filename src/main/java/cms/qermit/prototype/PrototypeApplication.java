package cms.qermit.prototype;

import cms.qermit.prototype.mongo.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeApplication {

    @Autowired
    private TokenRepository tokenRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrototypeApplication.class, args);
    }

}
