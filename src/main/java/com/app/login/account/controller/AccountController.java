package com.app.login.account.controller;

import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.app.login.account.dto.AccountIn;
import com.app.login.account.dto.NewpasswordIn;
import com.app.login.account.service.AccountService;
import com.app.login.common.dto.ApiStatusOut;
import com.app.login.common.dto.ResponseOut;
import com.app.login.common.utils.StopWatch;
import com.app.login.login.dto.LoginIn;
import com.app.login.login.dto.LogoutIn;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	private final Logger logger = LoggerFactory
			.getLogger(com.app.login.account.controller.AccountController.class);
	
	@PostMapping("/v/account") //Create Account
	public ResponseEntity<ResponseOut> createAccount(@RequestHeader Map<String, String> headers,
			@RequestBody(required = false) AccountIn body) {
		StopWatch watch = new StopWatch();
		ObjectMapper mapper = new ObjectMapper();
		logger.info(String.format("CreateAccount Controller Request Header: %s", headers.keySet().stream()
				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		try {
            if (body.getFirstname() == null || body.getFirstname() == "") { //Error ค่า Firstname = null
                apistatus.setCode("E4002");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter firstname is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getLastname() == null || body.getLastname() == "") { //Error ค่า Lastname = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter lastname is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getGender() == null || body.getGender() == "") { //Error ค่า Gender = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter gender is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getAddress() == null || body.getAddress() == "") { //Error ค่า Language = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter address is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getUsername() == null || body.getUsername() == "" ) { //Error ค่า Username = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter username is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getPassword() == null || body.getPassword() == "") { //Error ค่า Password = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter password is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getEmail() == null || body.getEmail() == "") { //Error ค่า Email = null
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter email is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            
			apistatus.setCode("S0000");
			apistatus.setBusinessMessage("Create Data Successful");
			apistatus.setDeveloperMessage("Success");
			response.setApiStatus(apistatus);
			response.setData((Map<String, Object>) accountService.create(body));
			logger.info(String.format("CreateAccount Controller Response: %s", mapper.writeValueAsString(response)));
			logger.info(String.format("CreateAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			apistatus.setCode("E5000");
			apistatus.setBusinessMessage("Service Not Available");
			apistatus.setDeveloperMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
  @GetMapping("/v1/account/{account_id}") //Select
  public ResponseEntity<ResponseOut> readAccount(@RequestHeader Map<String, String> headers, @PathVariable int account_id) {
      StopWatch watch = new StopWatch();
      ObjectMapper mapper = new ObjectMapper();
      logger.info(String.format("ReadAccount Controller Request Header: %s", headers.keySet().stream()
              .map(key -> key + ":" + headers.get(key))
              .collect(Collectors.joining(", ", "{", "}"))));
      ApiStatusOut apistatus = new ApiStatusOut();
      ResponseOut response = new ResponseOut();
      try {
          Map data = (Map<String, Object>)  accountService.read(account_id);
          if(data == null){
              apistatus.setCode("E404");
              apistatus.setBusinessMessage("Data not found");
              apistatus.setDeveloperMessage("Data not found");
              response.setApiStatus(apistatus);
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
          }
          apistatus.setCode("S0000");
          apistatus.setBusinessMessage("Query Data Successful");
          apistatus.setDeveloperMessage("Success");
          response.setApiStatus(apistatus);
          response.setData(data);
          logger.info(String.format("ReadAccount Controller Response: %s", mapper.writeValueAsString(response)));
          logger.info(String.format("ReadAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
          return ResponseEntity.status(HttpStatus.OK).body(response);
      } catch (Exception e) {
          apistatus.setCode("E5000");
          apistatus.setBusinessMessage("Service Not Available");
          apistatus.setDeveloperMessage(e.getMessage());
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
      }
      
  }
      @PutMapping("/v1/account") //Update message
  	 public ResponseEntity<ResponseOut> updateAccount(@RequestHeader Map<String, String> headers,
  			@RequestBody(required = false) AccountIn body) {
  		StopWatch watch = new StopWatch();
  		ObjectMapper mapper = new ObjectMapper();
  		logger.info(String.format("UpdateAccount Controller Request Header: %s", headers.keySet().stream()
  				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
  		ApiStatusOut apistatus = new ApiStatusOut();
  		ResponseOut response = new ResponseOut();
  		try {
  			Map data = (Map<String, Object>) accountService.update(body);
  			if (data == null) {
  				apistatus.setCode("E404");
  				apistatus.setBusinessMessage("Data not found");
  				apistatus.setDeveloperMessage("Data not found");
  				response.setApiStatus(apistatus);
  				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  			}
  			apistatus.setCode("S0000");
  			apistatus.setBusinessMessage("Update Data Successful");
  			apistatus.setDeveloperMessage("Success");
  			response.setApiStatus(apistatus);
  			response.setData(data);
  			logger.info(String.format("UpdateAccount Controller Response: %s", mapper.writeValueAsString(response)));
  			logger.info(String.format("UpdateAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
  			return ResponseEntity.status(HttpStatus.OK).body(response);
  		} catch (Exception e) {
  			apistatus.setCode("E5000");
  			apistatus.setBusinessMessage("Service Not Available");
  			apistatus.setDeveloperMessage(e.getMessage());
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  		}
  	}

  	@DeleteMapping("/v1/account/{account_id}") //Delete message
  	public ResponseEntity<ResponseOut> deleteAccount(@RequestHeader Map<String, String> headers,
  			@PathVariable int account_id) {
  		StopWatch watch = new StopWatch();
  		ObjectMapper mapper = new ObjectMapper();
  		logger.info(String.format("DeleteAccount Controller Request Header: %s", headers.keySet().stream()
  				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
  		ApiStatusOut apistatus = new ApiStatusOut();
  		ResponseOut response = new ResponseOut();
  		try {
  			apistatus.setCode("S0000");
  			apistatus.setBusinessMessage("Delete Data Successful");
  			apistatus.setDeveloperMessage("Success");
  			response.setApiStatus(apistatus);
  			response.setData((Map<String, Object>) accountService.delete(account_id));
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
      
  	
	  @PostMapping("/v1/login")
	  public ResponseEntity<ResponseOut> AccessLogin(@RequestHeader Map<String, String> headers, 
			  @RequestBody(required = false) LoginIn body) {
	      StopWatch watch = new StopWatch();
	      ObjectMapper mapper = new ObjectMapper();
	      logger.info(String.format("ValidLogin Controller Request Header: %s", headers.keySet().stream()
	              .map(key -> key + ":" + headers.get(key))
	              .collect(Collectors.joining(", ", "{", "}"))));
	      
	      ApiStatusOut apistatus = new ApiStatusOut();
	      ResponseOut response = new ResponseOut();
	      try {
	          Map data = (Map<String, Object>) 	accountService.userlogin(body);
	          //Login login = new Login();
	          if(data == null){
	              apistatus.setCode("E404");
	              apistatus.setBusinessMessage("Password Invalid.");
	              apistatus.setDeveloperMessage("Password Invalid.");
	              response.setApiStatus(apistatus);
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	          }

	            if (body.getUsername() == null) { //Error ค่า Username = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("Username Invalid");
	                apistatus.setDeveloperMessage("parameter username is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	            
	            if (body.getPassword() == null) { //Error ค่า Password = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("Password Invalid");
	                apistatus.setDeveloperMessage("parameter password is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	            
	        	  
	          apistatus.setCode("S0000");
	          apistatus.setBusinessMessage("Login Successful");
	          apistatus.setDeveloperMessage("Success");
	          response.setApiStatus(apistatus);
	          response.setData(data);
	          logger.info(String.format("ReadAccount Controller Response: %s", mapper.writeValueAsString(response)));
	          logger.info(String.format("ReadAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
	          return ResponseEntity.status(HttpStatus.OK).body(response);
	          
	      } catch (Exception e) {
	    	  //e.printStackTrace();
	          apistatus.setCode("E5000");
	          apistatus.setBusinessMessage("Your username or password is inccorect");
	          apistatus.setDeveloperMessage("parameter Username is null");
	          response.setApiStatus(apistatus);
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	      }
	    
      
  }
	  
	  @PostMapping("/v1/logout") //Logout
	  public ResponseEntity<ResponseOut> AccessLogout(@RequestHeader Map<String, String> headers, 
			  @RequestBody(required = false) LogoutIn body) {
	      StopWatch watch = new StopWatch();
	      ObjectMapper mapper = new ObjectMapper();
	      logger.info(String.format("ValidLogin Controller Request Header: %s", headers.keySet().stream()
	              .map(key -> key + ":" + headers.get(key))
	              .collect(Collectors.joining(", ", "{", "}"))));
	      
	      ApiStatusOut apistatus = new ApiStatusOut();
	      ResponseOut response = new ResponseOut();
	      

	      try {
	    	  
	          Map data = (Map<String, Object>) 	accountService.userlogout(body);
	         
	          if(data == null){
	              apistatus.setCode("E404");
	              apistatus.setBusinessMessage("Data not found");
	              apistatus.setDeveloperMessage("Data not found");
	              response.setApiStatus(apistatus);
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	          }
	          
	            /*if (body.getLoginId() == 0) { //Error ค่า LoginId = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("LoginId Invalid");
	                apistatus.setDeveloperMessage("parameter logid_id is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }*/
	            
	            if (body.getUsername() == null) { //Error ค่า Username = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("Username Invalid");
	                apistatus.setDeveloperMessage("parameter username is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	        	  
	          apistatus.setCode("S0000");
	          apistatus.setBusinessMessage("Logout Successful");
	          apistatus.setDeveloperMessage("Success");
	          response.setApiStatus(apistatus);
	          response.setData(data);
	          logger.info(String.format("Logout Controller Response: %s", mapper.writeValueAsString(response)));
	          logger.info(String.format("Logout Controller elapse time %.4f seconds", watch.elapsedTime()));
	          return ResponseEntity.status(HttpStatus.OK).body(response);
	          
	      } catch (Exception e) {
	          apistatus.setCode("E5000");
	          apistatus.setBusinessMessage("Service Not Available");
	          apistatus.setDeveloperMessage(e.getMessage());
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	      }
	  }
	  
	  
	  @PostMapping("/v1/newpassword") //New Password
	  public ResponseEntity<ResponseOut> Newpassword(@RequestHeader Map<String, String> headers, 
			  @RequestBody(required = false) NewpasswordIn body) {
	      StopWatch watch = new StopWatch();
	      ObjectMapper mapper = new ObjectMapper();
	      logger.info(String.format("ValidLogin Controller Request Header: %s", headers.keySet().stream()
	              .map(key -> key + ":" + headers.get(key))
	              .collect(Collectors.joining(", ", "{", "}"))));
	      
	      ApiStatusOut apistatus = new ApiStatusOut();
	      ResponseOut response = new ResponseOut();
	     
	      try {
	    	  
	          Map data = (Map<String, Object>) 	accountService.newpass(body);
	          
	          if(data == null){
	              apistatus.setCode("E404");
	              apistatus.setBusinessMessage("Data not found");
	              apistatus.setDeveloperMessage("Data not found");
	              response.setApiStatus(apistatus);
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	          }
	          
	            if (body.getUsername() == null) { //Error ค่า Username = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("Username Invalid");
	                apistatus.setDeveloperMessage("parameter Username is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	          
	            if (body.getPassword() == null) { //Error ค่า Password = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("Password Invalid");
	                apistatus.setDeveloperMessage("parameter Password is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	            
	            if (body.getNewpassword() == null) { //Error ค่า NewPassword = null
	                apistatus.setCode("E4003");
	                apistatus.setBusinessMessage("New Password Invalid");
	                apistatus.setDeveloperMessage("parameter Newpassword is missing");
	                response.setApiStatus(apistatus);
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	          Map data2 = (Map<String, Object>) accountService.changepass(body);
	          apistatus.setCode("S0000");
	          apistatus.setBusinessMessage("Change New Password Successful");
	          apistatus.setDeveloperMessage("Success");
	          response.setApiStatus(apistatus);
	          response.setData(data);
	          response.setData2(data2);
	          logger.info(String.format("New Password  Controller Response: %s", mapper.writeValueAsString(response)));
	          logger.info(String.format("New Password Controller elapse time %.4f seconds", watch.elapsedTime()));
	          return ResponseEntity.status(HttpStatus.OK).body(response);
	          
	      } catch (Exception e) {
	    	  e.printStackTrace();
	          apistatus.setCode("E5000");
	          apistatus.setBusinessMessage("Service Not Available");
	          apistatus.setDeveloperMessage(e.getMessage());
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	          
	      }
	  }
	  
	  
}
  

