package kg.itacademy.laborexchange.controller;

import kg.itacademy.laborexchange.entity.ServiceTypes;
import kg.itacademy.laborexchange.service.ServiceTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.List;

@RestController
@RequestMapping("/service/types")
public class ServiceTypesController {
    @Autowired
    private ServiceTypesService serviceTypesService;

    @PostMapping
    public ServiceTypes create(@RequestBody ServiceTypes serviceTypes){
        return serviceTypesService.create(serviceTypes);
    }

    @GetMapping
    public List<ServiceTypes> getAll(){
        return serviceTypesService.getAll();
    }
}
