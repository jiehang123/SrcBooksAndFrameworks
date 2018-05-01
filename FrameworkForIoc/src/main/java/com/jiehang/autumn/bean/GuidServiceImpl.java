package com.jiehang.autumn.bean;

public class GuidServiceImpl implements GuidService {
	private GuidDao guidDao;
	private TradeDao tradeDao;

	@Override
	public void getGuid() {
		guidDao.getGuid();
	}

	@Override
	public void insertGuid() {
		guidDao.insertGuid();
	}

	@Override
	public void insertTrade(Trade trade) {
		tradeDao.insertTrade(trade);
	}
}
