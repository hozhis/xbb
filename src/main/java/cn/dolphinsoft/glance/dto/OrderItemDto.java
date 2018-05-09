package cn.dolphinsoft.glance.dto;

import java.io.Serializable;

public class OrderItemDto implements Serializable {

	private static final long serialVersionUID = -4198556623492723884L;

	private Integer foodId;

	private String foodName;

	private Integer quantity;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
