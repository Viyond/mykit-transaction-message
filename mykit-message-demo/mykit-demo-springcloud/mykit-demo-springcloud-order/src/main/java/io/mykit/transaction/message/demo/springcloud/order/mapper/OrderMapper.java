/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.transaction.message.demo.springcloud.order.mapper;

import io.mykit.transaction.message.demo.springcloud.order.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author binghe
 * @version 1.0.0
 * @description OrderMapper
 */
public interface OrderMapper {

    /**
     * 保存订单
     *
     * @param order 订单对象
     * @return rows int
     */
    @Insert(" insert into `order` (create_time,number,status,product_id,total_amount,count,user_id) " +
            " values ( #{createTime},#{number},#{status},#{productId},#{totalAmount},#{count},#{userId})")
    int save(Order order);

    /**
     * 更新订单
     *
     * @param order 订单对象
     * @return rows int
     */
    @Update("update `order` set status = #{status} , total_amount=#{totalAmount} where number=#{number}")
    int update(Order order);

    /**
     * 获取所有的订单
     *
     * @return List<Order> list
     */
    @Select("select * from  order")
    List<Order> listAll();
}
