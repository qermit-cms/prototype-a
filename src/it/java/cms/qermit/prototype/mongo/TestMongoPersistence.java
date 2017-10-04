package cms.qermit.prototype.mongo;

import cms.qermit.prototype.data.Token;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class TestMongoPersistence {

    @Autowired
    private TokenRepository tokenRepository;

    private static final Logger logger = LoggerFactory.getLogger(TestMongoPersistence.class);

    @Before
    public void reset() {
        logger.info("Deleting all tokens");
        tokenRepository.deleteAll();
    }

    @Test
    public void testPersistAndLoadData() {
        final String id = UUID.randomUUID().toString();
        final String value = UUID.randomUUID().toString();
        logger.info("Persisting token with ID: {}", id);
        tokenRepository.save(new Token(id, value, System.currentTimeMillis() + 1000));
        tokenRepository.findAll().forEach(t -> logger.info("Found: {}", t));
    }
}
