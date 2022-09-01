package com.muktai.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class TestProductRestController 
{
	@Autowired
	MockMvc mockmvc;
	
	@Test
	public void testSavePro() throws Exception
	{
		//1. create a dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.post("/product/save")
							  .contentType(MediaType.APPLICATION_JSON)
							  .content("{\"pname\":\"bike\",\"pcost\":\"20000\",\"pdescription\":"
							  		+ "\"This is good prodcut\"}");
		//2. execute the request  and generate the response
		MvcResult result =mockmvc.perform(request).andReturn();
		//3. read the response
		MockHttpServletResponse response=result.getResponse();
		//4. test the response
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		if(!response.getContentAsString().contains("Product Created"))
		{
			fail("Product not created!!!!");
		}
	}
}
