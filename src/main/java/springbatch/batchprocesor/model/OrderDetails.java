package springbatch.batchprocesor.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
@Data
public class OrderDetails {



    @Id
    private Long id;


    @Column(name = "productName")
    private String productName;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productLine")
    private String productLine;

    @Column(name = "productScale")
    private String productScale;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "quantityInStock")
    private Integer quantityInStock;

    @Column(name = "buyPrice")
    private Double buyPrice;

    @Column(name = "MSRP")
    private Double msrp;

    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    @Column(name = "priceEach")
    private Double priceEach;

    @Column(name = "orderLineNumber")
    private Integer orderLineNumber;

    @Column(name = "orderNumber")
    private Integer orderNumber;









}
