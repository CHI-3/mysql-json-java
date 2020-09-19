package jp.co.mysql_json_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.mysql_json_java.domain.model.ItemCategory;

/**
 * 商品カテゴリに関するリポジトリインターフェース
 *
 * @author CHI-3
 *
 */
@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer>{
}
