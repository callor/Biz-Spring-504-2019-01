package com.biz.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.file.model.BoardVO;

public interface BoardDao {

	@Select(" SELECT * FROM tbl_board ")
	public List<BoardVO> selectAll();
	
	@Select("SELECT * FROM tbl_board WHERE id = #{id}")
	public BoardVO findByid(long id);
	
	@Select("SELELCT * FROM tbl_board WHERE b_userid = #{b_userid}")
	public List<BoardVO> findByUserId(String b_userid);
	
	/*
	 * @SelectKey 는 @InsertProvider가 
	 * 		실행되기 전(before=true)이나
	 * 		실행된 후(before=false) 에
	 * statement에 지정된 SQL을 실행하라
	 * 
	 * 이경우는 before=true이므로 Insert 이전에 실행을 해서
	 * keyProperty로 지정된 변수에 저장
	 * 이때 id의 자료형은 Long 형이다
	 */
	@SelectKey(before=true,keyProperty="id",resultType=Long.class,
			statement=" SELECT ROUND(DBMS_RANDOM.VALUE(0,9999999999),0) FROM DUAL "
			)
	@InsertProvider(type=BoardSQL.class,method="board_insert_sql")
	public int insert(BoardVO boardVo);
	
	@UpdateProvider(type=BoardSQL.class,method="board_update_sql")
	public int update(BoardVO boardVO);
	
	@Delete("DELETE FROM tbl_board WHERE id=#{id}")
	public int delete(long id);
		
}
