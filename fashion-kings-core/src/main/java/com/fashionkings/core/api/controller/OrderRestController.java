package com.fashionkings.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Order;
import com.fashionkings.core.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderRestController {
	
	private OrderService orderService;
	
	public OrderRestController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping(value = "{id}/item")
	@ResponseBody
	public ResponseEntity<?> addItem(@PathVariable long id, 
									 @RequestBody ItemToAdd item) {
		Order order = orderService.addItem(id, item);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
}
