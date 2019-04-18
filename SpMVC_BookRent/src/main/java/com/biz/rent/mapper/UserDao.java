package com.biz.rent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.rent.model.UserVO;

public interface UserDao {

	@Select("SELECT * FROM tbl_user")
	public List<UserVO> selectAll();
	
	@InsertProvider(type=UserSQL.class,method="user_insert_sql")
	public int insert(UserVO userVO);

	@Delete("DELETE FROM tbl_user WHERE user_seq = #{user_seq}")
	public void delete(@Param("user_seq") long id);

}
