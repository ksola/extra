package pl.extra.extra;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlackRequestRepo extends MongoRepository<SlackRequest, String> {
}
