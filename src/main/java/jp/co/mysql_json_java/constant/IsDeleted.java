package jp.co.mysql_json_java.constant;

import lombok.Getter;

/**
 * 削除フラグ
 *
 * @author CHI-3
 *
 */
@Getter
public enum IsDeleted {

	Off(false, "OFF"),On(true, "ON");

	private boolean key;
	private String value;

	private IsDeleted(boolean key, String value) {
		this.key = key;
		this.value = value;
	}
}
