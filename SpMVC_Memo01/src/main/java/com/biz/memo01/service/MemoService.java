package com.biz.memo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo01.model.MemoDao;
import com.biz.memo01.model.MemoVO;

@Service
public class MemoService {

//	@Autowired
//	SqlSession sqlSession;
	
	@Autowired
	MemoDao memoMapper;
	
	// MemoDao�� selectAll() �޼��带 ȣ���ؼ�
	// SELECT SQL�� ������ ����
	// ����� memoList�� �ް�
	// �ƹ��� ���� ���� Controller�� return
	public List<MemoVO> selectAll() {
		List<MemoVO> memoList = memoMapper.selectAll();
		return memoList;
	}
	
	public int insert(MemoVO vo) {
		
//		MemoDao dao = sqlSession.getMapper(MemoDao.class);
//		int ret = dao.insert(vo);
//		sqlSession.commit();
		
		int ret = memoMapper.insert(vo);
		return ret;
	}

	public MemoVO findById(long id) {
		// TODO Auto-generated method stub
		MemoVO vo = memoMapper.findById(id);
		return vo;
	}

	public int delete(Long id) {
		return memoMapper.delete(id);
	}

	public void memo_write(MemoVO vo) {

		// vo���� form���� ������ �����Ͱ� ��� �ִ�.
		// vo member �����߿���
		// ���� ���� �ִ�. == id�� ���� ����
		
		// ���� �޸� �ۼ��ϱ� ���� ��� id ���� �Ƹ��� 0 �ϰ��̴�.
		// �޸� �����ϱ�� ���� ���� id ���� 0 �� �̿� �ϰ��̴�.
		
		if(vo.getId()>0) {
			memoMapper.update(vo);
		} else {
			memoMapper.insert(vo);
		}
		
		
		
	}
	
}
