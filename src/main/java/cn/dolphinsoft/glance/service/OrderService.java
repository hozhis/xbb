package cn.dolphinsoft.glance.service;

import java.util.List;

import cn.dolphinsoft.glance.dto.OrderDto;

public interface OrderService {

	public void save(OrderDto dto);

	public List<OrderDto> search();

}
