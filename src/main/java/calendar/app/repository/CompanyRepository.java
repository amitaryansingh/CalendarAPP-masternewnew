package calendar.app.repository;

import calendar.app.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Find companies associated with a specific user
    @Query("""
        SELECT c
        FROM Company c
        JOIN c.users u
        WHERE u.id = :userId
    """)
    List<Company> findByUserId(Integer userId);
}
