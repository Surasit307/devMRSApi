package com.app.login.auction.controller;

import com.app.login.auction.dto.UpdateAuctionImagesBase64Payload;
import com.app.login.auction.entity.ListAuction;
import com.app.login.auction.service.AuctionService;
import com.app.login.common.dto.ApiStatusOut;
import com.app.login.common.dto.ResponseOut;
import com.app.login.common.utils.ObjectMapperUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/api")
public class AuctionController {

	private final Logger logger = LoggerFactory.getLogger(AuctionController.class);

	@Autowired
	AuctionService auctionService;

	@PostMapping(path = "/v1/updateAuctionImages")
	public ResponseEntity<ResponseOut> updateAuctionImages(@RequestParam("fileImage") MultipartFile[] files,
			@RequestParam("auctionId") String auctionId) {
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		try {
			if (files == null || files.length <= 0) {
				apistatus.setDeveloperMessage("no files to upload");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			if (files.length > 5) {
				apistatus.setDeveloperMessage("maximun files upload is 5");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			ListAuction result = auctionService.saveImages(files, auctionId);

			apistatus.setDeveloperMessage("uploadAuctionImages Success");
			response.setData(ObjectMapperUtils.classModelToMap(result));
			response.setApiStatus(apistatus);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception ex) {
			ex.printStackTrace();
			apistatus.setDeveloperMessage(ex.getMessage());
			response.setApiStatus(apistatus);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping(path = "/v1/updateAuctionImagesBase64")
	public ResponseEntity<ResponseOut> updateAuctionImagesBase64(
			@RequestBody UpdateAuctionImagesBase64Payload payload) {
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		try {
			if (payload.getFileImages() == null || payload.getFileImages().size() <= 0) {
				apistatus.setDeveloperMessage("no files to upload");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			if (payload.getFileImages() == null || payload.getFileImages().size() > 5) {
				apistatus.setDeveloperMessage("maximun files upload is 5");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			ListAuction result = auctionService.saveImagesBase64(payload);

			apistatus.setDeveloperMessage("updateAuctionImagesBase64 Success");
			response.setData(ObjectMapperUtils.classModelToMap(result));
			response.setApiStatus(apistatus);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception ex) {
			ex.printStackTrace();
			apistatus.setDeveloperMessage(ex.getMessage());
			response.setApiStatus(apistatus);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
