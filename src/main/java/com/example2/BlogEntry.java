package com.example2;

/**
 * cf. https://github.com/mongodb/morphia/wiki/ReferenceAnnotation
 *
 */
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity
public class BlogEntry {

	@Id
	private ObjectId id;

	private String title;

	private Date publishDate;

	private String body;

	@Reference
	private Author author;

	@Reference("blog_authors")
	private List<Author> authors;

	public Author getAuthor() {
		return author;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public String getBody() {
		return body;
	}

	public ObjectId getId() {
		return id;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// optional getters and setters
}
