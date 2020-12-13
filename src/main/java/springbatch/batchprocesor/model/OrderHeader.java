package springbatch.batchprocesor.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity

@Table(name = "ORDER_HEADER")
@Data
public class OrderHeader {

    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Column(name = "customerNumber")
    private Integer customerNumber;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "contactLastName")
    private String contactLastName;

    @Column(name = "contactFirstName")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;

    @Column(name = "creditLimit")
    private Double creditLimit;

    @Column(name = "orderDate")
    private java.sql.Date orderDate;

    @Column(name = "requiredDate")
    private java.sql.Date requiredDate;

    @Column(name = "shippedDate")
    private java.sql.Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;





    @OneToMany(mappedBy="orderNumber")
    private Set<OrderDetails> orderDetails;

}
