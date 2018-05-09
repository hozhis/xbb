package cn.dolphinsoft.glance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dolphinsoft.glance.dto.FoodSearchDto;
import cn.dolphinsoft.glance.dto.FoodsDto;
import cn.dolphinsoft.glance.dto.ResultDto;
import cn.dolphinsoft.glance.service.FoodsService;

@Controller
@RequestMapping(value = "/foods")
public class FoodsController {

	@Autowired
	private FoodsService foodsService;

	@RequestMapping(value = "/index")
	public String index() {
		return "foods/index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<FoodsDto> search(@RequestBody FoodSearchDto dto) {
		return foodsService.search(dto);
	}

	/**
	 * 此接口仅供顾客端调用，无需登录
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, List<FoodsDto>>> searchAll(
			@RequestBody FoodSearchDto dto) {
		return foodsService.searchAll(dto);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto save(@RequestBody FoodsDto dto) {
		foodsService.save(dto);
		return new ResultDto("success", "保存成功", null);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto delete(@PathVariable Integer id) {
		foodsService.delete(id);
		return new ResultDto("success", "删除成功", null);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto update(@RequestBody FoodsDto dto) {
		foodsService.update(dto);
		return new ResultDto("success", "修改成功", null);
	}

}
