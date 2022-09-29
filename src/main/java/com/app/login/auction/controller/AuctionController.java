package com.app.login.auction.controller;

import com.app.entity.Account;
import com.app.login.auction.dto.UpdateAuctionImagesBase64Payload;
import com.app.login.auction.entity.ListAuction;
import com.app.login.auction.service.AuctionService;
import com.app.login.common.dto.ApiStatusOut;
import com.app.login.common.dto.ResponseOut;
import com.app.login.common.utils.ObjectMapperUtils;
import com.app.login.common.utils.StopWatch;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	  @GetMapping("v1/ListAuction")
	  public List<ListAuction> getAllListAuction(){
		  return auctionService.getAllListAuction();
	  }
	  
	  @GetMapping("v1/ListVideoNotNull")
	  public List<ListAuction> getVideoNotNull(){
		  return auctionService.getVideoNotNull();
	  }
	  
	  	
	  	@DeleteMapping("/v1/deleteAllAuction") //Delete message
	  	public ResponseEntity<ResponseOut> deleteAccount(@RequestHeader Map<String, String> headers,
	  			ListAuction listauction) {
	  		StopWatch watch = new StopWatch();
	  		ObjectMapper mapper = new ObjectMapper();
	  		logger.info(String.format("Delete All Auction Controller Request Header: %s", headers.keySet().stream()
	  				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
	  		ApiStatusOut apistatus = new ApiStatusOut();
	  		ResponseOut response = new ResponseOut();
	  		
	  		try {
	  			auctionService.deleteAllAuction(listauction);
	  			apistatus.setCode("S0000");
	  			apistatus.setBusinessMessage("Delete All Data Successful");
	  			apistatus.setDeveloperMessage("Success");
	  			response.setApiStatus(apistatus);
	  			logger.info(String.format("DeleteAccount Controller Response: %s", mapper.writeValueAsString(response)));
	  			logger.info(String.format("DeleteAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
	  			return ResponseEntity.status(HttpStatus.OK).body(response);
	  		} catch (Exception e) {
	  			apistatus.setCode("E5000");
	  			apistatus.setBusinessMessage("Service Not Available");
	  			apistatus.setDeveloperMessage(e.getMessage());
	  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	  		}
	  	}
	  	
	  
//	  @PostMapping(path = "/v1/updateAuctionImages")
//		public ResponseEntity<ResponseOut> updateAuctionImages(@RequestParam("fileImage") MultipartFile[] files,
//				@RequestParam("auctionId") String auctionId) {
//			ApiStatusOut apistatus = new ApiStatusOut();
//			ResponseOut response = new ResponseOut();
//			try {
//				if (files == null || files.length <= 0) {
//					apistatus.setDeveloperMessage("no files to upload");
//					response.setApiStatus(apistatus);
//					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//				}
//				if (files.length > 5) {
//					apistatus.setDeveloperMessage("maximun files upload is 5");
//					response.setApiStatus(apistatus);
//					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//				}
//				ListAuction result = auctionService.saveImages(files, auctionId);
//
//				apistatus.setDeveloperMessage("uploadAuctionImages Success");
//				response.setData(ObjectMapperUtils.classModelToMap(result));
//				response.setApiStatus(apistatus);
//				return ResponseEntity.status(HttpStatus.OK).body(response);
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				apistatus.setDeveloperMessage(ex.getMessage());
//				response.setApiStatus(apistatus);
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//			}
//		}

	  @PostMapping(path = "/v1/updateAuctionImages1")
		public ResponseEntity<ResponseOut> updateAuctionImages1(@RequestParam("fileImage") MultipartFile[] files,
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
				ListAuction result = auctionService.saveImage1(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionImages2")
	public ResponseEntity<ResponseOut> updateAuctionImages2(@RequestParam("fileImage") MultipartFile[] files,
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
			ListAuction result = auctionService.saveImage2(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionImages3")
	public ResponseEntity<ResponseOut> updateAuctionImages3(@RequestParam("fileImage") MultipartFile[] files,
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
			ListAuction result = auctionService.saveImage3(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionImages4")
	public ResponseEntity<ResponseOut> updateAuctionImages4(@RequestParam("fileImage") MultipartFile[] files,
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
			ListAuction result = auctionService.saveImage4(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionImages5")
	public ResponseEntity<ResponseOut> updateAuctionImages5(@RequestParam("fileImage") MultipartFile[] files,
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
			ListAuction result = auctionService.saveImage5(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionVideo1")
	public ResponseEntity<ResponseOut> updateAuctionVideo1(@RequestParam("fileVideo") MultipartFile[] files,
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
			ListAuction result = auctionService.saveVideo1(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateAuctionVideo2")
	public ResponseEntity<ResponseOut> updateAuctionVideo2(@RequestParam("fileVideo") MultipartFile[] files,
			@RequestParam("auctionId") String auctionId) {
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		logger.info("Test");
		try {
			if (files == null || files.length <= 0) {
				apistatus.setDeveloperMessage("no files to upload");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			if (files.length > 1) {
				apistatus.setDeveloperMessage("maximun files upload is 1");
				response.setApiStatus(apistatus);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			ListAuction result = auctionService.saveVideo2(files, auctionId);

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
	
	@PostMapping(path = "/v1/updateListAuction")
	public ResponseEntity<ResponseOut> updateAuctionImages(@RequestParam("auctionId") String auctionId , 
			@RequestParam("productId") String productId, @RequestParam("username") String username ,
			 @RequestParam("productName") String productName , @RequestParam("price") String price , 
			 @RequestParam("userBid") String userBid ,@RequestParam("priceWinner") String priceWinner ,  @RequestParam("view") String view) {
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		try {
			ListAuction result = auctionService.saveListAuction(auctionId , username , productId , productName , price , userBid , priceWinner , view);

			apistatus.setDeveloperMessage("Update ListAuction Success");
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
