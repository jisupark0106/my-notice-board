package didoo.study.board.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


    Category createCategory(String name);

    void removeCategory(Long id);

    Optional<Category> getCategory(Long id);

    List<Category> getCategories();


}
