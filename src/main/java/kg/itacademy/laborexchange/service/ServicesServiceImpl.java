package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.ServiceTypes;
import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.model.ServicesModel;
import kg.itacademy.laborexchange.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceTypesService serviceTypesService;

    @Override
    public Services create(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public Services create(ServicesModel servicesModel, String login) {
        Services services = new Services();
        services.setName(servicesModel.getName());
        services.setDescription(servicesModel.getDescription());
        services.setPrice(servicesModel.getPrice());
        services.setLocalDate(servicesModel.getTerm());
        services.setUser(userService.getByLogin(login));
        services.setServiceTypes(serviceTypesService.getById(servicesModel.getServiceTypes()));
        services.setStatus(1);
        return create(services);
    }

    @Override
    public List<Services> getAll() {
        return servicesRepository.findAll();
    }

    @Override
    public Services getOne(Long id) {
        return servicesRepository.getOne(id);
    }

    @Override
    public Services update(Services services) {
        return servicesRepository.save(services);
    }


    @Override
    public List<Services> getAllByName(Services name) {
        return servicesRepository.findAllByName(name);
    }

    @Override
    public List<Services> getAllByDateCreated(Services dateCreated) {
        return servicesRepository.findAllByDateCreated(dateCreated);
    }

    @Override
    public List<Services> getAllByServiceTypes(Services serviceTypes) {
        return servicesRepository.findAllByServiceTypes(serviceTypes);
    }

    @Override
    public List<Services> get10Services(List<Services> servicesList,Integer page) {
        Integer counter = page * 10;
        List<Services> services = new LinkedList<>();
        for (int i = 10; i > 0; i--){
            services.add(0, servicesList.get(counter--));
        }
        return services;
    }

    @Override
    public List<Services> get10ByUserLoginAndPage(String login, Integer page) {
        List<Services> list = servicesRepository.getAllByUser_Login(login);
        return get10Services(list, page);
    }

    @Override
    public List<Services> get10ByServiceTypesId(Long id, Integer page) {
        List<Services> list = servicesRepository.getAllByServiceTypes_IdAndStatus(id, 1);
        return get10Services(list, page);
    }
}