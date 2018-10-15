package com.starocto.dao.api.model.resp;

import lombok.Data;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:11
 * ---------------------------------------
 * Desc   : 用户的登录相关信息
 */
@Data
public class UserRegisterInfoResp {
    private int userId;
    private String userName;
    private String userPsw;
    private String userPhone;
    private String userEmail;
    private String userRegisterTime;
    private String userChangeTime;
}
