package helloprinciple.core;

import helloprinciple.core.member.Grade;
import helloprinciple.core.member.Member;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberSerivceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
