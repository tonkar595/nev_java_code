package com.example.demo.service;

import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//unknowntation

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void saveStudent(UserReq userReq){
        StudentEntity studentEntity = new StudentEntity();


        studentEntity.setFirstName(userReq.getFirstName());
        studentEntity.setLastName(userReq.getLastName());
        studentEntity.setNickName(userReq.getNickName());
        studentEntity.setEmail(userReq.getEmail());
        studentEntity.setPhone(userReq.getPhone());
        studentEntity.setPoint(userReq.getPoint());
        studentRepository.save(studentEntity);
//        return studentRepository.save(studentEntity); // ::studentEntity = studentRepository.save(studentEntity)

    }

    public List<UserRes> findAll(){
        List<UserRes> studentResList = new ArrayList<>();
        List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();

        for(int i = 0;i < studentEntityList.size(); i++){
            UserRes userRes =  new UserRes();
            userRes.setId(studentEntityList.get(i).getId());
            userRes.setFirstName(studentEntityList.get(i).getFirstName());
            userRes.setLastName(studentEntityList.get(i).getLastName());
            userRes.setNickName(studentEntityList.get(i).getNickName());
            userRes.setEmail(studentEntityList.get(i).getEmail());
            userRes.setPhone(studentEntityList.get(i).getPhone());
            userRes.setPoint(studentEntityList.get(i).getPoint());
            studentResList.add(userRes);
        }
        return studentResList;
    }

    public UserRes findById(long id){
        StudentEntity studentEntity = studentRepository.findById(id).get();
        UserRes userRes = new UserRes();
        userRes.setId(studentEntity.getId());
        userRes.setFirstName(studentEntity.getFirstName());
        userRes.setLastName(studentEntity.getLastName());
        userRes.setNickName(studentEntity.getNickName());
        userRes.setEmail(studentEntity.getEmail());
        userRes.setPhone(studentEntity.getPhone());
        userRes.setPoint(studentEntity.getPoint());

        return userRes;
    }





}
