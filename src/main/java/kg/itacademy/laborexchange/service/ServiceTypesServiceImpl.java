package kg.itacademy.laborexchange.service;

import kg.itacademy.laborexchange.entity.ServiceTypes;
import kg.itacademy.laborexchange.repository.ServiceTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypesServiceImpl implements ServiceTypesService {
    @Autowired
    private ServiceTypesRepository serTypesRepo;

    @Override
    public ServiceTypes create(ServiceTypes serviceTypes) {
        return serTypesRepo.save(serviceTypes);
    }

    @Override
    public ServiceTypes getById(Long id) {
        return serTypesRepo.getOne(id);
    }

    @Override
    public List<ServiceTypes> getAll() {
        return serTypesRepo.findAll();
    }
}
