package com.fashionkings.core.service;

import java.util.Optional;
import java.util.Random;

import javax.persistence.criteria.Expression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionkings.core.dto.ItemToAdd;
import com.fashionkings.core.jpa.Customer;
import com.fashionkings.core.jpa.Order;
import com.fashionkings.core.jpa.Order.OrderStatus;
import com.fashionkings.core.jpa.OrderItem;
import com.fashionkings.core.jpa.Product;
import com.fashionkings.core.repository.CustomerRepository;
import com.fashionkings.core.repository.OrderRepository;
import com.fashionkings.core.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public Order findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order addItem(ItemToAdd itemToAdd) {
		Order order;
		Customer customer = customerRepo.findById(itemToAdd.getCustomerId())
				                        .orElseThrow();
		Optional<Order> optional = orderRepo.findByStatusAndCustomer(
				Order.OrderStatus.OPEN, customer);		
		if(optional.isPresent()) {
			order = optional.get();
		} else {
			Random random = new Random();
			order = new Order();
			order.setCustomer(customer);
			order.setOrderNumber("OR"+ random.nextInt(1, 10000));
			customer.addOrder(order);
		}		
		Product product = productRepo.findById(itemToAdd.getProductId())
								     .orElseThrow();
		OrderItem orderItem = 
			order.getItems().stream()
				 .filter(item -> item.getProduct().getId() == product.getId())
				 .reduce((a, b) -> {
			        throw new IllegalStateException("Duplicate product in order: " + a + ", " + b);
			      })
				 .orElse(null); 
		if (orderItem == null) {
			orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setPrice(product.getPrice());
			orderItem.setProduct(product);
			orderItem.setDiscount(product.getDiscountPercent());
			orderItem.setQuantity(1);
		} else {
			orderItem.setQuantity(orderItem.getQuantity() + 1);
		}
		product.addOrderItem(orderItem);
		orderItem.setProduct(product);
		return orderRepo.saveAndFlush(order);		
	}

	@Override
	public boolean removeItem(long orderId, long itemId, boolean delete) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		if(!Order.OrderStatus.OPEN.equals(order.getStatus())) {
			throw new IllegalStateException("You can only cancle open orders");
		}
		order.getItems().stream().forEach(item -> {
			if(item.getId() == itemId) {
				if(!delete && item.getQuantity() > 1) {
					item.setQuantity(item.getQuantity() - 1);
				} else {
					item.setDeleted(true);
				}
			}
		});
		orderRepo.save(order);
		return true;
	}

	@Override
	public boolean changeOrderStatus(long id, Order.OrderStatus status) {
		Order order = orderRepo.findById(id).orElseThrow();
		switch(status) {
			case CANCELED: 
				if(!Order.OrderStatus.OPEN.equals(order.getStatus())) {
					throw new IllegalStateException("You can only cancle open orders");
				}
				order.setStatus(status);
				break;
			case PROCESSING: 
			case DELIVERED: 
			case CONFIRMED: 
				order.setStatus(status);
				break;
			default: 
				throw new IllegalStateException("Invalid order status");
				
		}
		orderRepo.save(order);
		return true;
	}

	@Override
	public Order findByStatusAndCustomerId(OrderStatus status, long customerId) {
		Order order = orderRepo.findByStatusAndCustomerId(status, customerId)
							   .orElseThrow();
		return order;
	}
	
	

	

}
