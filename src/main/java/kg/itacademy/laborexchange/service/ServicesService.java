package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.model.ServicesModel;

import java.util.List;


public interface ServicesService {
    Services create(Services services);
    Services create(ServicesModel servicesModel, String login);
    List<Services> getAll();
    Services getOne(Long id);
    Services update(Services services);
    List<Services> getAllByName(Services name);
    List<Services> getAllByDateCreated(Services dateCreated);
    List<Services> getAllByServiceTypes(Services serviceTypes);
    List<Services> get10Services(List<Services> services, Integer page);
    List<Services> get10ByUserLoginAndPage(String login, Integer page);
    List<Services> get10ByServiceTypesId(Long id, Integer page);
}
