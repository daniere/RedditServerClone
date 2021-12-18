package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Trade;
import com.example.demo.repository.TradeRepo;

@Service
public class TradeService {
@Autowired
private TradeRepo tradeRepo;

public void addTrade(Trade trade)
{
	tradeRepo.save(trade);
}
}
