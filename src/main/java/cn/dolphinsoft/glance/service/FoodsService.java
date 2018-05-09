package cn.dolphinsoft.glance.service;

import java.util.List;
import java.util.Map;

import cn.dolphinsoft.glance.dto.FoodSearchDto;
import cn.dolphinsoft.glance.dto.FoodsDto;

public interface FoodsService {

	/**
	 * 保存食品信息
	 * 
	 * @param dto
	 */
	public void save(FoodsDto dto);

	public void delete(Integer id);

	public void update(FoodsDto dto);

	public List<FoodsDto> search(FoodSearchDto dto);

	public List<Map<String, List<FoodsDto>>> searchAll(FoodSearchDto dto);

}
