package com.example.servingwebcontent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myentities")

public class MyEntityController {
    private final MyEntityService myEntityService;

    public MyEntityController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @PostMapping
    public ResponseEntity<MyEntity> createMyEntity(@RequestBody MyEntity myEntity) {
        MyEntity createdEntity = myEntityService.createMyEntity(myEntity);
        return ResponseEntity.ok(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyEntity> updateMyEntity(@PathVariable Long id, @RequestBody MyEntity myEntity) {
        MyEntity updatedEntity = myEntityService.updateMyEntity(id, myEntity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        myEntityService.deleteMyEntity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> getMyEntityById(@PathVariable Long id) {
        MyEntity myEntity = myEntityService.getMyEntityById(id);
        return ResponseEntity.ok(myEntity);
    }

    @GetMapping
    public ResponseEntity<List<MyEntity>> getAllMyEntities() {
        List<MyEntity> myEntities = myEntityService.getAllMyEntities();
        return ResponseEntity.ok(myEntities);
    }
}
