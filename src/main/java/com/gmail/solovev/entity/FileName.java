package com.gmail.solovev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "FILENAME")
public class FileName {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "FILENAMES")
    private String filenames;

    @Column(name = "ERROR")
    private String error;

    public String getId() { return id; }

    public void setId() { this.id = UUID.randomUUID().toString(); }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public Integer getNumber() { return number; }

    public void setNumber(Integer number) { this.number = number; }

    public String getFilenames() { return filenames; }

    public void setFilenames(String filenames) { this.filenames = filenames; }

    public String getError() { return error; }

    public void setError(String error) { this.error = error; }
}
