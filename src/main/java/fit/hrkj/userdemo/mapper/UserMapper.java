package fit.hrkj.userdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fit.hrkj.userdemo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 格格不入
 * @Description
 * @Date 2023/5/6 0006 14:03
 * @Verson 1.0
 */

@Repository
@Mapper
public interface UserMapper extends BaseMapper<Users> {
}
