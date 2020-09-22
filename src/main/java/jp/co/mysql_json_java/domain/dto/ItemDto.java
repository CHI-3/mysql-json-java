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
	/** 商品金額 */
	private Integer itemPrice;
	/** 商品説明 */
	private String itemExplanation;
	/** カテゴリ名 */
	private String categoryName;
	/** 商品タグ */
	private List<ItemTagDto> itemTags;

}
