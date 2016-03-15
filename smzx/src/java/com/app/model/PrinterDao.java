/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author lvbowen
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;

public class PrinterDao implements Printable {

    private PrinterMessage printerMsg;

    public PrinterDao(PrinterMessage printerMsg) {
        this.printerMsg = printerMsg;
    }

    @Override
    public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
        System.out.println(printerMsg);
        try {
            /**
             * * @param Graphic指明打印的图形环境 * @param
             * PageFormat指明打印页格式（页面大小以点为计量单位，1
             * 点为1英寸的1/72，1英寸为25.4毫米。A4纸大致为595×842点） * @param pageIndex指明页号
             *
             */
// 转换成Graphics2D
            Graphics2D g2_1 = (Graphics2D) gra;
// Graphics2D g2_2 = (Graphics2D) gra;
// 设置打印颜色为黑色
            g2_1.setColor(Color.black);
// g2_2.setColor(Color.black);
// 打印起点坐标
            switch (pageIndex) {
                case 0:
// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
// Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和
// DialogInput
                    Font font = new Font("新宋体", Font.BOLD, 14);
                    Font font2 = new Font("新宋体", Font.BOLD, 10);

                    g2_1.setFont(font2); // 设置字体
// BasicStroke bs_3=new BasicStroke(0.5f);
                    float[] dash1 = {2.0f};
// 设置打印线的属性。
// 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
                    g2_1.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
                    double x = pf.getImageableX();
                    double y = pf.getImageableY();
                    float heigth1 = font.getSize2D();
                    float heigth = font2.getSize2D() + 2; // 字体高度
                    PrinterMessage bean1 = printerMsg;
//打印菜单头部信息
                    g2_1.setFont(font); // 设置字体
                    g2_1.drawString(bean1.getBrand(), (float) x + 20, (float) y + 1 * heigth1);
                    g2_1.setFont(font2); // 设置字体
                    g2_1.drawString("联系电话:" + bean1.getPhone(), (float) x, (int) (y + 2 * heigth1));
                    g2_1.drawString("地址:高新五路16号尚品格蓝", (float) x, (int) (y + 3 * heigth1));
                    //打印内容
                    g2_1.setFont(font2); // 设置字体
                    g2_1.drawString("************************" + bean1.getTimestamp(), (float) x, (float) y + 4 * heigth1);
                    g2_1.drawString("时间：" + bean1.getTimestamp(), (float) x, (float) y + 5 * heigth1);
                    //g2_1.drawString("银联卡：" + bean1.getCup(), (float) x + 50, (float) y + 4 * heigth1);
                    g2_1.drawString("单号：" + bean1.getOrderId(), (float) x, (float) y + 6 * heigth1);
                    //g2_1.drawString("台号：" + bean1.getTableName(), (float) x + 50, (float) y + 5 * heigth1);
                    g2_1.drawString("项目：" + bean1.getDetail(), (float) x, (float) y + 7 * heigth1);
                    g2_1.drawString("金额：" + bean1.getPrice(), (float) x, (float) y + 8 * heigth1);
                    g2_1.drawString("操作员：" + bean1.getStaffName(), (float) x, (float) y + 9 * heigth1);

                    if (bean1.getCardNumber() != 0) {
                        g2_1.setFont(font2);
                        g2_1.drawString("会员卡卡号：" + bean1.getCardNumber(), (float) x, (float) y + 10 * heigth1);
                        g2_1.drawString("余额：" + bean1.getBalance(), (float) x, (float) y + 11 * heigth1);
                        g2_1.setFont(font); // 设置字体
                        g2_1.drawString("签名：", (float) x, (float) y + 12 * heigth1);
                        g2_1.setFont(font2); // 设置字体
                        g2_1.drawString("谢谢惠顾！", (float) x, (float) y + 18 * heigth1);
                        g2_1.drawString("==========================", (float) x, (float) y + 20 * heigth1);
                    }

                    return PAGE_EXISTS;

                default:
                    return NO_SUCH_PAGE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
