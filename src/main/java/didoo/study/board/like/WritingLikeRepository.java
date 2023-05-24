package didoo.study.board.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingLikeRepository extends JpaRepository<WritingLike, Long> {
}
