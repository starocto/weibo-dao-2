package com.starocto.dao.server.controller;

import com.starocto.dao.api.model.resp.*;
import com.starocto.dao.api.service.WeiboQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/10/15
 * Time   : 00:28
 * ---------------------------------------
 * Desc   :
 */
@Controller
public class WeiboQueryController {

    @Autowired
    WeiboQueryService weiboQueryService;

    @ResponseBody
    @RequestMapping(value = "/dao/user/info", method = RequestMethod.GET)
    public UserInfoResp queryUserInfo(){
        return weiboQueryService.queryUserInfo(1);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/user/register", method = RequestMethod.GET)
    public UserRegisterInfoResp queryUserRegisterInfo(){
        return weiboQueryService.queryUserRegisterInfo("fuermoxun");
    }

    @ResponseBody
    @RequestMapping(value = "/dao/user/others", method = RequestMethod.GET)
    public UserOthersResp queryUserOthers(){
        return weiboQueryService.queryUserOthers(1);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/user/follow", method = RequestMethod.GET)
    public List<UserFollowResp> queryUserFollow(){
        return weiboQueryService.queryUserFollow(1);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/user/fans", method = RequestMethod.GET)
    public List<UserFollowResp> queryFans(){
        return weiboQueryService.queryFans(2);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/blog/info", method = RequestMethod.GET)
    public BlogInfoListResp queryBlogInfo(){
        return weiboQueryService.queryBlogInfo(1);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/blog/count", method = RequestMethod.GET)
    public BlogCountResp queryBlogCount(){
        return weiboQueryService.queryBlogCount(1);
    }

    @ResponseBody
    @RequestMapping(value = "/dao/comment/info", method = RequestMethod.GET)
    public List<CommentToBlogResp> queryCommentToBlog(){
        return weiboQueryService.queryCommentToBlog(1);
    }

}
