package com.ashken.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTablesResponse <T> implements Serializable {

   
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "iTotalRecords")
    public long totalRecords;

    @JsonProperty(value = "iTotalDisplayRecords")
    public long totalDisplayRecords;

    @JsonProperty(value = "sEcho")
    public String echo;

    @JsonProperty(value = "sColumns")
    public String columns;

    @JsonProperty(value = "aaData")
    public List<T> data = new ArrayList<T>();

    public DataTablesResponse() {
    }
    
    //accessors
	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public long getTotalDisplayRecords() {
		return totalDisplayRecords;
	}

	public void setTotalDisplayRecords(long totalDisplayRecords) {
		this.totalDisplayRecords = totalDisplayRecords;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
    
    
}