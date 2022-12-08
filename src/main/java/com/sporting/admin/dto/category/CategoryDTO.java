package com.sporting.admin.dto.category;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDTO implements Serializable {
    private String message;
    private String error_code;
    private List<CategoryInitial> list;
    private CategoryInitial data;
}
