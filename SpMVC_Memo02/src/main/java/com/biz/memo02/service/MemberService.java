package com.biz.memo02.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service	
public class MemberService {

	
	/*
	 * Map<Key,Value> 
	 * Ű�� ���� ������ ������ �ڷᱸ��
	 * ���� �߰��Ҷ��� : map.put(key,value)
	 * ���� �������� : map.key ���·� ���� �д´�.
	 */
	public Map<String,String> getCities() {
		/*
		 * HashMap�� put �� ������� ����
		 * TreeMap�� key�� �������� �������� ����
		 * 
		 * Map�� key�� �ߺ��� ������� �ʴ´�.
		 */
		Map<String,String> cities = new HashMap<String,String>();
		cities = new TreeMap<String,String>();
		
		cities.put("����Ư����","SEOUL");
		cities.put("���ֱ�����","GWANGJU");
		cities.put("��õ������","INCHUN");
		cities.put("����������","DAEJUN");
		cities.put("�λ걤����","BUSAN");
		cities.put("����Ư����ġ��","JEJU");
		
		return cities;
	}
	
	public List<String> getCitiesList() {
		
		List<String> cities = new ArrayList<String>();
		cities.add("���ֿ���");
		cities.add("����Ư����");
		cities.add("��걤����");
		cities.add("�λ걤����");
		cities.add("��õ������");
		cities.add("����Ư����ġ��");
		return cities;
		
	}
	
	public Map<String,String> getHobbies() {
		Map<String,String> hobbies = new HashMap<String,String>();
		hobbies.put("BOOK","����");
		hobbies.put("MOUNT","���");
		hobbies.put("MUSIC","���ǰ���");
		hobbies.put("GAME","����");
		hobbies.put("MOVIE","��ȭ����");
		return hobbies;
	}
	
	public List<String> getHobbiesList() {
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("����");
		hobbies.add("���");
		hobbies.add("���ǰ���");
		hobbies.add("��ȭ����");
		hobbies.add("����");
		return hobbies;
	}
}
