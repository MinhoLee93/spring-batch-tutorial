//package com.tutorial.batch.domain;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//public class PaySuccess {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long amount;
//    private boolean success;
//
//    public PaySuccess(Long amount, boolean successStatus) {
//        this.amount = amount;
//        this.success = successStatus;
//    }
//
//    public void success() {
//        this.success = true;
//    }
//}