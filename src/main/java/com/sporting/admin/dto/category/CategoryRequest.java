package com.sporting.admin.dto.category;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryRequest implements Serializable {
    private String categoryId;
}
