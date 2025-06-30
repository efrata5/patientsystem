package com.dem5.controller;

import com.dem5.entity.Doctor;
import com.dem5.services.DoctorService;
import com.dem5.tod.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")

public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
        public BaseResponseDTO<List<Doctor>>doctors(){
        try{
            List<Doctor>doctor1=doctorService.findAll();
            return new BaseResponseDTO<>("doctors list",HttpStatus.OK.value(), doctor1,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("there is no doctors list", HttpStatus.INTERNAL_SERVER_ERROR.value(),null, e.getMessage());
        }
        }
}
