package com.jiehang.dao.impl;

import com.jiehang.bean.BlogCategory;
import com.jiehang.dao.BlogCategoryDao;
import com.jiehang.utils.ResultSetHelper;
import com.jiehang.utils.ResultSetMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlogCategoryDaoImpl extends JdbcDaoSupport implements BlogCategoryDao{
    private static final String QUERY_CATEGORY_SQL = "select * from blog_category limit 0, 5";

    public int insertUser(BlogCategory blogCategory) {
        return this.getJdbcTemplate().update("insert into blog_category (NAME , DESCRIPT)  values (?, ?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setObject(1, "222");
                preparedStatement.setObject(2, "2222");
            }
        });
    }

    public List<BlogCategory> queryUser() {
        List<BlogCategory> blogCategoryList = this.getJdbcTemplate().query(QUERY_CATEGORY_SQL, new RowMapper<BlogCategory>() {
            public BlogCategory mapRow(ResultSet resultset, int i) throws SQLException {
                return (new FundMapper()).mapResultSet(resultset, i);
            }
        });
        return blogCategoryList;
    }

    public List<BlogCategory> queryUser1() {
        final List<BlogCategory> blogCategoryList = new ArrayList<BlogCategory>();
        this.getJdbcTemplate().query(QUERY_CATEGORY_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultset) throws SQLException {
                blogCategoryList.add((new FundMapper().mapResultSet(resultset, 0)));
            }
        });
        return blogCategoryList;
    }

    public List<BlogCategory> queryUser2() {
        List<BlogCategory> blogCategoryList = this.getJdbcTemplate().query(QUERY_CATEGORY_SQL, new ResultSetExtractor<List<BlogCategory>>() {
            public List<BlogCategory> extractData(ResultSet resultset) throws SQLException,
                    DataAccessException {
                List<BlogCategory> list = new ArrayList<BlogCategory>();
                while(resultset.next()) {
                    list.add((new FundMapper().mapResultSet(resultset, 0)));
                }
                return list;
            }
        });
        return blogCategoryList;

		/*String sql = "SELECT * FROM TSM_COUNT WHERE CREATED_AT > to_date('01-02-17 00:00:00','dd-MM-yy hh24:mi:ss')";
		final List<Fund> list = new ArrayList<Fund>();
		this.getJdbcTemplate().query(sql, new ResultSetExtractor<Fund>() {
			public Fund extractData(ResultSet resultset) throws SQLException,
					DataAccessException {
				while(resultset.next()) {
					list.add((new FundMapper().mapResultSet(resultset, 0)));
				}
				return null;
			}
		});
		return list;*/
    }

    /**
     * Spring4.x don't support this method, Instead of Using RowMapper to package datas into List.
     * @return
     */
    public List<BlogCategory> queryUser3() {
        return this.getJdbcTemplate().queryForList(QUERY_CATEGORY_SQL, BlogCategory.class);
    }

    /**
     * The same as above.
     * @return
     */
    public BlogCategory queryUser4() {
        return this.getJdbcTemplate().queryForObject(QUERY_CATEGORY_SQL, BlogCategory.class);
    }

    public Map<String, Object> queryUser5() {
        return this.getJdbcTemplate().queryForMap(QUERY_CATEGORY_SQL);
    }

    public void queryUser6() {
        SqlRowSet srs = this.getJdbcTemplate().queryForRowSet(QUERY_CATEGORY_SQL);
        while(srs.next()) {
            System.out.println("fundId: " + srs.getString("FUND_ID"));
        }
    }

    class FundMapper extends ResultSetHelper implements ResultSetMapper {
        public BlogCategory mapResultSet(ResultSet resultSet, int i)
                throws SQLException {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setName(getString(resultSet, "NAME"));
            blogCategory.setDescript(getString(resultSet, "DESCRIPT"));
            blogCategory.setCreatedAt(getTimestamp(resultSet, "CREATED_AT"));
            blogCategory.setCount(getInteger(resultSet, "COUNT"));
            return blogCategory;
        }
    }
}
