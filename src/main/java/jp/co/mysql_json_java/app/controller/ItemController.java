package jp.co.mysql_json_java.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jp.co.mysql_json_java.app.response.CategoryItemResponse;
import jp.co.mysql_json_java.app.response.ItemResponse;
import jp.co.mysql_json_java.domain.dto.CategoryItemDto;
import jp.co.mysql_json_java.domain.dto.ItemDto;
import jp.co.mysql_json_java.domain.service.ItemService;
import lombok.RequiredArgsConstructor;

/**
 * 商品取得用コントローラークラス
 *
 * @author CHI-3
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;

	/**
	 * カテゴリ別商品一覧を取得
	 *
	 * @param categoryId カテゴリID
	 * @return カテゴリ別商品一覧
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<CategoryItemResponse> getCategoryItem(@PathVariable("categoryId") Integer categoryId) throws JsonMappingException, JsonProcessingException {
		CategoryItemDto items = itemService.getCategoryItem(categoryId);
		CategoryItemResponse categoryItemResponse = CategoryItemResponse.builder().items(items).build();
		return new ResponseEntity<>(categoryItemResponse, HttpStatus.OK);
	}

	/**
	 * 商品を取得
	 *
	 * @param itemId 商品ID
	 * @return 商品
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("/indivisual/{itemId}")
	public ResponseEntity<ItemResponse> getItem(@PathVariable("itemId") Integer itemId) throws JsonMappingException, JsonProcessingException {
		ItemDto item = itemService.getItem(itemId);
		ItemResponse itemResponse = ItemResponse.builder().item(item).build();
		return new ResponseEntity<>(itemResponse, HttpStatus.OK);
	}

}
