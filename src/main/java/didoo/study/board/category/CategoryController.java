package didoo.study.board.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

}

