package didoo.study.board.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody String name){
        Category result = categoryService.createCategory(name);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Category> optional = categoryService.getCategory(id);
        if(optional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }
}

