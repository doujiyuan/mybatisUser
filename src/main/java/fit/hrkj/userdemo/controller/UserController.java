package fit.hrkj.userdemo.controller;

import fit.hrkj.userdemo.pojo.Users;
import fit.hrkj.userdemo.service.UserService;
import fit.hrkj.utils.response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 格格不入
 * @Description 用户相关api
 * @Date 2023/5/6 0006 14:04
 * @Verson 1.0
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询全部用户信息
     * @return
     */
    @GetMapping("/testSelectAll")
    public Message testSelectAll(){
        return userService.testSelectAll();

    }

    /**
     * 跟据id修改用户名和年龄*
     * @param users
     * @return
     */
    @PostMapping("/testUpdate")
    public Message testUpdate(@RequestBody() Users users) {
        return userService.testUpdate(users);
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/testSelectById")
    public Message testSelectById(@RequestParam() Long id) {
        return userService.testSelectById(id);
    }

    /**
     * 通过多个id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/testSelectBatchIds")
    public Message testSelectBatchIds(@RequestParam() Long[] id) {
        return userService.testSelectBatchIds(id);
    }

    /**
     * 根据姓名和年龄查询用户信息
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/testSelectByMap")
    public Message testSelectByMap(@RequestParam() String name, @RequestParam() Integer age) {
        return userService.testSelectByMap(name, age);
    }

    /**
     * 实现新增用户信息
     *
     * @param users
     * @return
     */
    @PostMapping("/testInsert")
    public Message testInsert(@RequestBody Users users) {
        return userService.testInsert(users);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/testDeleteById")
    public Message testDeleteById(@RequestParam() Long id) {
        return userService.testDeleteById(id);
    }

    /**
     * 根据多个id删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping("/testDeleteBatchIds")
    public Message testDeleteBatchIds(@RequestParam() Long[] id) {
        return userService.testDeleteBatchIds(id);
    }

    /**
     * 根据姓名和年龄删除用户信息
     * @param name
     * @param age
     * @return
     */
    @DeleteMapping("/testDeleteByMap")
    public Message testDeleteByMap(@RequestParam() String name, @RequestParam() Integer age){
        return userService.testDeleteByMap(name, age);
    }

    /**
     * 删除邮箱为null的用户信息
     * @return
     */
    @DeleteMapping("/testDelete")
    public Message testDelete() {
        return userService.testDelete();
    }

    /**
     * 查询用户名包含a,年龄在20到30之间,邮箱不为null的用户信息*
     * @param name
     * @param ageBegin
     * @param ageEnd
     * @return
     */
    @GetMapping("/testSelectList")
    public Message testSelectList(String name, Integer ageBegin, Integer ageEnd){
        return userService.testSelectList(name, ageBegin, ageEnd);
    }

    /**
     * 查询用户信息,按照年龄的降序排序,若年龄相同,则按照id升序排序
     * @return
     */
    @GetMapping("/testSelectList2")
    public Message testSelectList2(){
        return userService.testSelectList2();
    }

    /**
     * 查询用户的用户名、年龄、邮箱
     * @return
     */
    @GetMapping("/testSelectMaps")
    public Message testSelectMaps(){
        return userService.testSelectMaps();
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/testPage")
    public Message testPage(long current, long size){
        return userService.testPage(current, size);
    }
}
