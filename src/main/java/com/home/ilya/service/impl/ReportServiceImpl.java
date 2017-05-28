package com.home.ilya.service.impl;

import com.home.ilya.model.Employee;
import com.home.ilya.model.Report;
import com.home.ilya.service.api.ReportService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ReportServiceImpl implements ReportService {
    private RestTemplate restTemplate;

    public ReportServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Report buildReport(String host) {
        Employee[] employees = restTemplate.getForObject(host + "/api/employees", Employee[].class);
        int years = 0;
        int months= 0;
        int days= 0;
        int size = employees.length;
        for (Employee employee : employees) {
            Period between = Period.between(employee.getEmploymentDate(), employee.getFiredDate() != null ? employee.getFiredDate() : LocalDate.now());
            years += between.getYears();
            months += between.getMonths();
            days += between.getDays();
        }
        Report report = new Report();
        report.setReportCreationDate(LocalDate.now());
        report.setAverageWorkDurationInCompany(Period.of(years/size,months/size,days/size));
        return report;
    }

}
