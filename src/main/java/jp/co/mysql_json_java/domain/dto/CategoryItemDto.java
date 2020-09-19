package jp.co.mysql_json_java.domain.dto;

import java.util.List;

import lombok.Data;

/**
 * カテゴリ別商品一覧
 *
 * @author CHI-3
 *
 */
@Data
public class CategoryItemDto {
	/** カテゴリID */
	private Integer categoryId;
	/** カテゴリ名 */
	private String categoryName;
	/** 商品一覧 */
	private List<ItemDetailDto> itemList;
	/** 商品数 */
	private Integer itemCount;
	/** 優先順位 */
	private Short ranking;
}
