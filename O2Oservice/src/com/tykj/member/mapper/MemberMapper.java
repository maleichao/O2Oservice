package com.tykj.member.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tykj.member.model.Member;

@Repository(value = "memberMapper")  
public interface MemberMapper {
    public List<Member> getMemberAll();
    public List<Member> getMemberByParam(Map paramMap);
    public int  saveMember (Member member);
}
