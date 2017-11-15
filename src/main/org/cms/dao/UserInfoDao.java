package cms.dao;

import cms.core.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserInfoDao {
    public int GetCount();
    public int AddOps(UserInfo u);
    public List<UserInfo> GetList(@Param("index") int index, @Param("size") int size);
}
