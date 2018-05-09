package cn.dolphinsoft.glance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dolphinsoft.glance.dto.FoodSearchDto;
import cn.dolphinsoft.glance.dto.FoodsDto;
import cn.dolphinsoft.glance.entity.FoodsEntity;
import cn.dolphinsoft.glance.repository.FoodsRepository;
import cn.dolphinsoft.glance.service.FoodsService;

@Service
public class FoodsServiceImpl implements FoodsService {

	@Autowired
	private FoodsRepository foodsRepository;

	@Override
	public void save(FoodsDto dto) {
		FoodsEntity entity = new FoodsEntity();
		entity.setFoodName(dto.getFoodName());
		entity.setPrice(dto.getPrice());
		entity.setDescription(dto.getDescription());
		entity.setType(dto.getType());
		foodsRepository.save(entity);
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		foodsRepository.deleteById(id);
	}

	@Override
	public void update(FoodsDto dto) {
		FoodsEntity entity = new FoodsEntity();
		entity.setId(dto.getId());
		entity.setFoodName(dto.getFoodName());
		entity.setPrice(dto.getPrice());
		entity.setDescription(dto.getDescription());
		entity.setType(dto.getType());
		foodsRepository.save(entity);
	}

	@Override
	public List<FoodsDto> search(FoodSearchDto dto) {
		List<FoodsDto> returnList = new ArrayList<FoodsDto>();
		List<FoodsEntity> entities = foodsRepository.findAll();
		for (FoodsEntity entity : entities) {
			if (StringUtils.isNotBlank(dto.getFoodName())) {
				if (entity.getFoodName().contains(dto.getFoodName())) {
					returnList.add(convertEntity2Dto(entity));
				}
			} else {
				returnList.add(convertEntity2Dto(entity));
			}
		}
		return returnList;
	}

	@Override
	public List<Map<String, List<FoodsDto>>> searchAll(FoodSearchDto dto) {
		Map<String, List<FoodsDto>> map = new HashMap<String, List<FoodsDto>>();
		List<FoodsDto> list = search(dto);
		for (FoodsDto foodsDto : list) {
			if (!map.containsKey(foodsDto.getType())) {
				map.put(foodsDto.getType(), new ArrayList<FoodsDto>());
			}
			map.get(foodsDto.getType()).add(foodsDto);
		}
		List<Map<String, List<FoodsDto>>> returnList = new ArrayList<Map<String, List<FoodsDto>>>();
		returnList.add(map);
		return returnList;
	}

	private FoodsDto convertEntity2Dto(FoodsEntity entity) {
		FoodsDto dto = new FoodsDto();
		dto.setDescription(entity.getDescription());
		dto.setFoodName(entity.getFoodName());
		dto.setId(entity.getId());
		dto.setPrice(entity.getPrice());
		dto.setType(entity.getType());
		return dto;
	}

}
