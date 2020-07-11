package mvc.jdbc.service.a.mvcservicea.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@NonNull
	@Column(name = "country", length = 100)
	private String country;

	@NonNull
	@Column(name = "state", length = 100)
	private String state;

	@NonNull
	@Column(name = "city", length = 100)
	private String city;

	@NonNull
	@Column(name = "zip", length = 100)
	private String zip;

}
