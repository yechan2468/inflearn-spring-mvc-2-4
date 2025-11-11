package yechan.inflearn_spring_mvc_2_4.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import yechan.inflearn_spring_mvc_2_4.domain.member.Member;
import yechan.inflearn_spring_mvc_2_4.domain.member.MemberRepository;
import yechan.inflearn_spring_mvc_2_4.web.session.SessionManager;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    private final SessionManager sessionManager;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null) {
            return "home";
        }

        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);

        return "loginHome";
    }

    @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) {
        Object loginSession = sessionManager.getSession(request);
        if (loginSession == null) return "home";

        Member member = (Member) loginSession;
        model.addAttribute("member", member);

        return "loginHome";
    }
}