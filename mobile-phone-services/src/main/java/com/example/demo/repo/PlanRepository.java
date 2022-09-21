package com.example.demo.repo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.MobilePlan;
public interface PlanRepository extends JpaRepository<MobilePlan, Integer> {
    
    List<MobilePlan> findByPlanName(String planName);
    
    @Query(value = "SELECT * FROM lumen_mobile_plans WHERE cost>:searchAmount",nativeQuery = true)
    List<MobilePlan> getCostGreaterThan(@Param("searchAmount") double amount);
    
    @Query(nativeQuery = false,value = "update MobilePlan set validity=:newValue where planName=:pname ")
    @Modifying
    @Transactional
    int updateValidity(@Param("newValue") String updatedValidity,@Param("pname") String planName);
}