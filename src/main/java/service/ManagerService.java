package service;

import entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> getAllManagers();
    Manager getManagerById(Long id);
    Manager createManager(Manager manager);

}

