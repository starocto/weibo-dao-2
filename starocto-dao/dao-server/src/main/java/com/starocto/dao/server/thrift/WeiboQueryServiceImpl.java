package com.starocto.dao.server.thrift;


import com.starocto.dao.api.model.resp.*;
import com.starocto.dao.api.service.WeiboQueryService;
import com.starocto.dao.common.utils.BeanUtils;
import com.starocto.dao.db.mapper.WeiboDataMapper;
import com.starocto.dao.db.model.*;
import com.starocto.dao.db.util.SqlSessionFactoryUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 12:36
 * ---------------------------------------
 * Desc   :
 */
@Service
public class WeiboQueryServiceImpl implements WeiboQueryService {

    private WeiboDataMapper weiboDataMapper = SqlSessionFactoryUtil.getDataMapper();

    @Override
    public BlogCountResp queryBlogCount(long blogId){
        BlogCountDO blogCountDO = weiboDataMapper.selectBlogCountDO(blogId);
        return BeanUtils.propertiesCopy(blogCountDO, new BlogCountResp());
    }

    @Override
    public List<BlogInfoResp> queryBlogInfo(int userId){
        List<BlogInfoDO> blogInfoDOS = weiboDataMapper.selectBlogInfoDO(userId);
        return blogInfoDOS.stream()
                .map(e -> BeanUtils.propertiesCopy(e, new BlogInfoResp()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentToBlogResp> queryCommentToBlog(long blogId){
        List<CommentToBlogDO> commentToBlogDOS = weiboDataMapper.selectCommentToBlogDO(blogId);
        return commentToBlogDOS.stream()
                .map(e -> BeanUtils.propertiesCopy(e, new CommentToBlogResp()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFollowResp> queryUserFollow(int userId){
        List<UserFollowDO> userFollowDOS = weiboDataMapper.selectUserFollowDO(userId);
        return userFollowDOS.stream()
                .map(e -> BeanUtils.propertiesCopy(e, new UserFollowResp()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFollowResp> queryFans(int followUserId){
        List<UserFollowDO> userFollowDOS = weiboDataMapper.selectFansDO(followUserId);
        return userFollowDOS.stream()
                .map(e -> BeanUtils.propertiesCopy(e, new UserFollowResp()))
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoResp queryUserInfo(int userId){
        UserInfoDO userFollowDO = weiboDataMapper.selectUserInfoDO(userId);
        return BeanUtils.propertiesCopy(userFollowDO, new UserInfoResp());
    }

    @Override
    public UserOthersResp queryUserOthers(int userId){
        UserOthersDO userOthersDO = weiboDataMapper.selectUserOthersDO(userId);
        return BeanUtils.propertiesCopy(userOthersDO, new UserOthersResp());
    }

    @Override
    public UserRegisterInfoResp queryUserRegisterInfo(String userName){
        UserRegisterInfoDO userRegisterInfoDO = weiboDataMapper.selectUserRegisterInfoDO(userName);
        return BeanUtils.propertiesCopy(userRegisterInfoDO, new UserRegisterInfoResp());
    }
}
