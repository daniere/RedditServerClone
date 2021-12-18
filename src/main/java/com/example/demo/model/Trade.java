package com.example.demo.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Trade {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long tradeId;
	private String symbol;
	private int qty;
	private int price;
	private Instant date;
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trade(Long tradeId, String symbol, int qty, int price, Instant date) {
		super();
		this.tradeId = tradeId;
		this.symbol = symbol;
		this.qty = qty;
		this.price = price;
		this.date = date;
	}
	public Long getTradeId() {
		return tradeId;
	}
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	
}

