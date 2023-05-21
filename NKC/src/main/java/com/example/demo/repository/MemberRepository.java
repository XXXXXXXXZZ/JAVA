package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

public interface MemberRepository {

	
	
	Member save(Member member);
	Optional<Member> fineById(Long id);
	Optional<Member> findBuName(String name);
	List<Member> findALl();
	public void clearStore();
}
