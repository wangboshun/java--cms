package cms.service;

import cms.core.UserInfo;
import cms.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserInfoService implements UserInfoDao {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public int GetCount() {
        return userInfoDao.GetCount();
    }

    @Override
    public int AddOps(UserInfo u) {
        return userInfoDao.AddOps(u);
    }

    @Override
    public List<UserInfo> GetList(int index, int size) {
        return userInfoDao.GetList(index, size);
    }
}
