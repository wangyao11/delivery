package com.wangyao.company.delivery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        try {
            //起始日期
            Date d1 = sdf.parse("2019-05-01");
            //结束日期
            Date d2 = sdf.parse("2023-10-01");
            Date tmp=d1;
            Calendar dd =Calendar.getInstance();
            dd.setTime(d1);

            while(tmp.getTime()<=d2.getTime()) {
                tmp=dd.getTime();

                String dateTime = sdf.format(tmp);
                String week = weekDays[dd.get(Calendar.DAY_OF_WEEK)-1];
                String sql = "insert into tb_delivery_item(tb_delivery_item.dateTime,tb_delivery_item.states,tb_delivery_item.remark,tb_delivery_item.createTime,tb_delivery_item.updateTime) value ('"+dateTime+"',0,'"+week+"',now(),now());";
                System.out.println(sql);
                //天数加上1
                dd.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
