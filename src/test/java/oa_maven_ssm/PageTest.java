package oa_maven_ssm;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserExample;
import cn.zzpigt.mybatis.mapper.UserMapper;
public class PageTest {
	
	
	
	@Test
	public void Test() {

		// 创建一个spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 从spring容器中获取mapper代理对象
        UserMapper mapper = context.getBean(UserMapper.class);
        // 执行查询并分页,TbItemExample是逆向工程自动生成的，用来进行条件查询，这里不设置则表示无条件
        UserExample example = new UserExample();
        //分页处理，显示第一页的10条数据
        PageHelper.startPage(1, 10);
        List<User> list = mapper.selectByExample(example);//查询
        // 取商品列表
        for(User user : list) {
            System.out.println(user.getNickname());
        }
        // 取分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有用户总数：" + total);	
		
	}

}
