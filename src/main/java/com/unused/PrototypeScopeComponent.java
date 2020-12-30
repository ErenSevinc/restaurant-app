package com.unused;

import io.swagger.annotations.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(name = "deneme", description = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeScopeComponent implements Serializable {
    private static int instanceCount;

    public PrototypeScopeComponent(){
        instanceCount ++;
    }

    public void printInstanceInfo(){
        System.out.println("Prototype scope instanceCount : "+ instanceCount+" - hashCode : "+this.hashCode());
    }
}
