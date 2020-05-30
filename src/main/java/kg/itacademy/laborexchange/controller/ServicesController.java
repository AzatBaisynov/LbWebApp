package kg.itacademy.laborexchange.controller;
import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.model.ServicesModel;
import kg.itacademy.laborexchange.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public Services create(@RequestBody ServicesModel servicesModel, Principal principal){
        return servicesService.create(servicesModel, principal.getName());
    }
    @GetMapping
    public List<Services> getAll() {
        return servicesService.getAll();
    }

    @GetMapping("/{id}")
    public Services getOne(@PathVariable Long id){
        return servicesService.getOne(id);
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

    @GetMapping("/my/{page}")
    public List<Services> getMyListByPage(@PathVariable Integer page, Principal principal){
        return servicesService.get10ByUserLoginAndPage(principal.getName(), page);
    }

    @GetMapping("/by-category/{serviceTypeId}/{page}")
    public List<Services> getByServiceTypesId(@PathVariable Long serviceTypeId,
                                              @PathVariable Integer page){
        return servicesService.get10ByServiceTypesId(serviceTypeId, page);
    }
}
