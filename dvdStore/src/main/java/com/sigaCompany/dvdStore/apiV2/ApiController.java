package com.sigaCompany.dvdStore.apiV2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "apiV2")
public class ApiController {
    @Autowired
    ApiService apiService;

    @GetMapping()
    public List<ApiDvdDto> basketDvdFindAll() {
        return apiService.basketDvdFindAll();
    }
    @PostMapping()
    public void basketDvdcreate(@RequestBody ApiDvdDto apiDvdDto) {
        apiService.basketDvdcreate(apiDvdDto);
    }
    @PutMapping("/{id}")
    public void basketDvdupdate(@PathVariable int id, @RequestBody ApiDvdDto apiDvdDto) {
        apiService.basketDvdupdate(id,apiDvdDto);
    }
    @DeleteMapping("/{id}")
    public void basketDvddelete(@PathVariable int id) {
        apiService.basketDvddelete(id);
    }
}
