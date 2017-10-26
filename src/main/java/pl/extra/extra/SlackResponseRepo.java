package pl.extra.extra;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlackResponseRepo extends MongoRepository<SlackResponseDto, String> {
}
