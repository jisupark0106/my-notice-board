package didoo.study.board.category;

import didoo.study.board.common.BaseDateEntity;
import didoo.study.board.writing.Writing;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category extends BaseDateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private final List<Writing> writings = new ArrayList<>();
}
