package com.eliza.fjd.dal

import com.eliza.fjd.utils.JDBCUtil.DbTools
import java.sql.SQLException


/**
 *  购物车信息 增删
 *  f_commodity  商品表
 *  f_user  用户表
 * @constructor Create empty Shop cart dal
 */
class ShopCartDal {
    /**
     * Add shop cart

     * @param u_id 用户id
     * @param c_id 商品id  将该商品添加到 该用户的购物车中
     * @return
     */
    fun addShopCart(u_id: Int, c_id: Int): Boolean {
        var flag = false
        var u_rs = DbTools.selectSql("SELECT 1 FROM f_user where u_id='${u_id}' limit 1")
        var c_rs = DbTools.selectSql("SELECT 1 FROM f_commodity where c_id='${c_id}' limit 1")

        //如果存在该用户和商品
        var sql = "insert into f_shopCart (s_u_id, s_c_id) values "
        if (u_rs?.first()!! && c_rs?.first()!!) {
            var rs = DbTools.selectSql("SELECT 1 FROM f_shopCart where s_u_id='${u_id}' and s_c_id='${c_id}' limit 1")
            if (rs!!.first()) {
                println("该购物信息已存在，不可重复添加")
                return flag
            } else {
                sql += "($u_id ,${c_id})"
            }
        } else return flag
        try {
            val i = DbTools.addUpdDel(sql)
            flag = i > 0
            return flag
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return flag

    }


    /**
     * Get all
     *
     * @param u_id 用户id 获取该用户 购物车中所有物品信息
     * @return
     */
    fun getAll(u_id: Int): MutableList<ShopCartDal>? {
        var sql = "select * from f_shopCart"
        val list: MutableList<ShopCartDal> = ArrayList()
        try {
            val rs = DbTools.selectSql(sql)
            while (rs!!.next()) {
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
     * Delete 删除该用户的购物车 中的某条信息
     * @param u_id
     * @return
     */
    fun delete(u_id: Int, c_id: Int): Boolean {
        var flag = false
        val sql = "delete from f_shopCart where s_u_id='$u_id' and s_c_id='$c_id'"
        val i = DbTools.addUpdDel(sql)
        if (i > 0) {
            flag = true
        }
        return flag
    }

}