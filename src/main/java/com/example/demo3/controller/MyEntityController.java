package com.example.demo3.controller;

import com.example.demo3.dto.MyEntityDto;
import com.example.demo3.dto.MyEntityMapper;
import com.example.demo3.entity.MyEntity;
import com.example.demo3.service.MyEntityService;
import jakarta.persistence.EntityNotFoundException;
import jdk.jfr.Enabled;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/myentities")
@Configuration
@OpenAPIDefinition(info = @Info(title = "Your API Title", version = "1.0", description = "Your API Description"))

public class MyEntityController {
    private final MyEntityService myEntityService;

    public MyEntityController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @PostMapping
    public ResponseEntity<MyEntityDto> createMyEntity(@RequestBody MyEntityDto dto) {
        MyEntityDto createdDto = myEntityService.createMyEntity(dto);
        return ResponseEntity.ok(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyEntityDto> updateMyEntity(@PathVariable Long id, @RequestBody MyEntityDto myEntityDto) {
        MyEntity myEntity = myEntityService.getMyEntityById(id)
                .orElseThrow(() -> new EntityNotFoundException("MyEntity not found with id: " + id));
        myEntity.setName(myEntityDto.getName());
        myEntity.setId(myEntityDto.getId());
        myEntity.setName(myEntityDto.getName());
        myEntity.setId(myEntityDto.getId());
        MyEntityDto updatedEntity = myEntityService.saveMyEntity(myEntity.getId(),myEntityDto);
        MyEntityDto updatedDto = new MyEntityDto(updatedEntity.getId(), updatedEntity.getName());
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        myEntityService.deleteMyEntity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntityDto> getMyEntityById(@PathVariable Long id) {
        Optional<MyEntity> myEntity = myEntityService.getMyEntityById(id);
        MyEntityDto myEntityDto = MyEntityMapper.INSTANCE.toDto(myEntity);
        return ResponseEntity.ok(myEntityDto);
    }

    @GetMapping
    public ResponseEntity<List<MyEntityDto>> getAllMyEntities() {
        List<MyEntity> myEntities = myEntityService.getAllMyEntities();
        List<MyEntityDto> myEntityDtos = MyEntityMapper.INSTANCE.toDtoList(myEntities);
        return ResponseEntity.ok(myEntityDtos);
    }
}
