package com.starocto.dao.index.service.impl;

import com.starocto.dao.api.model.mq.BlogInfoMQ;
import com.starocto.dao.api.model.mq.CommentToBlogMQ;
import com.starocto.dao.api.model.mq.UserOthersMQ;
import com.starocto.dao.api.model.req.UserRegisterInfoReq;
import com.starocto.dao.common.utils.BeanUtils;
import com.starocto.dao.common.utils.DateUtils;
import com.starocto.dao.db.mapper.WeiboDataMapper;
import com.starocto.dao.db.model.*;
import com.starocto.dao.index.service.WeiboIndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 17:04
 * ---------------------------------------
 * Desc   :
 */
@Service
public class WeiboIndexServiceImpl implements WeiboIndexService {

    @Autowired
    private WeiboDataMapper weiboDataMapper;

    @Override
    public void indexBlogCountDO(List<BlogCountDO> blogCountDO){

    }

    @Override
    public void indexBlogInfoDO(List<BlogInfoMQ> blogInfoMQS){
        List<BlogInfoDO> blogInfoDOS = blogInfoMQS.stream().map(e -> {
            BlogInfoDO blogInfoDO = BeanUtils.propertiesCopy(e, new BlogInfoDO());
            blogInfoDO.setBlogPlusTime(new Date(DateUtils.strToDate(e.getBlogPlusTime()).getTime()));
            return blogInfoDO;
        }).collect(Collectors.toList());
        weiboDataMapper.insertBlogInfoDO(blogInfoDOS);
    }

    @Override
    public void indexCommentToBlogDO(List<CommentToBlogMQ> commentToBlogMQS){
        List<CommentToBlogDO> commentToBlogDOS = commentToBlogMQS.stream()
                .map(e -> {
                    CommentToBlogDO commentToBlogDO = BeanUtils.propertiesCopy(e, new CommentToBlogDO());
                    commentToBlogDO.setCommentTime(new Date(DateUtils.strToDate(e.getCommentTime()).getTime()));
                    return commentToBlogDO;
                }).collect(Collectors.toList());
        weiboDataMapper.insertCommentToBlogDO(commentToBlogDOS);
    }

    @Override
    public void indexUserFollowDO(List<UserFollowDO> userFollowDO){

    }

    @Override
    public void indexUserInfoDO(List<UserInfoDO> userInfoDO){
        weiboDataMapper.insertUserInfoDO(userInfoDO);
    }

    @Override
    public void indexUserOthersDO(List<UserOthersMQ> userOthersMQS){
        // 生产速率是干什么用的 ？？
        List<UserOthersDO> userOthersDOS = userOthersMQS.stream()
                .map(e -> {
                    UserOthersDO userOthersDO = BeanUtils.propertiesCopy(e, new UserOthersDO());
                    userOthersDO.setBlogProduceRate(0);
                    return userOthersDO;
                }).collect(Collectors.toList());
        weiboDataMapper.insertUserOthersDO(userOthersDOS);
    }

    @Override
    public void indexUserRegisterInfoDO(List<UserRegisterInfoReq> userRegisterInfoReqs){
        List<UserRegisterInfoDO> userRegisterInfoDOS = userRegisterInfoReqs.stream()
                .map(e -> BeanUtils.propertiesCopy(e, new UserRegisterInfoDO()))
                .collect(Collectors.toList());
        weiboDataMapper.insertUserRegisterInfoDO(userRegisterInfoDOS);
        Map<String, Integer> nameIdMap = weiboDataMapper.selectAllUserRegisterInfoDO(userRegisterInfoReqs.stream()
                .map(UserRegisterInfoReq::getUserName).collect(Collectors.toList())).stream()
                .collect(Collectors.toMap(UserRegisterInfoDO::getUserName, UserRegisterInfoDO::getUserId));
        List<UserInfoDO> userInfoDOS = userRegisterInfoReqs.stream()
                .map(e -> {
                    UserInfoDO userInfoDO = BeanUtils.propertiesCopy(e, new UserInfoDO());
                    userInfoDO.setUserId(nameIdMap.get(e.getUserName()));
                    return userInfoDO;
                })
                .collect(Collectors.toList());
        this.indexUserInfoDO(userInfoDOS);
    }

    @Override
    public void updateUserFollowDO(List<UserFollowDO> userFollowDO){

    }
}
