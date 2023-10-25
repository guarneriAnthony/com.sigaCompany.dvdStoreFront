package com.sigaCompany.dvdStore.apiV2;

import com.sigaCompany.dvdStore.feign.MyClientFeign;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ApiService {
@Autowired
    DvdRepository dvdRepository;
private final MyClientFeign myClientFeign;
public ApiService(MyClientFeign myClientFeign){
    this.myClientFeign = myClientFeign;
}

    public void basketDvdcreate(ApiDvdDto apiDvdDto) {
        myClientFeign.basketDvdcreate(apiDvdDto);
    }
    public List<ApiDvdDto> basketDvdFindAll() {
    return myClientFeign.basketDvdFindAll();
    }
    public void basketDvdupdate(int id, ApiDvdDto apiDvdDto) {
        myClientFeign.basketDvdupdate(id,apiDvdDto);
    }


    public void basketDvddelete(int id) {
        myClientFeign.basketDvddelete(id);
    }
}
