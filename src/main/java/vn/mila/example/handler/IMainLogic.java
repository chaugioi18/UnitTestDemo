package vn.mila.example.handler;

import vn.mila.example.dto.CommonResponse;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 11:57 AM
 */
public interface IMainLogic {

    CommonResponse getListAccount(String username);

}
