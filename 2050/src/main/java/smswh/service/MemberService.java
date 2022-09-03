package smswh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smswh.domain.Member;
import smswh.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create() {
        return Member.createMember();
    }
}
