package reactive.webflux.service.c.webfluxservicec.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("comment")
public class Comment {

    @Id
    private int id;

    @NotNull
    private String description;

    @NotNull
    private int postId;

    @NotNull
    private UUID authorId;
}
