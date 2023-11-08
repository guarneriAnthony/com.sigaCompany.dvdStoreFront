package com.sigaCompany.dvdStore;

import com.sigaCompany.dvdStore.controllers.DvdController;
import com.sigaCompany.dvdStore.dto.DvdDTO;
import com.sigaCompany.dvdStore.services.DvdService;
import com.sigaCompany.dvdStore.services.DvdServiceModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DvdControllerTest {

    @InjectMocks
    private DvdController dvdController;

    @Mock
    private DvdService dvdService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddDvdStore() {
        DvdDTO dvdDTO = new DvdDTO(1, "name","type", 10, 9, "description", "image");
        when(dvdService.add(any())).thenReturn(true);
        boolean result = dvdController.addDvdStore(dvdDTO);
        assertEquals(true, result);
    }

    @Test
    public void testUpdateDvd() {
        int id = 1;
        DvdDTO dvdDTO = new DvdDTO(1, "name","type", 10, 9, "description", "image");
        when(dvdService.updateDvd(eq(id), any())).thenReturn(true);
        ResponseEntity<String> response = dvdController.updateDvd(id, dvdDTO);
        assertEquals("Dvd updated successfully", response.getBody());
    }

    @Test
    public void testFindAll() {
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        when(dvdService.findAll()).thenReturn(dvdServiceModels);
        List<DvdDTO> result = dvdController.findAll();
    }
}
