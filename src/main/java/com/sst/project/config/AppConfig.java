package com.sst.project.config;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sst.project.dto.UserDTO;
import com.sst.project.entity.Role;
import com.sst.project.entity.User;

@Configuration
public class AppConfig {

	@Bean
	public LocalDateTime getLocalDateTimeBean() {
		return LocalDateTime.now();
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
    public ModelMapper modelMapper() {
//       return new ModelMapper();
		
		ModelMapper modelMapper = new ModelMapper();
		
		PropertyMap<User, UserDTO> userMap = new PropertyMap<User, UserDTO>() {
	        @Override
	        protected void configure() {
	            skip(destination.getPassword()); // DTO has no password, optional
	        }
	    };
	
	    modelMapper.addMappings(userMap);
	    
	    PropertyMap<UserDTO, User> dtoToEntityMap = new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {
            	map().setFirstName(source.getFirstName());
            	map().setMiddleName(source.getMiddleName());
            	map().setLastName(source.getLastName());
            	map().setEmail(source.getEmail());
            	map().setMobileNo(source.getMobileNo());
            	map().setGender(source.getGender());
            	
            	map().setRole(new Role(source.getRoleId()));
            }
        };
        modelMapper.addMappings(dtoToEntityMap);
	    
		return modelMapper;
    }
}
