package com.bit.dao;

import java.util.List;

import com.bit.model.MemberInfo;

public interface MemberInfoDao {

	public void insert(MemberInfo mem);

	public MemberInfo selectById(String userId);

	public List<MemberInfo> selectAll();

	public int update(MemberInfo mem);
	
	public int delete(String userId);
}
