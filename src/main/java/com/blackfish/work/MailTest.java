//package com.blackfish.work;
//
///**
// * @Auther: pcc
// * @Date: 2022/8/12 13:09
// * @Description:
// */
//public class MailTest {
//
//    public static void main(String[] args) {
//        // 01 创建一个HtmlEmail实例对象
//        HtmlEmail email = new HtmlEmail();
//
//        // 02 连接邮箱的SMTP服务器：一般QQ邮箱为 smtp.qq.com，163邮箱为 smtp.163.com
//        // 这里以大家常用的QQ邮箱来模拟公司邮箱
//        email.setHostName("smtp.qq.com");
//
//        // 03 设置发送的字符类型(编码格式选支持中文的utf-8)
//        email.setCharset("utf-8");
//        try {
//            // 04 设置收件人的邮箱(可以多个，我这里就设置两个来模拟批量发送，也就是填写要发送email的客户邮箱)
//            // 我这里分别申请了1个QQ邮箱和1个163邮箱来做测试
//            email.addTo("xxx1@xxx.com");//设置收件人
//            email.addTo("xxx2@xxx.com");//设置收件人
//
//            // 05 设置发件人邮箱(也就是公司邮箱，这里以自己的发送邮箱模拟)
//            // 第一个参数为:自己的邮箱     第2个参数为：你可以设置你自己发送的昵称(原则上随便填)-->我这里就随便取个名：揪心的情绪
//            // 我这里分别以另外1个QQ邮箱作为发件人邮箱
//            email.setFrom("xxx@xxx.com", "揪心的情绪");
//
//            // 06 获得本地发送邮件的授权码(需要去QQ邮箱里面开启POP3/SMTP服务)
//            // 登录网页版QQ邮箱-->点标题栏的设置-->账户-->POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务-->
//            // 开启POP3/SMTP服务-->手机发送短信获取授权码
//            email.setAuthentication("xxx@xxx.com", "xxxxxxxxxxxxxxx");
//
//            // 07 设置主题(也就是写邮件的主题)
//            email.setSubject("hey,我是主题");//设置发送主题
//
//            // 08 设置您要发送的内容
//            email.setMsg("我是内容");//设置发送内容
//
//            // 09 这里设为为true
//            email.setSSLOnConnect(true);
//
//            // 10 发送邮件
//            email.send(); //发送邮件
//
//            // 11 给控制台一个反馈(可要可不要)
//            System.out.println("发送成功");
//
//        } catch (EmailException e) { // 捕获可能会发生的异常
//            e.printStackTrace();
//        }
//    }
//}
