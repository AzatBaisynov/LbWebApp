package kg.itacademy.laborexchange.controller;

import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.model.ServicesModel;
import kg.itacademy.laborexchange.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @PostMapping("/old")
    public Services create(@RequestBody Services services) {
        return servicesService.create(services);
    }
@PostMapping
public Services create(@RequestBody ServicesModel servicesModel){
        return servicesService.create(servicesModel);
}
    @GetMapping
    public List<Services> getAll() {
        return servicesService.getAll();
    }

    @PutMapping
    public Services update(@RequestBody Services services) {
        return servicesService.update(services);
    }

    @GetMapping("/{name}")
    public List<Services> searchAllByName(@PathVariable Services name) {
        return servicesService.getAllByName(name);
    }

    @GetMapping("/{dateCreated}")
    public List<Services> searchAllByDateCreated(@PathVariable Services dateCreated) {
        return servicesService.getAllByDateCreated(dateCreated);
    }

    @GetMapping("/{serviceTypes}")
    public List<Services> searchAllByServiceTypes(@PathVariable Services serviceTypes) {
        return servicesService.getAllByServiceTypes(serviceTypes);
    }
}
