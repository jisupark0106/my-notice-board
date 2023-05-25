package didoo.study.board.category;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    @DisplayName("카테고리 생성")
    void createCategory() {
        String name = "여행";
        Category category = categoryService.createCategory(name);
        Assertions.assertEquals(category.getName(), name);

        categoryService.removeCategory(category.getId());
    }

    @Test
    @DisplayName("중복 카테고리 생성")
    void createDuplicateCategory() {
        String name = "여행";
        Category category = categoryService.createCategory(name);

        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.createCategory(name);
        });
        Assertions.assertEquals("이미 존재하는 카테고리입니다.", exception.getMessage());
        categoryService.removeCategory(category.getId());
    }

    @Test
    @DisplayName("존재하지 않는 카테고리 삭제")
    void removeCategory() {
        String name = "여행";
        Category category = categoryService.createCategory(name);
        categoryService.removeCategory(category.getId());

        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            categoryService.removeCategory(category.getId());
        });
        Assertions.assertEquals("존재하지 않는 카테고리입니다.", exception.getMessage());
    }
}