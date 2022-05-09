package ru.homyakin.ebot.dao;

import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.homyakin.ebot.model.Additive;

@Repository
public class AdditiveDao {
    private final MongoTemplate mongoTemplate;

    public AdditiveDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Additive> getAdditivesByName(List<String> names) {
        final var query = new Query()
            .addCriteria(Criteria.where("names").in(names))
            .withHint("names")
            ;
        return mongoTemplate.find(query, Additive.class);
    }
}
