package com.biz.memo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo02.dao.MemoDao;
import com.biz.memo02.vo.MemoVO;

@Service
public class MemoService {

	@Autowired // == @Inject
	MemoDao memoMapper;
	
	/*
	 * TDD(Test Driven Developer)
	 * 	1. MemoService Ŭ������ � �޼��带 ȣ���ؼ� ����� ������
	 * 		���� method ���(ȣ��) �ڵ带 �ۼ�
	 *  2. �翬�� ���� ������ �� ���̹Ƿ�
	 *  3. ��Ŭ������ ������ �޾Ƽ�
	 *  4. create method�� �����Ѵ�.
	 *  5. ��Ŭ������ MemoService Ŭ������ �ڵ����� �Ű�������
	 *  	���ϰ� ���� �����Ͽ�
	 *  	�޼��带 �ۼ� �� �ش�.
	 * 
	 */
	public int insertDB(MemoVO vo) {
		// �Ű������� ���� vo�� �ϴ� �ƹ��� ���� ����
		// MemoDao�� ���ؼ� DB�� ������ ��������.

		// MemoDao�� insert�� ���������� ����Ǹ�
		// 0 ���� ū ���� ���� �� ���̰�
		// �� ���ϰ��� Controller ���� �ٽ� �����Ѵ�
		int ret = memoMapper.insert(vo);
		return ret;
	}

	public List<MemoVO> selectAll() {

		List<MemoVO> memoList = memoMapper.selectAll();
		return memoList;
	
	}

	public MemoVO getMemo(long id) {
		
		MemoVO vo = memoMapper.findById(id);
		return vo;
	
	}

	public int delete(long id) {
		// TODO Auto-generated method stub
		int ret = memoMapper.delete(id);
		return ret;
	}

	public int writeDB(MemoVO vo) {
		
		long id = vo.getId();
		int ret = 0;
		if(id > 0) ret = memoMapper.update(vo);
		else ret = memoMapper.insert(vo);

		return ret;
	}



}
