package jp.co.mysql_json_java.domain.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the item_view database table.
 *
 */
@Entity
@Getter
@Setter
@Immutable
@Table(name="category_item_view")
@NamedQuery(name="CategoryItemView.findAll", query="SELECT c FROM CategoryItemView c")
public class CategoryItemView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id", updatable = false, nullable = false)
	private Integer categoryId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="item_count")
	private Integer itemCount;

	@Lob
	@Column(name="item_list")
	private String itemList;

	private Short ranking;

	public CategoryItemView() {
	}

}