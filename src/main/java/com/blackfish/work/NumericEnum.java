package com.blackfish.work;

/**
 * @Auther: SZSS
 * @Date: 2019/6/20 15:00
 * @Description:
 */
public enum NumericEnum {

    /**
     * -1
     */
    NEGATIVE(-1),

    /**
     * Zero numeric constants.
     */
    ZERO(0),

    /**
     * One numeric constants.
     */
    ONE(1),

    /**
     * Two numeric constants.
     */
    TWO(2),

    /**
     * Three numeric constants.
     */
    THREE(3),

    /**
     * Four numeric constants.
     */
    FOUR(4),

    /**
     * Five numeric constants.
     */
    FIVE(5),

    /**
     * Six numeric constants.
     */
    SIX(6),

    /**
     * Seven numeric constants.
     */
    SEVEN(7),

    /**
     * Eight numeric constants.
     */
    EIGHT(8),

    /**
     * Nine numeric constants.
     */
    NINE(9),

    /**
     * 10 numeric constants.
     */
    TEN(10),

    /**
     * 15 numeric constants.
     */
    FIFTEEN(15),

    /**
     * 20 numeric constants.
     */
    TWENTY(20),

    /**
     * 25 numeric constants.
     */
    TWENTY_FIVE(25),

    /**
     * 30 numeric constants.
     */
    THIRTY(30),

    /**
     * 32 numeric constants.
     */
    THIRTY_TWO(32),

    /**
     * 40 numeric constants.
     */
    FORTY(40),

    /**
     * 42 numeric constants.
     */
    FORTY_TWO(42),

    /**
     * 48 numeric constants.
     */
    FORTY_EIGHT(48),

    /**
     * 60 numeric constants.
     */
    SIXTY(60),

    /**
     * 100  numeric constants
     */
    HUNDRED(100),

    /**
     * 500 numeric constants.
     */
    FIVE_HUNDRED(500),

    /**
     * 999 numeric constants.
     */
    NINE_HUNDRED_NINETY_NINE(999),

    NINETY(90),

    /**
     * Gigantic numeric constants.
     */
    GIGANTIC(999999);

    /**
     * The Value.
     */
    public final int value;

    NumericEnum(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

}
