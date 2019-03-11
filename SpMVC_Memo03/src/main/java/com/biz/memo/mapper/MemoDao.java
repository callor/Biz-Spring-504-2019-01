package com.biz.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.memo.model.MemoVO;

public interface MemoDao {
	
	@Select("SELECT * FROM tbl_memo")
	public List<MemoVO> selectAll();

	@Select("SELECT * FROM tbl_memo WHERE m_auth = #{m_userid}")
	public List<MemoVO> selectByUserId(String m_userid);
	
	@Select("SELECT * FROM tbl_memo WHERE id = #{id} ")
	public MemoVO findById(long id);
	
	/*
	 * InsertProvider 문장이 실행되기 전에(before가 true이므로)
	 * SELECT SEQ_MEMO.NEXTVAL FROM DUAL 을 실해서
	 * 그 결과값을 id 라는 변수에 담아라
	 * 이때 이 id는 변수의 자료형은 Long 형이다.
	 */
	@SelectKey(statement=" SELECT SEQ_MEMO.NEXTVAL FROM DUAL ",
				keyProperty = "id", 
				before=true,
				resultType = Long.class)
	@InsertProvider(type=MemoSQL.class, method="memo_insert_sql")
	public int insert(MemoVO memoVO);
	
	@UpdateProvider(type=MemoSQL.class,method="memo_update_sql")
	public int update(MemoVO memoVO);
	
	@Delete("DELETE FROM tbl_memo WHERE id=#{id}")
	public void delte();
	
}
