package calendar.app.services;

import calendar.app.entities.Company;
import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    Company getCompanyById(Integer id);

    Company updateCompany(Integer id, Company companyDetails);

    void deleteCompany(Integer id);

    List<Company> getAllCompanies();

//    List<Company> getCompaniesByUserId(Integer userId);
}
