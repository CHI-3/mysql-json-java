package jp.co.mysql_json_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.mysql_json_java.domain.model.Item;

/**
 * 商品に関するリポジトリインターフェース
 *
 * @author CHI-3
 *
 */
@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{

	@Query("SELECT i FROM Item i WHERE i.itemId = :itemId and i.isDeleted = :isDeleted")
	public Item findByItemId(@Param("itemId") Integer itemId, @Param("isDeleted") boolean isDeleted);

}
