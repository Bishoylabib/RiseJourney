package com.fawry.ecommerce.interfaces;

import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpDate();

    default  Boolean isExpired(){
        return getExpDate().isBefore(LocalDate.now());
    }
}
