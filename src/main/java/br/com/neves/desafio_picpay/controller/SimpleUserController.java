package br.com.neves.desafio_picpay.controller;

import br.com.neves.desafio_picpay.domain.SimpleUser;
import br.com.neves.desafio_picpay.domain.dto.simple_user.CreateSimpleUserDto;
import br.com.neves.desafio_picpay.domain.dto.simple_user.ResponseSimpleUserDto;
import br.com.neves.desafio_picpay.domain.dto.simple_user.UpdateSimpleUserDto;
import br.com.neves.desafio_picpay.service.SimpleUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/simple-user")
public class SimpleUserController {

    @Autowired
    private SimpleUserService service;

    @PostMapping()
    public ResponseEntity<ResponseSimpleUserDto> save (@RequestBody @Valid CreateSimpleUserDto simpleUserDto, UriComponentsBuilder builder){
        SimpleUser simpleUser = service.save(new SimpleUser(simpleUserDto));
        URI uri = builder.path("/simpleUser/{id}").buildAndExpand(simpleUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseSimpleUserDto(simpleUser));
    }

    @GetMapping()
    public ResponseEntity<Page<ResponseSimpleUserDto>> findAll (@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(ResponseSimpleUserDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSimpleUserDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(new ResponseSimpleUserDto(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSimpleUserDto> update(@PathVariable UUID id, @RequestBody @Valid UpdateSimpleUserDto simpleUserDto){
        return ResponseEntity.ok(new ResponseSimpleUserDto(service.update(id, new SimpleUser(simpleUserDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseSimpleUserDto> delete (@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
