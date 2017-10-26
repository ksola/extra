package pl.extra.extra;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestMongoRepo extends MongoRepository<ExtraUser, String>
{
}
