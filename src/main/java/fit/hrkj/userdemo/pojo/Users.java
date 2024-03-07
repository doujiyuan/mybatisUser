package fit.hrkj.userdemo.pojo;

import lombok.Data;

/**
 * @author 格格不入
 * @Description 实体类
 * @Date 2023/5/6 0006 13:57
 * @Verson 1.0
 */

@Data
public class Users {
    /**
     * 用户的id*
     */
    private Long id;
    /**
     * 用户的名字*
     */
    private String name;
    /**
     * 用户的年龄*
     */
    private Integer age;
    /**
     * 用户的邮箱*
     */
    private String email;
}
