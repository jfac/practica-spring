package com.springs.mvc.web.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.service.SimpleProductManager;
import com.springs.mvc.web.InventoryController;


public class PriceIncreaseFormControllerTest {
	
	@Test
	public void testHandleRequestView() throws Exception{
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView mav =  controller.handleRequest(null, null);
		assertEquals("priceincrease", mav.getViewName());
		assertNotNull(mav.getModel());
	}

}
