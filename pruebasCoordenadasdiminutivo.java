package ModificarTablas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import com.placeholder.PlaceHolder;

public class pruebasCoordenadasdiminutivo {
	final private static int x = 20;
	final private static int ancho = 50;// Ancho de los JTextfields

	// LLAVE UNIQUE
	private static List<String> llavesUNIQUEarray = new ArrayList<String>();
	private static List<String> llavesUNIQUEarraySecundaria = new ArrayList<String>();
	private static Map<String, String> hmUNIQUE = new HashMap<String, String>();
	private static int hmUNIQUEcontador = 2;
	private static int llaveUNIQUEcontadorSecundaria = 0;
	private static String llaveunique = "";
	// LLAVE INDEX
	private static List<String> llavesINDEXarray = new ArrayList<String>();
	private static List<String> llavesINDEXarraySecundaria = new ArrayList<String>();
	private static Map<String, String> hmINDEX = new HashMap<String, String>();
	private static int hmINDEXcontador = 2;
	private static int llaveINDEXcontadorSecundaria = 0;
	private static String llaveindex = "";
	// LLAVE FULLTEXT
	private static List<String> llavesFULLTEXTarray = new ArrayList<String>();
	private static List<String> llavesFULLTEXTarraySecundaria = new ArrayList<String>();
	private static Map<String, String> hmFULLTEXT = new HashMap<String, String>();
	private static int hmFULLTEXTcontador = 2;
	private static int llaveFULLTEXTcontadorSecundaria = 0;
	private static String llavefulltext = "";
	// LLAVE SPATIAL
	private static List<String> llavesSPATIALarray = new ArrayList<String>();
	private static List<String> llavesSPATIALarraySecundaria = new ArrayList<String>();
	private static Map<String, String> hmSPATIAL = new HashMap<String, String>();
	private static int hmSPATIALcontador = 2;
	private static int llaveSPATIALcontadorSecundaria = 0;
	private static String llavespatial = "";

	private static String seleccionado;
	private static String nombrePersonalizado = "";

	static int contadorUNIQUE = 0;
	static int contadorINDEX = 0;
	static int contadorFULLTEXT = 0;
	static int contadorSPATIAL = 0;

	private static int validarAI = 0;

	private static int i = 0;

	public static void main(String[] args) {
		numeroCampos();
	}

