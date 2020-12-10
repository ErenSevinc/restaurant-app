package com.builder;

import com.entity.CategoryTable;

public class CategoryTableBuilder extends Builder {
    private int id;
    private String name;
    private int amount;

    public CategoryTableBuilder id(int id){
        this.id=id;
        return this;
    }
    public CategoryTableBuilder name(String name){
        this.name=name;
        return this;
    }
    public CategoryTableBuilder amount(int amount){
        this.amount=amount;
        return this;
    }

    @Override
    public CategoryTable build() {
        CategoryTable categoryTable=new CategoryTable();
        categoryTable.setId(this.id);
        categoryTable.setName(this.name);
        categoryTable.setAmount(this.amount);
        return categoryTable;
    }
}
