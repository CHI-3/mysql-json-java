package jp.co.mysql_json_java.app.response;

import jp.co.mysql_json_java.domain.dto.CategoryItemDto;
import lombok.Builder;
import lombok.Getter;

/**
 * カテゴリ別商品一覧用レスポンスクラス
 *
 * @author CHI3
 *
 */
@Getter
@Builder
public class CategoryItemResponse {
	/** カテゴリ別商品一覧 */
	private CategoryItemDto items;

}
