package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Member;

public class MemoryMemberRepository implements MemberRepository {

	private Map<Long, Member> store = new HashMap<Long, Member>();
	private static Long sequence = 0L;

	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> fineById(Long id) {
		// TODO Auto-generated method stub

		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findBuName(String name) {
		// TODO Auto-generated method stub
		return store.values().stream().filter(member -> member.getName().equals(name)).findAny();

	}

	@Override
	public List<Member> findALl() {
		// TODO Auto-generated method stub
		return new ArrayList<>(store.values());
	}

	@Override
	public void clearStore() {
		store.clear();
	}

}
