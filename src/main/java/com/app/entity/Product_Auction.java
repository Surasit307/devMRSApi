package com.app.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Auction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_product;
	private Integer id_history;
	private String product_name;
	private BigDecimal auction_price;
	private BigDecimal bid_price;
	private BigDecimal current_price;
	private String username;
	private Timestamp date_start_auction;
	private Timestamp date_end_auction;
	
	
	

}
