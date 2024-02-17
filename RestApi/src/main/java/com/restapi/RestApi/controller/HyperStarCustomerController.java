package com.restapi.RestApi.controller;

import com.restapi.RestApi.exceptions.ResourceNotFoundException;
import com.restapi.RestApi.model.HyperStarCustomer;
import com.restapi.RestApi.repository.HyperStarCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HyperStarCustomerController {

    @Autowired
    private final HyperStarCustomerRepository hyperStarCustomerRepository;

    public HyperStarCustomerController(HyperStarCustomerRepository hyperStarCustomerRepository) {
        this.hyperStarCustomerRepository = hyperStarCustomerRepository;
    }

    @GetMapping("/customers")
    public List<HyperStarCustomer> getAllCustomer() {
        return hyperStarCustomerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<HyperStarCustomer> getCustomerById
            (@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException {
        HyperStarCustomer customer =
                hyperStarCustomerRepository.findById(customerId)
                        .orElseThrow(
                                () -> new ResourceNotFoundException
                                        ("Customer can not find on" + " " + customerId)
                        );
        return ResponseEntity.ok().body(customer);

    }

  /*
   //first method:
   @PostMapping("/customers")
    public ResponseEntity<HyperStarCustomer> createCustomer
            (@Validated @RequestBody HyperStarCustomer customer){
HyperStarCustomer starCustomer = hyperStarCustomerRepository.save(customer);
return ResponseEntity.ok().body(starCustomer);
    }
    */

    //second method
    @PostMapping("/customers")
    public HyperStarCustomer createCustomer
    (@Validated @RequestBody HyperStarCustomer customer){
        return   hyperStarCustomerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<HyperStarCustomer> updateCustomer
            (@PathVariable(value = "id") Long customerId,
             HyperStarCustomer hyperStarCustomer)
            throws ResourceNotFoundException{
HyperStarCustomer customer =
        hyperStarCustomerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("Customer can not find on" + " " + customerId));

hyperStarCustomer.setFirstName(hyperStarCustomer.getFirstName());
hyperStarCustomer.setLastName(hyperStarCustomer.getLastName());
hyperStarCustomer.setEmail(hyperStarCustomer.getEmail());
hyperStarCustomer.setCratedAt(new Date());
hyperStarCustomer.setCreatedBy(hyperStarCustomer.getCreatedBy());
hyperStarCustomer.setUpdateAt(new Date());
hyperStarCustomer.setUpdateBy(hyperStarCustomer.getUpdateBy());
hyperStarCustomer.setPhoneNumber(hyperStarCustomer.getPhoneNumber());
hyperStarCustomer.setHomeAddress(hyperStarCustomer.getHomeAddress());
hyperStarCustomer.setJobAddress(hyperStarCustomer.getJobAddress());
hyperStarCustomer.setGrade(hyperStarCustomer.getGrade());
hyperStarCustomer.setNationalCode(hyperStarCustomer.getNationalCode());
hyperStarCustomer.setChildNumber(hyperStarCustomer.getChildNumber());
hyperStarCustomer.setDrivingLicense(hyperStarCustomer.getDrivingLicense());
hyperStarCustomer.setHealthStatus(hyperStarCustomer.getHealthStatus());
final HyperStarCustomer updatedCustomer = hyperStarCustomerRepository.save(hyperStarCustomer);
return ResponseEntity.ok().body(updatedCustomer);
    }

   @DeleteMapping("/delete/{id}")
   public Map<String,Boolean> deleteCustomer
           (@PathVariable(value = "id") Long customerId) throws Exception{
HyperStarCustomer customer =
        hyperStarCustomerRepository.findById(customerId).orElseThrow(
                ()->new ResourceNotFoundException("Customer can not find on" + " " + customerId));
hyperStarCustomerRepository.delete(customer);
Map<String,Boolean> response = new HashMap<>();
response.put("deleteed",Boolean.TRUE);
return response;
   }



}
