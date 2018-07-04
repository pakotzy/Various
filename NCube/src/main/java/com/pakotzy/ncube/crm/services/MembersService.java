package com.pakotzy.ncube.crm.services;

import com.pakotzy.ncube.crm.entities.Member;

import java.util.List;

public interface MembersService {
	List<Member> getMembers();

	Member getMember(String memberId);

	Member saveMember(Member member);

	void deleteMember(String memberId);

	boolean exists(String memberId);
}
