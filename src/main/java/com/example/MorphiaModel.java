package com.example;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Transient;

@Entity(value = "morphiatest", noClassnameStored = true)
class MorphiaModel {
	@Id
	ObjectId oid;
	int id;
	@Indexed
	long uuid;
	@Indexed
	String title;
	@Transient
	String normalizedTitle;
	@Property("last_updated")
	Date date;

	public Date getDate() {
		return date;
	}

	public int getId() {
		return id;
	}

	public String getNormalizedTitle() {
		return normalizedTitle;
	}

	public ObjectId getOid() {
		return oid;
	}

	public String getTitle() {
		return title;
	}

	public long getUuid() {
		return uuid;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNormalizedTitle(String normalizedTitle) {
		this.normalizedTitle = normalizedTitle;
	}

	public void setOid(ObjectId oid) {
		this.oid = oid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
}
