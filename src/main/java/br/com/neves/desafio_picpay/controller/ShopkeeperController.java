package br.com.neves.desafio_picpay.controller;

import br.com.neves.desafio_picpay.domain.Shopkeeper;
import br.com.neves.desafio_picpay.domain.dto.shopkeeper.CreateShopkeeperDto;
import br.com.neves.desafio_picpay.domain.dto.shopkeeper.ResponseShopkeeperDto;
import br.com.neves.desafio_picpay.domain.dto.shopkeeper.UpdateShopkeeperDto;
import br.com.neves.desafio_picpay.service.ShopkeeperService;
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
@RequestMapping("/shopkeeper")
public class ShopkeeperController {
    @Autowired
    private ShopkeeperService service;

    @PostMapping()
    public ResponseEntity<ResponseShopkeeperDto> save (@RequestBody @Valid CreateShopkeeperDto shopkeeperDto, UriComponentsBuilder builder){
        Shopkeeper shopkeeper = service.save(new Shopkeeper(shopkeeperDto));
        URI uri = builder.path("/shopkeeper/{id}").buildAndExpand(shopkeeper.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseShopkeeperDto(shopkeeper));
    }

    @GetMapping()
    public ResponseEntity<Page<ResponseShopkeeperDto>> findAll (@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(ResponseShopkeeperDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseShopkeeperDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(new ResponseShopkeeperDto(service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseShopkeeperDto> update(@PathVariable UUID id, @RequestBody @Valid UpdateShopkeeperDto shopkeeperDto){
        return ResponseEntity.ok(new ResponseShopkeeperDto(service.update(id, new Shopkeeper(shopkeeperDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseShopkeeperDto> delete (@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
