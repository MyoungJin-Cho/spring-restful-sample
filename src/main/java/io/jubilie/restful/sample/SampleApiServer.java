package io.jubilie.restful.sample;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

@Controller
@RequestMapping("/dummy")
public class SampleApiServer {

	private Gson gson = new Gson();
	
	@RequestMapping(value = "/login/{id}/{password}", method= RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String login(@PathVariable String id, @PathVariable String password, 
			HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[dummyServer] id=" + id + ", password:" + password);
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setLoginToken(UUID.randomUUID().toString());
		loginResponse.setResponseCode(200);
	    return gson.toJson(loginResponse);
	}
	
	/*
	@RequestMapping(value = "/users/{token}/{deviceid}/{timestamp}/{type}/{param}", method= RequestMethod.PUT)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String myInfoModify(@PathVariable String token, @PathVariable String deviceid, 
			@PathVariable String timestamp, @PathVariable String type, @PathVariable String param,
			@RequestBody String body, HttpServletRequest request, HttpServletResponse response) {
	   String json = "";
	   return json;
	}
	*/
}
