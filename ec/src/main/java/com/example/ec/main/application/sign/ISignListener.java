package com.example.ec.main.application.sign;

/**
 * @author alan
 *         Date  2018/7/20.
 *         Function :
 *         Issue :
 */

public interface ISignListener {

    void onSignInSuccess();

    void onSignInFail(String msg);

    void onRetreatSuccess();

    void onRetreatFail(String msg);

}
