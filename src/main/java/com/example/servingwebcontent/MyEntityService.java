package com.example.servingwebcontent;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntityService {
    private final MyEntityRepository myEntityRepository;

    public MyEntityService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public MyEntity createMyEntity(MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }

    public MyEntity updateMyEntity(Long id, MyEntity myEntity) {
        myEntity.setId(id);
        return myEntityRepository.save(myEntity);
    }

    public void deleteMyEntity(Long id) {
        myEntityRepository.deleteById(id);
    }

    public MyEntity getMyEntityById(Long id) {
        return myEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MyEntity not found with id: " + id));
    }

    public List<MyEntity> getAllMyEntities() {
        return myEntityRepository.findAll();
    }
}
