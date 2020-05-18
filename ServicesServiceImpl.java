package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.ServiceTypes;
import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.entity.User;
import kg.itacademy.laborexchange.model.ServicesModel;
import kg.itacademy.laborexchange.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.graalvm.compiler.options.OptionType.User;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ServiceTypesService serviceTypes;

    @Override
    public Services create(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public Services create(ServicesModel servicesModel) {
        // kak zdez pravilno zasetit ServiceTypes???
        User user = userService.getById(servicesModel.getUserId());
        if (user == null) return null;
        Services services = new Services();
        services.setName(servicesModel.getName());
        services.setDescription(servicesModel.getDescription());
        services.setLocalDate(servicesModel.getTerm());
        services.setPrice(servicesModel.getPrice());
        services.setUser(user);
                return servicesRepository.save(services);
    }

    @Override
    public List<Services> getAll() {
        return servicesRepository.findAll();
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
}
