package webfluxserviceb.model;

import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    @Column
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private UUID authorId;

    @NotNull
    private Long categoryId;

    @Timestamp
    private LocalDateTime createdDate;

    @Timestamp
    private LocalDateTime updatedDate;
}
