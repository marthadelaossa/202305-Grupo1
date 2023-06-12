package com.jmg.checkagro.provider.client;
import feign.Headers;
import feign.RequestLine;
import lombok.*;
import org.hibernate.annotations.Check;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.Size;

@FeignClient(name="api-check")
public interface CheckMSClient {

    @PostMapping("/api/v1/check/provider/register")
    void registerProvider(DocumentRequest request);

    @PostMapping("/api/v1/check/provider/delete")
    void deleteProvider(DocumentRequest request);

    @GetMapping("/api/v1/check/{id}")
    Check getById(@PathVariable Long id);

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
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false,name = "check_Virtual_id")
    private Long id;
    @Column(nullable = false, length = 10)
    private String documentTypeCustomer;
    @Column(nullable = false, length = 20)
    private String documentValueCustomer;
    @Column(nullable = false, length = 10)
    private String documentTypeProvider;
    @Column(nullable = false, length = 20)
    private String documentValueProvider;
    @Column(nullable = false)
    private LocalDateTime emitDate;
    @Column(nullable = false,precision = 17, scale = 2)
    private BigDecimal amountTotal;
    @Column(nullable = false)
    private Integer monthsDuration;
    @Column(nullable = false,precision = 17, scale = 2)
    private BigDecimal commissionAgro;

    @Column(nullable = false, length = 10)
    private String stateCheck;

    @OneToMany(mappedBy = "checkVirtual", orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<CheckDetail> checkDetails;
     */

}