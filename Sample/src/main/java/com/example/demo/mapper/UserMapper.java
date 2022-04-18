package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Combine;
import com.example.demo.model.Ben;
import com.example.demo.model.Ram;


@Mapper
public interface UserMapper {
void doinsert(Ram ram);
int doLoging(Ram ram);

void doInsert(Ben ben);
int timeLoging(Ben ben);
int  doUpdate(Ben ben);

List<Combine> doSelect(Ram ram);
void editUser(Ram ram);
void deleteUser(Ram ram);

List<Combine> searchUser (Ram ram);






}
