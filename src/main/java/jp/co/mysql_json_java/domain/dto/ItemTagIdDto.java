package jp.co.mysql_json_java.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品タグID一覧 JSON型（DB値）→ List型（Java）変換用
 *
 * @author CHI-3
 *
 */
@Data
public class ItemTagIdDto {
	/** 商品タグID一覧 */
	@JsonProperty("itemTags")
	private List<Integer> itemTagIds;
}
