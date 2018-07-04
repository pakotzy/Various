package com.pakotzy.ncube.crm.services;

import com.pakotzy.ncube.crm.entities.Member;
import com.pakotzy.ncube.crm.exceptions.MemberNotFoundException;
import com.pakotzy.ncube.crm.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MembersServiceImpl implements MembersService {
	@Autowired
	MemberRepository repository;

	@Override
	public List<Member> getMembers() {
		return repository.findAll();
	}

	@Override
	public Member getMember(String memberId) {
		Member tempMember = repository.findById(memberId).orElse(null);

		if (Objects.isNull(tempMember)) throw new MemberNotFoundException();

		return tempMember;

	}

	@Override
	public Member saveMember(Member member) {
		return repository.save(member);
	}

	@Override
	public void deleteMember(String id) {
		if (!repository.existsById(id)) throw new MemberNotFoundException();

		repository.deleteById(id);
	}

	@Override
	public boolean exists(String memberId) {
		return repository.existsById(memberId);
	}
}
