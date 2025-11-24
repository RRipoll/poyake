package com.jsantos.search.model.search;


import java.util.List;

/*
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

*/
public class ColumnDTO {

	//@ApiModelProperty("text shown in the header ")
	String headerName;
	//@ApiModelProperty("db table / view field name  ")
	String field;
	//@ApiModelProperty("size of the column (Integer) ")
	String width;
	//@ApiModelProperty("extra info ")
	String cellRendererFramework;
	//@ApiModelProperty("type of the data shown in this column ")
	String type;
	//@ApiModelProperty("arry of formatters in this column ")
	List<String> formatters;
	
	//@ApiModelProperty("Name of the group ")
	private String group;

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCellRendererFramework() {
		return cellRendererFramework;
	}

	public void setCellRendererFramework(String cellRendererFramework) {
		this.cellRendererFramework = cellRendererFramework;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getFormatters() {
		return formatters;
	}

	public void setFormatters(List<String> formatters) {
		this.formatters = formatters;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
