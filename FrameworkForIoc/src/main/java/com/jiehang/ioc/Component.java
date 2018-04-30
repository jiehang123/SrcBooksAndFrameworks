package com.jiehang.ioc;

import java.util.List;

public class Component {
	private String clazz;
	private List<String> refList;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public List<String> getRefList() {
		return refList;
	}
	public void setRefList(List<String> refList) {
		this.refList = refList;
	}
	Component(String clazz, List<String> refList) {
		super();
		this.clazz = clazz;
		this.refList = refList;
	}
}