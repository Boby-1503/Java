package com.exercise3.NZrobot.Controllers;

import com.exercise3.NZrobot.Models.Binder;
import com.exercise3.NZrobot.Services.NzRobotComplaintService;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class NzRobotController
{
    private final NzRobotComplaintService nzRobotComplaintService;
    @Autowired
    public NzRobotController(NzRobotComplaintService nzRobotComplaintService)
    {
        this.nzRobotComplaintService=nzRobotComplaintService;
    }
    @PostMapping("/websiteOpen")
    public Binder nzRobot()
    {
        Binder res= nzRobotComplaintService.nzRobot();
        return res ;
    }

}
