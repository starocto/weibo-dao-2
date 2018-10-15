package com.starocto.dao.api.model.resp;

import lombok.Data;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:43
 * ---------------------------------------
 * Desc   : 用户的简介相关信息
 */
@Data
public class UserInfoResp {
    private int userId;
    /**
     * true:女 false:男
     */
    private boolean userSex;
    private String userBirthday;
    private String userEmotion;
    private String userPosition;
    private String userHometown;
    private String userUniversity;
    private String userCompany;
    private String userSignature;
}
