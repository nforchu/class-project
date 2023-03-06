package com.fashionkings.core.service;

import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Order;

public interface OrderService {
	
	Order findById(long id);
	Order addItem(long orderId, ItemToAdd item);

}
