import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class InterfazProcesamiento extends JFrame {
    private JPanel JpanelPrincipal;
    private JTabbedPane JpanelInsertarQuantums;
    private JPanel JpanelDatos;
    private JPanel JPanelInsertarPreDef;
    private JPanel JPanelInsertarProcesos;
    private JPanel JpanelInsetarQuantums;
    private JPanel JpanelRoundRobbin;
    private JPanel VerHistorial;
    private JButton buttonMeterCola;
    private JButton buttonQuemarDatos;
    private JTextArea textAreaGenerarDatosQuemados;
    private JTextPane textPaneIdentificador;
    private JTextPane textPaneNumeroDeCedula;
    private JTextPane textPaneTiempoRequerido;
    private JButton generarButton;
    private JTextPane textPaneVelociadadQuantums;
    private JButton ButtonInsertarQuantums;
    private JTextArea textAreaRoundRobbin;
    private JTextArea textAreaInsertarCola;
    private JButton buttonGenerarRoundRobbin;
    private JTextArea textAreaHistorial;
    private JTextArea textAreaEstadoDeLaCola;
    private JButton buttonHistorialProcesamiento;

    static Queue<DatosProcesar> fila1= new LinkedList<>();
    static Stack <DatosProcesar> pila1=new Stack<>();
    static List<String> datos=new ArrayList<>();
    DatosProcesar dato1=new DatosProcesar("P1","1002856059",100);
    DatosProcesar dato2=new DatosProcesar("P2","1714196743",15);
    DatosProcesar dato3=new DatosProcesar("P3","1456756888",40);
    static Quantums quantumsIngresados;
    static int tiempoQueSeDemora;
    static int totalConmutaciones;

public InterfazProcesamiento() {

    add(JpanelPrincipal);
    setSize(300, 300);
    setLocationRelativeTo(null);

    setTitle("GUI QUANTUMS ESTEBAN-ENRIQUEZ");

    buttonQuemarDatos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


          textAreaGenerarDatosQuemados.setText(""+dato1+"\n"+dato2+"\n"+dato3);
        }
    });
    buttonMeterCola.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fila1.add(dato1);
            fila1.add(dato2);
            fila1.add(dato3);
            textAreaInsertarCola.setText(""+fila1);
        }
    });
    generarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DatosProcesar datosIngresadoPorUsuario=new DatosProcesar(textPaneIdentificador.getText(),textPaneNumeroDeCedula.getText(),Integer.valueOf(textPaneTiempoRequerido.getText()));
            fila1.add(datosIngresadoPorUsuario);
            textAreaEstadoDeLaCola.setText(""+fila1);
        }
    });
    ButtonInsertarQuantums.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int leer;
            leer=Integer.valueOf(textPaneVelociadadQuantums.getText());
            quantumsIngresados=new Quantums(leer);

        }
    });
    buttonGenerarRoundRobbin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mensaje="";
        metodoRetornar();
        for (String datosMostrar:datos){
            mensaje+=datos+"\n";
        }
            textAreaRoundRobbin.setText(mensaje+"\n"+"TOTAL CONMUTACIONES"+totalConmutaciones);

        }
    });


    buttonHistorialProcesamiento.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textAreaHistorial.setText(""+pila1);
        }
    });
}
    public static void metodoRetornar(){
        DatosProcesar datoRestaraQuantum;
        int respuestaResta;
        int tiempoRestar;
        int residuo;

        for (int i=0;i< fila1.size();i++)
        {

            datoRestaraQuantum=fila1.remove();
            datos.add("\n"+"timepo:"+tiempoQueSeDemora+" "+datoRestaraQuantum.getIdentificadorDeProcesos()+"Entra en ejecucion\n");

            tiempoRestar=datoRestaraQuantum.getTiempoProcesar();
            respuestaResta=tiempoRestar-quantumsIngresados.getQuantums(); //15-10=5
            datoRestaraQuantum.setTiempoProcesar(respuestaResta);//datosRestar.set(5)
            residuo=tiempoRestar-respuestaResta;//15-5=10
            System.out.println("respuesta resta"+respuestaResta);
            tiempoQueSeDemora=tiempoQueSeDemora+quantumsIngresados.getQuantums();
            totalConmutaciones=totalConmutaciones+1;
            System.out.println(totalConmutaciones);
            if (respuestaResta>0 && residuo==quantumsIngresados.getQuantums() )
            {
                datos.add("\n"+datoRestaraQuantum.getIdentificadorDeProcesos()+" Se conmuta Pendiente por ejecutar "+datoRestaraQuantum.getTiempoProcesar()+"\n TOTAL CONMUTACIONES"+totalConmutaciones);
                //datoRestaraQuantum.setTiempoProcesar(respuestaResta);
                fila1.add(datoRestaraQuantum);
                metodoRetornar();

            }else if(respuestaResta<=0){
                //tiempoQueSeDemora=tiempoQueSeDemora+respuestaResta;
                respuestaResta=0;
                datoRestaraQuantum.setTiempoProcesar(respuestaResta);
                datos.add("\n"+datoRestaraQuantum.getIdentificadorDeProcesos()+" Ya termino proceso");
                pila1.push(datoRestaraQuantum);
                metodoRetornar();
            }



        }
        System.out.println(datos+"\nTOTAL CONMUTACIONES"+totalConmutaciones);



    }


}
