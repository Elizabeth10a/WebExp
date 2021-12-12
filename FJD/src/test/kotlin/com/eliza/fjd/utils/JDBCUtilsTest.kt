package com.eliza.fjd.utils

import com.eliza.fjd.dal.UserDal
import org.junit.jupiter.api.Test

internal class JDBCUtilsTest {



    @Test
    fun getConn() {
        print(JDBCUtils().getConn())
        print(UserDal().login("lisi", "123"));
    }
}