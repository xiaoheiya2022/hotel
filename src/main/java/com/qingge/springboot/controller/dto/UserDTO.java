package com.qingge.springboot.controller.dto;

import com.qingge.springboot.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String avatarUrl;
    private String token;
    private String role;
    private Integer state;
    private List<Menu> menus;
}
