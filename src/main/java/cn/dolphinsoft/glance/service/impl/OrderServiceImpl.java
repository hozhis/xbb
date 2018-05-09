package cn.dolphinsoft.glance.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dolphinsoft.glance.dto.OrderDto;
import cn.dolphinsoft.glance.dto.OrderItemDto;
import cn.dolphinsoft.glance.entity.OrderEntity;
import cn.dolphinsoft.glance.entity.OrderItemEntity;
import cn.dolphinsoft.glance.repository.FoodsRepository;
import cn.dolphinsoft.glance.repository.OrderItemRepository;
import cn.dolphinsoft.glance.repository.OrderRepository;
import cn.dolphinsoft.glance.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	FoodsRepository foodsRepository;

	@Transactional
	@Override
	public void save(OrderDto dto) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setLoginId(dto.getLoginId());
		orderEntity.setTableNumber(dto.getTableNumber());
		orderEntity.setStatus("0");
		orderRepository.save(orderEntity);

		Long totalPrice = 0L;

		List<OrderItemEntity> itemEntities = new ArrayList<OrderItemEntity>();
		for (OrderItemDto itemDto : dto.getItemDtos()) {
			OrderItemEntity itemEntity = new OrderItemEntity();
			itemEntity.setFoodId(itemDto.getFoodId());
			totalPrice += foodsRepository.findOne(itemDto.getFoodId())
					.getPrice().longValue()
					* itemDto.getQuantity();
			itemEntity.setOrderId(orderEntity.getOrderId());
			itemEntity.setQuantity(itemDto.getQuantity());
			itemEntities.add(itemEntity);
		}
		orderItemRepository.save(itemEntities);

		orderEntity.setTotalPrice(totalPrice);
		orderRepository.save(orderEntity);
	}

	@Override
	public List<OrderDto> search() {
		List<OrderDto> returnList = new ArrayList<OrderDto>();

		List<OrderEntity> orderEntities = orderRepository.findAll();

		OrderDto dto;
		List<OrderItemDto> itemDtos;
		List<OrderItemEntity> itemEntities;
		for (OrderEntity orderEntity : orderEntities) {
			dto = new OrderDto();
			Integer orderId = orderEntity.getOrderId();
			itemDtos = new ArrayList<OrderItemDto>();
			itemEntities = orderItemRepository.findByOrderId(orderId);
			OrderItemDto itemDto;
			for (OrderItemEntity itemEntity : itemEntities) {
				itemDto = new OrderItemDto();
				itemDto.setFoodId(itemEntity.getFoodId());
				itemDto.setFoodName(foodsRepository.findOne(
						itemEntity.getFoodId()).getFoodName());
				itemDto.setQuantity(itemEntity.getQuantity());
				itemDtos.add(itemDto);
			}

			dto.setOrderId(orderEntity.getOrderId());
			dto.setTableNumber(orderEntity.getTableNumber());
			dto.setTotalPrice(orderEntity.getTotalPrice());
			dto.setItemDtos(itemDtos);
			dto.setStatus(orderEntity.getStatus());
			returnList.add(dto);
		}

		return returnList;
	}

}
