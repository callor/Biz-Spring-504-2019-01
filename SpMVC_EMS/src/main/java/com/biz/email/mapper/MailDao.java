package com.biz.email.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.email.model.MailVO;

public interface MailDao {
	
	@Select("SELECT * FROM tbl_emails")
	public List<MailVO> selectAll();
	
	@Select("SELECT * FROM tbl_emails WHERE id = #{id}")
	public MailVO findById(long id);
	
	@Select("SELECT * FROM tbl_emails WHERE from_email = #{from_email}")
	public List<MailVO> selectByFromMail(String from_email);
	
	
	@InsertProvider(type=MailSQL.class,method="email_insert_sql")
	public int insert(MailVO mailVO);
	
	@UpdateProvider(type=MailSQL.class,method="email_update_sql")
	public int update(MailVO mailVO);
	
	@Delete("DELETE FROM tbl_emails WHERE id = #{id}")
	public int delete(long id);

}
