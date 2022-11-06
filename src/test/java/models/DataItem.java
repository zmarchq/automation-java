package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataItem{

	@JsonProperty("last_name")
	private String lastName;
	private int id;
	private String avatar;

	@JsonProperty("first_name")
	private String firstName;
	private String email;
}