package jp.co.mysql_json_java.domain.dto;

import lombok.Data;

/**
 * 商品詳細
 *
 * @author CHI-3i
 *
 */
@Data
public class ItemDetailDto {
	/** 商品ID */
	private Integer itemId;
	/** 商品名 */
	private String itemName;
	/** 商品画像 */
	private String itemImage;
	/** 優先順位 */
	private Short ranking;
}
