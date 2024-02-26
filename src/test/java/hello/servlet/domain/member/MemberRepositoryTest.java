package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello",20);
        Member savedMember = memberRepository.save(member);

        Member findmember = memberRepository.findId(savedMember.getId());
        assertThat(findmember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> all = memberRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1,member2);
    }
}