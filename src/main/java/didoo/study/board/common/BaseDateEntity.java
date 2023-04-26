package didoo.study.board.common;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseDateEntity {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
