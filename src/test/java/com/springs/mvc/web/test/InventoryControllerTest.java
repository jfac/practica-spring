package com.springs.mvc.web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.service.SimpleProductManager;
import com.springs.mvc.web.InventoryController;

import java.util.Map;

public class InventoryControllerTest {
	
	@Test
	public void testHandleRequestView() throws Exception{
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello",modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		//String nowValue = (String) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

}