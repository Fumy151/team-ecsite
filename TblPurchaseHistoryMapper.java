package jp.co.internous.pegasus.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.pegasus.model.domain.dto.PurchaseHistoryDto;

@Mapper
public interface TblPurchaseHistoryMapper {
	int insert(@Param("destinationId") int destinationId, @Param("userId") int userId);
	
	//ユーザーIDを条件に購入履歴情報を取得する
	List<PurchaseHistoryDto> findByUserId(int userId);
	
	// ユーザーIDを条件に論理削除する
	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
	int logicalDeleteByUserId(int userId);
}
