package ru.innopolis.utils;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class BaseMapper {
    public final static MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();
}