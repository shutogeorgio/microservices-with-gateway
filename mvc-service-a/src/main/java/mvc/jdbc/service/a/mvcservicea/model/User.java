package mvc.jdbc.service.a.mvcservicea.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "id", columnDefinition = "uuid")
	private UUID id;

	@NonNull
	@Column(name = "first_name", length = 100)
	private String firstName;

	@NonNull
	@Column(name = "last_name", length = 100)
	private String lastName;

	@NonNull
	@Email
	@Column(name = "email")
	private String email;

	@Valid
	private Address address;

}
