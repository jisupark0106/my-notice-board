package didoo.study.board.category;

import didoo.study.board.common.BaseDateEntity;
import didoo.study.board.writing.Writing;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseDateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Writing> writings = new ArrayList<>();
}
