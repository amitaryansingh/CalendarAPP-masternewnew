package calendar.app.services.impl;

import calendar.app.entities.Company;
import calendar.app.entities.User;
import calendar.app.repository.CompanyRepository;
import calendar.app.repository.UserRepository;
import calendar.app.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Override
    public Company createCompany(Company company) {
        if (company.getUsers() != null && !company.getUsers().isEmpty()) {
            for (User user : company.getUsers()) {
                userRepository.findById(user.getId())
                        .orElseThrow(() -> new RuntimeException("User with ID not found"));
            }
        }
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public Company updateCompany(Integer id, Company companyDetails) {
        Company existingCompany = getCompanyById(id);
        existingCompany.setName(companyDetails.getName());
        existingCompany.setLogoUrl(companyDetails.getLogoUrl());
        existingCompany.setLocation(companyDetails.getLocation());
        existingCompany.setLinkedInProfile(companyDetails.getLinkedInProfile());
        existingCompany.setEmails(companyDetails.getEmails());
        existingCompany.setPhoneNumbers(companyDetails.getPhoneNumbers());
        existingCompany.setComments(companyDetails.getComments());
        existingCompany.setCommunicationPeriodicity(companyDetails.getCommunicationPeriodicity());
        return companyRepository.save(existingCompany);
    }

    @Override
    public void deleteCompany(Integer id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found");
        }
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

//    @Override
//    public List<Company> getCompaniesByUserId(Integer userId) {
//        return companyRepository.findByUsersId(userId);
//    }
}
