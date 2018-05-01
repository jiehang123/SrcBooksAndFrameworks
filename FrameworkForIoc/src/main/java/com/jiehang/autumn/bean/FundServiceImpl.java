package com.jiehang.autumn.bean;

public class FundServiceImpl implements FundService {
	private FundDao fundDao;

	@Override
	public void getFund() {
		fundDao.getFund();
	}

	@Override
	public void insertFund() {
		fundDao.insertFund();
	}

}
