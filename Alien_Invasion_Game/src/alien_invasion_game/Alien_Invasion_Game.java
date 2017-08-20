package alien_invasion_game;

import java.awt.event.*;
import Console.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Jun
 */
public class Alien_Invasion_Game extends javax.swing.JFrame implements ActionListener, KeyListener
{
    private int _xpos;
    private int _ypos;
    private int _numberOfAliens = 12;
    private IConsole _console;
    Timer t = new Timer(5,this);
    
    public Alien_Invasion_Game() 
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        while(_numberOfAliens > 10)
        {
            _numberOfAliens = Integer.parseInt(JOptionPane.showInputDialog("Give number of how many Aliens you want to face (MAXIMUM 10 ALIENS)"));
        }
        
        CreateAliens();
        
        _xpos = User.getX();
        _ypos = User.getY(); 
        _console = new Console();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        User = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        User.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserShip.jpg"))); // NOI18N
        User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(User)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addComponent(User)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserKeyPressed
    }//GEN-LAST:event_UserKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alien_Invasion_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alien_Invasion_Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel User;
    // End of variables declaration//GEN-END:variables

    public final void CreateAliens()
    {
        int xpos = 70;
        int ypos = -10;
        boolean goOnce = true;
        for(int i = 0; i < _numberOfAliens; i++)
        {
            if(i < 5)
            {
                DrawAliens(xpos,ypos);
                xpos = xpos +100;
            }
            else if(i >= 5)
            {
                if(goOnce)
                {
                    xpos = 70;
                    ypos = 50;
                    goOnce = false;
                    DrawAliens(xpos,ypos);
                }
                DrawAliens(xpos,ypos);
                ypos = 50;
                xpos = xpos +100;
            }
        }
    }
    
    public void DrawAliens(int xpos, int ypos)
    {
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon(getClass().getResource("/AlienShip.jpg")));
        l.setVisible(true);
        l.setLocation(xpos, ypos);
        l.setSize(100, 100);
        getContentPane().add(l);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            _xpos--;
            _console.WriteLine("Hel");
            User.setLocation(_xpos, _ypos);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            _xpos++;
            User.setLocation(_xpos, _ypos);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            _ypos--;
            User.setLocation(_xpos, _ypos);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            _ypos++;
            User.setLocation(_xpos, _ypos);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
