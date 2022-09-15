package com.devsuperior.dscatalog.services.exeptions;

public class ServiceNotFoundException extends RuntimeException{
    private  static final long serialVersionUID = 1L;

    public ServiceNotFoundException(String msg){
        super(msg);
    }
}
