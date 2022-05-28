package com.example.karma_shops.entity.myenum;

public enum ShoppingCartStatus {
    ACTIVE(1),DEACTIVE(0),UNDEFINE(-2);

    private int value;
    ShoppingCartStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static ShoppingCartStatus of(int value){
        for (ShoppingCartStatus status :
                ShoppingCartStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return UNDEFINE;
    }
}
