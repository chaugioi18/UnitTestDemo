package vn.mila.example.handler;

import vn.mila.example.dto.AccountInfo;
import vn.mila.example.dto.UserInfo;

import java.util.List;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:18 AM
 */
public interface ILogic {

    UserInfo checkUsernameExisted(String username);

    List<AccountInfo> getAccountByCif(String cif);

}
