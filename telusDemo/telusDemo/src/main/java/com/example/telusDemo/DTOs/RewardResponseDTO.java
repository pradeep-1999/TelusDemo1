package com.example.telusDemo.DTOs;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RewardResponseDTO {

	public String custId;
	
	public Map<String, Integer> monthlyRewards;
	
	public Integer totalRewards;
	
}
