package com.fashionkings.core.service;

import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Order;
import com.fashionkings.core.jpa.Order.OrderStatus;

public interface OrderService {
	
	Order findById(long id);
	Order addItem(ItemToAdd item);
	boolean removeItem(long orderId, long itemId, boolean delete);
	boolean changeOrderStatus(long id, Order.OrderStatus status);
	Order findByStatusAndCustomerId(Order.OrderStatus status, long customerId);

}
