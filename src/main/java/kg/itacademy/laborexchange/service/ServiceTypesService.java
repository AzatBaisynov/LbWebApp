package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.ServiceTypes;

import java.util.List;

public interface ServiceTypesService {
    ServiceTypes create(ServiceTypes serviceTypes);
    ServiceTypes getById(Long id);
    List<ServiceTypes> getAll();
}
