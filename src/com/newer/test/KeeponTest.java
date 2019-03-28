package com.newer.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newer.dao.sys.KeeponMapper;
import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.examples.KeeponExample;
import com.newer.pojo.sys.examples.KeeponExample.Criteria;

import junit.framework.TestCase;

public class KeeponTest extends TestCase {

    private KeeponMapper keeponMapper;


    @Before
    public void setUp() throws Exception {
        // 上下文对象
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring-context.xml");
        // 实例化业务层接口
        keeponMapper = (KeeponMapper) ctx.getBean("keeponMapper");
    }


    @Test
    public void testkeepon() {
        KeeponExample example = new KeeponExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andRolecodeEqualTo("counselor");
        createCriteria.andStudentnameEqualTo("aa");
        createCriteria.andUidEqualTo(1);
        List<Keepon> list = keeponMapper.selectKeeponByRoleCode(example);
        for (Keepon keepon : list) {
            System.out.println(keepon);
        }
    }

    @Test
    public void testSelectKeeponWithConsultation() {
        Keepon keepon = keeponMapper.selectKeeponWithConsultationsById(1);
        System.out.println(keepon.getConsultations());
    }

}
