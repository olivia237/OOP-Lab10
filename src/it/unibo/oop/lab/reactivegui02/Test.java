package it.unibo.oop.lab.reactivegui02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Exercise on a reactive GUI.
 */
public final class Test {

    private Test() {
    }

    /*
     * Realizzare una classe ConcurrentGUI con costruttore privo di argomenti,
     * tale che quando istanziata crei un JFrame con l'aspetto mostrato nella
     * figura allegata (e contatore inizialmente posto a zero).
     * 
     * Il contatore venga aggiornato incrementandolo ogni 100 millisecondi
     * circa, e il suo nuovo valore venga mostrato ogni volta (l'interfaccia sia
     * quindi reattiva).
     * 
     * Alla pressione del pulsante "down", il conteggio venga da lì in poi
     * aggiornato decrementandolo; alla pressione del pulsante "up", il
     * conteggio venga da lì in poi aggiornato incrementandolo; e così via, in
     * modo alternato.
     * 
     * Alla pressione del pulsante "stop", il conteggio si blocchi, e i tre
     * pulsanti vengano disabilitati. Per far partire l'applicazioni si tolga il
     * commento nel main qui sotto.
     * 
     * Suggerimenti: - si mantenga la struttura dell'esercizio precedente - per
     * pilotare la direzione su/giù si aggiunga un flag booleano all'agente --
     * deve essere volatile? - la disabilitazione dei pulsanti sia realizzata
     * col metodo setEnabled
     */
    
    public final class ConcurrentGUI  {
    
    private JFrame frame = new JFrame();
    
    public ConcurrentGUI() {
    private final JButton down = new JButton("down");
    private final JButton up = new JButton("up");
    final JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    private final JButton stop = new JButton("stop");
    panel.add(down, BorderLayout.CENTER);
    frame.setContentPane(panel);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    panel.add(stop);
    panel.add(down);
    panel.add(up);
    frame.getContentPane().add(panel);
    frame.setVisible(true);
    
    }

    /**
     * 
     * @param args
     *            possible args to pass (not used)
     * 
     */
    public static void main(final String... args) {
        // new ConcurrentGUI();
    }
}
