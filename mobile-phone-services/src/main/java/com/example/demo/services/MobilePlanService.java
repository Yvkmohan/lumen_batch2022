package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.MobilePlan;
import com.example.demo.utils.*;
import com.training.exceptions.*;
import com.example.demo.repo.PlanRepository;
@Service
public class MobilePlanService {
private PlanRepository repo;
@Autowired
public MobilePlanService(PlanRepository repo) {
              super();
              this.repo = repo;
}
public List<MobilePlan> findAll(){
              return this.repo.findAll();
}
public MobilePlan add(MobilePlan plan) {
              return this.repo.save(plan);
}
public MobilePlan findById(int id) {
              String message=new StringBuilder("Element with Guven Id ").append(id).append(" Not Found").toString();
              return this.repo.findById(id).orElseThrow(()->new RuntimeException(message));
              
}
public MobilePlan update(MobilePlan entity) {
              return this.repo.save(entity);
}
public MobilePlan remove(int id) {
              MobilePlan element=this.findById(id);
              this.repo.deleteById(id);
              return element;
}
public List<MobilePlan> findByPlanName(String planName){
              return this.repo.findByPlanName(planName);
}
public List<MobilePlan> getCostGreaterThan(double amount){
              return this.repo.getCostGreaterThan(amount);
}
public int updateValidity(String updateValidity,String planName) {
              return this.repo.updateValidity(updateValidity, planName);
}



}
