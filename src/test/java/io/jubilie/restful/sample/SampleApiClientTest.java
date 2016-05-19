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
	public void testLogin() {
		
		String id = "jubilie@naver.com";
		String password = "jewii3ri";
		LoginResponse loginResponse = apiClient.login(id, password);
		logger.info(loginResponse.toString());
	}

}
