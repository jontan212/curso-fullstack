package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;

public class Uso_JTable2 {
	public static void main(String[] args) {
		JFrame mimarco = new MarcoTablaPersonalizado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}

class MarcoTablaPersonalizado extends JFrame {
	public MarcoTablaPersonalizado() {
		setTitle("Tabla Personalizado");
		setBounds(300, 300, 400, 200);
		/* Tabla personalizada */
		TableModel miModelo = new ModeloTablaPersonalizada();
		JTable miTabla = new JTable(miModelo);
		add(new JScrollPane(miTabla));
	}
}
class ModeloTablaPersonalizada extends AbstractTableModel {
	/* Establece nº columnas */
	public int getColumnCount() {
		return 3;
	}
	/* Establece nº filas */
	public int getRowCount() {
		return 5;
	}
	/* Establece valores campos */
	public Object getValueAt(int rowIndex, int columnIndex) {
		int z = rowIndex + 1;
		int y = columnIndex + 2;
		return " " + z + " " + y;
	}
	/* Establece nombres las columnas título */
	public String getColumnName(int c) {
		return "Columna " + c;
	}
}
