package com.biz.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.memo.model.FileVO;

/*
 * 일반적으로 파일 업로드와 관련된 CRUD는 
 * SELECT, INSERT, DELETE 만을 구현하고
 * UPDATE는 별도로 구현하지 않는다.
 * 
 */
public interface FileDao {

	/*
	 * memo 테이블의 id값과 연결된 files 테이블의 데이터만
	 * select All 하겠다.
	 */
	@Select("SELECT * FROM tbl_files WHERE parent_id = #{parent_id}")
	public List<FileVO> selectById(long parent_id);
	
	@InsertProvider(type=FileSQL.class,method="file_insert_sql")
	public int insert(FileVO fileVO);
	
	@Delete("DELETE FROM tbl_files WHERE id=#{id}")
	public int delete(long id);
	
	
}


