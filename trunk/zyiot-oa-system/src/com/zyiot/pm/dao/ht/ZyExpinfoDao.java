package com.zyiot.pm.dao.ht;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.FetchMode;
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
import com.zyiot.framework.unit.ZyAutoNumberDao;
import com.zyiot.pm.entity.ht.ZyExpinfo;

@ Repository
public class ZyExpinfoDao extends BaseHibernateDao {
	@ Resource
	ZyAutoNumberDao	zyautonumberdao;
	
	public Collection<ZyExpinfo> getAll() {
		String hql = "FROM " + ZyExpinfo.class.getName();
		return this.query(hql);
	}
	
	/**
	 * 获取所有拓展商信息
	 * 
	 * @param parameter 条件参数
	 * */
	public void getAll(Page<ZyExpinfo> page , Map<String, Object> parameter) {
		Map<String, Object> condition = (Map<String, Object>) parameter.get("condition");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ZyExpinfo.class);
		
		detachedCriteria.setFetchMode("zyclass1", FetchMode.JOIN);
		
		detachedCriteria.createAlias("zyclass1", "class1");
		detachedCriteria.add(Restrictions.eq("class1.PK_ID", "1"));
		
		detachedCriteria.addOrder(Order.asc("expcode"));
		
		if (condition != null) {
			if (condition.get("expcode") != null && condition.get("expcode") != "") {
				String expcode = (String) condition.get("expcode");
				detachedCriteria.add(Restrictions.like("expcode", expcode, MatchMode.ANYWHERE));
			}
		}
		
		this.pagingQuery(page, detachedCriteria);
	}
	
	public void saveZyExpinfo(Collection<ZyExpinfo> zyexpinfos) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try {
			for (ZyExpinfo zyexpinfo : zyexpinfos) {
				EntityState state = EntityUtils.getState(zyexpinfo);
				if (state.equals(EntityState.NEW)) {
					// 校验检查
					// .................
					// check_class_name(zyexpinfo);
					
					// 生成自动编码
					String code = zyexpinfo.getExpcode();
					String str_max_number = zyautonumberdao.get_nature_code(code, 9);
					update_codes(str_max_number);
					
					// 保存表数据
					zyexpinfo.setPkid(UUID.randomUUID().toString());
					
					IUser user = ContextHolder.getLoginUser();
					zyexpinfo.setCreate_user(user.getUsername());
					zyexpinfo.setCreate_date(new Date());
					
					session.save(zyexpinfo);
					
				}
				
				if (state.equals(EntityState.MODIFIED)) {
					IUser user = ContextHolder.getLoginUser();
					zyexpinfo.setLast_update_user(user.getUsername());
					zyexpinfo.setLast_update_date(new Date());
					
					session.update(zyexpinfo);
				}
				
				if (state.equals(EntityState.DELETED)) {
					// 删除前检查表是否被引用
					// ............
					
					session.delete(zyexpinfo);
				}
			}
		}
		finally {
			session.flush();
			session.close();
		}
	}
	
	/**
	 * 自动取码
	 * */
	public String generate_code() {
		return zyautonumberdao.generate_max_codes(ZyExpinfo.class.getName(), "100000001");
	}
	
	/**
	 * 保存最大编码
	 * */
	public void update_codes(String str_max_number) {
		zyautonumberdao.update_codes(ZyExpinfo.class.getName(), str_max_number);
	}
	
}
