package com.example.testt.services;

import com.example.testt.entities.Project;
import com.example.testt.entities.Sprint;
import com.example.testt.entities.User;

import java.util.List;

public interface Iservice {
    public User addUser(User c);

    public void assignProjectToDevelopper(int projectid, int devid);
    public void assignProjectToScrumMaster(int projectid, String fName, String IName);
    public Project addProject(Project p);
    public List<Project> getProjectByScrumMaster(String fName, String IName);
    public void addsprintAndAssignToProject(Sprint sprint, int idProject);
    public void getProjectCurrentSprints();

}
