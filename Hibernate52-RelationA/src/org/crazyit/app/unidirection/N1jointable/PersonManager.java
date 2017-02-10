package org.crazyit.app.unidirection.N1jointable;

import org.crazyit.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ����һ��Person����
		Person p = new Person();
		// ����Person��nameΪcrazyit�ַ���
		p.setName("crazyit");
		p.setAge(21);
		// ����һ��˲̬��Address����
		Address a = new Address("�������");
		// ����Person��Address֮��Ĺ�����ϵ
		p.setAddress(a);
		// �ٳ־û�Address����
		session.persist(a);
		// ����һ��˲̬��Address����
		Address a2 = new Address("�Ϻ����");
		// ����Person��Address֮��Ĺ�����ϵ
		p.setAddress(a2);
		// ���ڲ��������ӱ���ά��N-1������ϵ����˲��������ӱ���ϵ��
		// ���������������ȳ־û��ĸ�ʵ�塣
		// �־û�Address����
		session.persist(a2);
		// �־û�Person����
		session.save(p);
		// �־û�Address����
		session.save(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}