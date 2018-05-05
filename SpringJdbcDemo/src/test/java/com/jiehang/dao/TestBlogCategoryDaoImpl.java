package com.jiehang.dao;

import com.jiehang.bean.BlogCategory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestBlogCategoryDaoImpl {

    private static BlogCategoryDao blogCategoryDao;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_jdbc_demo.xml");
        blogCategoryDao = (BlogCategoryDao) context.getBean("blogCategoryDao");
    }

    @Test
    public void testQuery() {
        List<BlogCategory> list = blogCategoryDao.queryUser();
        System.out.println(list.toString());
    }

}
