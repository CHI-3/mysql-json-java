package jp.co.mysql_json_java.domain.dto;

import java.util.List;

import lombok.Data;

/**
 * 商品
 *
 * @author CHI3
 *
 */
@Data
public class ItemDto {
	/** 商品ID */
	private Integer itemId;
	/** 商品名 */
	private String itemName;
	/** カテゴリ名 */
	private String categoryName;
	/** 商品タグ */
	private List<ItemTagDto> itemTags;

}
