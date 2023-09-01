package com.example.demo3.service;

import com.example.demo3.dto.MyEntityDto;
import com.example.demo3.dto.MyEntityMapper;
import com.example.demo3.entity.MyEntity;
import com.example.demo3.repository.MyEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyEntityService {
    private final MyEntityRepository myEntityRepository;
    private final MyEntityMapper myEntityMapper;
    public MyEntityService(MyEntityRepository myEntityRepository, MyEntityMapper myEntityMapper) {
        this.myEntityRepository = myEntityRepository;
        this.myEntityMapper = myEntityMapper;
    }

    public MyEntityDto saveMyEntity(Long id, MyEntityDto myEntityDto) {
        MyEntity myEntity = myEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MyEntity not found with id: " + id));

        myEntity.setName(myEntityDto.getName());
        myEntity.setName(myEntityDto.getName());

        MyEntity updatedMyEntity = myEntityRepository.save(myEntity);

        MyEntityDto updatedMyEntityDto = MyEntityMapper.INSTANCE.toDto(Optional.of(updatedMyEntity));
        return updatedMyEntityDto;
    }

    public MyEntityDto createMyEntity(MyEntityDto dto) {
        MyEntity entity = myEntityMapper.toEntity(dto);
        MyEntity savedEntity = myEntityRepository.save(entity);
        return myEntityMapper.toDto(Optional.of(savedEntity));
    }

    public MyEntity updateMyEntity(Long id, MyEntity myEntity) {
        myEntity.setId(id);
        return myEntityRepository.save(myEntity);
    }

    public void deleteMyEntity(Long id) {
        myEntityRepository.deleteById(id);
    }

    public Optional<MyEntity> getMyEntityById(Long id) {
        return myEntityRepository.findById(id);
    }

    public List<MyEntity> getAllMyEntities() {
        return myEntityRepository.findAll();
    }


}
