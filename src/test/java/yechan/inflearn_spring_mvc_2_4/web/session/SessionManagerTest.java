package yechan.inflearn_spring_mvc_2_4.web.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import yechan.inflearn_spring_mvc_2_4.domain.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {
        Member member = new Member();
        MockHttpServletResponse response = new MockHttpServletResponse();

        sessionManager.createSession(member, response);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}