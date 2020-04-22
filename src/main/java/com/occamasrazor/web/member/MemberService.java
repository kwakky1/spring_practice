package com.occamasrazor.web.member;


public interface MemberService {
	public void add(Member member);
	public Member[] list();
	public int count();
	public boolean login(Member member);
	public Member detail(Member member);
	public void update(Member member);
	public void delete(Member member);
}
