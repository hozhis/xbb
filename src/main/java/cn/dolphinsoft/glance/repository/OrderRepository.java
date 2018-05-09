package cn.dolphinsoft.glance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.dolphinsoft.glance.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	
}
