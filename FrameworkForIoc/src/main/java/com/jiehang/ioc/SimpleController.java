package com.jiehang.ioc;

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

interface FundService {
	void getFund();
	void insertFund();
}

class FundServiceImpl implements FundService {
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

interface FundDao {
	void getFund();
	void insertFund();
}

class FundDaoImpl implements FundDao {

	@Override
	public void getFund() {
		System.out.println("get a fund");
	}

	@Override
	public void insertFund() {
		System.out.println("insert a fund");
	}
	
}