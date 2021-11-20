package packageMain;

import javax.persistence.PersistenceUnit;

//@PersistenceUnit(unitName = "machine")
public class Teste {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	User all = new User();

	all.setName("Kalel");
	all.setEmail("kalelTeste@aaaa.com");
	all.setPassword("123456");

	Controller con = new Controller();

//		con.salvar(all);

	System.out.println("Rodando...");
    }

    public static void inserTypeMachine(User all) {

	Controller con = new Controller();

	con.salvar(all);

    }

}
