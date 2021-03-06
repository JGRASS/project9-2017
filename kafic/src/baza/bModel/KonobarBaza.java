package baza.bModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import baza.konekcija.Konekcija;
import model.Konobar;;

public class KonobarBaza {

	/**
	 * 
	 * @return vraca sve konobare(i admine) iz MySQL baze
	 */
	public static LinkedList<Konobar> ubaciUListuSveKonobare() {
		LinkedList<Konobar> listaKonobara = new LinkedList<>();

		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "SELECT * FROM korisnici";

			ResultSet rs = s.executeQuery(SQL);

			while (rs.next()) {
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				boolean admin = false;
				String a = rs.getString("Admin");
				if (a.contains("true")) {
					admin = true;
				}
//				if (a.equalsIgnoreCase("true")) { NE RADI!
//					admin = true;
//				}
				Konobar k = new Konobar(username, password, admin);
				listaKonobara.add(k);
			}

			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaKonobara;
	}

	/**
	 * Voditi racuna jer data metoda iz baze brise sve konobare i postavlja u
	 * bazu samo konobare iz liste, pa je potrebno pozvati ovu metodu uvek pri
	 * gasenju aplikacije
	 * 
	 * @param listaKonobara
	 *            lista svih konobara
	 */
	public static void prebaciSveKonobareIzListeUBazu(LinkedList<Konobar> listaKonobara) {
		try {
			Connection c = Konekcija.getInstance();
			Statement s = c.createStatement();

			String SQL = "DELETE FROM korisnici";
			s.executeUpdate(SQL);

			for (Konobar konobar : listaKonobara) {
//				String admin = konobar.isAdmin() + "";
				String admin = "false";
				if(konobar.isAdmin()){admin = "true";}
				String SQL2 = "INSERT INTO korisnici (Username , Password , Admin)" + " VALUES ('" + konobar.getUser()
						+ "' , '" + konobar.getPass() + "' , '" + admin + " ')";
				System.out.println(SQL2);
				s.executeUpdate(SQL2);
			}

			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/*	 public static void main(String[] args) {
		Konobar a = new Konobar("Admin", "123", true);
		Konobar b = new Konobar("Jova", "321", false);
		LinkedList<Konobar> konobari = KonobarBaza.ubaciUListuSveKonobare();
		konobari.add(a);
		konobari.add(b);
		KonobarBaza.prebaciSveKonobareIzListeUBazu(konobari);
	}
	*/
}
