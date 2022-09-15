package io.codemalone.pattern.singleton;

import java.io.Serializable;

public class SingletonBillPugh implements Serializable{
	
	private static final long serialVersionUID = -766932017737115L;

	private SingletonBillPugh() {
	}
	
	private static class SingletonHelper{
		private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
	}
	
	public static SingletonBillPugh getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
