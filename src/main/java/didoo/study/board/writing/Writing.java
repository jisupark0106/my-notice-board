package didoo.study.board.writing;

import didoo.study.board.category.Category;
import didoo.study.board.common.BaseDateEntity;
import didoo.study.board.like.WritingLike;
import didoo.study.board.member.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Writing extends BaseDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "writing", orphanRemoval = true)
    private List<WritingLike> likes = new ArrayList<>();
}
