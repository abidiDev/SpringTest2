package com.example.testt.controllers;

import com.example.testt.entities.Project;
import com.example.testt.entities.Sprint;
import com.example.testt.entities.User;
import com.example.testt.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("controller")
@RestController
@AllArgsConstructor

public class Controller {
    Iservice iservice;

    @PostMapping("/addUser")
    @ResponseBody
    public User addUser( @RequestBody User c){return iservice.addUser(c);}
    @GetMapping("/assignProjectToDevelopper/{projectid}/{devid}")

    public void assignProjectToDevelopper(@PathVariable int projectid,@PathVariable int devid){iservice.assignProjectToDevelopper(projectid, devid);}
    @PutMapping("/assignProjectToDevelopper/{projectid}/{fName}/{IName}")

    public void assignProjectToScrumMaster(@PathVariable int projectid, @PathVariable String fName,@PathVariable String IName){iservice.assignProjectToScrumMaster(projectid,fName,IName);};
    @PostMapping("/addProject")
    @ResponseBody
    public Project addProject(@RequestBody Project p){return iservice.addProject(p);}
    @GetMapping("/getProjectByScrumMaster/{fName}/{IName}")

    public List<Project> getProjectByScrumMaster(@PathVariable String fName,@PathVariable String IName){return iservice.getProjectByScrumMaster(fName,IName);}
    @PostMapping("/addsprintAndAssignToProject/{idProject}")
    @ResponseBody
    public void addsprintAndAssignToProject(@RequestBody Sprint sprint, int idProject){iservice.addsprintAndAssignToProject(sprint,idProject);}
}
