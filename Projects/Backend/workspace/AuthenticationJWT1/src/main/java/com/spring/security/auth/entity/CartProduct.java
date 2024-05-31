package com.spring.security.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartProduct {

	
	@Id
	@SequenceGenerator(name = "cart_product_sequence", sequenceName = "cart_product_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_product_sequence")
	private Long cartProductId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private Product product;
	
	private Integer quantity = 1;
}
