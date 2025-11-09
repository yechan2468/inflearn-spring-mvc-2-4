package yechan.inflearn_spring_mvc_2_4;

import yechan.inflearn_spring_mvc_2_4.domain.item.Item;
import yechan.inflearn_spring_mvc_2_4.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import yechan.inflearn_spring_mvc_2_4.domain.member.Member;
import yechan.inflearn_spring_mvc_2_4.domain.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
    }

}