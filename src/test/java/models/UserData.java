package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UserData {
	private String color;
	private int year;
	private String name;
	private int id;

	@JsonProperty("pantone_value")
	private String pantoneValue;
	private String job;
	private String updatedAt;
	private String createdAt;
}