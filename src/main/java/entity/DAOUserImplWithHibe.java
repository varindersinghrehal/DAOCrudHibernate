
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class DAOUserImplWithHibe implements DaoUsersHibe{
	private static final String StringUtils = null;
	Users user;
	Session session =  connessione().openSession();
	Transaction trx = session.beginTransaction();
	public Users getUser(int id) {
		user = new Users();
		user = session.get(Users.class, id);
		//session.close();
		return user;
	}
	public List<Users> getAllUsers() {
		List <Users> usersall = new ArrayList<Users>();
		Query<Users> query = session.createQuery("from Users");
		usersall = query.list();
		return usersall;
	}
	public void addUser(Users user) {

		session.save(user);
		System.out.println("*** Inserimento avvenuto correttamente ***");

	}
	public void updateUser(Users user) {
		this.user = session.get(Users.class, user.getId());
		this.user.setName(user.getName());
		this.user.setAddress(user.getAddress());
		this.user.setEmail(user.getEmail());
		this.user.setPhone(user.getPhone());
		System.out.println("*** Modifica avvenuta correttamente ***");
		session.save(this.user);
	}	
	
	public void deleteUser(int id) {
		user = new Users();
		if((checkUserId(user.getId()) == false)) {
			user = session.get(Users.class, id);
			session.delete(user);
		}else System.out.println("Impossibile cancellare utente. Id inserito non presente");
	}
	
	public static SessionFactory connessione() {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(sr).getMetadataBuilder().build();
		SessionFactory  sf = meta.getSessionFactoryBuilder().build();	
		return sf;
	}
	public void uscita() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Vuoi salvare le modifiche fatte al DB? Digitare si o no");
			String scelta = sc.nextLine();
			if(scelta.equalsIgnoreCase("si")) {
				trx.commit();
				session.close();
				System.out.println("*** Modifiche salvate correttamente ***");
				break;
			}
			else if(scelta.equalsIgnoreCase("no")) {
				trx.rollback();
				session.close();
				System.out.println("*** Modifiche non salvate ***");
				break;
			} System.out.println("Comando non valido");
		}while(true);
	}
	public boolean checkUserId(int id) {
		
		return session.get(Users.class, id) != null;
	}
}
