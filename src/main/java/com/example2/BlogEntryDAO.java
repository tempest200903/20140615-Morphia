package com.example2;

import org.bson.types.ObjectId;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

/**
 * cf. http://dayafterneet.blogspot.jp/2012/02/mongodbjavamorphia.html
 * 
 * cf. https://github.com/mongodb/morphia/wiki/DAOSupport
 * 
 */
public class BlogEntryDAO extends BasicDAO<BlogEntry, ObjectId> {

	public BlogEntryDAO(Morphia morphia, Mongo mongo) {
		super(mongo, morphia, "myBlogDb");
	}

}
