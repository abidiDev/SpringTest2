package com.example.testt.services;

import com.example.testt.entities.Project;
import com.example.testt.entities.Sprint;
import com.example.testt.entities.User;
import com.example.testt.repositories.IprojectRepository;
import com.example.testt.repositories.IsprintRepository;
import com.example.testt.repositories.IuserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.testt.entities.Role.DEVELOPER;
import static com.example.testt.entities.Role.SCRUM_MASTER;

@Service
@AllArgsConstructor
@Getter
public class ServiceImpl implements Iservice{
    IuserRepository userRepository;
    IprojectRepository iprojectRepository;
    IsprintRepository isprintRepository;



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User c) {
        return userRepository.save(c);
    }

    @Override
    public void assignProjectToDevelopper(int projectid, int devid) {
        Project p=iprojectRepository.findById(projectid).orElse(null);
        User u=userRepository.findById(devid).orElse(null);
        if (u.getRole()==DEVELOPER) {
            p.getUsers().add(u);
            iprojectRepository.save(p);
        }
    }

    @Override
    public void assignProjectToScrumMaster(int projectid, String fName, String IName) {
        Project p=iprojectRepository.findById(projectid).orElse(null);
        List<User> us=userRepository.findByFNameAndIname(fName,IName);
        for (User u:us) {
            if (u.getRole()==SCRUM_MASTER) {
                p.getUsers().add(u);
                iprojectRepository.save(p);
            }
        }



    }

    @Override
    public Project addProject(Project p) {
        Sprint s=new Sprint();
        s.setProject(p);
        Sprint added=isprintRepository.save(s);
        return iprojectRepository.save(p);


    }

    @Override
    public User updateUser(User c) {
        return userRepository.save(c);
    }

    @Override
    public void deleteDetailUser(Integer id) {
        userRepository.deleteById(id);
    }
}
