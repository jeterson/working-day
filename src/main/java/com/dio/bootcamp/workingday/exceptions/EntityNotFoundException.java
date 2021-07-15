package com.dio.bootcamp.workingday.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class<?> classz, Object id) {
        super("Entity " + classz.getSimpleName() + " not found {"+id+"}");
    }

}
