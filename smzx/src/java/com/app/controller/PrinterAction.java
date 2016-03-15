/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

/**
 *
 * @author lvbowen
 */
import com.app.model.PrinterDao;
import com.app.model.PrinterMessage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrinterAction {

    /**
     * 用于将商品零售进行进行打印
     *
     */
    public static void print(PrinterMessage printerMsg) {
// 通俗理解就是书、文档
        Book book = new Book();
// 设置成竖打
        PageFormat pf = new PageFormat();
        pf.setOrientation(PageFormat.PORTRAIT); // LANDSCAPE表示竖打;PORTRAIT表示横打;REVERSE_LANDSCAPE表示打印空白
// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
        Paper p = new Paper();
        //int length = printSize(list);
        System.out.println("=========length:" + 600);
        p.setSize(150, 1000); // 纸张大小(590, 840)表示A4纸
        p.setImageableArea(0, 0, 227, 600); // A4(595 X
// 842)设置打印区域，其实0，0应该是72，72
// ，因为A4纸的默认X,Y边距是72
        pf.setPaper(p);
// // 把 PageFormat 和 Printable 添加到书中，组成一个页面
        book.append(new PrinterDao(printerMsg), pf);
// // 获取打印服务对象
        PrinterJob job = PrinterJob.getPrinterJob();
// // 设置打印类
        job.setPageable(book);
        try {
// // 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
            boolean a = job.printDialog();
            if (a) {
                job.print();
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

}
