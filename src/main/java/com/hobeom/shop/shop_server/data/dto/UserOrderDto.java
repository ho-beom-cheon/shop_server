package com.hobeom.shop.shop_server.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
   //주문번호
   private int orderNumber;
   //아이디
   private String userId;
   //주문날짜
   private String orderDate;
   //배송자주소1(우편번호)
   private String address1;
   //배송자주소2(주소)
   private String address2;
   //배송자주소3(상세주소)
   private String address3;
   //수령자이름
   private String receiverName;
   //수령자전화번호
   private String receiverPhone;
}
