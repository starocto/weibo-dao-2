package com.starocto.dao.server.service;

import com.starocto.dao.api.model.resp.*;
import com.starocto.dao.api.service.WeiboQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/10/14
 * Time   : 16:21
 * ---------------------------------------
 * Desc   :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-local.xml"})
public class ServerTest {

    @Autowired
    WeiboQueryService weiboQueryService;

    @Test
    public void testQueryService(){

        UserInfoResp userInfoResp = weiboQueryService.queryUserInfo(1);
        System.out.println(userInfoResp);

        UserRegisterInfoResp userRegisterInfoResp = weiboQueryService.queryUserRegisterInfo("fuermoxun");
        System.out.println(userRegisterInfoResp);

        UserOthersResp userOthersResp = weiboQueryService.queryUserOthers(1);
        System.out.println(userOthersResp);

        List<UserFollowResp> userFollowResps = weiboQueryService.queryUserFollow(1);
        System.out.println(userFollowResps);
        List<UserFollowResp> userFanResps = weiboQueryService.queryFans(2);
        System.out.println(userFanResps);

        List<BlogInfoResp> blogInfoResps = weiboQueryService.queryBlogInfo(1);
        System.out.println(blogInfoResps);

        BlogCountResp blogCountResp = weiboQueryService.queryBlogCount(1);
        System.out.println(blogCountResp);

        List<CommentToBlogResp> commentToBlogResps = weiboQueryService.queryCommentToBlog(1);
        System.out.println(commentToBlogResps);

    }
}
