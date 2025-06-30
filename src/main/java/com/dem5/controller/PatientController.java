package com.dem5.controller;

import com.dem5.tod.BaseResponseDTO;
import com.dem5.entity.Patients;
import com.dem5.services.PatientServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    }

