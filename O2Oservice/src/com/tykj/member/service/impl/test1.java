package com.tykj.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tykj.member.model.Member;
import com.tykj.member.service.IMemberService;
@Service("test1")
public class test1 implements IMemberService{

	@Override
	public List getMemberAll(Map<String, Object> paramMap) {
		System.out.println("test");
		return null;
	}

	@Override
	public List getMemberByParam(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
