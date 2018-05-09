package cn.dolphinsoft.glance.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = -4827486234617058559L;

	private Integer orderId;

	private Integer loginId;

	private Integer tableNumber;

	private Long totalPrice;

	private String status;// 0 - 已创建待接单状态, 1 - 已接单待下厨状态, 2 - 已下厨待付款, 3 - 已付款

	private List<OrderItemDto> itemDtos;// 菜品信息

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItemDto> getItemDtos() {
		return itemDtos;
	}

	public void setItemDtos(List<OrderItemDto> itemDtos) {
		this.itemDtos = itemDtos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
