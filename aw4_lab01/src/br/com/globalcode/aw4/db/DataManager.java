package br.com.globalcode.aw4.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.globalcode.aw4.model.RegistroAtendimento;

public class DataManager {
    private SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
	Configuration configuration = new Configuration();
	configuration.configure();
	return configuration.buildSessionFactory();
    }

    public DataManager(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public void create(Object obj) {
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	session.save(obj);
	tx.commit();
	session.close();
    }

    public RegistroAtendimento getAtendimentoById(Integer id) {
	Session session = sessionFactory.openSession();
	RegistroAtendimento regAtendimento = (RegistroAtendimento) session.get(
		RegistroAtendimento.class, id);
	session.close();
	return regAtendimento;
    }

    public void update(Object obj) {
    }

    public List<RegistroAtendimento> getAtendimentosPendentes() {
	Session session = sessionFactory.openSession();
	Query query = session
		.createQuery("from RegistroAtendimento at where at.textoResposta = null");
	List<RegistroAtendimento> lista = query.list();
	session.close();
	return lista;
    }
}
