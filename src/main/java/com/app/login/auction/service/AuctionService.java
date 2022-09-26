package com.app.login.auction.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.app.entity.Account;
import com.app.login.auction.dto.UpdateAuctionImagesBase64Payload;
import com.app.login.auction.entity.ListAuction;
import com.app.login.auction.repository.ListAuctionRepository;

import org.apache.commons.lang3.time.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AuctionService {

	@Autowired
	ListAuctionRepository listAuctionRepository;
	

    public List<ListAuction> getAllListAuction() {
    	List<ListAuction> listauction = listAuctionRepository.findAll();
        return listauction;
    }
    
    public List<ListAuction> getVideoNotNull() {
    	List<ListAuction> listauction = listAuctionRepository.getVideoNotNull();
        return listauction;
    }
    
//	public ListAuction saveImages(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
//			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
//		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
//		SimpleDateFormat dateFormatter = new SimpleDateFormat ("dd-MM-yyyy");
//		for (int i = 0; i < files.length; i++) {
//			MultipartFile file = files[i];
//			byte[] fileBytes = file.getBytes();
//
//			Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
//			setImageMethod.invoke(listAuctionEntity, fileBytes);
//		}
//		listAuctionEntity.setId(Integer.valueOf(auctionId));
//		return listAuctionRepository.save(listAuctionEntity);
//	}
	
	public ListAuction saveImage1(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setImageMethod = ListAuction.class.getMethod("setImage" + (1), byte[].class);
		setImageMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	
	public ListAuction saveImage2(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setImageMethod = ListAuction.class.getMethod("setImage" + (2), byte[].class);
		setImageMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	
	public ListAuction saveImage3(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setImageMethod = ListAuction.class.getMethod("setImage" + (3), byte[].class);
		setImageMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	
	public ListAuction saveImage4(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setImageMethod = ListAuction.class.getMethod("setImage" + (4), byte[].class);
		setImageMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	
	public ListAuction saveImage5(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setImageMethod = ListAuction.class.getMethod("setImage" + (5), byte[].class);
		setImageMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	public ListAuction saveVideo1(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setVideoMethod = ListAuction.class.getMethod("setVideo" + (1), byte[].class);
		setVideoMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
		
	}
	
	public ListAuction saveVideo2(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		SimpleDateFormat dateFormatter = new SimpleDateFormat ("dd-MM-yyyy");
		//for (int i = 0; i < files.length; i++) {
		MultipartFile file = files[0];
		byte[] fileBytes = file.getBytes();

		//	Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
		Method setVideoMethod = ListAuction.class.getMethod("setVideo" + (2), byte[].class);
		setVideoMethod.invoke(listAuctionEntity, fileBytes);
		listAuctionEntity.setId(Integer.valueOf(auctionId));
		return listAuctionRepository.save(listAuctionEntity);
	}
	
	public ListAuction saveImagesBase64(UpdateAuctionImagesBase64Payload payload) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository
				.findById(Integer.valueOf(payload.getAuctionId()));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		List<String> fileImages = payload.getFileImages();
		for (int i = 0; i < fileImages.size(); i++) {
			String fileUrlBase64 = fileImages.get(i);
			int index64 = fileUrlBase64.lastIndexOf("base64");
			String fileBase64 = fileUrlBase64.substring(index64 + 7);
			byte[] decodedBytes = Base64.getDecoder().decode(fileBase64);

			Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
			setImageMethod.invoke(listAuctionEntity, decodedBytes);
		}
		listAuctionEntity.setId(Integer.valueOf(payload.getAuctionId()));
		return listAuctionRepository.save(listAuctionEntity);
	}


public ListAuction saveListAuction(String auctionId , String username , String productId, String productName ,
		String price , String userBid , String priceWinner , String view) throws IOException, NoSuchMethodException,
		SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
	ListAuction listAuctionEntity = optionalListAuctionEntity.get();
	Date date = new Date();
	listAuctionEntity.setId(Integer.valueOf(auctionId));
	listAuctionEntity.setUsername(String.valueOf(username));
	listAuctionEntity.setIdProduct(auctionId);
	listAuctionEntity.setProductName(String.valueOf(productName));
	listAuctionEntity.setPrice(Double.valueOf(price));
	listAuctionEntity.setUserBid(String.valueOf(userBid));
	listAuctionEntity.setPriceWinner(Double.valueOf(priceWinner));
	listAuctionEntity.setTime(LocalTime.now());
	listAuctionEntity.setDate(date);
	listAuctionEntity.setView(Integer.valueOf(view));
	return listAuctionRepository.save(listAuctionEntity);
}



}
