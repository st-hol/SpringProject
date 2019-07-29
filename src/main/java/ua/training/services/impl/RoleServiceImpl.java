package ua.training.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.entities.Complaint;
import ua.training.entities.Role;
import ua.training.entities.User;
import ua.training.repositories.ComplaintRepository;
import ua.training.repositories.RoleRepository;
import ua.training.services.ComplaintService;
import ua.training.services.RoleService;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return Lists.newArrayList(roleRepository.findAll());
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role save(Role complaint) {
        return roleRepository.save(complaint);
    }

    @Autowired
    public void setComplaintRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


//    @Override
//    public List<Role> findAllByUserName(String userName) {
//        return roleRepository.findByPersons_userName(userName);
//    }


    @Override
    public List<Role> findAllByUser(User user) {
        return roleRepository.findAllByUsers(user);
    }
}