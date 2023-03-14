package com.property.sales.app.service;

import com.property.sales.app.model.entity.Transaction;
import com.property.sales.app.model.entity.User;
import com.property.sales.app.repository.TransactionRepository;
import com.property.sales.app.util.GenericConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    UserDataService userDataService;

    @Autowired
    TransactionRepository transactionRepository;

    public void updateUserTransaction(Long userId, int amount) throws Exception {
        Optional<User> optionalUser = userDataService.retrieveFilteredUser(Long.toString(userId), GenericConstants.SEARCH_BY_ID);
        User user = optionalUser.orElse(null);
        Transaction transaction = null;
        if(null != user && null != user.getName()) {
            transaction = Transaction.builder()
                    .transactionDate(new Date())
                    .fullName(user.getName())
                    .amount(amount)
                    .userId(user.getId())
                    .build();
        } else {
            throw new Exception("Unable to update transaction as user not present");
        }
        transactionRepository.save(transaction);

    }
}
