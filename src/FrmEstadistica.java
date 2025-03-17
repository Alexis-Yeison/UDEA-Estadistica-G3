import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmEstadistica extends JFrame{

    private JTextField txtDato;
    private JList lstMuestra;

    //Metodo constructor
    public FrmEstadistica(){
        setSize(500,300);
        setTitle("Calculadora de estadistica");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblDato = new JLabel("Dato:");
        lblDato.setBounds(20,10,100,25);
        getContentPane().add(lblDato);

        txtDato = new JTextField();
        txtDato.setBounds(80,10,100,25);
        getContentPane().add(txtDato);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(80,40,100,25);
        getContentPane().add(btnAgregar);
        
        JButton btnQuitar = new JButton("Quitar");
        btnQuitar.setBounds(80,70,100,25);
        getContentPane().add(btnQuitar);

        JLabel lblMuestra = new JLabel("Muestra:");
        lblMuestra.setBounds(220,10,100,25);
        lblMuestra.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblMuestra);

        lstMuestra = new JList();
        JScrollPane spMuestra = new JScrollPane(lstMuestra);
        spMuestra.setBounds(250,40,100,150);
        getContentPane().add(spMuestra);
        
        JButton btnEstadistica = new JButton("Estadistica");
        btnEstadistica.setBounds(20,200,100,25);
        getContentPane().add(btnEstadistica);

        JComboBox cmbEstadistica = new JComboBox();
        String[] optioStrings = new String[]{"Sumatoria", "Promedio", "Desviacion", "Maximo", "Minimo", "Moda"};
        DefaultComboBoxModel dComboBoxModel = new DefaultComboBoxModel(optioStrings);
        cmbEstadistica.setModel(dComboBoxModel);
        cmbEstadistica.setBounds(130,200,100,25);
        getContentPane().add(cmbEstadistica);

        JTextField txtEstadistica = new JTextField();
        txtEstadistica.setBounds(250,200,100,25);
        txtEstadistica.setEnabled(false);
        getContentPane().add(txtEstadistica);


        // Crear eventos
        btnAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDato();
            }
        });

        btnQuitar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarDato();
            }
        });

        btnEstadistica.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEstadistica();
            }
        });

    }
    // Modificacion para mantener actualizado el git
    private int MAXIMO_DATOS = 1000; 
    private double[] muestra = new double[MAXIMO_DATOS];
    private int totalDatos = 0;


    private void agregarDato(){
        // JOptionPane.showMessageDialog(null, "Hizo clic en Agregar");
        if(totalDatos < MAXIMO_DATOS){
            muestra[totalDatos] = Double.parseDouble(txtDato.getText());
            totalDatos ++;
            mostrarDatos();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pueden agregar más datos");
        }
    }

    private void mostrarDatos(){
        String[] strMuestra = new String[totalDatos];
        for(int i=0; i<totalDatos; i++){
            strMuestra[i] = String.valueOf(muestra[i]);
        }
        lstMuestra.setListData(strMuestra);
    }

    private void quitarDato(){
        JOptionPane.showMessageDialog(null, "Hizo clic en Quitar");
    }

    private void calcularEstadistica(){
        JOptionPane.showMessageDialog(null, "Hizo clic en Calcular estadistica");
    }

}
