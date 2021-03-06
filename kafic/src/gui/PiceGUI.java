package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class PiceGUI extends JFrame {

	public JPanel contentPane;
	public JList listaTopliNapici;
	public JList listaBezalkoholnaPica;
	public JList listaAlkoholnaPica;
	public JList listaPiva;
	public JList list;
	private JTextField txtIznos;

	public PiceGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GuiKontroler.zatvoriProzorPiceGUI();
			}
		});

		setTitle("Porud\u017Ebina");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 821, 598);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Topli napici:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 25, 130, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Bezalkoholna pi\u0107a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(218, 25, 130, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Alkoholna pi\u0107a:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(34, 291, 130, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Piva:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(218, 291, 130, 16);
		contentPane.add(lblNewLabel_3);

		JPanel panelKafe = new JPanel();
		panelKafe.setBounds(34, 54, 150, 224);
		contentPane.add(panelKafe);
		panelKafe.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelKafe.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(getListaTopliNapici());

		JPanel panelAlkohol = new JPanel();
		panelAlkohol.setBounds(34, 320, 150, 224);
		contentPane.add(panelAlkohol);
		panelAlkohol.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelAlkohol.add(scrollPane_2, BorderLayout.CENTER);
		scrollPane_2.setViewportView(getListaAlkoholnaPica());

		JPanel panelSokovi = new JPanel();
		panelSokovi.setBounds(218, 54, 150, 224);
		contentPane.add(panelSokovi);
		panelSokovi.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelSokovi.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setViewportView(getListaBezalkoholnaPica());

		JPanel panelPivo = new JPanel();
		panelPivo.setBounds(218, 320, 150, 224);
		contentPane.add(panelPivo);
		panelPivo.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelPivo.add(scrollPane_3, BorderLayout.CENTER);
		scrollPane_3.setViewportView(getListaPiva());

		JPanel panel = new JPanel();
		panel.setBounds(458, 54, 323, 420);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane_4, BorderLayout.CENTER);
		scrollPane_4.setViewportView(getList());

		txtIznos = new JTextField();
		scrollPane_4.setColumnHeaderView(txtIznos);
		txtIznos.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("PREDRA\u010CUN:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(458, 25, 323, 16);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ispis = GuiKontroler.obrisiStavkuIzListe(list, list.getLastVisibleIndex());
				String c = ispis.substring(ispis.lastIndexOf(" ") + 1, ispis.length());

				int cena = Integer.parseInt(c) * (-1);
				GuiKontroler.dodajCenu(cena, txtIznos);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(458, 505, 130, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RA\u010CUN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				GuiKontroler.PiceGuiRacun();
				GuiKontroler.obrisiText(txtIznos);
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(651, 505, 130, 39);
		contentPane.add(btnNewButton_1);
	}

	private JList getListaTopliNapici() {
		if (listaTopliNapici == null) {
			listaTopliNapici = new JList();
			listaTopliNapici.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					GuiKontroler.odselektujOstale(listaAlkoholnaPica, listaBezalkoholnaPica, listaPiva);
				}

			});
			listaTopliNapici.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						String ispis = listaTopliNapici.getSelectedValue().toString();
						GuiKontroler.ispisiUJListu(ispis, list);

						String c = ispis.substring(ispis.lastIndexOf(" ") + 1, ispis.length());

						int cena = Integer.parseInt(c);
						GuiKontroler.dodajCenu(cena, txtIznos);
					}
				}
			});

			listaTopliNapici.setModel(new AbstractListModel() {
				String[] values = new String[] {};

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return listaTopliNapici;
	}

	private JList getListaBezalkoholnaPica() {
		if (listaBezalkoholnaPica == null) {
			listaBezalkoholnaPica = new JList();
			listaBezalkoholnaPica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					GuiKontroler.odselektujOstale(listaAlkoholnaPica, listaTopliNapici, listaPiva);
				}
			});
			listaBezalkoholnaPica.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						String ispis = listaBezalkoholnaPica.getSelectedValue().toString();
						GuiKontroler.ispisiUJListu(ispis, list);

						String c = ispis.substring(ispis.lastIndexOf(" ") + 1, ispis.length());

						int cena = Integer.parseInt(c);
						GuiKontroler.dodajCenu(cena, txtIznos);
					}
				}
			});
		}
		return listaBezalkoholnaPica;
	}

	private JList getListaAlkoholnaPica() {
		if (listaAlkoholnaPica == null) {
			listaAlkoholnaPica = new JList();
			listaAlkoholnaPica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GuiKontroler.odselektujOstale(listaTopliNapici, listaBezalkoholnaPica, listaPiva);
				}
			});
			listaAlkoholnaPica.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						String ispis = listaAlkoholnaPica.getSelectedValue().toString();
						GuiKontroler.ispisiUJListu(ispis, list);

						String c = ispis.substring(ispis.lastIndexOf(" ") + 1, ispis.length());

						int cena = Integer.parseInt(c);
						GuiKontroler.dodajCenu(cena, txtIznos);
					}
				}
			});
		}
		return listaAlkoholnaPica;
	}

	private JList getListaPiva() {
		if (listaPiva == null) {
			listaPiva = new JList();
			listaPiva.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GuiKontroler.odselektujOstale(listaAlkoholnaPica, listaBezalkoholnaPica, listaTopliNapici);
				}
			});
			listaPiva.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						String ispis = listaPiva.getSelectedValue().toString();
						GuiKontroler.ispisiUJListu(ispis, list);

						String c = ispis.substring(ispis.lastIndexOf(" ") + 1, ispis.length());

						int cena = Integer.parseInt(c);
						GuiKontroler.dodajCenu(cena, txtIznos);
					}
				}
			});
		}
		return listaPiva;
	}

	private JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
}