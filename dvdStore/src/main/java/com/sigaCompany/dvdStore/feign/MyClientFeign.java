package com.sigaCompany.dvdStore.feign;

import com.sigaCompany.dvdStore.apiV2.ApiDvdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name= "BasketDvdController", url= "http://localhost:9090")
public interface MyClientFeign {

    @PostMapping("/basket-dvd")
    void basketDvdcreate(ApiDvdDto apiDvdDto);
    @GetMapping("/basket-dvd")
    List<ApiDvdDto> basketDvdFindAll();
    @PutMapping("/basket-dvd/{id}")
    void basketDvdupdate(@PathVariable (value = "id") int id,@RequestBody ApiDvdDto apiDvdDto);
    @DeleteMapping("/basket-dvd/{id}")
    void basketDvddelete(@PathVariable int id);
}
