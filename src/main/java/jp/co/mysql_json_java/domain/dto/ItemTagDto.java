package jp.co.mysql_json_java.domain.dto;

import lombok.Data;

/**
 * 商品タグ
 *
 * @author CHI-3
 *
 */
@Data
public class ItemTagDto {
	/** 商品タグID */
	private Integer tagId;
	/** 商品タグ名 */
	private String tagName;
}
