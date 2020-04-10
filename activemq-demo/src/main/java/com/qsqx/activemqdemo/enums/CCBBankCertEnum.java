package com.qsqx.activemqdemo.enums;

import com.qsqx.activemqdemo.utils.RandomUtil;

/**
 *  建设凭证
 */
public enum CCBBankCertEnum {
    ONE(1, "10256"),
    TWO(2, "10326"),
    THREE(3, "10155"),
    FOUR(4, "10698"),
    FIVE(5,"10366"),
    SIX(6,"10321");

    private Integer code;
    private String message;

    CCBBankCertEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getCertificate(){
        int random = 1;
        for (int i = 0; i < 6; i++) {
             random=(int)(Math.random()*6+1);
        }
        CCBBankCertEnum[] enums = CCBBankCertEnum.values();
        String message = null;
        for (CCBBankCertEnum anEnum : enums) {
            if (random == anEnum.getCode()){
                 message = anEnum.getMessage();
            }
        }
        return message+RandomUtil.getRandomNumber();
    }
}
