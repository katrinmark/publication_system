package ru.innopolis.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 *This class is used to define a mapper for formatting entities and models
 */
public class BaseMapper {
    public final static MapperFacade MAPPER_FACADE = new DefaultMapperFactory.Builder().build().getMapperFacade();
}