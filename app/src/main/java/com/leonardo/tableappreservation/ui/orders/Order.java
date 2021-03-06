package com.leonardo.tableappreservation.ui.orders;

public class Order {
    private String fullName;
    private String email;
    private String phone;
    private String tableNumber;
    private String orderTime;
    private String partySize;
    private String orderStatus;
    private String menuOrder;

    public Order() {
        // empty
    }

    public Order(String fullName,String email,String phone,String tableNumber,String orderTime,String partySize,String orderStatus,String menuOrder){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.tableNumber = tableNumber;
        this.orderTime = orderTime;
        this.partySize = partySize;
        this.orderStatus = orderStatus;
        this.menuOrder = menuOrder;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getPartySize() {
        return partySize;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getMenuOrder() {
        return menuOrder;
    }
}
