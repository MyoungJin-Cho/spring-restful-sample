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
    public UserResponse createUser(UserRequest userRequest) {

        logger.debug("createUser ==> " + userRequest.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserRequest> httpEntity = new HttpEntity<UserRequest>(userRequest, headers);

        ResponseEntity<UserResponse> result = restTemplate.exchange(API_SERVER + "/user", HttpMethod.POST, httpEntity,
                UserResponse.class);

        return result.getBody();
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {

        logger.debug("updateUser ==> " + userRequest.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserRequest> httpEntity = new HttpEntity<UserRequest>(userRequest, headers);

        ResponseEntity<UserResponse> result = restTemplate.exchange(API_SERVER + "/user", HttpMethod.PUT, httpEntity,
                UserResponse.class);

        return result.getBody();
    }

    @Override
    public UserResponse getUser(String id) {

        logger.debug("getUser ==> id:" + id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<UserResponse> result = restTemplate.exchange(API_SERVER + "/user/{id}", HttpMethod.GET,
                httpEntity, UserResponse.class, id);

        return result.getBody();
    }

    @Override
    public UserResponse deleteUser(String id) {

        logger.debug("deleteUser ==> id:" + id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<UserResponse> result = restTemplate.exchange(API_SERVER + "/user/{id}", HttpMethod.DELETE,
                httpEntity, UserResponse.class, id);

        return result.getBody();
    }
}
