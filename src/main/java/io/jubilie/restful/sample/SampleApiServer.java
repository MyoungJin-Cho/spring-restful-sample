package io.jubilie.restful.sample;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

@Controller
@RequestMapping
public class SampleApiServer {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Gson gson = new Gson();
	
	@RequestMapping(value = "/user", method= RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String createUser(@RequestBody UserRequest userRequest, 
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("[SampleApiServer] [" + request.getMethod() + "] " + userRequest.toString());
		
		UserResponse userResponse = new UserResponse();
		userResponse.setLoginToken(UUID.randomUUID().toString());
	    return gson.toJson(userResponse);
	}
	
	@RequestMapping(value = "/user", method= RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String updateUser(@RequestBody UserRequest userRequest, 
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("[SampleApiServer] [" + request.getMethod() + "] " + userRequest.toString());
		
		UserResponse userResponse = new UserResponse();
		userResponse.setLoginToken(UUID.randomUUID().toString());
	    return gson.toJson(userResponse);
	}
	
	@RequestMapping(value = "/user/{id}", method= RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String selectUser(@PathVariable String id, 
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("[SampleApiServer] [" + request.getMethod() + "] id:" + id);
		
		UserResponse userResponse = new UserResponse();
		userResponse.setLoginToken(UUID.randomUUID().toString());
	    return gson.toJson(userResponse);
	}
	
	@RequestMapping(value = "/user/{id}", method= RequestMethod.DELETE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String deleteUser(@PathVariable String id, 
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("[SampleApiServer] [" + request.getMethod() + "] id:" + id);
		
		UserResponse userResponse = new UserResponse();
	    return gson.toJson(userResponse);
	}
}
