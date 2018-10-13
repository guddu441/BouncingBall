package bouncingballs;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class UI extends javax.swing.JFrame {
    ImageIcon img= new ImageIcon("icon.jpeg");
    private final int Ball_Count=5;
    ArrayList<Ball> Balls= new ArrayList<>();
    Bat bats=new Bat();
        
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for(Ball b: Balls){
            g.setColor(new Color(168, 2, 9));
            g.fillOval(b.getBallPosX(), b.getBallPosY(),b.getRadius(), b.getRadius());
        }
        g.setColor(Color.WHITE);
        g.fillRect(bats.getBatPosX(), bats.getBatPosY(), bats.getWidth(), bats.getHeight());
    }
    public UI() {
        initComponents();
        for(int i=0;i<Ball_Count;i++){
            Balls.add(new Ball());
        }
        Timer t= new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                /*for(Ball b: Balls){
                    if(b.getBallPosY()>=322){
                        Balls.remove(b);
                    }
                }*/
                for(Ball b: Balls){
                    b.move();
                }
                for(Ball b1: Balls){
                    for(Ball b2: Balls){
                        if (b1 != b2) {
                            b1.ballsColloiding(b2);
                        }
                    }
                }
                for(Ball b: Balls){
                    if((b.getBallPosY()+26>=bats.getBatPosY())&&(b.getBallPosX()>=bats.getBatPosX())&&(b.getBallPosX()<=bats.getBatPosX()+bats.getWidth())){
                        b.setBallSpeedY(b.getBallSpeedY()*-1);
                    }
                }
                repaint();
            }
        },0,30);
        
        this.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        bats.moveBat(1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        bats.moveBat(2);
                        break;
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOUNCING BALLS");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 0, 51));
        setForeground(new java.awt.Color(0, 102, 255));
        setIconImage(img.getImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bouncingballs/background.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
