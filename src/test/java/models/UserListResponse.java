package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserListResponse{
	private int per_page;
	private int total;
	private List<DataItem> data;
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;
	private Support support;
}