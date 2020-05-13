package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.Services;
import kg.itacademy.laborexchange.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.graalvm.compiler.options.OptionType.User;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
   private ServicesRepository servicesRepository;

    @Override
    public Services create(Services services) {
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
