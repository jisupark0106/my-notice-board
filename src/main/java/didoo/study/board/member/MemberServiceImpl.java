package didoo.study.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{

    private final MemberRepository memberRepository;
    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void removeMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(Long id) {
        Optional<Member>  member = memberRepository.findById(id);
        if(member.isEmpty()){
            throw new IllegalArgumentException();
        }
        return member.get();
    }
}
