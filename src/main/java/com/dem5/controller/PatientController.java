package com.dem5.controller;

import com.dem5.tod.BaseResponseDTO;
import com.dem5.entity.Patients;
import com.dem5.services.PatientServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")

public class PatientController {
    private final PatientServices patientServices;

    public PatientController(PatientServices patientServices) {
        this.patientServices = patientServices;
    }
    @GetMapping
    public BaseResponseDTO<List<Patients>>patient(){
        try{
            List<Patients>patient1=patientServices.findAll();
            return new BaseResponseDTO<>("patient list",HttpStatus.OK.value(),patient1,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("there is no list of patients", HttpStatus.INTERNAL_SERVER_ERROR.value(),null, e.getMessage());
        }

        }
        @PostMapping
    public BaseResponseDTO<Patients>patientrs(@RequestBody Patients patients){
        try{
            Patients patients1=patientServices.saved(patients);
            return new BaseResponseDTO<>("the patients are saved",HttpStatus.OK.value(),patients1,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("the pateints are not saved",HttpStatus.INTERNAL_SERVER_ERROR.value(),null, e.getMessage());
        }
        }
        @GetMapping("/{id}")
    public BaseResponseDTO<Optional<Patients>>patientse(@PathVariable Long id){
        try{

            Optional<Patients>patients1=patientServices.findById(id);
            if(patients1.isEmpty()){
                return new BaseResponseDTO<>("your patient id is not found",HttpStatus.NOT_FOUND.value(), null,null);
            }
            return new BaseResponseDTO<>("your patient id is correct",HttpStatus.OK.value(), patients1,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("your patient id is incorrect",HttpStatus.INTERNAL_SERVER_ERROR.value(),null, e.getMessage());
        }
        }
        @GetMapping("/filter")
    public BaseResponseDTO<Patients>searchpatient(@RequestParam String patientName){
        try{
//            Optional<Patients>patient1=patientServices.findById(id);
//            if(patient1.isEmpty()){
//                return new BaseResponseDTO<>("your patient name is not found",HttpStatus.NOT_FOUND.value(), null,null);
//            }
            Patients patients1=patientServices.findBypatientName(patientName);
            return new BaseResponseDTO<>("your patient id is correct",HttpStatus.OK.value(), patients1,null);


        }catch (Exception e){
            return new BaseResponseDTO<>("not found here",HttpStatus.INTERNAL_SERVER_ERROR.value(), null,e.getMessage());
        }
        }
        @PutMapping("/{patientId}")
    public BaseResponseDTO<Patients>patientes(@PathVariable Long patientId,@RequestBody Patients patients){
        try{
            Optional<Patients>patientses=patientServices.findById(patientId);
            if(patientses.isEmpty()){
                return new BaseResponseDTO<>("your id is not present",HttpStatus.NOT_FOUND.value(),null,null);
            }
            Patients updatepatient=patientses.get();
            updatepatient.setPatientName(patients.getPatientName());
            updatepatient.setAge(patients.getAge());
            updatepatient.setAddress(patients.getAddress());


            Patients savedpatient=patientServices.updatepatients(updatepatient);
            return new BaseResponseDTO<>("your patient information is updated",HttpStatus.OK.value(), savedpatient,null);
        }catch(Exception e){
            return new BaseResponseDTO<>("not updated",HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
        }
        }
        @DeleteMapping("/{id}")
    public BaseResponseDTO<Void>patientsess(@PathVariable Long id){
        try{
            Optional<Patients>existpatient=patientServices.findById(id);
            if(existpatient.isEmpty()){
                return new BaseResponseDTO<>("your id is inncorrect",HttpStatus.NOT_FOUND.value(),null,null);
            }
            patientServices.deleteById(id);
            return new BaseResponseDTO<>("deleted successfully",HttpStatus.OK.value(), null,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("not delted",HttpStatus.INTERNAL_SERVER_ERROR.value(),null,e.getMessage());
        }
        }


    }

