package com.magic.project.models.dto;

import com.magic.project.models.Agency;
import com.magic.project.models.User;
import org.modelmapper.ModelMapper;

public class AgencyUserMapper {

	private AgencyUserMapper() {
		// Private constructor to prevent instantiation
	}

	public static Agency mapToAgency(AgencyDto AgencyDto) {
		ModelMapper modelMapper = new ModelMapper();
		Agency Agency = modelMapper.map(AgencyDto, Agency.class);
		return Agency;
	}

	public static User mapToUser(AgencyDto AgencyDto) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(AgencyDto, User.class);
		return user;
	}
}
