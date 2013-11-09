package com.wgsh.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
* Group �� ����ƥ���ץȡ htmlҳ�������
* @author SoFlash - ����԰  http://www.cnblogs.com/longwu
*/
public class GroupTest {

    public static void main(String[] args) {
        // Pattern ���ڱ������� �����õ���3������ �ֱ�������()��ס
        // ��1����������ƥ��URL ��Ȼ���������һ��׼ȷ ���ƥ��URL��������Ǵ���� ֻ��������պ���ƥ�����
        // ��2������������ƥ����� SoFlash��
        // ��3����������ƥ������
        /* ����ֻ����һ�������url,���������ȫ����ƥ������� */
        Pattern p = Pattern
                .compile("='(\\w.+)'>(\\w.+[a-zA-Z])-(\\d{1,2}\\.\\d{1,2}\\.\\d{4})");
        String s = "<a href='http://www.cnblogs.com/longwu'>SoFlash-12.22.2011</a>";
        Matcher m = p.matcher(s);
        while (m.find()) {
            // ͨ������group()����������� ��url,���������ȫ������ӡ����
            System.out.println("��ӡ��url����:" + m.group(1));
            System.out.println("��ӡ������:" + m.group(2));
            System.out.println("��ӡ������:" + m.group(3));
            System.out.println();
        }
        System.out.println("group������������ݸ���:" + m.groupCount() + "��");
    }
}