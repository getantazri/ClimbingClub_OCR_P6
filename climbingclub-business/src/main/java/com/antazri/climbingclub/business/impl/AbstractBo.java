package com.antazri.climbingclub.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * La classe AbstractBo est utilisée afin de donner à chaque Business Object un accès au transactionManager
 */
public class AbstractBo {

    @Autowired
    @Qualifier("transactionManager")
    PlatformTransactionManager transactionManager;

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }
}
