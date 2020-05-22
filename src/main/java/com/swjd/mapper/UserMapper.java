package com.swjd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swjd.bean.User;

public interface UserMapper extends BaseMapper<User> {
    public abstract User findUserByuNamePwd(User user);
}
