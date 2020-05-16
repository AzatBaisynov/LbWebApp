package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.ServicesModel;

import java.util.List;

public interface ServicesService {
    Services create(Services services);
    Services create(ServicesModel servicesModel);
    List<Services> getAll();
    Services update(Services services);
    List<Services> getAllByName(Services name);
    List<Services> getAllByDateCreated(Services dateCreated);
    List<Services> getAllByServiceTypes(Services serviceTypes);
}
