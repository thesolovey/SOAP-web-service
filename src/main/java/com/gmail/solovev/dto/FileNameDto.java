package com.gmail.solovev.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileNameDto {

    private String id;

    private String code;

    private Integer number;

    private String filenames;

    private String error;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public Integer getNumber() { return number; }

    public void setNumber(Integer number) { this.number = number; }

    public String getFilenames() { return filenames; }

    public void setFilenames(List<String> filenames) { this.filenames = convertListToString(filenames); }

    public String getError() { return error; }

    public void setError(String error) { this.error = error; }

    private String convertListToString(List<String> list) {
        if (filenames == null || filenames.isEmpty()) { return ""; }
        return String.join(",", filenames);
    }
}
