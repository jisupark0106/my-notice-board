package didoo.study.board.member;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/members", produces = MediaTypes.HAL_JSON_VALUE)
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @PostMapping
    private ResponseEntity createMember(@RequestBody Member member) {

        memberRepository.save(member);

        WebMvcLinkBuilder link = linkTo(MemberController.class).slash("{id}");
        member.setId(1L);
        return ResponseEntity.created(link.toUri()).body(member);
    }
}
