package com.starocto.dao.api.model.req;

import lombok.Data;

/**
 * Author : zjx@com
 * Date   : 2018/11/11
 * Time   : 15:33
 * ---------------------------------------
 * Desc   : 用户使用POST请求，同步，注册操作和更改操作
 */
@Data
public class UserRegisterInfoReq {

    private static final long serialVersionUID = -1L;

    private String userName;
    private String userPsw;
    private String userPhone;
    private String userEmail;

    private boolean userSex;
    private String userBirthday;
    private String userEmotion;
    private String userPosition;
    private String userHometown;
    private String userUniversity;
    private String userCompany;
    private String userSignature;
}
