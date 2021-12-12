package com.eliza.fjd.dal

import com.eliza.fjd.model.CommodityModel
import com.eliza.fjd.utils.JDBCUtil.DbTools
import com.eliza.fjd.utils.JDBCUtil.DbTools.Companion.addUpdDel
import java.sql.SQLException


class CommodityDal {


    /**
     * Update mei tie
     *
     * @param commodel 新的信息
     * @param args 参数群，要修改的选项（属性名）
     * @param id 要修改的id
     * @return
     */
    fun updateCommodity(commodel: CommodityModel, vararg args: String, id: Int): Boolean {
        var flag = false
        var rs = DbTools.selectSql("SELECT 1 FROM f_commodity where m_id=${id} limit 1") //没有该信息提示添加
        rs ?: return flag
        if (!rs.first()) {
            println("不存在该 商品,请添加")
            return flag
        }
        //修改信息
        rs.let {
            var sql = "update f_commodity set "
            if (args.isNotEmpty()) {
                for (i in args.indices) {
                    sql += "${args[i]}='${args[i]}'"
                }
                sql += "where m_id = '${id}'"
            }

            print(sql)
            try {
                rs.let {
                    if (rs.first()) {
                        val i: Int = DbTools.addUpdDel(sql)
                        if (i > 0) {
                            flag = true
                        }
                    } else {
                        println("--不存在数据请添加---")
                    }
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
        return flag
    }

    /**
     * Get commodel all
     *
     * @param tableName 表名,默认从 f_commodity读取
     * @param args  不定参数,两两匹配[属性,值,属性,值] 最多三对
     * @return
     */
    fun getCommodityAll(tableName: String? = null, vararg args: String): MutableList<CommodityModel>? {
        var sql = "select * from f_commodity"
        tableName?.let {
            if (args.isNotEmpty()) {
                when (args[0].split("=").size == 2) {
                    args.size == 1 -> sql =
                        "select * from $tableName where ${args[0].split("=")[0]}='${args[0].split("=")[1]}' "
                    args.size > 2 -> for (i in 1..args.size) {
                        sql += "${args[i].split("=")[0]}='${args[i].split("=")[1]}'"
                    }
                    else -> {
                        println("---输入参数有误--")
                    }
                }
            }

        }
        println(sql)
        val list: MutableList<CommodityModel> = ArrayList()
        try {
            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
                list.add(
                    CommodityModel(
                        rs.getInt("c_id"),
                        rs.getString("c_title"),
                        rs.getInt("c_price"),
                        rs.getString("c_img1"),
                        rs.getString("c_img2"),
                        rs.getString("c_img3"),
                    )
                )

            }
            if (list.isEmpty()) {
                println("--信息不存在--")
                return null
            }
            return list
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null
    }


    /**
     * @param m_id 通过 meitie的id
     * @return 是否删除成功
     */
    fun deleteCommodity(m_id: Int): Boolean {
        var flag = false
        val sql = "delete  from f_commodity where m_id=$m_id"
        val i = addUpdDel(sql)
        if (i > 0) {
            flag = true
        }
        return flag
    }
}