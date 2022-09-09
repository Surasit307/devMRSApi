package com.app.login.auction.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_auction")
public class ListAuction {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "username")
	private String username;

	@Column(name = "price")
	private Double price;

	@Column(name = "time")
	private Date time;

	@Column(name = "date")
	private Timestamp date;

	@Column(name = "price_winner")
	private Timestamp priceWinner;

	@Column(name = "view")
	private int view;

	@Column(name = "user_bid")
	private String userBid;

	@Column(name = "id_product")
	private String idProduct;

	@Column(name = "image_1")
	private byte[] image1;

	@Column(name = "image_2")
	private byte[] image2;

	@Column(name = "image_3")
	private byte[] image3;

	@Column(name = "image_4")
	private byte[] image4;

	@Column(name = "image_5")
	private byte[] image5;

	@Column(name = "video_1")
	private byte[] video1;

	@Column(name = "video_2")
	private byte[] video2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getPriceWinner() {
		return priceWinner;
	}

	public void setPriceWinner(Timestamp priceWinner) {
		this.priceWinner = priceWinner;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getUserBid() {
		return userBid;
	}

	public void setUserBid(String userBid) {
		this.userBid = userBid;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public byte[] getImage3() {
		return image3;
	}

	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}

	public byte[] getImage4() {
		return image4;
	}

	public void setImage4(byte[] image4) {
		this.image4 = image4;
	}

	public byte[] getImage5() {
		return image5;
	}

	public void setImage5(byte[] image5) {
		this.image5 = image5;
	}

	public byte[] getVideo1() {
		return video1;
	}

	public void setVideo1(byte[] video1) {
		this.video1 = video1;
	}

	public byte[] getVideo2() {
		return video2;
	}

	public void setVideo2(byte[] video2) {
		this.video2 = video2;
	}
}
