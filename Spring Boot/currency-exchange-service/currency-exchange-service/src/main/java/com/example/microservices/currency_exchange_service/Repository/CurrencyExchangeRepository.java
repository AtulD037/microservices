package com.example.microservices.currency_exchange_service.Repository;

import com.example.microservices.currency_exchange_service.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from,String to);
    // find by id -> here i am finding by from and to
    // so spring boot basically use where From/mapped column = from and To/mapped column = to
    // so this is how my query will look - Hibernate: select ce1_0.id,ce1_0.conversion_multiple,ce1_0.environment,ce1_0.currency_from,ce1_0.currency_to from currency_exchange ce1_0 where ce1_0.currency_from=? and ce1_0.currency_to=?
}
