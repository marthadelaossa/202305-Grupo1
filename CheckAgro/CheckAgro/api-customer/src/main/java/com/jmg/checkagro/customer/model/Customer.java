package com.jmg.checkagro.customer.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer")

public class Customer implements Serializable {

    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String businessName;
    private String email;
    private String phone;
    private LocalDate creation;
    private Boolean active;

}
