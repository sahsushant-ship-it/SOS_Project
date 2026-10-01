package com.sos.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.sos.dto.UserRequestDto;
import com.sos.dto.UserResponseDto;
import com.sos.entity.User;
import com.sos.repository.UserRepository;
import com.sos.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserResponseDto addUser(UserRequestDto requestDto) {
		User user = modelMapper.map(requestDto, User.class);
		User u=urepo.save(user);
		return modelMapper.map(u, UserResponseDto.class);
	}


	@Override
	public UserResponseDto getUserById(Integer id) {
		User user= urepo.findById(id)
									.orElseThrow(() -> new RuntimeException("User Not found with id: "+id));
		return modelMapper.map(user, UserResponseDto.class);
	}

	@Override
	public UserResponseDto updateUser(Integer id, UserRequestDto requestDto) {
		User existing = urepo.findById(id)
				.orElseThrow(()-> new RuntimeException("User not found with id: "+id));
		
		modelMapper.map(requestDto, existing);
		User updated = urepo.save(existing);
		return modelMapper.map(updated, UserResponseDto.class);
	}

	@Override
	public void deleteUser(Integer id) {
		if(!urepo.existsById(id)) {
			throw new RuntimeException("user not found with id: "+id);
		}
		urepo.deleteById(id);
		
	}


	@Override
	public List<UserResponseDto> getAllUsers() {
		
		return urepo.findAll().stream()
							.map(user -> modelMapper.map(user, UserResponseDto.class))
							.collect(Collectors.toList());
	}

}
