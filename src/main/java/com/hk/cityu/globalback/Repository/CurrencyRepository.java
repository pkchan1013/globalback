package com.hk.cityu.globalback.Repository;

import com.hk.cityu.globalback.Models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findFirstByOrderByCreateDateDesc();
}
