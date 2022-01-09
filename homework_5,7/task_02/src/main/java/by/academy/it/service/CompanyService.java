package by.academy.it.service;

import by.academy.it.pojo.Company;

public class CompanyService {

    public void defaultInit() {
        System.out.println("CompanyService default init method");
    }

    public void print(Company company) {
        System.out.println("This is " + company.getCompanyName() + " company");
    }

    public void defaultDestroy() {
        System.out.println("CompanyService default destroy method");
    }
}
