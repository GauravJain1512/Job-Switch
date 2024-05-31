package com.spring.security.auth.service;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.Cart;
import com.spring.security.auth.entity.CartProduct;
import com.spring.security.auth.entity.Product;
import com.spring.security.auth.exception.ResourceNotFoundException;
import com.spring.security.auth.repository.CartProductRepository;
import com.spring.security.auth.repository.CartRepository;
import com.spring.security.auth.repository.ProductRepository;
import com.spring.security.auth.repository.UserRepository;

@Service
public class ConsumerService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartProductRepository cartProductRepository;
	
	public ResponseEntity<Object> addProductToCart(Long cartId, Long productId, Principal principal){
		
		Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Cart", "cartId", cartId));
		
		if(principal.getName().equals(cart.getUser().getEmail())) {
			Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "productId", productId));
			List<CartProduct> cartProducts = cart.getCartProducts();
			boolean isProductAvailableInCart = false;
			for(CartProduct cartProduct : cartProducts) {
				if(cartProduct.getProduct().getProductId().equals(productId)) {
					isProductAvailableInCart = true;
				}
			}
			
			if(isProductAvailableInCart) {
				Optional<CartProduct> optionalCartProduct = cartProducts.stream().filter(cp -> cp.getProduct().getProductId().equals(productId)).findFirst();
				if(optionalCartProduct.isPresent()) {
					CartProduct cartProduct = optionalCartProduct.get();
					cartProduct.setQuantity(cartProduct.getQuantity()+1);
					cart.getCartProducts().add(cartProduct);
				
				}
			}else {
				CartProduct cartProduct = new CartProduct();
				cartProduct.setProduct(product);
				cartProduct.setQuantity(1);
				cart.getCartProducts().add(cartProduct);
			}
			
			Cart savedCart = cartRepository.save(cart);
			return new ResponseEntity<Object>(savedCart, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Object>("Access Denied", HttpStatus.BAD_REQUEST);
		}
	}
}
