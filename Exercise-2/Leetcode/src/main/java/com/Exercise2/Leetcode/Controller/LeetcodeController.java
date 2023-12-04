package com.Exercise2.Leetcode.Controller;

import com.Exercise2.Leetcode.Service.LeetcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leetcode")
public class LeetcodeController
{
    private final LeetcodeService leetcodeService;
    @Autowired
    public LeetcodeController(LeetcodeService leetcodeService)
    {
        this.leetcodeService=leetcodeService;
    }

    @GetMapping("/paste")
    public String pastingCode()
    {
        return leetcodeService.pastingCode();
    }
}
