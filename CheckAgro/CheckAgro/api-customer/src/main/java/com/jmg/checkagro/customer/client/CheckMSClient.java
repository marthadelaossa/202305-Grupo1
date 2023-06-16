package com.jmg.checkagro.customer.client;
import com.jmg.checkagro.customer.model.Customer;
import lombok.*;
import org.hibernate.annotations.Check;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.Size;

@FeignClient(name="api-check")
public interface CheckMSClient {

    @PostMapping("/api/v1/check/customer/register")
    void registerCustomer(DocumentRequest request);

    @PostMapping("/api/v1/check/customer/delete")
    void deleteCustomer(DocumentRequest request);

    @GetMapping("/api/v1/check/{id}")
    Check getById(@PathVariable Long id);
    //Student getById(@PathVariable Long id);

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    class DocumentRequest {
        @Size(min = 1, max = 10)
        private String documentType;
        @Size(min = 1, max = 20)
        private String documentValue;


    }
}
