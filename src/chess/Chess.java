/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Egor
 */
public class Chess {

    static Share share = new Share();

    static int[][] field = {
        {14, 11, 0, 0, 0, 0, 1, 4}, //0 _ 0  
        {12, 11, 0, 0, 0, 0, 1, 2},
        {13, 11, 0, 0, 0, 0, 1, 3},
        {15, 11, 0, 0, 0, 0, 1, 5},
        {16, 11, 0, 0, 0, 0, 1, 6},
        {13, 11, 0, 0, 0, 0, 1, 3},
        {12, 11, 0, 0, 0, 0, 1, 2},
        {14, 11, 0, 0, 0, 0, 1, 4}};
    
   
      

    static boolean Bplay = true;
    
    static boolean Wplay = true;
    
    static boolean Bcheck = false;

    static boolean Wcheck = false;

    static boolean WhiteToMove = true;

    static boolean WhiteKingFirstMove = true;

    static boolean BlackKingFirstMove = true;

    static boolean WhiteTowerLeftFirstMove = true;

    static boolean WhiteTowerRightFirstMove = true;

    static boolean BlackTowerLeftFirstMove = true;

    static boolean BlackTowerRightFirstMove = true;
    
    static int whitePawnLastMove;
    
    static int blackPawnLastMove;
    
    
    

    BufferedImage Ckral = ImageIO.read(new File("kral.png"));
    BufferedImage Cpon = ImageIO.read(new File("pon.png"));
    BufferedImage Cvez = ImageIO.read(new File("vez.png"));
    BufferedImage Ckralovna = ImageIO.read(new File("kralovna.png"));
    BufferedImage Cstrelec = ImageIO.read(new File("strelec.png"));
    BufferedImage Ckun = ImageIO.read(new File("kun.png"));

    BufferedImage Bkral = ImageIO.read(new File("Bkral.png"));
    BufferedImage Bpon = ImageIO.read(new File("Bpon.png"));
    BufferedImage Bvez = ImageIO.read(new File("Bvez.png"));
    BufferedImage Bkralovna = ImageIO.read(new File("Bkralovna.png"));
    BufferedImage Bstrelec = ImageIO.read(new File("Bstrelec.png"));
    BufferedImage Bkun = ImageIO.read(new File("Bkun.png"));

    static boolean WhiteMove = true;
    
    
    
    static int gameOver = 0;

    static JLabel labelTahu = new JLabel("Na tahu je ");
    static JLabel labelSachu = new JLabel("aaaaaaaaaaaaaaaaaaaa");

    static JLabel labelNaKonciHry = new JLabel();
    
    static JButton buttonEnd = new JButton();
    static JButton buttonContinue = new JButton();
    
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();

    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException {

        Chess chess = new Chess();

    }

