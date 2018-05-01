package com.jiehang.autumn.bean;

/**
 * they are test Controllers, services and daos.
 * @author a620824
 *
 */
public class SimpleController {
	private FundService fundService;

	public void getFund() {
		fundService.getFund();
	}
	public void insertFund() {
		fundService.insertFund();
	}
}

