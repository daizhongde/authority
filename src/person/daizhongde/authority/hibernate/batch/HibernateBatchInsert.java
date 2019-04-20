package person.daizhongde.authority.hibernate.batch;

import java.sql.Connection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateBatchInsert  extends HibernateDaoSupport{
	@SuppressWarnings("deprecation")
	public void batchInsert(final List rows)
	{
		getHibernateTemplate().execute(
				new HibernateCallback()
				{
					public Object doInHibernate(Session session)
						throws HibernateException
					{
						Transaction tx = session.beginTransaction();     
				        for ( int i=0, j = rows.size(); i<j; i++ ) { //插入100万条数据  
				            session.save( rows.get(i) );   
				            if(i%100==0){   //每一千条刷新并写入数据库  
				                session.flush();  
				                session.clear();  
				            }
				        }
				        tx.commit();   
				        session.close();
				        return null;
					}
				});
		
		
//		Session session = this.getSession(true);
////	  long begin = System.currentTimeMillis();  
//	  Transaction tx = session.beginTransaction();     
//        for ( int i=0, j = rows.size(); i<j; i++ ) { //插入100万条数据  
//            session.save( rows.get(i) );   
//            if(i%100==0){   //每一千条刷新并写入数据库  
//                session.flush();  
//                session.clear();  
//            }
//        }
//        tx.commit();   
//        session.close();  
////        long end = System.currentTimeMillis();  
////        System.out.println((end-begin)/1000.0);
	}
	
	public void jdbcBatchInsert(final List rows)
	{
		
//		getHibernateTemplate().execute(
//				new HibernateCallback()
//				{
//					public Object doInHibernate(Session session)
//						throws HibernateException
//					{
//						session.doWork(  
//								  new Work() {  
//								    public void execute(Connection connection) {  
//								      // 这里已经得到connection了，可以继续你的JDBC代码。  
//								      // 注意不要close了这个connection。  
//								    	 for ( int i=0, j = rows.size(); i<j; i++ ) { //插入100万条数据  
//								    		 connection.set.save( rows.get(i) );   
//									            if(i%100==0){   //每一千条刷新并写入数据库  
//									            	connection.flush();  
//									            	connection.clear();  
//									            }
//									        }
//								    }  
//								  }  
//								);
//				        session.close();
//				        return null;
//					}
//				});
		
		
	}
}
