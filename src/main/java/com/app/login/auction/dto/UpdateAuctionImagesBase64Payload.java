package com.app.login.auction.dto;

import java.util.List;

public class UpdateAuctionImagesBase64Payload {
	private String auctionId;
	private List<String> fileImages;

	
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public List<String> getFileImages() {
		return fileImages;
	}
	public void setFileImages(List<String> fileImages) {
		this.fileImages = fileImages;
	}
}
