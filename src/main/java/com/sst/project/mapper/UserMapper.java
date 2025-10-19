package com.sst.project.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sst.project.dto.UserDTO;
import com.sst.project.entity.User;

@Component
public class UserMapper {

	private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    public UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    } 
	
    public User convertToEntity(UserDTO UserDTO) {
		return modelMapper.map(UserDTO, User.class);
        
//    	User User = new User();
//		
//		User.setFirstName(UserDTO.getFirstName());
//		User.setMiddleName(UserDTO.getMiddleName());
//		User.setLastName(UserDTO.getLastName());
//		User.setEmail(UserDTO.getEmail());
//		User.setMobileNo(UserDTO.getMobileNo());
//		User.setGender(UserDTO.getGender());
//		
//		return User;
    }
    
    public List<User> toEntityList(List<UserDTO> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public List<UserDTO> toDTOList(List<User> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
