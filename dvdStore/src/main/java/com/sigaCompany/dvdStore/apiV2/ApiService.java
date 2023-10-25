package com.sigaCompany.dvdStore.apiV2;

import com.sigaCompany.dvdStore.feign.MyClientFeign;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
@Autowired
    DvdRepository dvdRepository;
private final MyClientFeign myClientFeign;
public ApiService(MyClientFeign myClientFeign){
    this.myClientFeign = myClientFeign;
}

    public void basketDvdcreate(ApiBasketDto apiBasketDto) {
        myClientFeign.basketDvdcreate(apiBasketDto);
    }
    public List<ApiBasketDto> basketDvdFindAll() {
    return myClientFeign.basketDvdFindAll();
    }
    public void basketDvdupdate(int id, ApiBasketDto apiDvdDto) {
        myClientFeign.basketDvdupdate(id,apiDvdDto);
    }


    public void basketDvddelete(int id) {
        myClientFeign.basketDvddelete(id);
    }
}
