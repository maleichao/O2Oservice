package com.tykj.member.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tykj.member.mapper.MemberMapper;
import com.tykj.member.model.Member;
import com.tykj.member.service.IMemberService;

//@Transactional
@Service("memberService")
public class MemberSerrvice implements IMemberService{
	@Resource
    private MemberMapper memberMapper;
	public List getMemberAll(Map<String, Object> paramMap) {
		List<Member> member=memberMapper.getMemberAll();
		return member;
	}
	@Override
	public List getMemberByParam(Map<String, Object> paramMap) {
		List<Member> member=memberMapper.getMemberByParam(paramMap);
		return member;
	}
	@Override
	public int saveMember(Member member) throws Exception {
		
		int count=memberMapper.saveMember(member);
		System.out.println(member.getMemberId());
		
		return count;
	}

}
