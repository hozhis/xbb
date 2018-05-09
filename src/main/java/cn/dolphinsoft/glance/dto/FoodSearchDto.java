package cn.dolphinsoft.glance.dto;

import java.io.Serializable;

public class FoodSearchDto implements Serializable {

	private static final long serialVersionUID = -9195011573591387283L;

	private String foodName;

	private Long price;

	private String type;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
