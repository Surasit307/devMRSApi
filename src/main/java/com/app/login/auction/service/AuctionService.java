package com.app.login.auction.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.app.login.auction.dto.UpdateAuctionImagesBase64Payload;
import com.app.login.auction.entity.ListAuction;
import com.app.login.auction.repository.ListAuctionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AuctionService {

	@Autowired
	ListAuctionRepository listAuctionRepository;

	public ListAuction saveImages(MultipartFile[] files, String auctionId) throws IOException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Optional<ListAuction> optionalListAuctionEntity = listAuctionRepository.findById(Integer.valueOf(auctionId));
		ListAuction listAuctionEntity = optionalListAuctionEntity.get();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			byte[] fileBytes = file.getBytes();

			Method setImageMethod = ListAuction.class.getMethod("setImage" + (i + 1), byte[].class);
			setImageMethod.invoke(listAuctionEntity, fileBytes);
		}
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
}
