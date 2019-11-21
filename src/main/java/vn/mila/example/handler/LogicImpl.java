package vn.mila.example.handler;

import vn.mila.example.base.CommonException;
import vn.mila.example.dto.AccountInfo;
import vn.mila.example.dto.UserInfo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:19 AM
 */
public class LogicImpl implements ILogic {

    @Override
    public UserInfo checkUsernameExisted(String username) {
        if ("chaudeptrai".equalsIgnoreCase(username)) {
            return new UserInfo().setUsername("chaudeptrai")
                    .setCif("00001")
                    .setOld(11);
        }
        throw new CommonException.NotFound("Not found username");
    }

    @Override
    public List<AccountInfo> getAccountByCif(String cif) {
        if ("00001".equalsIgnoreCase(cif)) {
            return Arrays.asList(
                    new AccountInfo().setCif("00001").setAccountNumber("0000001").setBalance(new BigDecimal(1000)),
                    new AccountInfo().setCif("00001").setAccountNumber("0000002").setBalance(new BigDecimal(2000)),
                    new AccountInfo().setCif("00001").setAccountNumber("0000003").setBalance(new BigDecimal(5000)),
                    new AccountInfo().setCif("00001").setAccountNumber("0000004").setBalance(new BigDecimal(10000))
            );
        }
        throw new CommonException.NotFound("Not found account");
    }


}
