package com.dem5.controller;

import com.dem5.model.Doctor;
import com.dem5.services.DoctorService;
import com.dem5.dot.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        @PostMapping
    public BaseResponseDTO<Doctor>doctors(@RequestBody Doctor doctor){
        try{
            Doctor savedoctors=doctorService.saved(doctor);
            return new BaseResponseDTO<>("the Doctors are saved",HttpStatus.OK.value(), savedoctors,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("docotors are not saved",HttpStatus.INTERNAL_SERVER_ERROR.value(),null,e.getMessage());
        }
        }
        @GetMapping("/{id}")
    public BaseResponseDTO<Optional<Doctor>>doctors(@PathVariable Long id){
        try{
            Optional<Doctor>doctorse=doctorService.findById(id);
            if(doctorse.isEmpty()){
                return new BaseResponseDTO<>("your id is incorrect",HttpStatus.NOT_FOUND.value(), null,null);
            }
            return new BaseResponseDTO<>("the doctors is here you can meet ",HttpStatus.OK.value(),doctorse,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("a doctor id is not here",HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
        }


       }
       @GetMapping("/filter")
    public BaseResponseDTO<Doctor>doctorse(@RequestParam String doctorName){
        try{

            Doctor doctorse1=doctorService.findBydoctorName(doctorName);
            return new BaseResponseDTO<>("here is a doctor",HttpStatus.OK.value(),doctorse1,null );
        }catch (Exception e){
            return new BaseResponseDTO<>("the doctor name is not exist",HttpStatus.INTERNAL_SERVER_ERROR.value(),null, e.getMessage());
        }
       }

@PutMapping("/{doctorId}")
    public BaseResponseDTO<Doctor>updateDoctor(@PathVariable Long doctorId,@RequestBody Doctor doctor){
        try{
            Optional<Doctor>existdoctor=doctorService.findById(doctorId);
            if(existdoctor.isEmpty()){
                return new BaseResponseDTO<>("your is is not exist",HttpStatus.NOT_FOUND.value(),null,null);
            }
            Doctor updatedoctors=existdoctor.get();
            updatedoctors.setDoctorName(doctor.getDoctorName());
            updatedoctors.setSpecialization(doctor.getSpecialization());
            updatedoctors.setAvailability(doctor.getAvailability());
            Doctor saveddoctors=doctorService.updatsave(updatedoctors);
            return new BaseResponseDTO<>("doctor update",HttpStatus.OK.value(), saveddoctors,null);
        }catch (Exception e){
            return new BaseResponseDTO<>("your doctors inforamation is not updated",HttpStatus.INTERNAL_SERVER_ERROR.value(), null,null);
        }
}
}

