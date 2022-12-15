package com.example.testt.services;

import com.example.testt.entities.Project;
import com.example.testt.entities.Sprint;
import com.example.testt.entities.User;
import com.example.testt.repositories.IprojectRepository;
import com.example.testt.repositories.IsprintRepository;
import com.example.testt.repositories.IuserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
        User u=userRepository.findByFNameAndIname(fName,IName);

            if (u.getRole()==SCRUM_MASTER) {
                p.getUsers().add(u);
                iprojectRepository.save(p);
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
    public List<Project> getProjectByScrumMaster(String fName, String IName) {
        List<Project> projects=new ArrayList<Project>();
        User u=userRepository.findByFNameAndIname(fName,IName);
            if (u.getRole()==SCRUM_MASTER) {
               projects= (List<Project>) u.getProjects();
            }
            return projects;
        }

    @Override
    public void addsprintAndAssignToProject(Sprint sprint, int idProject) {
        Project p =iprojectRepository.findById(idProject).orElse(null);
        sprint.setProject(p);
        Sprint added=isprintRepository.save(sprint);


    }

    @Override
    @Scheduled(cron = "*/30 * * * * *")

    public void getProjectCurrentSprints() {
        List<Project> projects=new ArrayList<Project>();
        Boolean enCours;
        Date todayDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        for (Project p: projects) {
            enCours=false;
            for (Sprint s: p.getSprints()) {
                if (s.getStartDate().getTime()-todayDate.getTime()<=0){
                    enCours=true;
                }
                if(enCours==true){
                    System.out.println(s.toString());
                }
            }

            }

    }


}
