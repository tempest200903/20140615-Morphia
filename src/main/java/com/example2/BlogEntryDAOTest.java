package com.example2;

import java.io.Serializable;
import java.net.UnknownHostException;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class BlogEntryDAOTest {

	private String mongoServer;

	Morphia morphia;

	Mongo mongo;

	private BlogEntry createBlogEntry() {
		BlogEntry blogEntry = new BlogEntry();
		blogEntry.setTitle("title123");
		return blogEntry;
	}

	private void isSerializeable(BlogEntryDAO blogEntryDAO) {
		boolean b = blogEntryDAO instanceof Serializable;
		System.out.println("isSerializeable " + b); // #=> false
	}

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		morphia = new Morphia();
		mongoServer = "localhost";
		mongo = new Mongo(mongoServer);
	}

	@Test
	public void test() throws UnknownHostException {
		BlogEntryDAO blogEntryDAO = new BlogEntryDAO(morphia, mongo);

		ObjectId blogEntryId;
		{
			// * Create
			BlogEntry entity = createBlogEntry();
			blogEntryDAO.save(entity);
			blogEntryId = entity.getId();
			System.out.println("Create blogEntryId =: " + blogEntryId);
		}

		{
			// * Read
			// get one specific blog entry
			BlogEntry myBlogEntry = blogEntryDAO.get(blogEntryId);

			// * Update
			// update it
			myBlogEntry.setTitle("My Blog Entry");
			blogEntryDAO.save(myBlogEntry);
			System.out.println("Update blogEntryId =: " + blogEntryId);

			// * Delete
			// or just delete it
			blogEntryDAO.deleteById(myBlogEntry.getId());
		}

		isSerializeable(blogEntryDAO);
	}

}
