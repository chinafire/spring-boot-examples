package com.leone.boot.common.design.creation.abstractfactory;

/**
 * @author leone
 * @since 2018-07-28
 **/
public class SmsSenderFactory implements Provider {

    @Override
    public Sender provider() {
        return new SmsSender();
    }
}
