package didoo.study.board.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;


    @Override
    public Category createCategory(String name){

        boolean isExist = categoryRepository.existsByName(name);
        if(isExist){
            throw new IllegalArgumentException("이미 존재하는 카테고리입니다.");
        }
        Category category = Category.builder().name(name).build();

        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long id) {

        boolean isExist = categoryRepository.existsById(id);
        if(!isExist){
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        categoryRepository.deleteById(id);
        // TODO: 카테고리에 속해 있는 글들을 모두 지움
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        boolean isExist = categoryRepository.existsById(id);
        if(!isExist){
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
