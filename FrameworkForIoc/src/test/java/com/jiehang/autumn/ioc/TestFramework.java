package com.jiehang.autumn.ioc;

import com.jiehang.autumn.bean.SimpleController;
import com.jiehang.autumn.bean.SimpleProcessor;
import com.jiehang.autumn.bean.Trade;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFramework {
	
	private static SimpleController controller;
	private static SimpleProcessor processor;
	
	@BeforeClass
	public static void init() {
		FrameworkContainer.init("autumnContext.xml");
		controller = (SimpleController) FrameworkContainer.getComponment("simpleController");
		processor = (SimpleProcessor) FrameworkContainer.getComponment("simpleProcessor");
	}
	
	@Test
	public void testController() {
		controller.insertFund();
		controller.getFund();
	}
	
	@Test
	public void testProcessor() {
		processor.insertGuid(new Trade("Test_id", "Test_name"));
		processor.getGuid();
	}
}
