package com.zmj.bean;
/**
 * 交易类
 */
public class Transaction {

	private com.zmj.bean.Trader trader;
	private int year;
	private int value;

	public Transaction() {
	}

	public Transaction(com.zmj.bean.Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public com.zmj.bean.Trader getTrader() {
		return trader;
	}

	public void setTrader(com.zmj.bean.Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value="
				+ value + "]";
	}

}
