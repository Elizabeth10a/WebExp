package com.eliza.fjd.dal

import com.eliza.fjd.model.CommodityModel
import com.eliza.fjd.utils.JDBCUtil.DbTools
import java.sql.SQLException

/*
*
*
* 通过种类查找商品
* */
/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/12/21
 * @Software: IntelliJ IDEA
 */
class CommodityTypeDal {

    //* 通过种类查找商品
    fun getCommodityByType(type: String? = null): ArrayList<CommodityModel>? {
        var sql = ""
        type ?: let {
            sql = "select * from f_commodity_type"
        }
        type?.let {
            sql = "select * from f_commodity_type where c_type='$type'"
        }
        try {
            var list: ArrayList<CommodityModel> = ArrayList<CommodityModel>()

            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
                println(rs.getInt("c_id"))
                val int = rs.getInt("c_id")
                val ca = CommodityDal().getCommodityAll("f_user", "", "id=$int")
                if (ca != null && ca.isEmpty()) {
                    list.addAll(ca)
                }

            }
            if (list.isEmpty()) {
                return null
            }
            return list
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null
    }
}