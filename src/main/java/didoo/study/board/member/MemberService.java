package didoo.study.board.member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    /**
     *
     * @param member 생성하기 위한 회원
     * @return 저장 완료된 회원
     */
    Member createMember(Member member);

    /**
     *
     * @param id 제거하기 위한 회원 ID
     */
    void removeMember(Long id);

    /**
     *
     * @return 가입된 회원 목록
     */
    List<Member> getMembers();

    /**
     *
     * @param id 조회하기 위한 회원 ID
     * @return 조회 완료된 회원
     */
    Member getMember(Long id);

}
