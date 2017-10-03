package cms.qermit.prototype.mongo;

import cms.qermit.prototype.data.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<Token, String> {

}
