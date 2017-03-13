package toptal.business.persistence.nosql.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public abstract class MongoDaoFacade<I> {

	public static final String ID = "_id";
	
	public static final String NAME = "name";
	
	public static final String VALUE = "value";

	private final MongoOperations mongo;

	@Autowired
	public MongoDaoFacade(MongoTemplate mongo) {
		this.mongo = mongo;
	}
	
	protected abstract String getCollectionName();
	
	protected abstract Class<I> getCollectionClass();

	protected void save(I doc) {

		mongo.insert(doc, getCollectionName());
	}

	protected I findById(Object id) {

		return mongo.findOne(new Query(where(ID).is(id.toString())), getCollectionClass());
	}

	protected I findByFieldName(String fieldName, Object value) {
		return mongo.findOne(new Query(where(fieldName).is(value.toString())), getCollectionClass());
	}
	
	protected List<I> findManyByFieldName(String fieldName, Object value) {
		return mongo.find(new Query(where(fieldName).is(value.toString())), getCollectionClass());
	}
	
	protected List<I> findManyByMultipleFieldName(List<Object> values, List<String> fieldNames) {
		Query query = new Query();
		
		for(int i = 0; i < fieldNames.size(); i++){
			query.addCriteria(where(fieldNames.get(i)).is(values.get(i).toString()));
		}
		
		return mongo.find(query, getCollectionClass());
	}
	
	protected List<I> findAll() {

		return mongo.findAll(getCollectionClass(), getCollectionName());
	}

	protected long update(Query query, Update update, I doc) {

		WriteResult result = mongo.updateFirst(query, update, getCollectionClass(), getCollectionName());
		return result.getN();
	}

	protected void removeById(I id) {

		mongo.remove(new Query(where(ID).is(id)), getCollectionClass());
	}

	public boolean exists(I id) {

		return mongo.findOne(new Query(where(ID).is(id)), getCollectionClass()) != null;
	}
	
	protected MongoOperations getMongo() {
	
		return mongo;
	}	
	
}
