package jp.co.mysql_json_java.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.mysql_json_java.constant.IsDeleted;
import jp.co.mysql_json_java.domain.dto.CategoryItemDto;
import jp.co.mysql_json_java.domain.dto.ItemDetailDto;
import jp.co.mysql_json_java.domain.dto.ItemDto;
import jp.co.mysql_json_java.domain.dto.ItemTagDto;
import jp.co.mysql_json_java.domain.dto.ItemTagIdDto;
import jp.co.mysql_json_java.domain.model.CategoryItemView;
import jp.co.mysql_json_java.domain.model.Item;
import jp.co.mysql_json_java.domain.model.ItemTag;
import jp.co.mysql_json_java.domain.repository.CategoryItemViewRepository;
import jp.co.mysql_json_java.domain.repository.ItemRepository;
import jp.co.mysql_json_java.domain.repository.ItemTagRepository;
import lombok.RequiredArgsConstructor;

/**
 * 商品取得に関するサービスクラス
 *
 * @author CHI-3
 *
 */
@Service
@RequiredArgsConstructor
public class ItemService {

	private final CategoryItemViewRepository categoryItemViewRepository;

	private final ItemRepository itemRepository;

	private final ItemTagRepository itemTagRepository;

	/** 件数がnullの場合に設定する用 */
	private final Integer ZERO = 0;

	/**
	 * カテゴリ毎に商品一覧を取得
	 *
	 * @param categoryId 商品カテゴリID
	 * @return 商品一覧（カテゴリ別）
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public CategoryItemDto getCategoryItem(Integer categoryId) throws JsonMappingException, JsonProcessingException {

		CategoryItemView itemsOrigin = categoryItemViewRepository.findByCategoryId(categoryId);
		CategoryItemDto items = new CategoryItemDto();

		if(itemsOrigin != null) {
			// DTOに詰め替え（必要な要素のみ取得）
			BeanUtils.copyProperties(itemsOrigin, items);
			// 商品詳細をJSON→Listに変換
			if(itemsOrigin.getItemList() != null) {
				ObjectMapper mapper = new ObjectMapper();
				List<ItemDetailDto> itemDetails = mapper.readValue(itemsOrigin.getItemList(), new TypeReference<List<ItemDetailDto>>() {});
				items.setItemList(itemDetails);
			}else {
				items.setItemList(Collections.emptyList());
			}
			// 商品数がnullの場合は0を設定
			items.setItemCount(Optional.ofNullable(items.getItemCount()).orElse(ZERO));
		}

		return items;

	}

	/**
	 * 商品ID毎に商品を取得
	 *
	 * @param itemId 商品ID
	 * @return 商品情報
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public ItemDto getItem(Integer itemId) throws JsonMappingException, JsonProcessingException {

		Item itemOrigin = itemRepository.findByItemId(itemId, IsDeleted.Off.isKey());
		ItemDto item = new ItemDto();

		if(itemOrigin != null) {
			BeanUtils.copyProperties(itemOrigin,item);
			// 商品カテゴリ名を取得
			item.setCategoryName(itemOrigin.getItemCategory().getCategoryName());
			// 商品タグIDをJSON→Listに変換して、データ検索
			ObjectMapper mapper = new ObjectMapper();
			List<Integer> itemTagIds = mapper.readValue(itemOrigin.getItemTag(), ItemTagIdDto.class).getItemTagIds();
			List<ItemTagDto> itemTags = new ArrayList<>();
			for(Integer itemTagId : itemTagIds) {
				ItemTag itemTagOrigin = itemTagRepository.findByTagId(itemTagId, IsDeleted.Off.isKey());
				if(itemTagOrigin != null) {
					ItemTagDto itemTag = new ItemTagDto();
					BeanUtils.copyProperties(itemTagOrigin, itemTag);
					itemTags.add(itemTag);
				}
			}
			item.setItemTags(itemTags);

		}

		return item;


	}

}
