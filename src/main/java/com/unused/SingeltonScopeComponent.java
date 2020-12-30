package com.unused;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SingeltonScopeComponent implements Serializable {
    private static int instanceCount;

    public SingeltonScopeComponent(){
        instanceCount ++;
    }

    public void printInstanceInfo(){
        System.out.println("Singelton scope instanceCount : "+ instanceCount+" - hashCode : "+this.hashCode());
    }
}
