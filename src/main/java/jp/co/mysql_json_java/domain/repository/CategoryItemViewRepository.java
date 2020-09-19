package jp.co.mysql_json_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.mysql_json_java.domain.model.CategoryItemView;

/**
 * カテゴリ別商品一覧に関するリポジトリインターフェース
 *
 * @author CHI-3
 *
 */
@Repository
public interface CategoryItemViewRepository extends JpaRepository<CategoryItemView, Integer>{

	/**
	 * カテゴリ毎に商品一覧を取得
	 *
	 * @param categoryId カテゴリID
	 * @return 商品一覧（カテゴリ別）
	 */
	@Query("SELECT c FROM CategoryItemView c WHERE c.categoryId = :categoryId")
	public CategoryItemView findByCategoryId(@Param("categoryId") Integer categoryId);

}
