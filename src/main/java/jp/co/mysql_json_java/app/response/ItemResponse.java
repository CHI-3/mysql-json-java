package jp.co.mysql_json_java.app.response;

import jp.co.mysql_json_java.domain.dto.ItemDto;
import lombok.Builder;
import lombok.Getter;

/**
 * 商品用レスポンスクラス
 *
 * @author CHI-3
 *
 */
@Getter
@Builder
public class ItemResponse {
	/** 商品 */
	private ItemDto item;
}
