package com.jiehang.autumn.bean;

/**
 * /**
 * they are test Controllers, services and daos.
 * @author a620824
 *
 */
public class SimpleProcessor {
	private GuidService guidService;

	public void getGuid() {
		guidService.getGuid();
	}
	public void insertGuid(Trade trade) {
		guidService.insertGuid();
		guidService.insertTrade(trade);
	}
}

