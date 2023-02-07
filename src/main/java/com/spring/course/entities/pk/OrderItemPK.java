package com.spring.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.spring.course.entities.Order;
import com.spring.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product poduct;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	public Product getPoduct() {
		return poduct;
	}
	
	public void setPoduct(Product poduct) {
		this.poduct = poduct;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, poduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(poduct, other.poduct);
	}
	
	
}
