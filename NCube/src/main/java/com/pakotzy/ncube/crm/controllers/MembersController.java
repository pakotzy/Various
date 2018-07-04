package com.pakotzy.ncube.crm.controllers;

import com.pakotzy.ncube.crm.entities.Member;
import com.pakotzy.ncube.crm.services.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MembersController {
	@Autowired
	MembersService service;

	@GetMapping("/members")
	public List<Member> getMembers() {
		return service.getMembers();
	}

	@GetMapping("/members/{memberId}")
	public Member getMember(@PathVariable String memberId) {
		return service.getMember(memberId);
	}

	@PostMapping("/members")
	public Member addMember(@RequestBody Member member) {
		return service.saveMember(member);
	}

	@PutMapping("/members")
	public Member updateMember(@RequestBody Member member) {
		return service.saveMember(member);
	}

	@DeleteMapping("/members/{memberId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMember(@PathVariable String memberId) {
		service.deleteMember(memberId);
	}
}
