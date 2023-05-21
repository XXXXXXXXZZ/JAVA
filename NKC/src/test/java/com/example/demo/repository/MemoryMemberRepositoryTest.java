package com.example.demo.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import domain.Member;

class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();

	/* 테스트 는 순서 상관없 진행됩니다 
	 * 
	 * 
	 */
	
	
	// 테스트가 끝나고 동작하는 메소드 콜백 함수
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("Spring");

		repository.save(member);
		Member result = repository.fineById(member.getId()).get();
		
//		Assertions.assertEquals(member, null);  // 방법 1
		Assertions.assertThat(member).isEqualTo(result); //방법2 
		
	}
	
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2  = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result =  repository.findBuName("spring1").get();
		
		assertThat(result).isEqualTo(member1);
	}
	
	
	@Test
	public void findAll() {
		Member member1  = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2  = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		
		List<Member> result = repository.findALl();
		
		assertThat(result.size()).isEqualTo(2);
		
		
	}
	

}
