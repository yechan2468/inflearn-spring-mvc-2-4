package yechan.inflearn_spring_mvc_2_4.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yechan.inflearn_spring_mvc_2_4.domain.member.Member;
import yechan.inflearn_spring_mvc_2_4.domain.member.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
