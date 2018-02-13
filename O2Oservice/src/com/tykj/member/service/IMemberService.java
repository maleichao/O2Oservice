package com.tykj.member.service;

import java.util.List;
import java.util.Map;

import com.tykj.member.model.Member;
import com.tykj.mybatis.DataSource;

public interface IMemberService {
	@DataSource("read")
	public List getMemberAll(Map<String,Object> paramMap);
	@DataSource("read")
	public List getMemberByParam(Map<String,Object> paramMap);
	@DataSource("write")
	public int saveMember(Member member) throws Exception;
}
