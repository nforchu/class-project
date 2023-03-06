package com.fashionkings.core.service;

import javax.persistence.criteria.Expression;

import org.springframework.stereotype.Service;

import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public Order findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order addItem(long orderId, ItemToAdd item) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
