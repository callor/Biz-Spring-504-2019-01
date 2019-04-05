package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.biz.iolist.mapper.DeptDao;
import com.biz.iolist.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeptService {

	@Autowired
	SqlSession session;
	
	private DeptDao dDao() {
		return session.getMapper(DeptDao.class);
	}
	
	public List<DeptVO> selectAll(){
		
		log.debug("DeptService Call");
		// DeptDao dDao = session.getMapper(DeptDao.class);
		List<DeptVO> deptVO = dDao().selectAll();
		return deptVO;

	}
	
	public String getDCode() {
		
		// tbl_dept에서 가장 큰 코드값을 가져오는 부분
		String d_code = dDao().getDCode();
		String new_dcode = "D0001";
		if(d_code != null) { // 테이블에 값이 없으면 null이된다.
			
			d_code = d_code.substring(1); // 1번째 문자부터 잘라라
						
			// d_code값은 db로 부터 가져온 값이어서 혹시 앞뒤에 빈칸이
			// 있을수 있어서 빈칸을 제거
			int temp_code = Integer.valueOf(d_code.trim()) + 1; // 100
			new_dcode = String.format("D%04d",temp_code);
			//	%d 숫자(정수)를 표현하라
			//	%5d 왼쪽 빈칸을 두고 자리수를 5개로 맞추어라
			//	%05d 왼쪽에 빈칸을 0으로 채워서 5개로 맞추어라 : 0100
			// 최종 결과는 D0100
			
		}
		
		return new_dcode;
		
		
	} // getDCode
	
	
	public String getDName(String d_code) {
		DeptVO vo = dDao().findByDCode(d_code);
		return vo.getD_name();
	}

	public int insert(DeptVO deptVO) {
		// TODO Service insert 메서드
		
		// TODO Service insert 테스트케이스
		// 조건 : session으로부터 DeptDao mapper를 추출
		// 결과 : deptDao mapper의 insert를 수행하여
		//		테이블에 데이터 저장 완료
		// DeptDao dDao = session.getMapper(DeptDao.class);
		int ret = dDao().insert(deptVO);
		return ret;
	}
}







