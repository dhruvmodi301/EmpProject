package com.employee.employeedetails.controller;

import com.employee.employeedetails.entity.AccountData;
import com.employee.employeedetails.entity.EmployeeDetailsData;
import com.employee.employeedetails.service.EmployeeDetailsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "error", defaultValue = "false") boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping(name = "/")
    public String navigateCustomer() {
        AccountData accountData = new AccountData();

        if (ObjectUtils.isEmpty(accountData)) {
            return "redirect:/login";
        }

        return "redirect:/employee/home";
    }
}