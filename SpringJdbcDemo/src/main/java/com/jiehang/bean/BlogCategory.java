package com.jiehang.bean;

import java.util.Date;

public class BlogCategory {
	private String name;
	private String descript;
	private Date createdAt;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BlogCategory{" +
				"name='" + name + '\'' +
				", descript='" + descript + '\'' +
				", createdAt=" + createdAt +
				", count=" + count +
				'}';
	}
}