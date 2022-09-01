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
	
	@Test
	public void testGetAllProducts() throws Exception
	{
		//1.create the dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/product/all");
		//2. execute the request and gets the result
		MvcResult result =mockmvc.perform(request).andReturn();
		
		//3. reads the response
		MockHttpServletResponse response=result.getResponse();
		
		//4. Test that response using assert method and status is 200 Ok
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		if(response.getContentAsString().isEmpty())
		{
			fail("No products there");
		}
	}
	
	@Test
	public void testGetOneProduct() throws Exception
	{
		//1. create the dummy request
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/product/one/4");
		
		//2. execute the request and get the result
		MvcResult result=mockmvc.perform(request).andReturn();
		
		//3. read the response
		MockHttpServletResponse response=result.getResponse();
		
		//4. test using assert method status is ok
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		//test content type matching
		assertEquals(MediaType.APPLICATION_JSON_VALUE,response.getContentType());
		//check the content length
		if(response.getContentAsString().isEmpty())
		{
			fail("No product found");
		}
	}
//	@Test
//	public void testGetOneProductNotFound()
//	{
//		
//	}
}
