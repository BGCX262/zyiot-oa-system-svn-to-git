package com.zyiot.pm.dao.comm;

import java.util.Collection;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.zyiot.pm.dao.ht.BaseHibernateDao;
import com.zyiot.pm.entity.comm.ZyBaseCode;
@Repository
public class ZyBaseCodeDao extends BaseHibernateDao
{
	public Collection<ZyBaseCode> getAll()
	{
		String hql = "FROM " + ZyBaseCode.class.getName();
		return this.query(hql);
	}
	
	/**
	 * 增，删，改所有数据字典
	 * 
	 * @throws Exception
	 * */
	public void saveZyBaseCode(final Collection<ZyBaseCode> zybasecodes) throws Exception
	{
		
		Session session = this.getSessionFactory().openSession();
		try
		{
			for (ZyBaseCode zybasecode : zybasecodes)
			{
				EntityState state = EntityUtils.getState(zybasecode);
				if (state.equals(EntityState.NEW))
				{
					// 保存表数据
					zybasecode.setPkid(UUID.randomUUID().toString());
					session.save(zybasecode);
				}
				
				if (state.equals(EntityState.MODIFIED))
				{
					session.update(zybasecode);
				}
				
				if (state.equals(EntityState.DELETED))
				{
					// 删除前检查表是否被引用
					session.delete(zybasecode);
				}
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
}
