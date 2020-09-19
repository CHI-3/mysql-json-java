package jp.co.mysql_json_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.mysql_json_java.domain.model.ItemTag;

/**
 * 商品タグに関するリポジトリインターフェース
 * @author CHI-3
 *
 */
@Repository
public interface ItemTagRepository extends JpaRepository<ItemTag, Integer>{

	@Query("SELECT i FROM ItemTag i WHERE i.tagId = :tagId and i.isDeleted = :isDeleted")
	public ItemTag findByTagId(@Param("tagId") Integer tagId, @Param("isDeleted") boolean isDeleted);

}
