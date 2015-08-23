package com.zyiot.pm.dao.ht;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.zyiot.framework.exception.ZYException;
import com.zyiot.framework.unit.ZyAutoNumberDao;
import com.zyiot.pm.entity.comm.ZyClass1;
import com.zyiot.pm.entity.ht.ZyExpinfo;

@ Repository
public class ZyClass1Dao extends BaseHibernateDao
{
	@ Resource
	ZyAutoNumberDao	zyautonumberdao;
	
	public Collection<ZyClass1> getAll()
	{
		String hql = "FROM " + ZyClass1.class.getName();
		return this.query(hql);
	}
	
	/**
	 * 获取所有行业分类信息
	 * 
	 * @param parameter 条件参数
	 * @throws Exception
	 * */
	public void getAll(Page<ZyClass1> page , Map<String, Object> parameter) throws Exception
	{
		Map<String, Object> condition = (Map<String, Object>) parameter.get("condition");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ZyClass1.class);
		
		detachedCriteria.addOrder(Order.asc("classcode1"));
		
		if (condition != null)
		{
			if (condition.get("classcode1") != null && condition.get("classcode1") != "")
			{
				String classCode1 = (String) condition.get("classcode1");
				detachedCriteria.add(Restrictions.like("classcode1", classCode1, MatchMode.ANYWHERE));
			}
			if (condition.get("classname1") != null && condition.get("classname1") != "")
			{
				String className1 = (String) condition.get("classname1");
				detachedCriteria.add(Restrictions.like("classname1", className1, MatchMode.ANYWHERE));
			}
		}
		
		this.pagingQuery(page, detachedCriteria);
		
		// 用于虚拟属性
		// Collection<ZyClass1> zyclass1s = page.getEntities();
		// zyclass1s = EntityUtils.toEntity(zyclass1s);
		// for (ZyClass1 zyclass1 : zyclass1s)
		// {
		// EntityUtils.setValue(zyclass1, "percent_test", 100);
		// }
		// page.setEntities(zyclass1s);
	}
	
	/**
	 * 增，删，改所有行业分类信息
	 * 
	 * @throws Exception
	 * */
	public void saveZyClass(final Collection<ZyClass1> zyclasses) throws Exception
	{
		
		Session session = this.getSessionFactory().openSession();
		try
		{
			for (ZyClass1 zyclass : zyclasses)
			{
				EntityState state = EntityUtils.getState(zyclass);
				if (state.equals(EntityState.NEW))
				{
					// 校验检查
					// .................
					check_class_name(zyclass);
					
					// 生成自动编码
					String code = zyclass.getClasscode1();
					String str_max_number = zyautonumberdao.get_nature_code(code, 3);
					update_codes(str_max_number);
					
					// 保存表数据
					zyclass.setPkid(UUID.randomUUID().toString());
					
					IUser user = ContextHolder.getLoginUser();
					zyclass.setCreate_user(user.getUsername());
					zyclass.setCreate_date(new Date());
					
					session.save(zyclass);
					
				}
				
				if (state.equals(EntityState.MODIFIED))
				{
					IUser user = ContextHolder.getLoginUser();
					zyclass.setLast_update_user(user.getUsername());
					zyclass.setLast_update_date(new Date());
					
					session.update(zyclass);
				}
				
				if (state.equals(EntityState.DELETED))
				{
					// 删除前检查表是否被引用
					// ............
					
					session.delete(zyclass);
				}
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	/**
	 * 检查行业分类是否重复
	 * 
	 * */
	public void check_class_name(ZyClass1 zyclasses) throws Exception
	{
		String str_class_name = zyclasses.getClassname1();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("classname1", str_class_name);
		String sql = "select count(cl) from " + ZyClass1.class.getName() + " cl where cl.classname1=:classname1";
		int count = this.queryForInt(sql, map);
		if (count > 0)
		{
			throw new ZYException("重复的行业分类名称");
		}
		
	}
	
	/**
	 * 自动取码
	 * */
	public String generate_code()
	{
		return zyautonumberdao.generate_max_codes(ZyClass1.class.getName(), "101");
	}
	
	/**
	 * 保存最大编码
	 * */
	public void update_codes(String str_max_number)
	{
		zyautonumberdao.update_codes(ZyClass1.class.getName(), str_max_number);
	}
	
}
