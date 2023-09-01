package com.example.demo3.dto;

import com.example.demo3.entity.MyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper


    public interface MyEntityMapper {
        MyEntityMapper INSTANCE = Mappers.getMapper(MyEntityMapper.class);

        MyEntityDto toDto(Optional<MyEntity> myEntity);


    MyEntity toEntity(MyEntityDto myEntityDto);

    List<MyEntityDto> toDtoList(List<MyEntity> myEntities);
}