	public static void numeroCampos() {
		int numero;
		try {
			String numerostr = JOptionPane.showInputDialog(null, "¿Cuantas columnas tendra la tabla?");
			numero = Integer.parseInt(numerostr);
			crearTabla(numero);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Ingresa un numero", "FAIL", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void crearTabla(int numero) {
		JFrame crearTableGUI = new JFrame();
		crearTableGUI.setLayout(null);
		JPanel panelS = new JPanel();
		// panelS.setLayout(new GridLayout(1, 9));
		panelS.setLayout(new GridBagLayout());
		JLabel nombre = new JLabel("Nombre de la Tabla:");
		JLabel commTable = new JLabel("Comentarios de la Tabla:");
		JTextField nombreF = new JTextField();
		JTextField commTableF = new JTextField();
		JButton crearBTN = new JButton("Crear Tabla");
		JButton atrasBTN = new JButton("Atras");
		JButton reiniciarBTN = new JButton("Reiniciar");
		JTextArea infoErrorTA = new JTextArea();
		panelS.setBackground(Color.orange);

		// Creacion de ScrollBars
		infoErrorTA.setEditable(false);
		infoErrorTA.setText(
				"Aquí agregar los fallos que puedan suceder al crear la tabla o mandar de creada satisfactoriamente");
		JScrollPane scrollErrorTA = new JScrollPane(infoErrorTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// ScrollBar del panelS
		JScrollPane scrollBar = new JScrollPane(panelS, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// 1780,740
		// 1330, 450 RESOLUCION BAJA
		scrollBar.setBounds(0, 150, 1330, 490);

		// Bordes
		Border blackline = BorderFactory.createLineBorder(Color.black);
		nombre.setBorder(blackline);
		commTable.setBorder(blackline);

		// Posicionamos el JLabel y JButton
		nombre.setBounds(x, 30, 120, ancho);
		commTable.setBounds(x, 80, 150, ancho);
		nombreF.setBounds(x + 160, 40, 400, 40);
		commTableF.setBounds(x + 160, 90, 400, 40);
		crearBTN.setBounds(x + 600, 35, 150, 40);
		atrasBTN.setBounds(x + 790, 35, 150, 40);
		reiniciarBTN.setBounds(x + 790, 85, 150, 40);
		scrollErrorTA.setBounds(x + 1000, 20, 300, 100);

		// Crear objetos de Encabezado de Campos
		JLabel nombreEncabezado = new JLabel("Nombre:", SwingConstants.CENTER);
		JLabel tipoEncabezado = new JLabel("Tipo:", SwingConstants.CENTER);
		JLabel longvalEncabezado = new JLabel("Longitud Valores:", SwingConstants.CENTER);
		JLabel predetEncabezado = new JLabel("Predeterminado:", SwingConstants.CENTER);
		JLabel atributoEncabezado = new JLabel("Atributos:", SwingConstants.CENTER);
		JLabel nuloEncabezado = new JLabel("Nulo:", SwingConstants.CENTER);
		JLabel indiceEncabezado = new JLabel("Indice:", SwingConstants.CENTER);
		JLabel a_i_Encabezado = new JLabel("A_I:", SwingConstants.CENTER);
		JLabel comentariosEncabezado = new JLabel("Comentarios:", SwingConstants.CENTER);

		// Bordes de cada objeto del Encabezado del Campo
		nombreEncabezado.setBorder(blackline);
		tipoEncabezado.setBorder(blackline);
		longvalEncabezado.setBorder(blackline);
		predetEncabezado.setBorder(blackline);
		atributoEncabezado.setBorder(blackline);
		nuloEncabezado.setBorder(blackline);
		indiceEncabezado.setBorder(blackline);
		a_i_Encabezado.setBorder(blackline);
		comentariosEncabezado.setBorder(blackline);

		// Posicionando Encabezado de Campos
		nombreEncabezado.setBounds(65, 150, 60, 40);
		tipoEncabezado.setBounds(155, 150, 60, 40);
		longvalEncabezado.setBounds(235, 150, 110, 40);
		predetEncabezado.setBounds(440, 150, 100, 40);
		atributoEncabezado.setBounds(620, 150, 100, 40);
		nuloEncabezado.setBounds(830, 150, 100, 40);
		indiceEncabezado.setBounds(1020, 150, 100, 40);
		a_i_Encabezado.setBounds(1120, 150, 100, 40);
		comentariosEncabezado.setBounds(1210, 150, 100, 40);

		// Agregando objetos de Encabezado a panelS
		/*
		 * crearTableGUI.add(nombreEncabezado); crearTableGUI.add(tipoEncabezado);
		 * crearTableGUI.add(longvalEncabezado); crearTableGUI.add(predetEncabezado); //
		 * crearTableGUI.add(cotejaEncabezado); crearTableGUI.add(atributoEncabezado);
		 * crearTableGUI.add(nuloEncabezado); crearTableGUI.add(indiceEncabezado);
		 * crearTableGUI.add(a_i_Encabezado); crearTableGUI.add(comentariosEncabezado);
		 */

		// Paneles de los campos
		JPanel panel1 = new JPanel(new GridLayout(numero, 1));
		JPanel panel2 = new JPanel(new GridLayout(numero, 1));
		JPanel panel3 = new JPanel(new GridLayout(numero, 1));
		JPanel panel4 = new JPanel(new GridLayout(numero, 1));
		JPanel panel5 = new JPanel(new GridLayout(numero, 1));
		JPanel panel6 = new JPanel(new GridLayout(numero, 1));
		JPanel panel7 = new JPanel(new GridLayout(numero, 1));
		JPanel panel8 = new JPanel(new GridLayout(numero, 1));
		JPanel panel9 = new JPanel(new GridLayout(numero, 1));

		GridBagConstraints c = new GridBagConstraints(); // Creacion de la variable para manejar los tamaños
		c.ipadx = 23;
		c.ipady = 30;

		c.gridx = 0;
		c.gridy = 0;
		panelS.add(nombreEncabezado, c);
		c.gridx = 1;
		panelS.add(tipoEncabezado, c);
		c.gridx = 2;
		panelS.add(longvalEncabezado, c);
		c.gridx = 3;
		panelS.add(predetEncabezado, c);
		c.gridx = 4;
		panelS.add(atributoEncabezado, c);
		c.gridx = 5;
		panelS.add(nuloEncabezado, c);
		c.gridx = 6;
		panelS.add(indiceEncabezado, c);
		c.gridx = 7;
		panelS.add(a_i_Encabezado, c);
		c.gridx = 8;
		panelS.add(comentariosEncabezado, c);
		GridBagConstraints c1 = new GridBagConstraints(); // Creacion de la variable para manejar los tamaños
		c1.ipadx = 23;
		c1.ipady = 400;

		c1.gridx = 0;
		c1.gridy = 1;
		panelS.add(panel1, c1);
		c1.gridx = 1;
		panelS.add(panel2, c1);
		c1.gridx = 2;
		panelS.add(panel3, c1);
		c1.gridx = 3;
		panelS.add(panel4, c1);
		c1.gridx = 4;
		panelS.add(panel5, c1);
		c1.gridx = 5;
		panelS.add(panel6, c1);
		c1.gridx = 6;
		panelS.add(panel7, c1);
		c1.gridx = 7;
		panelS.add(panel8, c1);
		c1.gridx = 8;
		panelS.add(panel9, c1);

		/*
		 * panel1.setPreferredSize(new Dimension(145, 0)); panel2.setPreferredSize(new
		 * Dimension(145, 0)); panel3.setPreferredSize(new Dimension(145, 0));
		 * panel4.setPreferredSize(new Dimension(145, 0)); panel5.setPreferredSize(new
		 * Dimension(145, 0)); panel6.setPreferredSize(new Dimension(145, 0));
		 * panel7.setPreferredSize(new Dimension(145, 0)); panel8.setPreferredSize(new
		 * Dimension(145, 0)); panel9.setPreferredSize(new Dimension(145, 0));
		 */

		// Crear arreglo de JTextFields de Nombre
		JTextField camposNombre[] = new JTextField[numero];
		JPanel camposNombreP[] = new JPanel[numero];
		PlaceHolder holder[] = new PlaceHolder[numero];

		// Arreglo del Nombre
		for (i = 0; i < camposNombre.length; i++) {
			camposNombreP[i] = new JPanel();
			camposNombre[i] = new JTextField();
			// holder[i] = new PlaceHolder(camposNombre[i], ""+(i + 1));
			// Tamaño para el JtextField
			camposNombre[i].setPreferredSize(new Dimension(100, 30));
			camposNombreP[i].add(camposNombre[i]);

			panel1.add(camposNombreP[i]);
		}
		/*
		 * for (i = 0; i < camposNombre.length; i++) { String ii = Integer.toString(i +
		 * 1); holder[i] = new PlaceHolder(camposNombre[i], Integer.toString(i + 1)); }
		 */

		// Arreglo de Lista Desplegable
		JComboBox tipoList[] = new JComboBox[numero];
		JPanel camposTipoP[] = new JPanel[numero];
		String[] tipoPal = { "BIT", "TINYINT", "SMALLINT", "MEDIUMINT", "INT", "BIGINT", "REAL", "DOUBLE", "FLOAT",
				"DECIMAL", "DATE", "TIME", "TIMESTAMP", "DATETIME", "YEAR", "CHAR", "VARCHAR", "BINARY", "VARBINARY",
				"TINYBLOB", "BLOB", "MEDIUMBLOB", "LONGBLOB", "TINYTEXT", "TEXT", "MEDIUMTEXT", "LONGTEXT", "ENUM",
				"SET", "BOOLEAN", "SERIAL", "GEOMETRY", "POINT", "LINESTRING", "POLYGON", "GEOMETRYCOLLECTION",
				"MULTILINESTRING", "MULTIPOINT", "MULTIPOLYGON", "JSON" };
		for (i = 0; i < tipoList.length; i++) {
			camposTipoP[i] = new JPanel();
			tipoList[i] = new JComboBox(tipoPal);
			tipoList[i].setPreferredSize(new Dimension(150, 30));
			// camposTipoP[i].setPreferredSize(new Dimension(100, 30));
			camposTipoP[i].add(tipoList[i]);

			panel2.add(camposTipoP[i]);
		}

		// Arreglo de Longitud de Valores
		JTextField camposLongVal[] = new JTextField[numero];
		JPanel camposLongValP[] = new JPanel[numero];
		for (i = 0; i < camposLongVal.length; i++) {
			camposLongValP[i] = new JPanel();
			camposLongVal[i] = new JTextField();
			camposLongVal[i].setPreferredSize(new Dimension(100, 30));

			camposLongValP[i].add(camposLongVal[i]);

			panel3.add(camposLongValP[i]);
		}

		/*
		 * String[] tiposSinLength = { "DATE", "TIME", "TIMESTAMP", "DATETIME", "YEAR",
		 * "TINYBLOB", "BLOB", "MEDIUMBLOB", "LONGBLOB", "TINYTEXT", "TEXT",
		 * "MEDIUMTEXT", "LONGTEXT", "ENUM", "SET" };
		 */
		// Action Listener para cada tipo de Dato
		for (i = 0; i < tipoList.length; i++) {
			tipoList[i].addItemListener(new ItemListener() {
				/**
				 *
				 */
				@Override
				public void itemStateChanged(ItemEvent e) {
					// Regresa el valor que se esta tomando con e.getStateChange() == 1
					if (e.getStateChange() == 1) {
						String seleccionadocampoSinTamaño = "";
						// Regresa el nombre del tipo de dato seleccionado
						// JOptionPane.showMessageDialog(null, e.getItem().toString());
						// Para habilitar o deshabiligat JtextField
						for (int j = 0; j < camposLongVal.length; j++) {
							// JOptionPane.showMessageDialog(null,
							// tipoList[j].getSelectedItem().toString());
							if (tipoList[j].getSelectedItem().toString() == "DATE"
									|| tipoList[j].getSelectedItem().toString() == "TIME"
									|| tipoList[j].getSelectedItem().toString() == "TIMESTAMP"
									|| tipoList[j].getSelectedItem().toString() == "DATETIME"
									|| tipoList[j].getSelectedItem().toString() == "YEAR"
									|| tipoList[j].getSelectedItem().toString() == "TINYBLOB"
									|| tipoList[j].getSelectedItem().toString() == "BLOB"
									|| tipoList[j].getSelectedItem().toString() == "MEDIUMBLOB"
									|| tipoList[j].getSelectedItem().toString() == "LONGBLOB"
									|| tipoList[j].getSelectedItem().toString() == "TINYTEXT"
									|| tipoList[j].getSelectedItem().toString() == "TEXT"
									|| tipoList[j].getSelectedItem().toString() == "MEDIUMTEXT"
									|| tipoList[j].getSelectedItem().toString() == "LONGTEXT"
									|| tipoList[j].getSelectedItem().toString() == "ENUM"// ESTE ES TENTATIVO
									|| tipoList[j].getSelectedItem().toString() == "SET") {// ESTE ES TENTATIVO
								camposLongVal[j].setEnabled(false);
							} else {
								camposLongVal[j].setEnabled(true);
							}

						}

					}
				}
			});
		}

		String[] tiposLengthDif = { "REAL", "DOUBLE", "FLOAT", "DECIMAL", "NUMERIC" };
		for (i = 0; i < camposLongVal.length; i++) {
			camposLongVal[i].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					for (int j = 0; j < camposLongVal.length; j++) {
						if ((tipoList[j].getSelectedItem().toString() == "REAL"
								|| tipoList[j].getSelectedItem().toString() == "DOUBLE"
								|| tipoList[j].getSelectedItem().toString() == "FLOAT")) {
							if (camposLongVal[j].getText().isEmpty()) {
							} else if (!camposLongVal[j].getText().contains(",")) {
								JOptionPane.showMessageDialog(null,
										"El formato de la Longitud debe de ser 3,7 en el campo: " + (j + 1));
							}
						}
					}
				}

				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		// Arreglo de Predeterminado
		JComboBox predetList[] = new JComboBox[numero];
		JPanel camposPredetP[] = new JPanel[numero];
		String[] predetPal = { "NINGUNO", "PERSONALIZADO", "CURRENT_TIMESTAMP" };
		for (i = 0; i < predetList.length; i++) {
			camposPredetP[i] = new JPanel();
			predetList[i] = new JComboBox(predetPal);

			predetList[i].setPreferredSize(new Dimension(150, 30));
			camposPredetP[i].add(predetList[i]);

			panel4.add(camposPredetP[i]);
		}

		for (i = 0; i < predetList.length; i++) {
			predetList[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ie) {
					if (ie.getStateChange() == 1 && ie.getItem().toString() == "PERSONALIZADO") {
						nombrePersonalizado = JOptionPane.showInputDialog("Nombre:");
						if (nombrePersonalizado.isEmpty()) {
							validarAI = 1;
							JOptionPane.showMessageDialog(null, "Ingresa un nombre al campo Predeterminado",
									"Nombre Invalido", JOptionPane.ERROR_MESSAGE);
							// validarAI = 0;
						}
					}
				}
			});
		}

		// Arreglo de atributos
		JComboBox atribuList[] = new JComboBox[numero];
		JPanel camposAtribuP[] = new JPanel[numero];
		String[] atribuPal = { "", "BINARY", "UNSIGNED", "UNSIGNED ZEROFILL", "on update CURRENT_TIMESTAMP" };
		for (i = 0; i < atribuList.length; i++) {
			camposAtribuP[i] = new JPanel();
			atribuList[i] = new JComboBox(atribuPal);

			atribuList[i].setPreferredSize(new Dimension(150, 30));
			camposAtribuP[i].add(atribuList[i]);
			panel5.add(camposAtribuP[i]);
		}

		// Arreglo de Nulo
		JCheckBox nuloChK[] = new JCheckBox[numero];
		JPanel camposNuloP[] = new JPanel[numero];
		for (i = 0; i < nuloChK.length; i++) {
			camposNuloP[i] = new JPanel();
			nuloChK[i] = new JCheckBox();

			nuloChK[i].setPreferredSize(new Dimension(20, 30));
			camposNuloP[i].add(nuloChK[i]);

			panel6.add(camposNuloP[i]);
		}

		// Arreglo de los Indices
		JComboBox indiceList[] = new JComboBox[numero];
		JPanel camposIndiceP[] = new JPanel[numero];
		String[] indicePal = { "---", "PRIMARY", "UNIQUE", "INDEX", "FULLTEXT", "SPATIAL" };
		for (i = 0; i < indiceList.length; i++) {
			camposIndiceP[i] = new JPanel();
			indiceList[i] = new JComboBox(indicePal);

			indiceList[i].setPreferredSize(new Dimension(150, 30));
			camposIndiceP[i].add(indiceList[i]);
			panel7.add(camposIndiceP[i]);
		}

		/*
		 * EN ESTA PARTE ESTA LA LOGICA DE LSA LLAVES CUANDO SE SELECCIONA MAS DE
		 * UNIQUE, ....
		 * 
		 * SE DEBE DE PREGUNTAR SI SE ANIDA OTRA LLAVE O DENTR DE LA MISMA
		 */
		for (i = 0; i < indiceList.length; i++) {
			// Crear itemListener para cada indiceList
			indiceList[i].addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent ie) {
					/*
					 * Con getStateChange()==1 se obtiene la opcion que se selecciona, ya no regresa
					 * los 2 valores el anterior y el que se toma.
					 */
					if (ie.getStateChange() == 1) {
						seleccionado = ie.getItem().toString();
						if (seleccionado == "PRIMARY") {
							/*
							 * static int contadorINDEX = 0; static int contadorFULLTEXT = 0; static int
							 * contadorSPATIAL = 0;
							 */
						} else if (seleccionado == "UNIQUE") {
							if (contadorUNIQUE == 0) {
								// Aumenta el cotador a 1 porque ya se escogio
								contadorUNIQUE++;

								String nombre = JOptionPane.showInputDialog("¿Cuál es el Nombre?");
								for (i = 0; i < indiceList.length; i++) {
									if (indiceList[i].getSelectedItem().toString() == "UNIQUE") {
										llavesUNIQUEarray.add(camposNombre[i].getText());
										if (nombre.isEmpty()) {
											hmUNIQUE.put("1", "UNIQUE " + "(" + "`" + camposNombre[i].getText() + "`");
										} else {
											hmUNIQUE.put("1", "UNIQUE " + "`" + nombre + "`" + "(" + "`"
													+ camposNombre[i].getText() + "`");
										}
										// TOMAR ID DEL PRIMER LLAVE NUIQUE NE ESTA CASE
										// JOptionPane.showMessageDialog(null, llavesUNIQUEarray);
									}

								}

							} else {
								JFrame frameUNIQUEanidados = new JFrame();
								JPanel panelUNIQUE = new JPanel();
								JLabel llave = new JLabel("UNIQUE", SwingConstants.CENTER);
								JRadioButton indice1column = new JRadioButton("Crear indice Solo", false);
								JRadioButton indiceCompuesto = new JRadioButton("Crear indice compuesto", false);

								// Añadiendo estilo a las palabras
								llave.setFont(new Font(null, Font.BOLD, 18));
								llave.setForeground(Color.black);
								indice1column.setFont(new Font(null, Font.BOLD, 16));
								indice1column.setForeground(Color.black);
								indiceCompuesto.setFont(new Font(null, Font.BOLD, 16));
								indiceCompuesto.setForeground(Color.black);

								// Border
								llave.setBorder(blackline);

								// GridBaLayout
								panelUNIQUE.setLayout(new GridBagLayout());
								GridBagConstraints c = new GridBagConstraints(); // Creacion de la variable para manejar
																					// los tamaños

								c.gridx = 0;
								c.gridy = 0;
								c.ipady = 30;
								panelUNIQUE.add(llave, c);
								c.gridx = 0;
								c.gridy = 1;
								c.anchor = GridBagConstraints.WEST;
								panelUNIQUE.add(indice1column, c);
								c.gridx = 0;
								c.gridy = 2;
								c.anchor = GridBagConstraints.WEST;
								panelUNIQUE.add(indiceCompuesto, c);

								JScrollPane scrollBar = new JScrollPane(panelUNIQUE,
										JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

								indice1column.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indiceCompuesto.setSelected(false);
										String nombre = JOptionPane.showInputDialog("¿Cuál es el nombre de la llave?");
										for (i = 0; i < indiceList.length; i++) {
											// En este condicional esta la parte de que si no esta dentro del
											// llavesUNIQUEarraylo agregue
											if (indiceList[i].getSelectedItem().toString() == "UNIQUE"
													&& llavesUNIQUEarray.contains(camposNombre[i].getText()) == false
													&& llavesUNIQUEarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesUNIQUEarray.add(camposNombre[i].getText());

												if (nombre.isEmpty()) {
													hmUNIQUE.put(Integer.toString(hmUNIQUEcontador),
															"UNIQUE " + "(" + "`" + camposNombre[i].getText() + "`");
												} else {
													hmUNIQUE.put(Integer.toString(hmUNIQUEcontador),
															"UNIQUE " + "`" + nombre + "`" + "(" + "`"
																	+ camposNombre[i].getText() + "`");
												}

												hmUNIQUEcontador++;
												// JOptionPane.showMessageDialog(null, llavesUNIQUEarray);
												frameUNIQUEanidados.setVisible(false);
												frameUNIQUEanidados.dispose();
											}
										}
										/*
										 * JOptionPane.showMessageDialog(null, hmUNIQUE);
										 * JOptionPane.showMessageDialog(null, "El contador de Map es: " +
										 * hmUNIQUEcontador);
										 */
									}
								});
								indiceCompuesto.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indice1column.setSelected(false);
										JRadioButton[] arregloLlaves = new JRadioButton[llavesUNIQUEarray.size()];
										// JOptionPane.showMessageDialog(null, hmUNIQUE);
										/*
										 * Arreglo de llaves Secundarias.
										 * 
										 * Para que no se agreguen a las llaves primarias que tiene una llave y
										 * viceversa.
										 */
										for (int i = 0; i < indiceList.length; i++) {
											if (indiceList[i].getSelectedItem().toString() == "UNIQUE"
													&& llavesUNIQUEarray.contains(camposNombre[i].getText()) == false
													&& llavesUNIQUEarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesUNIQUEarraySecundaria.add(camposNombre[i].getText());
											}
										}
										// JOptionPane.showMessageDialog(null, llavesUNIQUEarraySecundaria);

										String[] arrayUNIQUE = new String[llavesUNIQUEarray.size()];

										for (int i = 0; i < arregloLlaves.length; i++) {
											arregloLlaves[i] = new JRadioButton();

											arregloLlaves[i].addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													String nombre = e.getActionCommand();
													String idUNIQUE = e.getActionCommand();
													nombre = nombre.substring(3, nombre.length());
													idUNIQUE = idUNIQUE.substring(0, 1);
													/*
													 * JOptionPane.showMessageDialog(null, "El nombre tomado es: " +
													 * nombre); JOptionPane.showMessageDialog(null, "El id tomado es: "
													 * + idUNIQUE); JOptionPane.showMessageDialog(null, ie.getItem());
													 */

													// llaveUNIQUEcontadorSecundaria++; con este ir tomando el
													// siguiente valor como con el HashMap
													for (Map.Entry m : hmUNIQUE.entrySet()) {
														// m.getKey()-->OBTIENE LA LLAVE
														// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
														if (m.getKey().toString().contains(idUNIQUE)) {
															hmUNIQUE.replace(idUNIQUE,
																	m.getValue() + ", `"
																			+ llavesUNIQUEarraySecundaria
																					.get(llaveUNIQUEcontadorSecundaria)
																			+ "`");
															llaveUNIQUEcontadorSecundaria++;
														}
													}
													frameUNIQUEanidados.setVisible(false);
													frameUNIQUEanidados.dispose();
												}
											});

											// Agregando al JPanel de las llaves primarias de UNIQUE
											arregloLlaves[i].setText((i + 1) + ".-" + llavesUNIQUEarray.get(i));
											c.gridy = (i + 3);
											// arregloLlaves[i].setText("a");
											panelUNIQUE.add(arregloLlaves[i], c);
										}
										panelUNIQUE.updateUI();
									}
								});

								frameUNIQUEanidados.add(scrollBar);
								frameUNIQUEanidados.setBounds(400, 400, 400, 500);
								frameUNIQUEanidados.setVisible(true);
								frameUNIQUEanidados.setResizable(false);
							}
						} else if (seleccionado == "INDEX") {
							if (contadorINDEX == 0) {
								// Aumenta el cotador a 1 porque ya se escogio
								contadorINDEX++;

								String nombre = JOptionPane.showInputDialog("¿Cuál es el Nombre?");
								for (i = 0; i < indiceList.length; i++) {
									if (indiceList[i].getSelectedItem().toString() == "INDEX") {
										llavesINDEXarray.add(camposNombre[i].getText());
										if (nombre.isEmpty()) {
											hmINDEX.put("1", "INDEX " + "(" + "`" + camposNombre[i].getText() + "`");
										} else {
											hmINDEX.put("1", "INDEX " + "`" + nombre + "`" + "(" + "`"
													+ camposNombre[i].getText() + "`");
										}
									}

								}

							} else {

								JFrame frameINDEXanidados = new JFrame();
								JPanel panelINDEX = new JPanel();
								JLabel llave = new JLabel("INDEX", SwingConstants.CENTER);
								JRadioButton indice1column = new JRadioButton("Crear indice Solo", false);
								JRadioButton indiceCompuesto = new JRadioButton("Crear indice compuesto", false);

								// Añadiendo estilo a las palabras
								llave.setFont(new Font(null, Font.BOLD, 18));
								llave.setForeground(Color.black);
								indice1column.setFont(new Font(null, Font.BOLD, 16));
								indice1column.setForeground(Color.black);
								indiceCompuesto.setFont(new Font(null, Font.BOLD, 16));
								indiceCompuesto.setForeground(Color.black);

								// Border
								llave.setBorder(blackline);

								// GridBaLayout
								panelINDEX.setLayout(new GridBagLayout());
								GridBagConstraints c = new GridBagConstraints(); // Creacion de la variable para manejar
																					// los tamaños

								c.gridx = 0;
								c.gridy = 0;
								c.ipady = 30;
								panelINDEX.add(llave, c);
								c.gridx = 0;
								c.gridy = 1;
								c.anchor = GridBagConstraints.WEST;
								panelINDEX.add(indice1column, c);
								c.gridx = 0;
								c.gridy = 2;
								c.anchor = GridBagConstraints.WEST;
								panelINDEX.add(indiceCompuesto, c);

								JScrollPane scrollBar = new JScrollPane(panelINDEX,
										JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

								indice1column.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indiceCompuesto.setSelected(false);
										String nombre = JOptionPane.showInputDialog("¿Cuál es el nombre de la llave?");
										for (i = 0; i < indiceList.length; i++) {
											// En este condicional esta la parte de que si no esta dentro del
											// llavesINDEXarraylo agregue
											if (indiceList[i].getSelectedItem().toString() == "INDEX"
													&& llavesINDEXarray.contains(camposNombre[i].getText()) == false
													&& llavesINDEXarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesINDEXarray.add(camposNombre[i].getText());

												if (nombre.isEmpty()) {
													hmINDEX.put(Integer.toString(hmINDEXcontador),
															"INDEX " + "(" + "`" + camposNombre[i].getText() + "`");
												} else {
													hmINDEX.put(Integer.toString(hmINDEXcontador),
															"INDEX " + "`" + nombre + "`" + "(" + "`"
																	+ camposNombre[i].getText() + "`");
												}

												hmINDEXcontador++;
												// JOptionPane.showMessageDialog(null, llavesINDEXarray);
												frameINDEXanidados.setVisible(false);
												frameINDEXanidados.dispose();
											}
										}
									}
								});
								indiceCompuesto.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indice1column.setSelected(false);
										JRadioButton[] arregloLlaves = new JRadioButton[llavesINDEXarray.size()];

										for (int i = 0; i < indiceList.length; i++) {
											if (indiceList[i].getSelectedItem().toString() == "INDEX"
													&& llavesINDEXarray.contains(camposNombre[i].getText()) == false
													&& llavesINDEXarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesINDEXarraySecundaria.add(camposNombre[i].getText());
											}
										}

										for (int i = 0; i < arregloLlaves.length; i++) {
											arregloLlaves[i] = new JRadioButton();

											arregloLlaves[i].addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													String nombre = e.getActionCommand();
													String idINDEX = e.getActionCommand();
													nombre = nombre.substring(3, nombre.length());
													idINDEX = idINDEX.substring(0, 1);

													// llaveUNIQUEcontadorSecundaria++; con este ir tomando el
													// siguiente valor como con el HashMap
													for (Map.Entry m : hmINDEX.entrySet()) {
														// m.getKey()-->OBTIENE LA LLAVE
														// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
														if (m.getKey().toString().contains(idINDEX)) {
															hmINDEX.replace(idINDEX,
																	m.getValue() + ", `"
																			+ llavesINDEXarraySecundaria
																					.get(llaveINDEXcontadorSecundaria)
																			+ "`");
															llaveINDEXcontadorSecundaria++;
														}
													}
													frameINDEXanidados.setVisible(false);
													frameINDEXanidados.dispose();
												}
											});

											// Agregando al JPanel de las llaves primarias de UNIQUE
											arregloLlaves[i].setText((i + 1) + ".-" + llavesINDEXarray.get(i));
											c.gridy = (i + 3);
											panelINDEX.add(arregloLlaves[i], c);
										}
										panelINDEX.updateUI();
									}
								});

								frameINDEXanidados.add(scrollBar);
								frameINDEXanidados.setBounds(400, 400, 400, 500);
								frameINDEXanidados.setVisible(true);
								frameINDEXanidados.setResizable(false);
							}
						} else if (seleccionado == "FULLTEXT") {
							if (contadorFULLTEXT == 0) {
								// Aumenta el cotador a 1 porque ya se escogio
								contadorFULLTEXT++;

								String nombre = JOptionPane.showInputDialog("¿Cuál es el Nombre?");
								for (i = 0; i < indiceList.length; i++) {
									if (indiceList[i].getSelectedItem().toString() == "FULLTEXT") {
										llavesFULLTEXTarray.add(camposNombre[i].getText());
										if (nombre.isEmpty()) {
											hmFULLTEXT.put("1",
													"FULLTEXT " + "(" + "`" + camposNombre[i].getText() + "`");
										} else {
											hmFULLTEXT.put("1", "FULLTEXT " + "`" + nombre + "`" + "(" + "`"
													+ camposNombre[i].getText() + "`");
										}
									}
								}
							} else {
								JFrame frameFULLTEXTanidados = new JFrame();
								JPanel panelFULLTEXT = new JPanel();
								JLabel llave = new JLabel("FULLTEXT", SwingConstants.CENTER);
								JRadioButton indice1column = new JRadioButton("Crear indice Solo", false);
								JRadioButton indiceCompuesto = new JRadioButton("Crear indice compuesto", false);

								// Añadiendo estilo a las palabras
								llave.setFont(new Font(null, Font.BOLD, 18));
								llave.setForeground(Color.black);
								indice1column.setFont(new Font(null, Font.BOLD, 16));
								indice1column.setForeground(Color.black);
								indiceCompuesto.setFont(new Font(null, Font.BOLD, 16));
								indiceCompuesto.setForeground(Color.black);

								// Border
								llave.setBorder(blackline);

								// GridBaLayout
								panelFULLTEXT.setLayout(new GridBagLayout());
								GridBagConstraints c = new GridBagConstraints(); // Creacion de la variable para manejar
																					// los tamaños

								c.gridx = 0;
								c.gridy = 0;
								c.ipady = 30;
								panelFULLTEXT.add(llave, c);
								c.gridx = 0;
								c.gridy = 1;
								c.anchor = GridBagConstraints.WEST;
								panelFULLTEXT.add(indice1column, c);
								c.gridx = 0;
								c.gridy = 2;
								c.anchor = GridBagConstraints.WEST;
								panelFULLTEXT.add(indiceCompuesto, c);

								JScrollPane scrollBar = new JScrollPane(panelFULLTEXT,
										JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

								indice1column.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indiceCompuesto.setSelected(false);
										String nombre = JOptionPane.showInputDialog("¿Cuál es el nombre de la llave?");
										for (i = 0; i < indiceList.length; i++) {
											// En este condicional esta la parte de que si no esta dentro del
											// llavesFULLTEXTarraylo agregue
											if (indiceList[i].getSelectedItem().toString() == "FULLTEXT"
													&& llavesFULLTEXTarray.contains(camposNombre[i].getText()) == false
													&& llavesFULLTEXTarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesFULLTEXTarray.add(camposNombre[i].getText());

												if (nombre.isEmpty()) {
													hmFULLTEXT.put(Integer.toString(hmFULLTEXTcontador),
															"FULLTEXT " + "(" + "`" + camposNombre[i].getText() + "`");
												} else {
													hmFULLTEXT.put(Integer.toString(hmFULLTEXTcontador),
															"FULLTEXT " + "`" + nombre + "`" + "(" + "`"
																	+ camposNombre[i].getText() + "`");
												}

												hmFULLTEXTcontador++;
												// JOptionPane.showMessageDialog(null, llavesFULLTEXTarray);
												frameFULLTEXTanidados.setVisible(false);
												frameFULLTEXTanidados.dispose();
											}
										}
									}
								});
								indiceCompuesto.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indice1column.setSelected(false);
										JRadioButton[] arregloLlaves = new JRadioButton[llavesFULLTEXTarray.size()];

										for (int i = 0; i < indiceList.length; i++) {
											if (indiceList[i].getSelectedItem().toString() == "FULLTEXT"
													&& llavesFULLTEXTarray.contains(camposNombre[i].getText()) == false
													&& llavesFULLTEXTarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesFULLTEXTarraySecundaria.add(camposNombre[i].getText());
											}
										}

										for (int i = 0; i < arregloLlaves.length; i++) {
											arregloLlaves[i] = new JRadioButton();

											arregloLlaves[i].addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													String nombre = e.getActionCommand();
													String idFULLTEXT = e.getActionCommand();
													nombre = nombre.substring(3, nombre.length());
													idFULLTEXT = idFULLTEXT.substring(0, 1);

													// llaveFULLTEXTcontadorSecundaria++; con este ir tomando el
													// siguiente valor como con el HashMap
													for (Map.Entry m : hmFULLTEXT.entrySet()) {
														// m.getKey()-->OBTIENE LA LLAVE
														// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
														if (m.getKey().toString().contains(idFULLTEXT)) {
															hmFULLTEXT.replace(idFULLTEXT,
																	m.getValue() + ", `"
																			+ llavesFULLTEXTarraySecundaria.get(
																					llaveFULLTEXTcontadorSecundaria)
																			+ "`");
															llaveFULLTEXTcontadorSecundaria++;
														}
													}
													frameFULLTEXTanidados.setVisible(false);
													frameFULLTEXTanidados.dispose();
												}
											});

											// Agregando al JPanel de las llaves primarias de FULLTEXT
											arregloLlaves[i].setText((i + 1) + ".-" + llavesFULLTEXTarray.get(i));
											c.gridy = (i + 3);
											panelFULLTEXT.add(arregloLlaves[i], c);
										}
										panelFULLTEXT.updateUI();
									}
								});

								frameFULLTEXTanidados.add(scrollBar);
								frameFULLTEXTanidados.setBounds(400, 400, 400, 500);
								frameFULLTEXTanidados.setVisible(true);
								frameFULLTEXTanidados.setResizable(false);
							}
						} else if (seleccionado == "SPATIAL") {
							if (contadorSPATIAL == 0) {
								// Aumenta el cotador a 1 porque ya se escogio
								contadorSPATIAL++;

								String nombre = JOptionPane.showInputDialog("¿Cuál es el Nombre?");
								for (i = 0; i < indiceList.length; i++) {
									if (indiceList[i].getSelectedItem().toString() == "SPATIAL") {
										llavesSPATIALarray.add(camposNombre[i].getText());
										if (nombre.isEmpty()) {
											hmSPATIAL.put("1",
													"SPATIAL " + "(" + "`" + camposNombre[i].getText() + "`");
										} else {
											hmSPATIAL.put("1", "SPATIAL " + "`" + nombre + "`" + "(" + "`"
													+ camposNombre[i].getText() + "`");
										}
									}
								}
							} else {
								JFrame frameSPATIALanidados = new JFrame();
								JPanel panelSPATIAL = new JPanel();
								JLabel llave = new JLabel("SPATIAL", SwingConstants.CENTER);
								JRadioButton indice1column = new JRadioButton("Crear indice Solo", false);
								JRadioButton indiceCompuesto = new JRadioButton("Crear indice compuesto", false);

								// Añadiendo estilo a las palabras
								llave.setFont(new Font(null, Font.BOLD, 18));
								llave.setForeground(Color.black);
								indice1column.setFont(new Font(null, Font.BOLD, 16));
								indice1column.setForeground(Color.black);
								indiceCompuesto.setFont(new Font(null, Font.BOLD, 16));
								indiceCompuesto.setForeground(Color.black);

								// Border
								llave.setBorder(blackline);

								// GridBaLayout
								panelSPATIAL.setLayout(new GridBagLayout());
								GridBagConstraints c = new GridBagConstraints(); // Creacion de la variable para manejar
																					// los tamaños

								c.gridx = 0;
								c.gridy = 0;
								c.ipady = 30;
								panelSPATIAL.add(llave, c);
								c.gridx = 0;
								c.gridy = 1;
								c.anchor = GridBagConstraints.WEST;
								panelSPATIAL.add(indice1column, c);
								c.gridx = 0;
								c.gridy = 2;
								c.anchor = GridBagConstraints.WEST;
								panelSPATIAL.add(indiceCompuesto, c);

								JScrollPane scrollBar = new JScrollPane(panelSPATIAL,
										JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

								indice1column.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indiceCompuesto.setSelected(false);
										String nombre = JOptionPane.showInputDialog("¿Cuál es el nombre de la llave?");
										for (i = 0; i < indiceList.length; i++) {
											// En este condicional esta la parte de que si no esta dentro del
											// llavesSPATIALarray lo agregue
											if (indiceList[i].getSelectedItem().toString() == "SPATIAL"
													&& llavesSPATIALarray.contains(camposNombre[i].getText()) == false
													&& llavesSPATIALarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesSPATIALarray.add(camposNombre[i].getText());

												if (nombre.isEmpty()) {
													hmSPATIAL.put(Integer.toString(hmSPATIALcontador),
															"SPATIAL " + "(" + "`" + camposNombre[i].getText() + "`");
												} else {
													hmSPATIAL.put(Integer.toString(hmSPATIALcontador),
															"SPATIAL " + "`" + nombre + "`" + "(" + "`"
																	+ camposNombre[i].getText() + "`");
												}

												hmSPATIALcontador++;
												// JOptionPane.showMessageDialog(null, llavesSPATIALarray);
												frameSPATIALanidados.setVisible(false);
												frameSPATIALanidados.dispose();
											}
										}
									}
								});
								indiceCompuesto.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										indice1column.setSelected(false);
										JRadioButton[] arregloLlaves = new JRadioButton[llavesSPATIALarray.size()];

										for (int i = 0; i < indiceList.length; i++) {
											if (indiceList[i].getSelectedItem().toString() == "SPATIAL"
													&& llavesSPATIALarray.contains(camposNombre[i].getText()) == false
													&& llavesSPATIALarraySecundaria
															.contains(camposNombre[i].getText()) == false) {
												llavesSPATIALarraySecundaria.add(camposNombre[i].getText());
											}
										}

										for (int i = 0; i < arregloLlaves.length; i++) {
											arregloLlaves[i] = new JRadioButton();

											arregloLlaves[i].addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													String nombre = e.getActionCommand();
													String idSPATIAL = e.getActionCommand();
													nombre = nombre.substring(3, nombre.length());
													idSPATIAL = idSPATIAL.substring(0, 1);

													// llaveSPATIALcontadorSecundaria++; con este ir tomando el
													// siguiente valor como con el HashMap
													for (Map.Entry m : hmSPATIAL.entrySet()) {
														// m.getKey()-->OBTIENE LA LLAVE
														// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
														if (m.getKey().toString().contains(idSPATIAL)) {
															hmSPATIAL.replace(idSPATIAL,
																	m.getValue() + ", `"
																			+ llavesSPATIALarraySecundaria
																					.get(llaveSPATIALcontadorSecundaria)
																			+ "`");
															llaveSPATIALcontadorSecundaria++;
														}
													}
													frameSPATIALanidados.setVisible(false);
													frameSPATIALanidados.dispose();
												}
											});

											// Agregando al JPanel de las llaves primarias de SPATIAL
											arregloLlaves[i].setText((i + 1) + ".-" + llavesSPATIALarray.get(i));
											c.gridy = (i + 3);
											panelSPATIAL.add(arregloLlaves[i], c);
										}
										panelSPATIAL.updateUI();
									}
								});

								frameSPATIALanidados.add(scrollBar);
								frameSPATIALanidados.setBounds(400, 400, 400, 500);
								frameSPATIALanidados.setVisible(true);
								frameSPATIALanidados.setResizable(false);
							}
						} else if (seleccionado == "---") {
							/*
							 * llaveunique = ""; llaveindex = ""; llavefulltext = ""; llavespatial = "";
							 * 
							 * contadorUNIQUE = 0; contadorINDEX = 0; contadorFULLTEXT = 0; contadorSPATIAL
							 * = 0;
							 */
						}
					}
				}
			});
		}

		// Arreglo de A_I
		JCheckBox aiChK[] = new JCheckBox[numero];
		JPanel camposAiP[] = new JPanel[numero];
		for (i = 0; i < aiChK.length; i++) {
			camposAiP[i] = new JPanel();
			aiChK[i] = new JCheckBox();

			aiChK[i].setPreferredSize(new Dimension(20, 30));
			camposAiP[i].add(aiChK[i]);
			panel8.add(camposAiP[i]);
		}

		// Arreglo de los comentarios
		JTextField camposcommen[] = new JTextField[numero];
		JPanel camposCommenP[] = new JPanel[numero];
		for (i = 0; i < camposLongVal.length; i++) {
			camposCommenP[i] = new JPanel();
			camposcommen[i] = new JTextField();
			camposcommen[i].setPreferredSize(new Dimension(200, 30));

			camposCommenP[i].add(camposcommen[i]);

			panel9.add(camposCommenP[i]);
		}

		String[] reserva = { "ADD", "ALL", "ALTER", "ANALYZE", "AND", "AS", "ASC", "ASENSITIVE", "BEFORE", "BETWEEN",
				"BIGINT", "BINARY", "BLOB", "BOTH", "BY", "CALL", "CASCADE", "CASE", "CHANGE", "CHAR", "CHARACTER",
				"CHECK", "COLLATE", "COLUMN", "CONDITION", "CONNECTION", "CONSTRAINT", "CONTINUE", "CONVERT", "CREATE",
				"CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR", "DATABASE",
				"DATABASES", "DAY_HOUR", "DAY_MICROSECOND", "DAY_MINUTE", "DAY_SECOND", "DEC", "DECIMAL", "DECLARE",
				"DEFAULT", "DELAYED", "DELETE", "DESC", "DESCRIBE", "DETERMINISTIC", "DISTINCT", "DISTINCTROW", "DIV",
				"DOUBLE", "DROP", "DUAL", "EACH", "ELSE", "ELSEIF", "ENCLOSED", "ESCAPED", "EXISTS", "EXIT", "EXPLAIN",
				"FALSE", "FETCH", "FLOAT", "FOR", "FORCE", "FOREIGN", "FROM", "FULLTEXT", "GOTO", "GRANT", "GROUP",
				"HAVING", "HIGH_PRIORITY", "HOUR_MICROSECOND", "HOUR_MINUTE", "HOUR_SECOND", "IF", "IGNORE", "IN",
				"INDEX", "INFILE", "INNER", "INOUT", "INSENSITIVE", "INSERT", "INT", "INTEGER", "INTERVAL", "INTO",
				"IS", "ITERATE", "JOIN", "KEY", "KEYS", "KILL", "LEADING", "LEAVE", "LEFT", "LIKE", "LIMIT", "LINES",
				"LOAD", "LOCALTIME", "LOCALTIMESTAMP", "LOCK", "LONG", "LONGBLOB", "LONGTEXT", "LOOP", "LOW_PRIORITY",
				"MATCH", "MEDIUMBLOB", "MEDIUMINT", "MEDIUMTEXT", "MIDDLEINT", "MINUTE_MICROSECOND", "MINUTE_SECOND",
				"MOD", "MODIFIES", "NATURAL", "NOT", "NO_WRITE_TO_BINLOG", "NULL", "NUMERIC", "ON", "OPTIMIZE",
				"OPTION", "OPTIONALLY", "OR", "ORDER", "OUT", "OUTER", "OUTFILE", "PRECISION", "PRIMARY", "PROCEDURE",
				"PURGE", "READ", "READS", "REAL", "REFERENCES", "REGEXP", "RENAME", "REPEAT", "REPLACE", "REQUIRE",
				"RESTRICT", "RETURN", "REVOKE", "RIGHT", "RLIKE", "SCHEMA", "SCHEMAS", "SECOND_MICROSECOND", "SELECT",
				"SENSITIVE", "SEPARATOR", "SET", "SHOW", "SMALLINT", "SONAME", "SPATIA", "SPECIFIC", "SQL",
				"SQLEXCEPTION", "SQLSTATE", "SQLWARNING", "SQL_BIG_RESULT", "SQL_CALC_FOUND_ROWS", "SQL_SMALL_RESULT",
				"SSL", "STARTING,STRAIGHT_JOIN", "TABLE", "TERMINATED", "THEN", "TINYBLOB", "TINYINT", "TINYTEXT", "TO",
				"TRAILING", "TRIGGER", "TRUE", "UNDO", "UNION", "UNIQUE", "UNLOCK", "UNSIGNED", "UPDATE", "USAGE",
				"USE", "USING", "UTC_DATE", "UTC_TIME", "UTC_TIMESTAMP", "VALUES", "VARBINARY", "VARCHAR",
				"VARCHARACTER", "VARYING", "WHEN", "WHERE", "WHILE", "WITH", "WRITE", "XOR", "YEAR_MONTH", "ZEROFILL" };

		String[] inicioCampoNombre = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "_", "-", "'", "¿", "!", "#",
				"$", "%", "&", "/", "(", ")", "=", "°", "|", "¬", ";", ":", ".", ",", "[", "]", "{", "}", "´", "+", "*",
				"?" };

		// Boton de crear Tabla y obtener informacion de los campos
		crearBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] nombre = new String[numero];
				String[] tipo = new String[numero];
				String[] longVal = new String[numero];
				String[] predet = new String[numero];
				String[] atribu = new String[numero];
				String[] nulo = new String[numero];
				String[] indicePRIMARY = new String[numero];
				String[] indiceUNIQUE = new String[numero];
				String[] indiceINDEX = new String[numero];
				String[] indiceFULLTEXT = new String[numero];
				String[] indiceSPATIAL = new String[numero];
				String[] a_i = new String[numero];
				String[] commen = new String[numero];

				// Validacion del nombre de la tabla no este vacio
				if (nombreF.getText().length() == 0) {
					validarAI = 1;
					JOptionPane.showMessageDialog(null, "Ingresa un nombre a la tabla ", "Nombre Tabla",
							JOptionPane.ERROR_MESSAGE);
				}

				// Recibir String de Nombre
				/*
				 * YA QUEDO ESTA PARTE AGREGADA CON EXITO Y CON LOS DIFERETES CASOS
				 */
				for (int i = 0; i < camposNombre.length; i++) {
					// nombre[i] = camposNombre[i].getText().toString();
					for (int m = 0; m < reserva.length; m++) {
						if (reserva[m].equals(camposNombre[i].getText().toUpperCase())) {
							validarAI = 1;
							JOptionPane.showMessageDialog(null, "Ingresa un nombre valido en el campo " + (i + 1),
									"Nombre Invalido", JOptionPane.WARNING_MESSAGE);
						} else {
							// nombre[i] = camposNombre[i].getText().toString();
						}
					}
					if (camposNombre[i].getText().equals("")) {
						validarAI = 1;
						JOptionPane.showMessageDialog(null, "Ingresa un nombre en el campo " + (i + 1),
								"Nombre Invalido", JOptionPane.WARNING_MESSAGE);
					}
					try {
						for (int m = 0; m < inicioCampoNombre.length; m++) {
							if (inicioCampoNombre[m].equals(camposNombre[i].getText(0, 1))) {
								validarAI = 1;
								JOptionPane.showMessageDialog(null,
										"No se puede iniciar nombre del campo con numero o caracter invalido en el campo "
												+ (i + 1),
										"Nombre Invalido", JOptionPane.WARNING_MESSAGE);
							} else {
								nombre[i] = "`" + camposNombre[i].getText().toString() + "`";
							}
						}
					} catch (BadLocationException e1) {
					}

				}

				// Recibir String de tipo
				/*
				 * YA QUEDO ESTA PARTE AGREGADA CON EXITO Y CON LOS DIFERETES CASOS
				 */
				for (int i = 0; i < tipoList.length; i++) {
					tipo[i] = tipoList[i].getSelectedItem().toString();
				}

				// REcibir String de Longitud de Valor
				/*
				 * Aqui hay una excepcion si no agregan ningun valor, el numero por defecto es
				 * 11 hay que meter esa condicion en el textfield
				 * 
				 * YA QUEDO ESTA PARTE AGREGADA CON EXITO Y CON LOS DIFERETES CASOS
				 */
				for (int i = 0; i < camposLongVal.length; i++) {

					if (camposLongVal[i].isEnabled() == false) {
						// JOptionPane.showMessageDialog(null, "Esta deshabilitado");
						longVal[i] = "";
					} else {
						if (camposLongVal[i].getText().isEmpty() == true) {
							longVal[i] = "(11)";
						} else {
							longVal[i] = "(" + camposLongVal[i].getText().toString() + ")";
						}
					}

				}

				// Recibir Strin g predeterminado
				for (int i = 0; i < predetList.length; i++) {
					if (predetList[i].getSelectedItem().toString() == "NINGUNO") {
						predet[i] = "";
					} else if (predetList[i].getSelectedItem().toString() == "PERSONALIZADO") {
						// Aqui traer el nombre del personalizado al activar esta opcion
						predet[i] = " DEFAULT `" + nombrePersonalizado + "`";
					} else if (predetList[i].getSelectedItem().toString() == "CURRENT_TIMESTAMP") {
						/*
						 * METER EN ESTA PARTE LA LOGCA QUE SOLO ES POSIBLE SELECCIONAR ESTE SI EL TIPO
						 * DE DATOS ES TIMESTAMP O DATE
						 */
						if (tipoList[i].getSelectedItem().toString() == "DATETIME") {
							predet[i] = " DEFAULT " + predetList[i].getSelectedItem().toString();
						} else if (tipoList[i].getSelectedItem().toString() == "TIMESTAMP") {
							predet[i] = " DEFAULT " + predetList[i].getSelectedItem().toString();
						} else {
							validarAI = 1;
							JOptionPane.showMessageDialog(null,
									"Solo es valido para DATETIME y TIMESTAMP verifica el campo: " + (i + 1),
									"Nombre Invalido", JOptionPane.WARNING_MESSAGE);
						}

						// predet[i] = " DEFAULT " + predetList[i].getSelectedItem().toString();
					}
				}

				// Recibir String de atributos
				/*
				 * Meter las condiconales que si es atributo vacio no lo agrega a la consulta en
				 * caso contrario si se agrega.
				 * 
				 * YA QUEDO ESTA PARTE AGREGADA CON EXITO Y CON LOS DIFERETES CASOS
				 */
				for (i = 0; i < atribuList.length; i++) {
					// if (atribuList[i].getSelectedItem() != "") {
					// atribu += (atribuList[i].getSelectedItem() + "\n");
					// }
					atribu[i] = atribuList[i].getSelectedItem().toString();
				}

				// Recibir String de Nulo
				/*
				 * YA QUEDO ESTA PARTE AGREGADA CON EXITO Y CON LOS DIFERETES CASOS
				 */
				for (int i = 0; i < nuloChK.length; i++) {
					// nulo += nuloChK[i].isSelected() + "\n";
					// nulo[i] = nuloChK[i].isSelected();
					if (nuloChK[i].isSelected() == true) {
						nulo[i] = "NULL";
					} else {
						nulo[i] = "NOT NULL";
					}
				}

				// Recibir String de indice
				for (i = 0; i < indiceList.length; i++) {
					if (indiceList[i].getSelectedItem().toString() == "PRIMARY") {
						indicePRIMARY[i] = camposNombre[i].getText().toString() + " ";
					}
				}

				// Recibir String de Auto Incrementable
				// aiChK CHECKBOX
				int aiveces = 0;
				for (i = 0; i < aiChK.length; i++) {
					if (aiChK[i].isSelected() == true && indiceList[i].getSelectedItem().toString() == "---") {
						JOptionPane.showMessageDialog(null, "Elige una Llave", "Pruebas",
								JOptionPane.INFORMATION_MESSAGE);
						aiChK[i].setSelected(false);
						validarAI = 1;
					} else if (aiChK[i].isSelected() == true && indiceList[i].getSelectedItem().toString() != "---") {
						aiveces++;
						if (aiveces > 1) {
							validarAI = 1;
							JOptionPane.showMessageDialog(null, "Solo puede seleccionar un Auto-Incrementable");
						} else {
							a_i[i] = "AUTO_INCREMENT";
							validarAI = 2;
						}
					} else if (aiChK[i].isSelected() == false) {
						a_i[i] = "";
					}
				}

				// Recibir String de los comentarios del JtextArea
				for (i = 0; i < camposcommen.length; i++) {
					if (!camposcommen[i].getText().toString().isEmpty()) {
						commen[i] = " COMMENT '" + camposcommen[i].getText().toString() + "'";
					} else {
						commen[i] = "";
					}
				}

				// Agregando todo los campos en un solo arreglo de String para despues mandarlos
				// a la consulta
				for (i = 0; i < nombre.length; i++) {
					/*
					 * nombre es el equivalente que va a dentro de la creacion de la tabla CREATE
					 * TABLE nombretabla(nombre id(11),apellido varchar(30) );
					 */
					nombre[i] += " " + tipo[i] + " " + longVal[i] + " " + atribu[i] + " " + nulo[i] + " " + predet[i]
							+ " " + a_i[i] + " " + commen[i];
				}

				// Pasando el arreglo de String de llave primaria a String sencillo
				String indicePRIMARYstr = "";
				for (int i = 0; i < indicePRIMARY.length; i++) {

					if (indicePRIMARY[i] != null) {
						indicePRIMARYstr += indicePRIMARY[i] + ",";
					}

				}

				/*
				 * VALIDACION DEL AUTOINCREMENTABLE SI SE SELECCIONA SIN ESCOGER LLAVE NO VA A
				 * ENVIAR NADA, PERO SI ESTE ESCOGE LLAVE PERMITE ENVIAR LOS DATOS O SI NO SE
				 * SELECCIONA EL AUTO INCREMENTABLE TAMBIEN PERMITE ENVIAR LA CONSULTA
				 */
				if (validarAI == 2 || validarAI == 0) {// ALGO QUE SIEMPRE ES VALIDO TOMA LA CONSULTA
					// Cerrando LLAVE UNIQUE
					/*
					 * for (Map.Entry m : hmUNIQUE.entrySet()) { // m.getKey()-->OBTIENE LA LLAVE //
					 * m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE hmUNIQUE.replace((String)
					 * m.getKey(), m.getValue() + ")"); } // Cerrando LLAVE INDEX for (Map.Entry m :
					 * hmINDEX.entrySet()) { // m.getKey()-->OBTIENE LA LLAVE //
					 * m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE hmINDEX.replace((String)
					 * m.getKey(), m.getValue() + ")"); } // Cerrando LLAVE FULLTEXT for (Map.Entry
					 * m : hmFULLTEXT.entrySet()) { // m.getKey()-->OBTIENE LA LLAVE //
					 * m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE hmFULLTEXT.replace((String)
					 * m.getKey(), m.getValue() + ")"); } // Cerrando LLAVE SPATIAL for (Map.Entry m
					 * : hmSPATIAL.entrySet()) { // m.getKey()-->OBTIENE LA LLAVE //
					 * m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE hmSPATIAL.replace((String)
					 * m.getKey(), m.getValue() + ")"); }
					 */
					// JOptionPane.showMessageDialog(null, "Al enviar la tabla crear UNIQUE: " +
					// hmUNIQUE);
					// JOptionPane.showMessageDialog(null, "Al enviar la tabla crear INDEX: " +
					// hmINDEX);
					// JOptionPane.showMessageDialog(null, "Al enviar la tabla crear FULLTEXT: " +
					// hmFULLTEXT);
					// JOptionPane.showMessageDialog(null, "Al enviar la tabla crear SPATIAL: " +
					// hmSPATIAL);

					// Eliminando la ultima coma del String de las llaves PRIMARY
					if (indicePRIMARYstr.length() == 0) {

					} else {
						// Aqui se concatena las llaves primarias
						indicePRIMARYstr = "PRIMARY KEY( "
								+ indicePRIMARYstr.substring(0, indicePRIMARYstr.length() - 1) + "), ";
					}
					// Obteniendo la LLAVE UNIQUE del HashMap hmUNIQUE
					for (Map.Entry m : hmUNIQUE.entrySet()) {
						// m.getKey()-->OBTIENE LA LLAVE
						// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
						llaveunique += m.getValue() + "), ";
					}
					// Obteniendo la LLAVE UNIQUE del HashMap hmINDEX
					for (Map.Entry m : hmINDEX.entrySet()) {
						// m.getKey()-->OBTIENE LA LLAVE
						// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
						llaveindex += m.getValue() + "), ";
					}
					// Obteniendo la LLAVE UNIQUE del HashMap hmFULLTEXT
					for (Map.Entry m : hmFULLTEXT.entrySet()) {
						// m.getKey()-->OBTIENE LA LLAVE
						// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
						llavefulltext += m.getValue() + "), ";
					}
					// Obteniendo la LLAVE UNIQUE del HashMap hmSPATIAL
					for (Map.Entry m : hmSPATIAL.entrySet()) {
						// m.getKey()-->OBTIENE LA LLAVE
						// m.getValue-->OBTIENE EL CONTENIDO DE LA LLAVE
						llavespatial += m.getValue() + "), ";
					}

					// Query para la creacion de la Tabla general
					/*
					 * En este String hay que concatenar todos los campos de la tabla que se va a
					 * crear
					 */
					String query = "CREATE TABLE `" + nombreF.getText() + "`" + " (";
					// CAMPOS, LLAVES+ ")" + " ENGINE = InnoDB"
					String camposSTR = "";
					for (i = 0; i < nombre.length; i++) {
						camposSTR += nombre[i] + ", ";
					}
					String llaves = indicePRIMARYstr + llaveunique + llaveindex + llavefulltext + llavespatial;
					camposSTR += llaves;
					camposSTR = camposSTR.substring(0, camposSTR.length() - 2);// ELIMINANDO ULTIMA COMA ALWAYS
					if (!commTableF.getText().toString().isEmpty()) {
						query += camposSTR + ")" + " ENGINE = InnoDB" + " COMMENT = '" + commTableF.getText() + "';";
					} else {
						query += camposSTR + ")" + " ENGINE = InnoDB;";
					}
					JOptionPane.showMessageDialog(null, query, "Pruebas  def", JOptionPane.INFORMATION_MESSAGE);
				} else if (validarAI == 1) {// ALGO INVALIDO NO REALIZA NINGUNA ACCION HASTA DEMOSTRAR LO CONTRARIO
					validarAI = 0;
				}
			}
		});

		reiniciarBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearTableGUI.setVisible(false);
				crearTableGUI.dispose();
				numeroCampos();

				// LLAVE UNIQUE
				llavesUNIQUEarray.clear();
				llavesUNIQUEarraySecundaria.clear();
				hmUNIQUE.clear();
				hmUNIQUEcontador = 2;
				llaveUNIQUEcontadorSecundaria = 0;
				// LLAVE INDEX
				llavesINDEXarray.clear();
				llavesINDEXarraySecundaria.clear();
				hmINDEX.clear();
				hmINDEXcontador = 2;
				llaveINDEXcontadorSecundaria = 0;
				// LLAVE FULLTEXT
				llavesFULLTEXTarray.clear();
				llavesFULLTEXTarraySecundaria.clear();
				hmFULLTEXT.clear();
				hmFULLTEXTcontador = 2;
				llaveFULLTEXTcontadorSecundaria = 0;
				// LLAVE SPATIAL
				llavesSPATIALarray.clear();
				llavesSPATIALarraySecundaria.clear();
				hmSPATIAL.clear();
				hmSPATIALcontador = 2;
				llaveSPATIALcontadorSecundaria = 0;

				llaveunique = "";
				llaveindex = "";
				llavefulltext = "";
				llavespatial = "";

				contadorUNIQUE = 0;
				contadorINDEX = 0;
				contadorFULLTEXT = 0;
				contadorSPATIAL = 0;
				validarAI = 0;

			}
		});

		// Agregando componentes al JFrame
		crearTableGUI.add(nombre);
		crearTableGUI.add(commTable);
		crearTableGUI.add(nombreF);
		crearTableGUI.add(commTableF);
		crearTableGUI.add(crearBTN);
		crearTableGUI.add(atrasBTN);
		crearTableGUI.add(reiniciarBTN);
		crearTableGUI.add(scrollErrorTA);

		// crearTableGUI.add(panelS);
		crearTableGUI.add(scrollBar);

		// 1800, 1000 RESOLUCION MAXIMA
		// 1350, 700 RESOLUCION BAJA
		crearTableGUI.setSize(1350, 700);
		crearTableGUI.setVisible(true);
		// PARA HABILITAR MODIFICAR TAMAÑO DE LA VENTAN
		// crearTableGUI.setResizable(false);
		// Cerrar JFrame con el boton del marco
		crearTableGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}