package didoo.study.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody Member member) {
        Member saveResult = memberService.createMember(member);
        return new ResponseEntity<>(saveResult, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMemberList() {
        List<Member> members = memberService.getMembers();
         return ResponseEntity.ok().body(members);
    }

}
