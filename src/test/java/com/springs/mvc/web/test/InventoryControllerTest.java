package com.springs.mvc.web.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.domain.Producto;
import com.spring.mvc.repository.InMemoryProductDao;
import com.spring.mvc.service.SimpleProductManager;
import com.spring.mvc.web.InventoryController;

import java.util.ArrayList;
import java.util.Map;

public class InventoryControllerTest {
	
	@Test
	public void testHandleRequestView() throws Exception{
		InventoryController controller = new InventoryController();
		SimpleProductManager spm = new SimpleProductManager();
		spm.setProductDao(new InMemoryProductDao(new ArrayList<Producto>()));
		controller.setProductManager(spm);
		//controller.setProductManager(new SimpleProductManager());
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