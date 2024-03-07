package fit.hrkj.userdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fit.hrkj.userdemo.pojo.Users;
import fit.hrkj.utils.response.Message;


/**
 * @author 格格不入
 * @Description 用户业务层
 * @Date 2023/5/6 0006 14:00
 * @Verson 1.0
 */


public interface UserService extends  IService<Users>{
    /**
     * 查询全部用户信息*
     * @return
     */
    Message testSelectAll();

    /**
     * 根据id修改用户信息
     * @param users
     * @return
     */
    Message testUpdate(Users users);

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    Message testSelectById(Long id);

    /**
     * 通过多个id查询用户信息
     * @param id
     * @return
     */
    Message testSelectBatchIds(Long[] id);

    /**
     * 根据姓名和年龄查询用户信息
     * @param name
     * @param age
     * @return
     */
    Message testSelectByMap(String name, Integer age);

    /**
     * 实现新增用户信息
     * @param users
     * @return
     */
    Message testInsert(Users users);

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    Message testDeleteById(Long id);

    /**
     * 根据多个id删除用户信息
     * @param id
     * @return
     */
    Message testDeleteBatchIds(Long[] id);

    /**
     * 根据姓名和年龄删除用户信息
     * @param name
     * @param age
     * @return
     */
    Message testDeleteByMap(String name, Integer age);

    /**
     * 删除邮箱为null的用户信息
     * @return
     */
    Message testDelete();

    /**
     * 查询用户名包含a,年龄在20到30之间,邮箱不为null的用户信息
     * @param name
     * @param ageBegin
     * @param ageEnd
     * @param email
     * @return
     */
    Message testSelectList(String name, Integer ageBegin, Integer ageEnd);

    /**
     * 查询用户信息,按照年龄的降序排序,若年龄相同,则按照id升序排序
     * @return
     */
    Message testSelectList2();

    /**
     * 查询用户的用户名、年龄、邮箱
     * @return
     */
    Message testSelectMaps();

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    Message testPage(long current, long size);
}
