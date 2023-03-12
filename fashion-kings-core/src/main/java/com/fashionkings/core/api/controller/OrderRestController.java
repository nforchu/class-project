package com.fashionkings.core.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionkings.core.dto.Cart;
import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Order;
import com.fashionkings.core.jpa.Order.OrderStatus;
import com.fashionkings.core.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderRestController {
	
	private OrderService orderService;
	
	public OrderRestController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping(value = "add-item")
	@ResponseBody
	public ResponseEntity<?> addItem(@RequestBody ItemToAdd item) {
		Order order = orderService.addItem(item);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PostMapping(value = "remove-item")
	@ResponseBody
	public ResponseEntity<?> removeItem(@RequestParam long orderId, @RequestParam long itemId) {
		boolean removed = orderService.removeItem(orderId, itemId, false);
		return ResponseEntity.status(HttpStatus.OK).body(removed);
	}
	
	@DeleteMapping("delete-item")
	public ResponseEntity<?> deleteItem(@RequestParam long orderId, @RequestParam long itemId) {
		boolean removed = orderService.removeItem(orderId, itemId, true);
		return ResponseEntity.status(HttpStatus.OK).body(removed);
	}
	
	@PostMapping("{id}/checkout")
	public ResponseEntity<?> checkout(@PathVariable long id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.changeOrderStatus(id, OrderStatus.CONFIRMED));
	}
	
	@PostMapping("{id}/cancel")
	public ResponseEntity<?> cancel(@PathVariable long id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(orderService.changeOrderStatus(id, OrderStatus.CANCELED));
	}
	
	
	@GetMapping("open")
	public ResponseEntity<?> getOpenOrder(@RequestParam long customerId) {
		Cart cart = orderService.findByStatusAndCustomerId(OrderStatus.OPEN, customerId)
				                .toCart();
		return ResponseEntity.status(HttpStatus.OK).body(cart);
	}	
	
}
