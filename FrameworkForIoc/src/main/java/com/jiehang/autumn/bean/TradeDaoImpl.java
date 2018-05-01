package com.jiehang.autumn.bean;

public class TradeDaoImpl implements TradeDao {
	@Override
	public void insertTrade(Trade trade) {
		System.out.println(trade.toString());
	}

}
