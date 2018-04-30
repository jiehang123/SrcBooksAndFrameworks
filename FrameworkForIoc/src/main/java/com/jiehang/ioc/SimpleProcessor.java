package com.jiehang.ioc;

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

interface GuidService {
	void getGuid();
	void insertGuid();
	void insertTrade(Trade trade);
}

class GuidServiceImpl implements GuidService {
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

interface TradeDao {
	
	void insertTrade(Trade trade);
}

class TradeDaoImpl implements TradeDao{
	
	@Override
	public void insertTrade(Trade trade) {
		System.out.println(trade.toString());
	}
	
}

interface GuidDao {
	void getGuid();
	void insertGuid();
}

class GuidDaoImpl implements GuidDao {

	@Override
	public void getGuid() {
		System.out.println("GuidDaoImpl.getGuid");
	}

	@Override
	public void insertGuid() {
		System.out.println("GuidDaoImpl.insertGuid");
	}
	
}

class Trade {
	private String id;
	private String name;
	Trade(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", name=" + name + "]";
	}
}