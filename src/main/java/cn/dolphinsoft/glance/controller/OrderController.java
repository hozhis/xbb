package cn.dolphinsoft.glance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dolphinsoft.glance.dto.OrderDto;
import cn.dolphinsoft.glance.service.OrderService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/index")
	public String index() {
		return "order/index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public void orderSave(@RequestBody OrderDto dto) {
		orderService.save(dto);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderDto> search() {
		return orderService.search();
	}

}
