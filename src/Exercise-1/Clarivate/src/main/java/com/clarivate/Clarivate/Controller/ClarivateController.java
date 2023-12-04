package com.clarivate.Clarivate.Controller;
import com.clarivate.Clarivate.Entity.ClarivateEntity;
import com.clarivate.Clarivate.Service.ClarivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/titles")
public class ClarivateController
{
    @Autowired
    private ClarivateService clarivateService;
    @RequestMapping(method= RequestMethod.GET)
    public Map<String,List<String>> getAllData()
    {
        return clarivateService.getAllData();
    }


}
