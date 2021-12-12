package com.eliza.fjd.utils.JDBCUtil

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class DbToolsTest {

    @Test
    fun addupDelTest() {

        DbTools.addUpdDel(
            "insert into `f_user` (u_id, u_name, u_tel, u_pwd) value (2, 'ssa', 12, 'asd');"
        )

    }
}