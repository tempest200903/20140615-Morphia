package com.example1;

import java.net.UnknownHostException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MorphiaModelTest {

	private MorphiaModel createModel() {
		MorphiaModel morphiaModel = new MorphiaModel();
		morphiaModel.setDate(new Date());
		morphiaModel.setTitle("title1");
		return morphiaModel;
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMorphia() throws UnknownHostException, MongoException {
		String mongoServer = "localhost";
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo(mongoServer);
		Morphia morphia = new Morphia();
		morphia.map(MorphiaModel.class);
		String dbName = "mydb";
		Datastore ds = morphia.createDatastore(mongo, dbName);

		// do test
		MorphiaModel expectedModel = createModel();
		Key<MorphiaModel> key = ds.save(expectedModel);

		MorphiaModel foundModel = ds.find(MorphiaModel.class).field("title")
				.equal(expectedModel.getTitle()).get();

		Assert.assertNotNull(foundModel);
		Assert.assertEquals(expectedModel.getId(), foundModel.getId());
		Assert.assertEquals(expectedModel.getUuid(), foundModel.getUuid());
		Assert.assertEquals(expectedModel.getTitle(), foundModel.getTitle());
		{
			long expected = expectedModel.getDate().getTime();
			long actual = foundModel.getDate().getTime();
			Assert.assertEquals(expected, actual);
		}
		Assert.assertEquals(key.getId().toString(), foundModel.getOid()
				.toString());

		ds.delete(MorphiaModel.class, foundModel.getOid());

		MorphiaModel expected2 = ds.find(MorphiaModel.class).field("title")
				.equal(expectedModel.getTitle()).get();
		Assert.assertNull(expected2);
	}

}
