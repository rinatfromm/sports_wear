package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    /*
    @Query("SELECT bi.balance FROM BankAccount bi " +
            "WHERE bi.id = 1 ")
    BigDecimal getBalance();

    @Modifying
    @Query("UPDATE BankAccount bi " +
            "SET bi.balance = :balance " +
            "WHERE bi.id = 1 ")
    void setBalance(BigDecimal balance);

     */
}