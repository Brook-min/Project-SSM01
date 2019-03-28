package com.newer.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.newer.dao.sys.ResourceMapper;
import com.newer.pojo.sys.Resource;
import junit.framework.TestCase;

/**
 * 资源测试类
 *
 * @author LiuKang
 */
public class ResourceTest extends TestCase {

    ResourceMapper resourceMapper;

    @Before
    public void setUp() throws Exception {
        // 上下文对象
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"/spring/spring-context.xml"});
        // 实例化业务层接口
        resourceMapper = (ResourceMapper) ctx.getBean("resourceMapper");
    }

    /**
     * 测试左侧菜单
     */
    @Test
    public void testMenu() {

        // 查询出所有资源
        List<Resource> resources = resourceMapper.selectMenu(2);

        // 存放菜单树
        List<Resource> resourceMenu = new ArrayList<Resource>();
        List<Resource> resources2 = null;
        for (Resource resource : resources) {
            // 顶级菜单
            if (resource.getType().equals("0")) {
                resourceMenu.add(resource);
                // 双重条件循环
                resources2 = new ArrayList<Resource>();
                for (Resource r : resources) {
                    // if等于
                    if (resource.getId().equals(r.getPid())) {
                        resources2.add(r);
                        resource.setResources(resources2);
                    }
                }
            }
        }
        Collections.sort(resourceMenu, new MyComparator());
        Collections.sort(resources2, new MyComparator());
        System.out.println(resourceMenu);

    }

    /**
     * 用于list集合排序
     *
     * @author LiuKang
     */
    class MyComparator implements Comparator<Resource> {
        @Override
        public int compare(Resource o1, Resource o2) {
            return o1.getSeq() - o2.getSeq();
        }
    }

}
