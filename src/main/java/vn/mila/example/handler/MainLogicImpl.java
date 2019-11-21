package vn.mila.example.handler;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.mila.example.base.CommonException;
import vn.mila.example.dto.AccountInfo;
import vn.mila.example.dto.CommonResponse;
import vn.mila.example.dto.UserInfo;

import java.util.List;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:58 AM
 */
public class MainLogicImpl implements IMainLogic {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private ILogic logic;
    private Gson gson;

    @Inject
    MainLogicImpl(ILogic logic,
                  Gson gson) {
        this.logic = logic;
        this.gson = gson;
    }

    @Override
    public CommonResponse getListAccount(String username) {
        try {
            LOGGER.info("Run 1");
            UserInfo userInfo = logic.checkUsernameExisted(username);
            LOGGER.info("Run 2");
            List<AccountInfo> list = logic.getAccountByCif(userInfo.getCif());
            LOGGER.info("Run 3");
            return new CommonResponse().setCode("2000")
                    .setData(gson.toJsonTree(list));
        } catch (CommonException.NotFound e) {
            LOGGER.info("Run 4");
            return new CommonResponse().setCode("4000");
        } catch (Exception e) {
            LOGGER.info("Run 5");
            return new CommonResponse().setCode("5000");
        }
    }
}
