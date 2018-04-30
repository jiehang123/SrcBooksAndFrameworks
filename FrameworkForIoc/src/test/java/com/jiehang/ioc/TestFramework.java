package com.jiehang.ioc;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFramework {
	
	private static SimpleController controller; 
	private static SimpleProcessor processor;
	
	@BeforeClass
	public static void init() {
		FrameworkContainer.init();
		controller = (SimpleController) FrameworkContainer.getComponment("controller");
		processor = (SimpleProcessor) FrameworkContainer.getComponment("processor");
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
