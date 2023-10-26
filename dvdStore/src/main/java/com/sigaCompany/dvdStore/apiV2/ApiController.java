package com.sigaCompany.dvdStore.apiV2;

import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "apiV2")
public class ApiController {
    @Autowired
    ApiService apiService;


}
