package io.jubilie.restful.sample;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-applicationContext.xml"})
public class SampleApiClientTest {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SampleApiClient apiClient;
	
	@Test
	public void testUser() {
		UserRequest request = new UserRequest();
		String id = "id@jubilie.io";
		request.setId(id);
		request.setName("jubilie");
		
		UserResponse createResponse = apiClient.createUser(request);
		logger.debug(createResponse.toString());

		request.setName("rename jubilie");
		UserResponse updateResponse = apiClient.updateUser(request);
		logger.debug(updateResponse.toString());
		
		UserResponse getResponse = apiClient.getUser(id);
		logger.debug(getResponse.toString());
		
		UserResponse deleteResponse = apiClient.deleteUser(id);
		logger.debug(deleteResponse.toString());
	}
}
