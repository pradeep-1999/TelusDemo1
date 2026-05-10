package com.example.telusDemo.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telusDemo.DTOs.RewardResponseDTO;
import com.example.telusDemo.Repositories.TransactionRepository;
import com.example.telusDemo.Repositories.UsersRepository;

@Service
public class RewardService {
	
	@Autowired
	public UsersRepository usersRepo;
	
	@Autowired
	public TransactionRepository tranxRepo;

	public RewardResponseDTO calcRewardsByMonth(String custId) {
		
		RewardResponseDTO rewardResponseDTO = null;
	    Map<String, Integer> monthlyRewards = new HashMap<>();

        int totalRewards = 0;

        // current month
        YearMonth currentMonth = YearMonth.now();

        // loop for last 3 months
        for (int i = 0; i < 3; i++) {

            YearMonth yearMonth = currentMonth.minusMonths(i);

            LocalDate startDate = yearMonth.atDay(1);

            LocalDate endDate = yearMonth.atEndOfMonth();

            var transactions = tranxRepo.findTransactions(custId,startDate,endDate);

            int monthlyPoints = transactions.stream()
                    .mapToInt(transaction ->
                            calculatePoints(
                                    transaction.getAmount())).sum();

            Month month = yearMonth.getMonth();

            monthlyRewards.put( month.toString(),  monthlyPoints );

            totalRewards += monthlyPoints;
        }

        rewardResponseDTO = new RewardResponseDTO();

        rewardResponseDTO.setCustId(custId);
        rewardResponseDTO.setMonthlyRewards(monthlyRewards);
        rewardResponseDTO.setTotalRewards(totalRewards);

        return rewardResponseDTO;
    }

    private int calculatePoints(Double amount) {

        if (amount <= 50) {
            return 0;
        }

        if (amount <= 100) {
            return (int) (amount - 50);
        }

        return 50 +
                (int) ((amount - 100) * 2);
    }

}
