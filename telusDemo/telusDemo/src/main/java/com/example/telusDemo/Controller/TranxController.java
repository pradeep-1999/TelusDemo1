package com.example.telusDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telusDemo.DTOs.RewardResponseDTO;
import com.example.telusDemo.Service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class TranxController {
	
	 @Autowired
	 private RewardService rewardService;

	   @GetMapping("/{customerId}")
	   public  ResponseEntity<?> getRewards( @PathVariable String customerId) {

		   RewardResponseDTO response = rewardService.calcRewardsByMonth(customerId);
	        return ResponseEntity.ok(response);
	    }
	
}
