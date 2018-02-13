package com.tykj.member.mapper;

import com.tykj.member.model.Memberbasicinfo;

public interface MemberbasicinfoMapper {
    int deleteByPrimaryKey(Integer memberBasicInfoId);

    int insert(Memberbasicinfo record);

    int insertSelective(Memberbasicinfo record);

    Memberbasicinfo selectByPrimaryKey(Integer memberBasicInfoId);

    int updateByPrimaryKeySelective(Memberbasicinfo record);

    int updateByPrimaryKey(Memberbasicinfo record);
}