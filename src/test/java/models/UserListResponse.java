package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserListResponse{
	private int per_page;
	private int total;
	private List<DataItem> data;
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;
	private Support support;
}