    public Chess() throws IOException, InterruptedException, InvocationTargetException {
        
        labelNaKonciHry.setVisible(true);
        buttonEnd.setVisible(false);
        buttonEnd.setText("Ukončit program");
        buttonEnd.setBounds(425, 475, 150, 50);
        buttonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
                }
            
            
        });
        
        buttonContinue.setBounds(225, 475, 150, 50);
        buttonContinue.setText("Pokračovat ve hraní");
        buttonContinue.setVisible(false);
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                field = new int[][] {
        {14, 11, 0, 0, 0, 0, 1, 4}, 
        {12, 11, 0, 0, 0, 0, 1, 2},
        {13, 11, 0, 0, 0, 0, 1, 3},
        {15, 11, 0, 0, 0, 0, 1, 5},
        {16, 11, 0, 0, 0, 0, 1, 6},
        {13, 11, 0, 0, 0, 0, 1, 3},
        {12, 11, 0, 0, 0, 0, 1, 2},
        {14, 11, 0, 0, 0, 0, 1, 4}};
                
      Bcheck = false;

      Wcheck = false;

      WhiteToMove = true;

      WhiteKingFirstMove = true;

      BlackKingFirstMove = true;

      WhiteTowerLeftFirstMove = true;

      WhiteTowerRightFirstMove = true;

      BlackTowerLeftFirstMove = true;

      BlackTowerRightFirstMove = true;
    
      whitePawnLastMove=-1;
    
      blackPawnLastMove=-1;
      
      WhiteMove = true;
      
      gameOver = 0;
      
      buttonContinue.setVisible(false);
      buttonEnd.setVisible(false);
      labelNaKonciHry.setVisible(false);
      
      if(Bplay){
          Bplay=false;
          Wplay=true;
      }
                
                }
            
            
        });
        MouseListener mou = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                share.mousePressed = true;

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        Runnable run = new Runnable() {
            @Override
            public void run() {

                frame.setVisible(true);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setSize(1000, 1000);

                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                        if (e.getKeyCode() == KeyEvent.MOUSE_EVENT_MASK) {

                        }

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                JPanel panel = new JPanel() {
                    @Override

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {

                                if ((i + j) % 2 == 0) {

                                    g.setColor(new Color(99, 0, 0));
                                    g.fillRect(i * 100, 100 * j, 100, 100);

                                } else {
                                    g.setColor(new Color(33, 0, 0));
                                    g.fillRect(i * 100, 100 * j, 100, 100);

                                }

                                switch (field[i][j]) {

                                    case 1:
                                        g.drawImage(Bpon, i * 100, j * 100, null);
                                        break;

                                    case 2:
                                        g.drawImage(Bkun, i * 100, j * 100, null);
                                        break;

                                    case 3:
                                        g.drawImage(Bstrelec, i * 100, j * 100, null);
                                        break;

                                    case 4:
                                        g.drawImage(Bvez, i * 100, j * 100, null);
                                        break;

                                    case 5:
                                        g.drawImage(Bkralovna, i * 100, j * 100, null);
                                        break;

                                    case 6:
                                        g.drawImage(Bkral, i * 100, j * 100, null);
                                        break;

                                    case 11:
                                        g.drawImage(Cpon, i * 100, j * 100, null);
                                        break;

                                    case 12:
                                        g.drawImage(Ckun, i * 100, j * 100, null);
                                        break;

                                    case 13:
                                        g.drawImage(Cstrelec, i * 100, j * 100, null);
                                        break;

                                    case 14:
                                        g.drawImage(Cvez, i * 100, j * 100, null);
                                        break;

                                    case 15:
                                        g.drawImage(Ckralovna, i * 100, j * 100, null);
                                        break;

                                    case 16:
                                        g.drawImage(Ckral, i * 100, j * 100, null);
                                        break;

                                }

                            }
                        }
                        if (WhiteMove) {
                            g.drawImage(Bpon, 840, 300, null);
                        } else {
                            g.drawImage(Cpon, 840, 300, null);
                        }

                        if (share.WhitePawnChoice) {

                            g.drawImage(Bkun, 400, 800, null);
                            g.drawImage(Bstrelec, 500, 800, null);
                            g.drawImage(Bvez, 600, 800, null);
                            g.drawImage(Bkralovna, 700, 800, null);
                        }
                        if (share.BlackPawnChoice) {

                            g.drawImage(Ckun, 400, 800, null);
                            g.drawImage(Cstrelec, 500, 800, null);
                            g.drawImage(Cvez, 600, 800, null);
                            g.drawImage(Ckralovna, 700, 800, null);
                        }
                        
                        if(gameOver!=0){
                            g.setColor(new Color(131,139,139,100));
                            g.fillRect(200, 200, 400, 400);
                            g.setColor(Color.blue);
                            
                            if(gameOver==2)labelNaKonciHry.setText("Černý hráč vyhrál");
                            if(gameOver==1)labelNaKonciHry.setText("Bilý hráč vyhrál");
                            if(gameOver==3)labelNaKonciHry.setText("Remíza");
                            labelTahu.setVisible(true);
                            buttonEnd.setVisible(true);
//                            buttonContinue.setVisible(true);
                            frame.repaint();
                        }

                        labelTahu.setSize(300, 300);
                        labelTahu.setForeground(Color.red);
                        labelTahu.setFont(new Font("Verdana", Font.PLAIN, 18));
                        labelTahu.setLocation(850, 100);

                        labelSachu.setForeground(Color.red);
                        labelSachu.setFont(new Font("Verdana", Font.PLAIN, 18));
                        labelSachu.setLocation(820, 20);
                        
                        labelNaKonciHry.setForeground(Color.YELLOW);
                        labelNaKonciHry.setFont(new Font("Verdana", Font.PLAIN, 18));
                        labelNaKonciHry.setLocation(300, 300);
                    }
                };
                panel.setBackground(Color.BLACK);
                panel.add(labelSachu);
                panel.add(labelTahu);
                frame.add(buttonEnd);
                
                frame.add(buttonContinue);
                panel.add(labelNaKonciHry);
                panel.addMouseListener(mou);
                frame.add(panel);

            }
        };

        newGameBoard();
    

        SwingUtilities.invokeLater(run);

        //Kontrola check (nejdriv u bilich)
        blackCheckControl(field);

        if (Bcheck == true) {
         }
        boolean done = true;

        //GAME
        while (done) {

            if (whiteCheckControl(field)) {
                labelSachu.setText("Bilý je v šachu");
                frame.repaint();
            } else {
                labelSachu.setText("");
                frame.repaint();
            }

            whiteMove();

            if (blackCheckControl(field)) {
                
                labelSachu.setText("Černý je v šachu");
                frame.repaint();
            } else {
                labelSachu.setText("");
                frame.repaint();
            }

            blackMove();

        }
        // 1. zkontrolovat check!{zkontrolovat mat :( }
        // 2. kliknout na figuru
        // 3. zobrazit moznosti
        // 4. vybrat z moznosti
        // 5. predat tah

    }
    
    
    
    
    public static boolean blackCheckControl(int[][] field) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                switch (field[i][j]) {

                    case 1:// Pawn
                        try {
                        if (field[i + 1][j - 1] == 16) {

                            Bcheck = true;

                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i - 1][j - 1] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;

                    case 2: // Kuň
                        try {
                        if (field[i + 2][j - 1] == 16) {

                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    try {
                        if (field[i - 1][j - 2] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    try {
                        if (field[i - 2][j - 1] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i - 2][j + 1] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i - 1][j + 2] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 1][j + 2] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 2][j + 1] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 1][j - 2] == 16) {
                            Bcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    break;
                    case 3: // Bshop

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j - k] == 0 || field[i + k][j - k] == 16) {

                                    if (field[i + k][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j + k] == 0 || field[i - k][j + k] == 16) {

                                    if (field[i - k][j + k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j + k] == 0 || field[i + k][j + k] == 16) {

                                    if (field[i + k][j + k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j - k] == 0 || field[i - k][j - k] == 16) {

                                    if (field[i - k][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        break;
                    case 4:// Tower

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j - k] == 16 || field[i][j - k] == 0) {

                                    if (field[i][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j + k] == 16 || field[i][j + k] == 0) {

                                    if (field[i][j + k] == 16) {
                                        Bcheck = true;
                                    }
                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i - k][j] == 16 || field[i - k][j] == 0) {
                                    if (field[i - k][j] == 16) {
                                        Bcheck = true;
                                    }

                                } else {

                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i + k][j] == 16 || field[i + k][j] == 0) {
                                    if (field[i + k][j] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        break;
                    case 5:// Kralovna

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j - k] == 16 || field[i][j - k] == 0) {

                                    if (field[i][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j + k] == 16 || field[i][j + k] == 0) {

                                    if (field[i][j + k] == 16) {
                                        Bcheck = true;
                                    }
                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i - k][j] == 16 || field[i - k][j] == 0) {
                                    if (field[i - k][j] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i + k][j] == 16 || field[i + k][j] == 0) {
                                    if (field[i + k][j] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }
                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j - k] == 0 || field[i + k][j - k] == 16) {

                                    if (field[i + k][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j + k] == 0 || field[i - k][j + k] == 16) {

                                    if (field[i - k][j + k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j + k] == 0 || field[i + k][j + k] == 16) {

                                    if (field[i + k][j + k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j - k] == 0 || field[i - k][j - k] == 16) {

                                    if (field[i - k][j - k] == 16) {
                                        Bcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        break;
                        case 6:
                            //top
                            try{
                            if(field[i-1][j-1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i][j-1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j-1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            //mid
                            try{
                            if(field[i-1][j]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            //bottom
                            try{
                            if(field[i-1][j+1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i][j+1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j+1]==16)Bcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}

                }

            }
        }
        boolean IsCheck = Bcheck;
        Bcheck = false;

        return IsCheck;
    }

    public static boolean whiteCheckControl(int[][] field) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                switch (field[i][j]) {

                    case 11:// Pěšec
                        try {
                        if (field[i - 1][j + 1] == 6) {

                            Wcheck = true;

                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 1][j + 1] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;

                    case 12: // Kuň
                        try {
                        if (field[i + 2][j - 1] == 6) {

                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    try {
                        if (field[i - 1][j - 2] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    try {
                        if (field[i - 2][j - 1] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i - 2][j + 1] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i - 1][j + 2] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 1][j + 2] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 2][j + 1] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    try {
                        if (field[i + 1][j - 2] == 6) {
                            Wcheck = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }

                    break;
                    case 13: // Bshop

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j - k] == 0 || field[i + k][j - k] == 6) {

                                    if (field[i + k][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j + k] == 0 || field[i - k][j + k] == 6) {

                                    if (field[i - k][j + k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j + k] == 0 || field[i + k][j + k] == 6) {

                                    if (field[i + k][j + k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j - k] == 0 || field[i - k][j - k] == 6) {

                                    if (field[i - k][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        break;
                    case 14:// Tower

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j - k] == 6 || field[i][j - k] == 0) {

                                    if (field[i][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j + k] == 6 || field[i][j + k] == 0) {

                                    if (field[i][j + k] == 6) {
                                        Wcheck = true;
                                    }
                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i - k][j] == 6 || field[i - k][j] == 0) {
                                    if (field[i - k][j] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i + k][j] == 6 || field[i + k][j] == 0) {
                                    if (field[i + k][j] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        break;
                    case 15:// Kralovna

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j - k] == 6 || field[i][j - k] == 0) {

                                    if (field[i][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i][j + k] == 6 || field[i][j + k] == 0) {

                                    if (field[i][j + k] == 6) {
                                        Wcheck = true;
                                    }
                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i - k][j] == 6 || field[i - k][j] == 0) {
                                    if (field[i - k][j] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }

                        for (int k = 1; k < 8; k++) {

                            try {
                                if (field[i + k][j] == 6 || field[i + k][j] == 0) {
                                    if (field[i + k][j] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                        }
                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j - k] == 0 || field[i + k][j - k] == 6) {

                                    if (field[i + k][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }

                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j + k] == 0 || field[i - k][j + k] == 6) {

                                    if (field[i - k][j + k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i + k][j + k] == 0 || field[i + k][j + k] == 6) {

                                    if (field[i + k][j + k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        for (int k = 1; k < 8; k++) {
                            try {
                                if (field[i - k][j - k] == 0 || field[i - k][j - k] == 6) {

                                    if (field[i - k][j - k] == 6) {
                                        Wcheck = true;
                                    }

                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                        }

                        break;
                        case 16:
                            //top
                            try{
                            if(field[i-1][j-1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i][j-1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j-1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            //mid
                            try{
                            if(field[i-1][j]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            //bottom
                            try{
                            if(field[i-1][j+1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i][j+1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                            try{
                            if(field[i+1][j+1]==6)Wcheck =true;
                             } catch (IndexOutOfBoundsException ex) {}
                            
                }

            }
        }

        boolean IsCheck = Wcheck;
        Wcheck = false;
        return IsCheck;
    }

    public static void newGameBoard() {

        //Rozestaveni figurek na spravna mista
//        pěšec     1 & 11
//        kuň       2 & 12
//        střelec   3 & 13
//        vež       4 & 14
//        královna  5 & 15
//        král      6 & 16
    }

    

    private void whiteMove() {

        WhiteMove = true;
        int mouseX;
        int mouseY;

        if (isPat('W')) {
            if (whiteCheckControl(field)) {
                gameOver =2;
            } else {
                gameOver=3;
            }

        };
         Wplay = true;

        while (Wplay) {
            ArrayList<Integer> moves = new ArrayList<Integer>();

            while (true) {

                synchronized (share) {

                    if (share.mousePressed) {

                        mouseX = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                        mouseY = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                        mouseX = mouseX / 100;
                        mouseY = mouseY / 100;

                        if (mouseX > 7) {
                            mouseX = 7;
                        }
                        if (mouseX < 0) {
                            mouseX = 0;
                        }
                        if (mouseY > 7) {
                            mouseY = 7;
                        }
                        if (mouseY < 0) {
                            mouseY = 0;
                        }


                        if (field[mouseX][mouseY] < 10 && field[mouseX][mouseY] != 0) {

                        

                            share.mousePressed = false;

                            break;
                        } else {

                        }

                    }

                }
            }

            //switch1-6
            switch (field[mouseX][mouseY]) {

                case 1:
               
                
                //klasicky pohyb dopředu
                try {
                    if (field[mouseX][mouseY - 1] == 0) {

                        moves.add(mouseX * 10 + mouseY - 1);

                        if (field[mouseX][mouseY - 2] == 0 && mouseY == 6) {

                            moves.add(mouseX * 10 + mouseY - 2);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                // utok do stran
                try {
                    if (field[mouseX - 1][mouseY - 1] != 0 && field[mouseX - 1][mouseY - 1] > 10) {

                        moves.add((mouseX - 1) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY - 1] != 0 && field[mouseX + 1][mouseY - 1] > 10) {

                        moves.add((mouseX + 1) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                
                // en passant right
                try{
                if(field[mouseX+1][mouseY]==11&&field[mouseX+1][mouseY-1]==0&&mouseY==3){
                        
                        if(blackPawnLastMove/10 == mouseX+1&&blackPawnLastMove%10==mouseY){
                                
                            moves.add((mouseX + 1) * 10+mouseY-1);
                        }
                    
                }
                }catch (IndexOutOfBoundsException ex) {
                }
                // en passant left
                try{
                if(field[mouseX-1][mouseY]==11&&field[mouseX-1][mouseY-1]==0&&mouseY==3){
                    
                        if(blackPawnLastMove/10 == mouseX-1&&blackPawnLastMove%10==mouseY){
                                
                            moves.add((mouseX - 1) * 10+mouseY-1);
                        }
                    
                }
                }catch (IndexOutOfBoundsException ex) {
                }
                break;

                case 2:
                //kun
                try {
                    if (field[mouseX + 2][mouseY - 1] == 0 || field[mouseX + 2][mouseY - 1] > 10) {

                        moves.add((mouseX + 2) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX - 1][mouseY - 2] == 0 || field[mouseX - 1][mouseY - 2] > 10) {

                        moves.add((mouseX - 1) * 10 + mouseY - 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX - 2][mouseY - 1] == 0 || field[mouseX - 2][mouseY - 1] > 10) {

                        moves.add((mouseX - 2) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX - 2][mouseY + 1] == 0 || field[mouseX - 2][mouseY + 1] > 10) {

                        moves.add((mouseX - 2) * 10 + mouseY + 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX - 1][mouseY + 2] == 0 || field[mouseX - 1][mouseY + 2] > 10) {

                        moves.add((mouseX - 1) * 10 + mouseY + 2);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY + 2] == 0 || field[mouseX + 1][mouseY + 2] > 10) {

                        moves.add((mouseX + 1) * 10 + mouseY + 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 2][mouseY + 1] == 0 || field[mouseX + 2][mouseY + 1] > 10) {

                        moves.add((mouseX + 2) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY - 2] == 0 || field[mouseX + 1][mouseY - 2] > 10) {
                        moves.add((mouseX + 1) * 10 + mouseY - 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                //kun
                break;
                case 3:
                    //strelec
                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY - k] == 0 || field[mouseX + k][mouseY - k] > 10) {

                                if (field[mouseX + k][mouseY - k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                }
                                if (field[mouseX + k][mouseY - k] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY + k] == 0 || field[mouseX - k][mouseY + k] > 10) {

                                if (field[mouseX - k][mouseY + k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);

                                }
                                if (field[mouseX - k][mouseY + k] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY + k] == 0 || field[mouseX + k][mouseY + k] > 10) {

                                if (field[mouseX + k][mouseY + k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);

                                }
                                if (field[mouseX + k][mouseY + k] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);
                                    break;

                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY - k] == 0 || field[mouseX - k][mouseY - k] > 10) {

                                if (field[mouseX - k][mouseY - k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);

                                }
                                if (field[mouseX - k][mouseY - k] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    break;

                case 4:
                    // vež

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY - k] > 10 || field[mouseX][mouseY - k] == 0) {

                                if (field[mouseX][mouseY - k] == 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                }
                                if (field[mouseX][mouseY - k] > 10) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY + k] > 10 || field[mouseX][mouseY + k] == 0) {

                                if (field[mouseX][mouseY + k] == 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);

                                }
                                if (field[mouseX][mouseY + k] > 10) {

                                    moves.add((mouseX) * 10 + mouseY + k);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX - k][mouseY] > 10 || field[mouseX - k][mouseY] == 0) {
                                if (field[mouseX - k][mouseY] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                }
                                if (field[mouseX - k][mouseY] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX + k][mouseY] > 10 || field[mouseX + k][mouseY] == 0) {
                                if (field[mouseX + k][mouseY] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                }
                                if (field[mouseX + k][mouseY] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    break;
                case 5:
                    //kralovna
                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY - k] > 10 || field[mouseX][mouseY - k] == 0) {

                                if (field[mouseX][mouseY - k] == 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                }
                                if (field[mouseX][mouseY - k] > 10) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY + k] > 10 || field[mouseX][mouseY + k] == 0) {

                                if (field[mouseX][mouseY + k] == 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);

                                }
                                if (field[mouseX][mouseY + k] > 10) {

                                    moves.add((mouseX) * 10 + mouseY + k);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX - k][mouseY] > 10 || field[mouseX - k][mouseY] == 0) {
                                if (field[mouseX - k][mouseY] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                }
                                if (field[mouseX - k][mouseY] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX + k][mouseY] > 10 || field[mouseX + k][mouseY] == 0) {
                                if (field[mouseX + k][mouseY] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                }
                                if (field[mouseX + k][mouseY] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY - k] == 0 || field[mouseX + k][mouseY - k] > 10) {

                                if (field[mouseX + k][mouseY - k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                }
                                if (field[mouseX + k][mouseY - k] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY + k] == 0 || field[mouseX - k][mouseY + k] > 10) {

                                if (field[mouseX - k][mouseY + k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);

                                }
                                if (field[mouseX - k][mouseY + k] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY + k] == 0 || field[mouseX + k][mouseY + k] > 10) {

                                if (field[mouseX + k][mouseY + k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);

                                }
                                if (field[mouseX + k][mouseY + k] > 10) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);
                                    break;

                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY - k] == 0 || field[mouseX - k][mouseY - k] > 10) {

                                if (field[mouseX - k][mouseY - k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);

                                }
                                if (field[mouseX - k][mouseY - k] > 10) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    break;
                case 6:
//                kral
                
                //top
                try {
                    if (field[mouseX - 1][mouseY - 1] == 0 || field[mouseX - 1][mouseY - 1] > 10) {
                        moves.add((mouseX - 1) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX][mouseY - 1] == 0 || field[mouseX][mouseY - 1] > 10) {
                        moves.add((mouseX) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY - 1] == 0 || field[mouseX + 1][mouseY - 1] > 10) {
                        moves.add((mouseX + 1) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                //mid
                try {
                    if (field[mouseX - 1][mouseY] == 0 || field[mouseX - 1][mouseY] > 10) {
                        moves.add((mouseX - 1) * 10 + mouseY);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                //Rosada do leva
                try {
                    if (field[mouseX - 1][mouseY] == 0 && field[mouseX - 2][mouseY] == 0 && field[mouseX - 3][mouseY] == 0 && WhiteKingFirstMove && WhiteTowerLeftFirstMove && !(whiteCheckControl(field))) {

                        int[][] testfield = new int[8][8];
                        boolean underAttack = false;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 8; j++) {
                                for (int k = 0; k < 8; k++) {
                                    testfield[j][k] = field[j][k];
                                }
                            }
                            switch (i) {

                                case 0:
                                    testfield[4][7] = 0;
                                    testfield[3][7] = 6;

                                    break;
                                case 1:

                                    testfield[4][7] = 0;
                                    testfield[2][7] = 6;

                                    break;
                                case 2:

                                    testfield[4][7] = 0;
                                    testfield[1][7] = 6;

                                    break;

                                case 3:

                                    testfield[4][7] = 0;
                                    testfield[0][7] = 6;

                                    break;
                            }
                            if (whiteCheckControl(testfield)) {
                                underAttack = true;
                            }

                        }

                        if (underAttack == false) {
                            moves.add((mouseX - 2) * 10 + mouseY);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                //rosada do prava
                try {
                    if (field[mouseX + 1][mouseY] == 0 && field[mouseX + 2][mouseY] == 0 && WhiteKingFirstMove && WhiteTowerRightFirstMove && !(whiteCheckControl(field))) {

                        int[][] testfield = new int[8][8];
                        boolean underAttack = false;

                        for (int i = 0; i < 3; i++) {

                            for (int j = 0; j < 8; j++) {
                                for (int k = 0; k < 8; k++) {
                                    testfield[j][k] = field[j][k];
                                }
                            }
                            switch (i) {

                                case 0:
                                    testfield[4][7] = 0;
                                    testfield[5][7] = 6;

                                    break;
                                case 1:

                                    testfield[4][7] = 0;
                                    testfield[6][7] = 6;

                                    break;
                                case 2:

                                    testfield[4][7] = 0;
                                    testfield[7][7] = 6;

                                    break;

                            }
                            if (whiteCheckControl(testfield)) {
                                underAttack = true;
                            }

                        }

                        if (underAttack == false) {
                            moves.add((mouseX + 2) * 10 + mouseY);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX + 1][mouseY] == 0 || field[mouseX + 1][mouseY] > 10) {
                        moves.add((mouseX + 1) * 10 + mouseY);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                //bottom
                try {
                    if (field[mouseX - 1][mouseY + 1] == 0 || field[mouseX - 1][mouseY + 1] > 10) {
                        moves.add((mouseX - 1) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX][mouseY + 1] == 0 || field[mouseX][mouseY + 1] > 10) {
                        moves.add((mouseX) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY + 1] == 0 || field[mouseX + 1][mouseY + 1] > 10) {
                        moves.add((mouseX + 1) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                break;

            }
            //Tady uz mame pole možných tahu.

            // musim overit, zda tah z "moves" je platny z hlediska šachu a krale.
            // overeni kazdeho tahu zda je platny
            for (int i = 0; i < moves.size(); i++) {

                if (moves.get(i) != -1) {
                    int x = moves.get(i) / 10;
                    int y = moves.get(i) % 10;

                    int[][] testfield = new int[8][8];

                    if (field[x][y] == 16) {
                        moves.set(i, -1);
                    }

                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 8; k++) {
                            testfield[j][k] = field[j][k];
                        }
                    }
                    testfield[mouseX][mouseY] = 0;
                    testfield[x][y] = field[mouseX][mouseY];
                    if (whiteCheckControl(testfield)) {
                        moves.set(i, -1);
                    }

                }
            }

            for (int i = 0; i < moves.size(); i++) {

            }

            // B hrac vybira bud mozny tah nebo jinou figurku.
            while (true) {

                synchronized (share) {

                    if (share.mousePressed) {

                        int mouseXvyber = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                        int mouseYvyber = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                        mouseXvyber = mouseXvyber / 100;
                        mouseYvyber = mouseYvyber / 100;

                        if (mouseXvyber > 7) {
                            mouseXvyber = 7;
                        }
                        if (mouseXvyber < 0) {
                            mouseXvyber = 0;
                        }
                        if (mouseYvyber > 7) {
                            mouseYvyber = 7;
                        }
                        if (mouseYvyber < 0) {
                            mouseYvyber = 0;
                        }
                        //vyber tahu
                        for (int i = 0; i < moves.size(); i++) {
                            if (moves.get(i) != -1) {
                                if (moves.get(i) / 10 == mouseXvyber && moves.get(i) % 10 == mouseYvyber) {

                                    //pocitani prvnich pohybu krale a vezi(rosada)
                                    if (field[mouseX][mouseY] == 6) {

                                        if (mouseXvyber == 2 && WhiteKingFirstMove && mouseYvyber == 7) {
                                            field[mouseX][mouseY] = 0;
                                            field[0][7] = 0;

                                            field[mouseX - 1][mouseY] = 4;
                                            field[mouseX - 2][mouseY] = 6;

                                            WhiteKingFirstMove = false;

                                            frame.repaint();

                                            share.mousePressed = false;
                                            return;

                                        } else if (mouseXvyber == 6 && WhiteKingFirstMove && mouseYvyber == 7) {
                                            field[mouseX][mouseY] = 0;
                                            field[7][7] = 0;

                                            field[6][7] = 6;
                                            field[5][7] = 4;
                                            WhiteKingFirstMove = false;

                                            frame.repaint();

                                            share.mousePressed = false;
                                            return;
                                        } else {
                                            field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];

                                            field[mouseX][mouseY] = 0;

                                            frame.repaint();
                                            WhiteKingFirstMove = false;

                                            share.mousePressed = false;
                                            return;

                                        }

                                    } else {

                                        if (field[mouseX][mouseY] == 4) {
                                            if (mouseX == 0) {
                                                WhiteTowerLeftFirstMove = false;

                                            } else {
                                                WhiteTowerRightFirstMove = false;
                                            }

                                        }

                                        if (field[mouseX][mouseY] == 1) {

                                            if (mouseYvyber == 0) {

                                                int rozhodnuti = rozhodnutiBPesce();
                                                if (rozhodnuti == -1) {
                                                    Share.WhitePawnChoice = false;

                                                    break;
                                                } else {
                                                    field[mouseXvyber][mouseYvyber] = rozhodnuti;
                                                    field[mouseX][mouseY] = 0;
                                                    Share.WhitePawnChoice = false;

                                                    return;
                                                }

                                            }
                                            if(mouseYvyber+2==mouseY){
                                                whitePawnLastMove=(mouseXvyber*10)+mouseYvyber;
                                            }else{
                                                
                                                whitePawnLastMove=-1;
                                            
                                            }
                                            //sikmy uder pravo
                                            if(mouseY==3&&moves.get(i)/10==mouseX+1&&mouseY-1==moves.get(i)%10){
                                                
                                                field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];
                                                field[mouseXvyber][mouseYvyber+1]=0; 
                                                field[mouseX][mouseY] = 0;
                                                frame.repaint();
                                        share.mousePressed = false;
                                        return;
                                            }
                                            //sikmy uder levo
                                            if(mouseY==3&&moves.get(i)/10==mouseX-1&&mouseY-1==moves.get(i)%10){
                                                
                                                field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];
                                                field[mouseXvyber][mouseYvyber+1]=0; 
                                                field[mouseX][mouseY] = 0;
                                                
                                                frame.repaint();
                                        share.mousePressed = false;
                                        return;
                                            }
                                            
                                        }else{
                                            
                                                whitePawnLastMove=-1;
                                            
                                        }

                                        field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];

                                        field[mouseX][mouseY] = 0;

                                        frame.repaint();

                                        share.mousePressed = false;
                                        return;

                                    }
                                }
                            }

                        }
                        if (field[mouseXvyber][mouseYvyber] < 10) {
                            break;
                        }

                    }

                }
            }

        }

    }

    public synchronized static int rozhodnutiBPesce() {

        share.WhitePawnChoice = true;

        frame.repaint();

        share.mousePressed = false;

        while (true) {

            synchronized (share) {

                if (share.mousePressed) {

                    int mouseXvyber = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                    int mouseYvyber = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                    mouseXvyber = mouseXvyber / 100;
                    mouseYvyber = mouseYvyber / 100;
                    if (mouseYvyber == 8) {
                        if (mouseXvyber == 4) {

                            return 2;
                        }
                        if (mouseXvyber == 5) {

                            return 3;
                        }
                        if (mouseXvyber == 6) {

                            return 4;
                        }
                        if (mouseXvyber == 7) {

                            return 5;
                        }

                    } else {

                        if (field[mouseXvyber][mouseYvyber] < 10 && field[mouseXvyber][mouseYvyber] != 0) {
                            return -1;
                        }
                    }

                }
            }

        }

    }
    
    public synchronized static int rozhodnutiCPesce() {

        share.BlackPawnChoice = true;

        frame.repaint();
        ;

        share.mousePressed = false;

        while (true) {

            synchronized (share) {

                if (share.mousePressed) {

                    int mouseXvyber = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                    int mouseYvyber = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                    mouseXvyber = mouseXvyber / 100;
                    mouseYvyber = mouseYvyber / 100;
                    if (mouseYvyber == 8) {
                        if (mouseXvyber == 4) {

                            return 12;
                        }
                        if (mouseXvyber == 5) {

                            return 13;
                        }
                        if (mouseXvyber == 6) {

                            return 14;
                        }
                        if (mouseXvyber == 7) {

                            return 15;
                        }

                    } else {

                        if (field[mouseXvyber][mouseYvyber] > 10 ) {
                            return -1;
                        }
                    }

                }
            }

        }

    }

    private static void blackMove() {

        WhiteMove = false;
        int mouseX;
        int mouseY;

        if (isPat('B')) {
            if (blackCheckControl(field)) {
                gameOver=1;
            } else {
                gameOver=3;
            }

        };
         Bplay = true;

        while (Bplay) {
            ArrayList<Integer> moves = new ArrayList<Integer>();

            while (true) {

                synchronized (share) {

                    if (share.mousePressed) {

                        mouseX = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                        mouseY = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                        mouseX = mouseX / 100;
                        mouseY = mouseY / 100;

                        if (mouseX > 7) {
                            mouseX = 7;
                        }
                        if (mouseX < 0) {
                            mouseX = 0;
                        }
                        if (mouseY > 7) {
                            mouseY = 7;
                        }
                        if (mouseY < 0) {
                            mouseY = 0;
                        }


                        if (field[mouseX][mouseY] > 10 && field[mouseX][mouseY] != 0) {


                            share.mousePressed = false;

                            break;
                        } else {

                        }

                    }

                }
            }

            //switch1-6
            switch (field[mouseX][mouseY]) {

                case 11:
               
                
                //klasicky pohyb dopředu
                try {
                    if (field[mouseX][mouseY + 1] == 0) {

                        moves.add(mouseX * 10 + mouseY + 1);

                        if (field[mouseX][mouseY + 2] == 0 && mouseY == 1) {

                            moves.add(mouseX * 10 + mouseY + 2);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                // utok do stran
                try {
                    if (field[mouseX - 1][mouseY + 1] != 0 && field[mouseX - 1][mouseY + 1] < 10) {

                        moves.add((mouseX - 1) * 10 + mouseY + 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY + 1] != 0 && field[mouseX + 1][mouseY + 1] < 10) {

                        moves.add((mouseX + 1) * 10 + mouseY + 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                
                // en passant right
                try{
                if(field[mouseX+1][mouseY]==1&&field[mouseX+1][mouseY+1]==0&&mouseY==4){
                    
                        if(whitePawnLastMove/10 == mouseX+1&&whitePawnLastMove%10==mouseY){
                                
                            moves.add((mouseX + 1) * 10+mouseY+1);
                        }
                    
                }
                }catch (IndexOutOfBoundsException ex) {
                }
                // en passant left
                try{
                if(field[mouseX-1][mouseY]==1&&field[mouseX-1][mouseY+1]==0&&mouseY==4){
                    
                        if(whitePawnLastMove/10 == mouseX-1&&whitePawnLastMove%10==mouseY){
                                
                            moves.add((mouseX - 1) * 10+mouseY+1);
                        }
                    
                }
                }catch (IndexOutOfBoundsException ex) {
                }
                break;
                case 12:
                //kun
                try {
                    if (field[mouseX + 2][mouseY - 1] == 0 || field[mouseX + 2][mouseY - 1] < 10) {

                        moves.add((mouseX + 2) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX - 1][mouseY - 2] == 0 || field[mouseX - 1][mouseY - 2] < 10) {

                        moves.add((mouseX - 1) * 10 + mouseY - 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX - 2][mouseY - 1] == 0 || field[mouseX - 2][mouseY - 1] < 10) {

                        moves.add((mouseX - 2) * 10 + mouseY - 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX - 2][mouseY + 1] == 0 || field[mouseX - 2][mouseY + 1] < 10) {

                        moves.add((mouseX - 2) * 10 + mouseY + 1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX - 1][mouseY + 2] == 0 || field[mouseX - 1][mouseY + 2] < 10) {

                        moves.add((mouseX - 1) * 10 + mouseY + 2);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY + 2] == 0 || field[mouseX + 1][mouseY + 2] < 10) {

                        moves.add((mouseX + 1) * 10 + mouseY + 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 2][mouseY + 1] == 0 || field[mouseX + 2][mouseY + 1] < 10) {

                        moves.add((mouseX + 2) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY - 2] == 0 || field[mouseX + 1][mouseY - 2] < 10) {
                        moves.add((mouseX + 1) * 10 + mouseY - 2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                break;
                case 13:
                    //strelec
                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY - k] == 0 || field[mouseX + k][mouseY - k] < 10) {

                                if (field[mouseX + k][mouseY - k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                }
                                if (field[mouseX + k][mouseY - k] < 10 && field[mouseX + k][mouseY - k] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY + k] == 0 || field[mouseX - k][mouseY + k] < 10) {

                                if (field[mouseX - k][mouseY + k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);

                                }
                                if (field[mouseX - k][mouseY + k] < 10 && field[mouseX - k][mouseY + k] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY + k] == 0 || field[mouseX + k][mouseY + k] < 10) {

                                if (field[mouseX + k][mouseY + k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);

                                }
                                if (field[mouseX + k][mouseY + k] < 10 && field[mouseX + k][mouseY + k] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);
                                    break;

                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY - k] == 0 || field[mouseX - k][mouseY - k] < 10) {

                                if (field[mouseX - k][mouseY - k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);

                                }
                                if (field[mouseX - k][mouseY - k] < 10 && field[mouseX - k][mouseY - k] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    break;

                case 14:
                    // vež

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY - k] < 10 || field[mouseX][mouseY - k] == 0) {

                                if (field[mouseX][mouseY - k] == 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                }
                                if (field[mouseX][mouseY - k] < 10 && field[mouseX][mouseY - k] != 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY + k] < 10 || field[mouseX][mouseY + k] == 0) {

                                if (field[mouseX][mouseY + k] == 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);

                                }
                                if (field[mouseX][mouseY + k] < 10 && field[mouseX][mouseY + k] != 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX - k][mouseY] < 10 || field[mouseX - k][mouseY] == 0) {
                                if (field[mouseX - k][mouseY] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                }
                                if (field[mouseX - k][mouseY] < 10 && field[mouseX - k][mouseY] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX + k][mouseY] < 10 || field[mouseX + k][mouseY] == 0) {
                                if (field[mouseX + k][mouseY] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                }
                                if (field[mouseX + k][mouseY] < 10 && field[mouseX + k][mouseY] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    break;
                case 15:
                    //kralovna

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY - k] == 0 || field[mouseX + k][mouseY - k] < 10) {

                                if (field[mouseX + k][mouseY - k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                }
                                if (field[mouseX + k][mouseY - k] < 10 && field[mouseX + k][mouseY - k] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY + k] == 0 || field[mouseX - k][mouseY + k] < 10) {

                                if (field[mouseX - k][mouseY + k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);

                                }
                                if (field[mouseX - k][mouseY + k] < 10 && field[mouseX - k][mouseY + k] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY + k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX + k][mouseY + k] == 0 || field[mouseX + k][mouseY + k] < 10) {

                                if (field[mouseX + k][mouseY + k] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);

                                }
                                if (field[mouseX + k][mouseY + k] < 10 && field[mouseX + k][mouseY + k] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY + k);
                                    break;

                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {
                        try {
                            if (field[mouseX - k][mouseY - k] == 0 || field[mouseX - k][mouseY - k] < 10) {

                                if (field[mouseX - k][mouseY - k] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);

                                }
                                if (field[mouseX - k][mouseY - k] < 10 && field[mouseX - k][mouseY - k] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY - k] < 10 || field[mouseX][mouseY - k] == 0) {

                                if (field[mouseX][mouseY - k] == 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                }
                                if (field[mouseX][mouseY - k] < 10 && field[mouseX][mouseY - k] != 0) {
                                    moves.add((mouseX) * 10 + mouseY - k);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX][mouseY + k] < 10 || field[mouseX][mouseY + k] == 0) {

                                if (field[mouseX][mouseY + k] == 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);

                                }
                                if (field[mouseX][mouseY + k] < 10 && field[mouseX][mouseY + k] != 0) {

                                    moves.add((mouseX) * 10 + mouseY + k);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX - k][mouseY] < 10 || field[mouseX - k][mouseY] == 0) {
                                if (field[mouseX - k][mouseY] == 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                }
                                if (field[mouseX - k][mouseY] < 10 && field[mouseX - k][mouseY] != 0) {
                                    moves.add((mouseX - k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }

                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    for (int k = 1; k < 8; k++) {

                        try {
                            if (field[mouseX + k][mouseY] < 10 || field[mouseX + k][mouseY] == 0) {
                                if (field[mouseX + k][mouseY] == 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                }
                                if (field[mouseX + k][mouseY] < 10 && field[mouseX + k][mouseY] != 0) {
                                    moves.add((mouseX + k) * 10 + mouseY);
                                    break;
                                }

                            } else {
                                break;
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }

                    }

                    break;
                case 16:
//                kral
                
                //top
                try {
                    if (field[mouseX - 1][mouseY - 1] == 0 || field[mouseX - 1][mouseY - 1] < 10) {
                        moves.add((mouseX - 1) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX][mouseY - 1] == 0 || field[mouseX][mouseY - 1] < 10) {
                        moves.add((mouseX) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY - 1] == 0 || field[mouseX + 1][mouseY - 1] < 10) {
                        moves.add((mouseX + 1) * 10 + mouseY - 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                //mid
                try {
                    if (field[mouseX - 1][mouseY] == 0 || field[mouseX - 1][mouseY] < 10) {
                        moves.add((mouseX - 1) * 10 + mouseY);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                //Rosada do leva black
                try {
                    if (field[mouseX - 1][mouseY] == 0 && field[mouseX - 2][mouseY] == 0 && field[mouseX - 3][mouseY] == 0 && BlackKingFirstMove && BlackTowerLeftFirstMove && !(blackCheckControl(field))) {

                        int[][] testfield = new int[8][8];
                        boolean underAttack = false;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 8; j++) {
                                for (int k = 0; k < 8; k++) {
                                    testfield[j][k] = field[j][k];
                                }
                            }
                            switch (i) {

                                case 0:
                                    testfield[4][0] = 0;
                                    testfield[3][0] = 16;

                                    break;
                                case 1:

                                    testfield[4][0] = 0;
                                    testfield[2][0] = 16;

                                    break;
                                case 2:

                                    testfield[4][0] = 0;
                                    testfield[1][0] = 16;

                                    break;

                                case 3:

                                    testfield[4][0] = 0;
                                    testfield[0][0] = 16;

                                    break;
                            }
                            if (blackCheckControl(testfield)) {
                                underAttack = true;
                            }

                        }

                        if (underAttack == false) {
                            moves.add((mouseX - 2) * 10 + mouseY);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                //rosada do prava
                try {
                    if (field[mouseX + 1][mouseY] == 0 && field[mouseX + 2][mouseY] == 0 && BlackKingFirstMove && BlackTowerRightFirstMove && !(blackCheckControl(field))) {

                        int[][] testfield = new int[8][8];
                        boolean underAttack = false;

                        for (int i = 0; i < 3; i++) {

                            for (int j = 0; j < 8; j++) {
                                for (int k = 0; k < 8; k++) {
                                    testfield[j][k] = field[j][k];
                                }
                            }
                            switch (i) {

                                case 0:
                                    testfield[4][0] = 0;
                                    testfield[5][0] = 16;

                                    break;
                                case 1:

                                    testfield[4][0] = 0;
                                    testfield[6][0] = 16;

                                    break;
                                case 2:

                                    testfield[4][0] = 0;
                                    testfield[7][0] = 16;

                                    break;

                            }
                            if (blackCheckControl(testfield)) {
                                underAttack = true;
                            }

                        }

                        if (underAttack == false) {
                            moves.add((mouseX + 2) * 10 + mouseY);
                        }

                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                try {
                    if (field[mouseX + 1][mouseY] == 0 || field[mouseX + 1][mouseY] < 10) {
                        moves.add((mouseX + 1) * 10 + mouseY);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                //bottom
                try {
                    if (field[mouseX - 1][mouseY + 1] == 0 || field[mouseX - 1][mouseY + 1] < 10) {
                        moves.add((mouseX - 1) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX][mouseY + 1] == 0 || field[mouseX][mouseY + 1] < 10) {
                        moves.add((mouseX) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                try {
                    if (field[mouseX + 1][mouseY + 1] == 0 || field[mouseX + 1][mouseY + 1] < 10) {
                        moves.add((mouseX + 1) * 10 + mouseY + 1);

                    }
                } catch (IndexOutOfBoundsException ex) {
                }
                break;

            }
            //Tady uz mame pole možných tahu.

            // musim overit, zda tah z "moves" je platny z hlediska šachu a krale.
            // overeni kazdeho tahu zda je platny
            for (int i = 0; i < moves.size(); i++) {

                if (moves.get(i) != -1) {
                    int x = moves.get(i) / 10;
                    int y = moves.get(i) % 10;

                    int[][] testfield = new int[8][8];

                    if (field[x][y] == 6) {
                        moves.set(i, -1);
                    }

                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 8; k++) {
                            testfield[j][k] = field[j][k];
                        }
                    }
                    testfield[mouseX][mouseY] = 0;
                    testfield[x][y] = field[mouseX][mouseY];
                    if (blackCheckControl(testfield)) {
                        moves.set(i, -1);
                    }

                }
            }

            
            // C hrac vybira bud mozny tah nebo jinou figurku.
            while (true) {

                synchronized (share) {

                    if (share.mousePressed) {

                        int mouseXvyber = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
                        int mouseYvyber = MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;

                        mouseXvyber = mouseXvyber / 100;
                        mouseYvyber = mouseYvyber / 100;

                        if (mouseXvyber > 7) {
                            mouseXvyber = 7;
                        }
                        if (mouseXvyber < 0) {
                            mouseXvyber = 0;
                        }
                        if (mouseYvyber > 7) {
                            mouseYvyber = 7;
                        }
                        if (mouseYvyber < 0) {
                            mouseYvyber = 0;
                        }
                        //vyber tahu
                        for (int i = 0; i < moves.size(); i++) {
                            if (moves.get(i) != -1) {
                                if (moves.get(i) / 10 == mouseXvyber && moves.get(i) % 10 == mouseYvyber) {

                                    //pocitani prvnich pohybu krale a vezi(rosada)
                                    if (field[mouseX][mouseY] == 16) {

                                        if (mouseXvyber == 2 && BlackKingFirstMove && mouseYvyber == 0 && BlackTowerLeftFirstMove) {
                                            field[mouseX][mouseY] = 0;
                                            field[0][0] = 0;

                                            field[mouseX - 1][mouseY] = 14;
                                            field[mouseX - 2][mouseY] = 16;

                                            BlackKingFirstMove = false;

                                            frame.repaint();

                                            share.mousePressed = false;
                                            return;

                                        } else if (mouseXvyber == 6 && BlackKingFirstMove && mouseYvyber == 0 && BlackTowerRightFirstMove) {

                                            field[mouseX][mouseY] = 0;
                                            field[7][0] = 0;

                                            field[6][0] = 16;
                                            field[5][0] = 14;

                                            BlackKingFirstMove = false;

                                            frame.repaint();

                                            share.mousePressed = false;
                                            return;

                                        } else {

                                            field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];

                                            field[mouseX][mouseY] = 0;

                                            frame.repaint();
                                            BlackKingFirstMove = false;

                                            share.mousePressed = false;
                                            return;

                                        }

                                    } else {

                                        if (field[mouseX][mouseY] == 14) {
                                            if (mouseX == 0) {
                                                BlackTowerLeftFirstMove = false;

                                            } else {
                                                BlackTowerRightFirstMove = false;
                                            }

                                        }
                                        
                                        if (field[mouseX][mouseY] == 11) {

                                            if (mouseYvyber == 7) {

                                                
                                                int rozhodnuti = rozhodnutiCPesce();
                                                if (rozhodnuti == -1) {
                                                    Share.BlackPawnChoice = false;

                                                    break;
                                                } else {
                                                    field[mouseXvyber][mouseYvyber] = rozhodnuti;
                                                    field[mouseX][mouseY] = 0;
                                                    Share.BlackPawnChoice = false;

                                                    return;
                                                }

                                            }
                                            if(mouseYvyber-2==mouseY){
                                                blackPawnLastMove=(mouseXvyber*10)+mouseYvyber;
                                            }else{
                                                blackPawnLastMove=-100;
                                            }
                                            //sikmy uder pravo
                                            if(mouseY==4&&moves.get(i)/10==mouseX+1&&mouseY+1==moves.get(i)%10){
                                                
                                                field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];
                                                field[mouseXvyber][mouseYvyber-1]=0; 
                                                field[mouseX][mouseY] = 0;
                                                frame.repaint();
                                        share.mousePressed = false;
                                        return;
                                            }
                                            //sikmy uder levo
                                            if(mouseY==4&&moves.get(i)/10==mouseX-1&&mouseY+1==moves.get(i)%10){
                                                
                                                field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];
                                                field[mouseXvyber][mouseYvyber-1]=0; 
                                                field[mouseX][mouseY] = 0;
                                                
                                                frame.repaint();
                                        share.mousePressed = false;
                                        return;
                                            }
                                            field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];

                                        field[mouseX][mouseY] = 0;

                                        frame.repaint();

                                        share.mousePressed = false;
                                        return;
                                        }
                                        blackPawnLastMove=-1;

                                        field[mouseXvyber][mouseYvyber] = field[mouseX][mouseY];

                                        field[mouseX][mouseY] = 0;

                                        frame.repaint();
                                        

                                        share.mousePressed = false;
                                        return;

                                    }
                                }
                            }

                        }
                        if (field[mouseXvyber][mouseYvyber] > 10) {
                            break;
                        }

                    }

                }
            }

        }

    }

    private static boolean isPat(char side) {
        if (side == 'W') {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    ArrayList<Integer> moves = new ArrayList<Integer>();

                    if (field[i][j] < 10 && field[i][j] != 0) {
                        switch (field[i][j]) {
                            case 1:
               
                
                //klasicky pohyb dopředu
                try {
                                if (field[i][j - 1] == 0) {

                                    moves.add(i * 10 + j - 1);

                                    if (field[i][j - 2] == 0 && j == 6) {

                                        moves.add(i * 10 + j - 2);
                                    }

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            // utok do stran
                            try {
                                if (field[i - 1][j - 1] != 0) {

                                    moves.add((i - 1) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j - 1] != 0) {

                                    moves.add((i + 1) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            break;

                            case 2:
                //kun
                try {
                                if (field[i + 2][j - 1] == 0 || field[i + 2][j - 1] > 10) {

                                    moves.add((i + 2) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            try {
                                if (field[i - 1][j - 2] == 0 || field[i - 1][j - 2] > 10) {

                                    moves.add((i - 1) * 10 + j - 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            try {
                                if (field[i - 2][j - 1] == 0 || field[i - 2][j - 1] > 10) {

                                    moves.add((i - 2) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i - 2][j + 1] == 0 || field[i - 2][j + 1] > 10) {

                                    moves.add((i - 2) * 10 + j + 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i - 1][j + 2] == 0 || field[i - 1][j + 2] > 10) {

                                    moves.add((i - 1) * 10 + j + 2);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j + 2] == 0 || field[i + 1][j + 2] > 10) {

                                    moves.add((i + 1) * 10 + j + 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 2][j + 1] == 0 || field[i + 2][j + 1] > 10) {

                                    moves.add((i + 2) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j - 2] == 0 || field[i + 1][j - 2] > 10) {
                                    moves.add((i + 1) * 10 + j - 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            //kun
                            break;
                            case 3:
                                //strelec
                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j - k] == 0 || field[i + k][j - k] > 10) {

                                            if (field[i + k][j - k] == 0) {
                                                moves.add((i + k) * 10 + j - k);
                                            }
                                            if (field[i + k][j - k] > 10) {
                                                moves.add((i + k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j + k] == 0 || field[i - k][j + k] > 10) {

                                            if (field[i - k][j + k] == 0) {
                                                moves.add((i - k) * 10 + j + k);

                                            }
                                            if (field[i - k][j + k] > 10) {
                                                moves.add((i - k) * 10 + j + k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j + k] == 0 || field[i + k][j + k] > 10) {

                                            if (field[i + k][j + k] == 0) {
                                                moves.add((i + k) * 10 + j + k);

                                            }
                                            if (field[i + k][j + k] > 10) {
                                                moves.add((i + k) * 10 + j + k);
                                                break;

                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j - k] == 0 || field[i - k][j - k] > 10) {

                                            if (field[i - k][j - k] == 0) {
                                                moves.add((i - k) * 10 + j - k);

                                            }
                                            if (field[i - k][j - k] > 10) {
                                                moves.add((i - k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                break;

                            case 4:
                                // vež

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j - k] > 10 || field[i][j - k] == 0) {

                                            if (field[i][j - k] == 0) {
                                                moves.add((i) * 10 + j - k);
                                            }
                                            if (field[i][j - k] > 10) {
                                                moves.add((i) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j + k] > 10 || field[i][j + k] == 0) {

                                            if (field[i][j + k] == 0) {

                                                moves.add((i) * 10 + j + k);

                                            }
                                            if (field[i][j + k] > 10) {

                                                moves.add((i) * 10 + j + k);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i - k][j] > 10 || field[i - k][j] == 0) {
                                            if (field[i - k][j] == 0) {
                                                moves.add((i - k) * 10 + j);
                                            }
                                            if (field[i - k][j] > 10) {
                                                moves.add((i - k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i + k][j] > 10 || field[i + k][j] == 0) {
                                            if (field[i + k][j] == 0) {
                                                moves.add((i + k) * 10 + j);
                                            }
                                            if (field[i + k][j] > 10) {
                                                moves.add((i + k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                break;
                            case 5:
                                //kralovna
                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j - k] > 10 || field[i][j - k] == 0) {

                                            if (field[i][j - k] == 0) {
                                                moves.add((i) * 10 + j - k);
                                            }
                                            if (field[i][j - k] > 10) {
                                                moves.add((i) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j + k] > 10 || field[i][j + k] == 0) {

                                            if (field[i][j + k] == 0) {

                                                moves.add((i) * 10 + j + k);

                                            }
                                            if (field[i][j + k] > 10) {

                                                moves.add((i) * 10 + j + k);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i - k][j] > 10 || field[i - k][j] == 0) {
                                            if (field[i - k][j] == 0) {
                                                moves.add((i - k) * 10 + j);
                                            }
                                            if (field[i - k][j] > 10) {
                                                moves.add((i - k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i + k][j] > 10 || field[i + k][j] == 0) {
                                            if (field[i + k][j] == 0) {
                                                moves.add((i + k) * 10 + j);
                                            }
                                            if (field[i + k][j] > 10) {
                                                moves.add((i + k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j - k] == 0 || field[i + k][j - k] > 10) {

                                            if (field[i + k][j - k] == 0) {
                                                moves.add((i + k) * 10 + j - k);
                                            }
                                            if (field[i + k][j - k] > 10) {
                                                moves.add((i + k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j + k] == 0 || field[i - k][j + k] > 10) {

                                            if (field[i - k][j + k] == 0) {
                                                moves.add((i - k) * 10 + j + k);

                                            }
                                            if (field[i - k][j + k] > 10) {
                                                moves.add((i - k) * 10 + j + k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j + k] == 0 || field[i + k][j + k] > 10) {

                                            if (field[i + k][j + k] == 0) {
                                                moves.add((i + k) * 10 + j + k);

                                            }
                                            if (field[i + k][j + k] > 10) {
                                                moves.add((i + k) * 10 + j + k);
                                                break;

                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j - k] == 0 || field[i - k][j - k] > 10) {

                                            if (field[i - k][j - k] == 0) {
                                                moves.add((i - k) * 10 + j - k);

                                            }
                                            if (field[i - k][j - k] > 10) {
                                                moves.add((i - k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                break;
                            case 6:
//                kral 
                
                //top
                try {
                                if (field[i - 1][j - 1] == 0 || field[i - 1][j - 1] > 10) {
                                    moves.add((i - 1) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i][j - 1] == 0 || field[i][j - 1] > 10) {
                                    moves.add((i) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j - 1] == 0 || field[i + 1][j - 1] > 10) {
                                    moves.add((i + 1) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            //mid
                            try {
                                if (field[i - 1][j] == 0 || field[i - 1][j] > 10) {
                                    moves.add((i - 1) * 10 + j);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j] == 0 || field[i + 1][j] > 10) {
                                    moves.add((i + 1) * 10 + j);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            //bottom
                            try {
                                if (field[i - 1][j + 1] == 0 || field[i - 1][j + 1] > 10) {
                                    moves.add((i - 1) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i][j + 1] == 0 || field[i][j + 1] > 10) {
                                    moves.add((i) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j + 1] == 0 || field[i + 1][j + 1] > 10) {
                                    moves.add((i + 1) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            break;

                        }

                        for (int ii = 0; ii < moves.size(); ii++) {

                            if (moves.get(ii) != -1) {
                                int x = moves.get(ii) / 10;
                                int y = moves.get(ii) % 10;
                                int[][] testfield = new int[8][8];

                                for (int jj = 0; jj < 8; jj++) {
                                    for (int k = 0; k < 8; k++) {
                                        testfield[jj][k] = field[jj][k];
                                    }
                                }
                                testfield[i][j] = 0;
                                testfield[x][y] = field[i][j];
                                if (whiteCheckControl(testfield)) {
                                    moves.set(ii, -1);
                                }

                            }
                        }
                        //musime overit zda je seznam pohybu je prazdny
                        for (int k = 0; k < moves.size(); k++) {
                            if (moves.get(k) != -1) {

                                return false;
                            }
                        }
                    }

                }

            }

            return true;

        } else {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    ArrayList<Integer> moves = new ArrayList<Integer>();

                    if (field[i][j] > 10) {
                        switch (field[i][j]) {
                            case 11:
               
                
                //klasicky pohyb dopředu
                try {
                                if (field[i][j + 1] == 0) {

                                    moves.add(i * 10 + j + 1);

                                    if (field[i][j + 2] == 0 && j == 1) {

                                        moves.add(i * 10 + j + 2);
                                    }

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            // utok do stran
                            try {
                                if (field[i - 1][j + 1] != 0 && field[i - 1][j + 1] < 10) {

                                    moves.add((i - 1) * 10 + j + 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j + 1] != 0 && field[i + 1][j + 1] < 10) {

                                    moves.add((i + 1) * 10 + j + 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            break;

                            case 12:
                //kun
                try {
                                if (field[i + 2][j - 1] == 0 || field[i + 2][j - 1] < 10) {

                                    moves.add((i + 2) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            try {
                                if (field[i - 1][j - 2] == 0 || field[i - 1][j - 2] < 10) {

                                    moves.add((i - 1) * 10 + j - 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            try {
                                if (field[i - 2][j - 1] == 0 || field[i - 2][j - 1] < 10) {

                                    moves.add((i - 2) * 10 + j - 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i - 2][j + 1] == 0 || field[i - 2][j + 1] < 10) {

                                    moves.add((i - 2) * 10 + j + 1);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i - 1][j + 2] == 0 || field[i - 1][j + 2] < 10) {

                                    moves.add((i - 1) * 10 + j + 2);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j + 2] == 0 || field[i + 1][j + 2] < 10) {

                                    moves.add((i + 1) * 10 + j + 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 2][j + 1] == 0 || field[i + 2][j + 1] < 10) {

                                    moves.add((i + 2) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j - 2] == 0 || field[i + 1][j - 2] < 10) {
                                    moves.add((i + 1) * 10 + j - 2);
                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            //kun
                            break;
                            case 13:
                                //strelec
                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j - k] == 0 || field[i + k][j - k] < 10) {

                                            if (field[i + k][j - k] == 0) {
                                                moves.add((i + k) * 10 + j - k);
                                            }
                                            if (field[i + k][j - k] < 10 && field[i + k][j - k] != 0) {
                                                moves.add((i + k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j + k] == 0 || field[i - k][j + k] < 10) {

                                            if (field[i - k][j + k] == 0) {
                                                moves.add((i - k) * 10 + j + k);

                                            }
                                            if (field[i - k][j + k] < 10 && field[i - k][j + k] != 0) {
                                                moves.add((i - k) * 10 + j + k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j + k] == 0 || field[i + k][j + k] < 10) {

                                            if (field[i + k][j + k] == 0) {
                                                moves.add((i + k) * 10 + j + k);

                                            }
                                            if (field[i + k][j + k] < 10 && field[i + k][j + k] != 0) {
                                                moves.add((i + k) * 10 + j + k);
                                                break;

                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j - k] == 0 || field[i - k][j - k] < 10) {

                                            if (field[i - k][j - k] == 0) {
                                                moves.add((i - k) * 10 + j - k);

                                            }
                                            if (field[i - k][j - k] < 10 && field[i - k][j - k] != 0) {
                                                moves.add((i - k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                break;

                            case 14:
                                // vež

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j - k] < 10 || field[i][j - k] == 0) {

                                            if (field[i][j - k] == 0) {
                                                moves.add((i) * 10 + j - k);
                                            }
                                            if (field[i][j - k] < 10 && field[i][j - k] != 0) {
                                                moves.add((i) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j + k] < 10 || field[i][j + k] == 0) {

                                            if (field[i][j + k] == 0) {

                                                moves.add((i) * 10 + j + k);

                                            }
                                            if (field[i][j + k] < 10 && field[i][j + k] != 0) {

                                                moves.add((i) * 10 + j + k);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i - k][j] < 10 || field[i - k][j] == 0) {
                                            if (field[i - k][j] == 0) {
                                                moves.add((i - k) * 10 + j);
                                            }
                                            if (field[i - k][j] < 10 && field[i - k][j] != 0) {
                                                moves.add((i - k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i + k][j] < 10 || field[i + k][j] == 0) {
                                            if (field[i + k][j] == 0) {
                                                moves.add((i + k) * 10 + j);
                                            }
                                            if (field[i + k][j] < 10 && field[i + k][j] != 0) {
                                                moves.add((i + k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                break;
                            case 15:
                                //kralovna
                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j - k] == 0 || field[i + k][j - k] < 10) {

                                            if (field[i + k][j - k] == 0) {
                                                moves.add((i + k) * 10 + j - k);
                                            }
                                            if (field[i + k][j - k] < 10 && field[i + k][j - k] != 0) {
                                                moves.add((i + k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j + k] == 0 || field[i - k][j + k] < 10) {

                                            if (field[i - k][j + k] == 0) {
                                                moves.add((i - k) * 10 + j + k);

                                            }
                                            if (field[i - k][j + k] < 10 && field[i - k][j + k] != 0) {
                                                moves.add((i - k) * 10 + j + k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i + k][j + k] == 0 || field[i + k][j + k] < 10) {

                                            if (field[i + k][j + k] == 0) {
                                                moves.add((i + k) * 10 + j + k);

                                            }
                                            if (field[i + k][j + k] < 10 && field[i + k][j + k] != 0) {
                                                moves.add((i + k) * 10 + j + k);
                                                break;

                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {
                                    try {
                                        if (field[i - k][j - k] == 0 || field[i - k][j - k] < 10) {

                                            if (field[i - k][j - k] == 0) {
                                                moves.add((i - k) * 10 + j - k);

                                            }
                                            if (field[i - k][j - k] < 10 && field[i - k][j - k] != 0) {
                                                moves.add((i - k) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }
                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j - k] < 10 || field[i][j - k] == 0) {

                                            if (field[i][j - k] == 0) {
                                                moves.add((i) * 10 + j - k);
                                            }
                                            if (field[i][j - k] < 10 && field[i][j - k] != 0) {
                                                moves.add((i) * 10 + j - k);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i][j + k] < 10 || field[i][j + k] == 0) {

                                            if (field[i][j + k] == 0) {

                                                moves.add((i) * 10 + j + k);

                                            }
                                            if (field[i][j + k] < 10 && field[i][j + k] != 0) {

                                                moves.add((i) * 10 + j + k);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i - k][j] < 10 || field[i - k][j] == 0) {
                                            if (field[i - k][j] == 0) {
                                                moves.add((i - k) * 10 + j);
                                            }
                                            if (field[i - k][j] < 10 && field[i - k][j] != 0) {
                                                moves.add((i - k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }

                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                for (int k = 1; k < 8; k++) {

                                    try {
                                        if (field[i + k][j] < 10 || field[i + k][j] == 0) {
                                            if (field[i + k][j] == 0) {
                                                moves.add((i + k) * 10 + j);
                                            }
                                            if (field[i + k][j] < 10 && field[i + k][j] != 0) {
                                                moves.add((i + k) * 10 + j);
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    } catch (IndexOutOfBoundsException ex) {
                                    }

                                }

                                break;
                            case 16:
//                kral 
                
                //top
                try {
                                if (field[i - 1][j - 1] == 0 || field[i - 1][j - 1] < 10) {
                                    moves.add((i - 1) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i][j - 1] == 0 || field[i][j - 1] < 10) {
                                    moves.add((i) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j - 1] == 0 || field[i + 1][j - 1] < 10) {
                                    moves.add((i + 1) * 10 + j - 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }

                            //mid
                            try {
                                if (field[i - 1][j] == 0 || field[i - 1][j] < 10) {
                                    moves.add((i - 1) * 10 + j);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j] == 0 || field[i + 1][j] < 10) {
                                    moves.add((i + 1) * 10 + j);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            //bottom
                            try {
                                if (field[i - 1][j + 1] == 0 || field[i - 1][j + 1] < 10) {
                                    moves.add((i - 1) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i][j + 1] == 0 || field[i][j + 1] < 10) {
                                    moves.add((i) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            try {
                                if (field[i + 1][j + 1] == 0 || field[i + 1][j + 1] < 10) {
                                    moves.add((i + 1) * 10 + j + 1);

                                }
                            } catch (IndexOutOfBoundsException ex) {
                            }
                            break;

                        }

                        for (int ii = 0; ii < moves.size(); ii++) {
                            int x = moves.get(ii) / 10;
                            int y = moves.get(ii) % 10;
                            int[][] testfield = new int[8][8];

                            for (int jj = 0; jj < 8; jj++) {
                                for (int k = 0; k < 8; k++) {
                                    testfield[jj][k] = field[jj][k];
                                }
                            }
                            testfield[i][j] = 0;
                            testfield[x][y] = field[i][j];
                            if (blackCheckControl(testfield)) {
                                moves.set(ii, -1);
                            }

                        }
                        //musime overit zda je seznam pohybu je prazdny
                        for (int k = 0; k < moves.size(); k++) {
                            if (moves.get(k) != -1) {
                                return false;
                            }
                        }
                    }

                }

            }

        }

        return true;
    }
;

}
