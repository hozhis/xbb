package cn.dolphinsoft.glance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dolphinsoft.glance.entity.OrderItemEntity;

public interface OrderItemRepository extends
		JpaRepository<OrderItemEntity, Integer> {

	List<OrderItemEntity> findByOrderId(Integer orderId);

}
