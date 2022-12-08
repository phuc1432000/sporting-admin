package com.sporting.admin.dto.category;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryInitial implements Serializable {
    private long id;
    private String categoryId;
    private String name;
    private String description;
    private String active;
}
