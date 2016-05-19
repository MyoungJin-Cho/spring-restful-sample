package io.jubilie.restful.sample;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleApiClientImpl implements SampleApiClient {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("#{config['API_SERVER']}")
	public String API_SERVER;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private HttpEntity<String> createHttpEndtity() {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
		return httpEntity;
	}
	
	@Override
	public LoginResponse login(String id, String password) {
		
		logger.debug("login ==> id:" + id + ", password:" + password);
		HttpEntity<String> httpEntity = createHttpEndtity();
	    
		ResponseEntity<LoginResponse> result = restTemplate.exchange(API_SERVER + "/login/{id}/{password}", HttpMethod.GET, httpEntity, LoginResponse.class, id, password);
		
		return result.getBody();
	}

}
