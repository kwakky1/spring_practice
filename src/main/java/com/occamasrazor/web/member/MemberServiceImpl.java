package com.occamasrazor.web.member;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	private Member[] members;
	private int count;
	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}
	@Override
	public void add(Member member) {
		members[count] = member;
		count++;
	}

	@Override
	public Member[] list() {
		return members;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public Member detail(Member member) {
		Member detail = new Member();
		for(int i=0;i<count;i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				detail = members[i];
			}
		}
		return detail;
	}

	@Override
	public void update(Member member) {
		for(int i=0;i<count;i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				member.setPassword(members[i].getPassword());
			}
		}
	}

	@Override
	public void delete(Member member) {
		for(int i=0;i<count;i++) {
			if(member.getUserid().equals(members[i].getUserid())
			&& member.getPassword().equals(members[i].getPassword())) {
				members[i]=members[count-1];
				members[count-1]= null;
				count--;
			}
		}
	}
	@Override
	public boolean login(Member member) {
		boolean login = false;
		for(int i=0;i<count;i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				login=true;
				break;
			}
		}
		
		return login;
	}

}
