package com.jiehang.dao;

import com.jiehang.bean.BlogCategory;

import java.util.List;
import java.util.Map;

public interface BlogCategoryDao {
	
	public abstract int insertUser(BlogCategory blogCategory);
	
	public abstract List<BlogCategory> queryUser();
	
	public abstract List<BlogCategory> queryUser1();
	
	public abstract List<BlogCategory> queryUser2();
	
	/**
	 * Spring4.x don't support this method, Instead of Using RowMapper to package datas into List.
	 * @return
	 */
	public abstract List<BlogCategory> queryUser3();
	
	/**
	 * The same as above.
	 * @return
	 */
	public abstract BlogCategory queryUser4();
	
	public abstract Map<String, Object> queryUser5();
	
	public abstract void queryUser6();
}