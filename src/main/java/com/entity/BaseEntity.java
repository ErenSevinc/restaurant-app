package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    boolean deleted;

//    @Override
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    @Override
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }


}
