package fit.hrkj.userdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fit.hrkj.userdemo.mapper.UserMapper;
import fit.hrkj.userdemo.pojo.Users;
import fit.hrkj.userdemo.service.UserService;
import fit.hrkj.utils.response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 格格不入
 * @Description
 * @Date 2023/5/6 0006 14:01
 * @Verson 1.0
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Message testSelectAll() {
        try {
            List<Users> data = userMapper.selectList(null);
            return Message.ok(data,"查询全部用户信息成功");
        }catch (Exception e){
            return Message.error("查询全部用户信息失败，请检查");
        }
    }

    @Override
    public Message testUpdate(Users users) {
        users.setId(users.getId());
        users.setName(users.getName());
        users.setAge(users.getAge());
        users.setEmail(users.getEmail());
        int result = userMapper.updateById(users);
        if (result == 0) {
            return Message.error("修改用户信息失败，请检查");
        }
        return Message.ok("修改用户信息成功");
    }

    @Override
    public Message testSelectById(Long id) {
        Users data = userMapper.selectById(id);
        if (data == null) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testSelectBatchIds(Long[] id) {
        List list = Arrays.asList(id);
        List<Users> data = userMapper.selectBatchIds(list);
        if (data.size() == 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testSelectByMap(String name, Integer age) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        List<Users> data = userMapper.selectByMap(map);
        if (data.size() == 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testInsert(Users users) {
        if (users == null) {
            return Message.error("请上传用户信息");
        }
        int data = userMapper.insert(users);
        if (data == 0) {
            return Message.error("新增用户失败，请检查");
        }
        return Message.ok(data, "新增用户成功");
    }

    @Override
    public Message testDeleteById(Long id) {
        int result = userMapper.deleteById(id);
        if (result == 0) {
            return Message.error("删除用户失败，请检查");
        }
        return Message.ok("删除用户成功");
    }

    @Override
    public Message testDeleteBatchIds(Long[] id) {
        List<Object> list = Arrays.asList(id);
        int result = userMapper.deleteBatchIds(list);
        if (result == 0) {
            return Message.error("删除用户失败，请检查");
        }
        return Message.ok("删除用户成功");
    }

    @Override
    public Message testDeleteByMap(String name, Integer age) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        int result = userMapper.deleteByMap(map);
        if (result == 0) {
            return Message.error("删除用户失败，请检查");
        }
        return Message.ok("删除用户成功");
    }

    @Override
    public Message testDelete() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        if (result == 0) {
            return Message.error("删除用户失败，请检查");
        }
        return Message.ok("删除用户成功");
    }

    @Override
    public Message testSelectList(String name, Integer ageBegin, Integer ageEnd) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name)
                .between("age", ageBegin, ageEnd)
                .isNotNull("email");
        List<Users> data = userMapper.selectList(queryWrapper);
        if (data.size() == 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testSelectList2() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<Users> data = userMapper.selectList(queryWrapper);
        if (data.size() == 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testSelectMaps() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<Map<String,Object>> data = userMapper.selectMaps(queryWrapper);
        if (data.size() == 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(data, "查询用户信息成功");
    }

    @Override
    public Message testPage(long current, long size) {
        Page<Users> page = new Page<>(current,size);
        userMapper.selectPage(page, null);
        if(page.getPages() < current || current <= 0) {
            return Message.error("查询用户信息失败，请检查");
        }
        return Message.ok(page.getRecords(), "查询用户信息成功");
    }
}
