package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:11
 * ---------------------------------------
 * Desc   : 用户的登录相关信息
 */
@Data
public class UserRegisterInfoResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    private String userName;
    private String userPsw;
    private String userPhone;
    private String userEmail;
    private String userRegisterTime;
    private String userChangeTime;
}
