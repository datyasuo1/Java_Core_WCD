package com.example.karma_shops.entity.myenum;

public enum CategoryStatus {
    ACTIVE(1), DEACTIVE(0), DELETE(-1) ,UNDEFINE(-2);

    private int value;
    CategoryStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static CategoryStatus of(int value){
        for (CategoryStatus status:
        CategoryStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return CategoryStatus.UNDEFINE;
    }
}
