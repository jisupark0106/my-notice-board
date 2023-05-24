package didoo.study.board.member;

import didoo.study.board.common.BaseDateEntity;
import didoo.study.board.writing.Writing;
import didoo.study.board.like.WritingLike;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member extends BaseDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Auth auth;
    @OneToMany(mappedBy = "member", orphanRemoval = true)
    private final List<Writing> writings = new ArrayList<>();

    @OneToMany(mappedBy = "member", orphanRemoval = true)
    private final List<WritingLike> likes = new ArrayList<>();
}
