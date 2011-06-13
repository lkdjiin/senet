package senet;

import gameboard2d.GameBoard2D;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.JOptionPane;
import senet.dialog.DialogAbout;
import senet.game.element.*;
import senet.utils.ColorUtils;

/**
 * The main GUI. Keep all logic out of this file.
 */
public class UI extends javax.swing.JFrame {

    private static final String WHITE_PIECE = "white";
    private static final String BLACK_PIECE = "black";
    private static final String SELECTED_BOX = "selected box";

    private Controller controller;
    private GameBoard2D gb2d;
    private SticksPanel sticksPanel;

    /**
     * Sole constructor.
     */
    public UI() {
        initComponents();
        panelContainer.setBackground(new Color(201,193,146));
        labelSticksResult.setText(" ");
        
        try {
            sticksPanel = new SticksPanel();

            gb2d = new GameBoard2D();
            gb2d.setBoard(new File("images/board.jpg"), new File("images/board-cache.png"));

            gb2d.addBox(1, ColorUtils.gray(0), new Point(15,25));
            gb2d.addBox(2, ColorUtils.gray(5), new Point(85,25));
            gb2d.addBox(3, ColorUtils.gray(10), new Point(150,25));
            gb2d.addBox(4, ColorUtils.gray(15), new Point(215,25));
            gb2d.addBox(5, ColorUtils.gray(20), new Point(285,25));
            gb2d.addBox(6, ColorUtils.gray(25), new Point(350,25));
            gb2d.addBox(7, ColorUtils.gray(30), new Point(415,25));
            gb2d.addBox(8, ColorUtils.gray(35), new Point(480,25));
            gb2d.addBox(9, ColorUtils.gray(40), new Point(545,25));
            gb2d.addBox(10, ColorUtils.gray(45), new Point(610,25));
            gb2d.addBox(11, ColorUtils.gray(50), new Point(610,90));
            gb2d.addBox(12, ColorUtils.gray(55), new Point(545,90));
            gb2d.addBox(13, ColorUtils.gray(60), new Point(480,90));
            gb2d.addBox(14, ColorUtils.gray(65), new Point(415,90));
            gb2d.addBox(15, ColorUtils.gray(70), new Point(350,90));
            gb2d.addBox(16, ColorUtils.gray(75), new Point(285,90));
            gb2d.addBox(17, ColorUtils.gray(80), new Point(215,90));
            gb2d.addBox(18, ColorUtils.gray(85), new Point(150,90));
            gb2d.addBox(19, ColorUtils.gray(90), new Point(85,90));
            gb2d.addBox(20, ColorUtils.gray(95), new Point(15, 90));
            gb2d.addBox(21, ColorUtils.gray(100), new Point(15,155));
            gb2d.addBox(22, ColorUtils.gray(105), new Point(85,155));
            gb2d.addBox(23, ColorUtils.gray(110), new Point(150,155));
            gb2d.addBox(24, ColorUtils.gray(115), new Point(215,155));
            gb2d.addBox(25, ColorUtils.gray(120), new Point(285,155));
            gb2d.addBox(26, ColorUtils.gray(125), new Point(350,155));
            gb2d.addBox(27, ColorUtils.gray(130), new Point(415,155));
            gb2d.addBox(28, ColorUtils.gray(135), new Point(480,155));
            gb2d.addBox(29, ColorUtils.gray(140), new Point(545,155));
            gb2d.addBox(30, ColorUtils.gray(145), new Point(610,155));

            gb2d.addPiece(WHITE_PIECE, new File("images/white.png"));
            gb2d.addPiece(BLACK_PIECE, new File("images/black.png"));
            gb2d.addPiece(SELECTED_BOX, new File("images/selected-box.png"));
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        panelBoard.add(gb2d);
        gb2d.drawBoard();
        panelSticks.add(sticksPanel);
        sticksPanel.clear();
        setTitle("Senet " + ApplicationVersion.VERSION);
    }

    /**
     * Set the controller, from where we get messages and to
     * where we send messages.
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Run the event queue and display the UI.
     */
    public void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        panelBoard = new javax.swing.JPanel();
        labelSticksResult = new javax.swing.JLabel();
        btThrowSticks = new javax.swing.JButton();
        labelTurn = new javax.swing.JLabel();
        btMoveOut = new javax.swing.JButton();
        panelSticks = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileNewGameTwoPlayers = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuFileQuit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelpRules = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuHelpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContainer.setBackground(new java.awt.Color(201, 193, 146));

        panelBoard.setBackground(new java.awt.Color(1, 126, 155));
        panelBoard.setPreferredSize(new java.awt.Dimension(682, 237));
        panelBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBoardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBoardLayout = new javax.swing.GroupLayout(panelBoard);
        panelBoard.setLayout(panelBoardLayout);
        panelBoardLayout.setHorizontalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        panelBoardLayout.setVerticalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        labelSticksResult.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
        labelSticksResult.setText("jLabel1");

        btThrowSticks.setText("Throw sticks");
        btThrowSticks.setEnabled(false);
        btThrowSticks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThrowSticksActionPerformed(evt);
            }
        });

        labelTurn.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
        labelTurn.setText("Player's Turn");

        btMoveOut.setText("Move out");
        btMoveOut.setEnabled(false);
        btMoveOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveOutActionPerformed(evt);
            }
        });

        panelSticks.setBackground(new java.awt.Color(201, 193, 146));
        panelSticks.setBorder(null);
        panelSticks.setPreferredSize(new java.awt.Dimension(145, 150));

        javax.swing.GroupLayout panelSticksLayout = new javax.swing.GroupLayout(panelSticks);
        panelSticks.setLayout(panelSticksLayout);
        panelSticksLayout.setHorizontalGroup(
            panelSticksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        panelSticksLayout.setVerticalGroup(
            panelSticksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addComponent(labelTurn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSticks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSticksResult)
                            .addGroup(panelContainerLayout.createSequentialGroup()
                                .addComponent(btThrowSticks)
                                .addGap(18, 18, 18)
                                .addComponent(btMoveOut)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContainerLayout.createSequentialGroup()
                        .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTurn)
                            .addComponent(btMoveOut)
                            .addComponent(btThrowSticks))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSticksResult))
                    .addComponent(panelSticks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuFile.setText("File");

        menuFileNewGameTwoPlayers.setText("New Game Two Players...");
        menuFileNewGameTwoPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewGameTwoPlayersActionPerformed(evt);
            }
        });
        menuFile.add(menuFileNewGameTwoPlayers);
        menuFile.add(jSeparator1);

        menuFileQuit.setText("Quit Game");
        menuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileQuitActionPerformed(evt);
            }
        });
        menuFile.add(menuFileQuit);

        jMenuBar1.add(menuFile);

        menuHelp.setText("Help");

        menuHelpRules.setText("Rules");
        menuHelp.add(menuHelpRules);
        menuHelp.add(jSeparator2);

        menuHelpAbout.setText("About");
        menuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHelpAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuHelpAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Player clicks the button to throw sticks.
     */
    private void btThrowSticksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThrowSticksActionPerformed
        controller.throwTheSticks();
    }//GEN-LAST:event_btThrowSticksActionPerformed

    /**
     * Player wants a new game.
     */
    private void menuFileNewGameTwoPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewGameTwoPlayersActionPerformed
        controller.newGameTwoPlayersClicked();
    }//GEN-LAST:event_menuFileNewGameTwoPlayersActionPerformed

    /**
     * Player clicks into the board game.
     */
    private void panelBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBoardMouseClicked
        try {
            int id = gb2d.getBoxId(evt.getPoint());
            if(evt.getButton() == MouseEvent.BUTTON1)
                controller.boxClicked(id);
            else if (evt.getButton() == MouseEvent.BUTTON3)
                controller.deselect(id);
        } catch (ArrayIndexOutOfBoundsException ex) {
            
        }
    }//GEN-LAST:event_panelBoardMouseClicked

    private void btMoveOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveOutActionPerformed
        controller.buttonMoveOutClicked();
    }//GEN-LAST:event_btMoveOutActionPerformed

    private void menuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuFileQuitActionPerformed

    private void menuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHelpAboutActionPerformed
        DialogAbout dialogAbout = new DialogAbout(this, true);
    }//GEN-LAST:event_menuHelpAboutActionPerformed

    /**
     * Show the result of threw to the player(s).
     * @param result the number to show
     */
    public void displaySticksResult(Integer[] detail, int total) {
        labelSticksResult.setText("" + total);
        sticksPanel.draw(detail);
    }

    /**
     * Ask player for a name through a dialog box.
     * @param question the question displayed in the dialog box.
     * @param defaultAnswer the default name
     * @return a name or null if player canceled the dialog
     */
    public String getPlayerName(String question, String defaultAnswer) {
        return JOptionPane.showInputDialog(this, question, defaultAnswer);
    }

    /**
     * Show what turn is it.
     * @param text the text to show
     */
    public void setTurn(String text) {
        labelTurn.setText(text);
    }

    /**
     * Display the board and its pieces.
     * @param board the board object to show
     */
    public void displayBoard(Board board) {
        gb2d.drawBoard();
        for(int i = 1; i <= 30; i++) {
            if(board.getBoxContent(i) == Board.BOX_BLACK) {
                gb2d.drawPiece(BLACK_PIECE, i);
            } else if(board.getBoxContent(i) == Board.BOX_WHITE) {
                gb2d.drawPiece(WHITE_PIECE, i);
            }
        }
    }

    /**
     * Highligth a box to mark it as selected by the player.
     * @param board the board object to show
     * @param id the selected box id
     */
    public void setBoxSelected(Board board, int id) {
        displayBoard(board);
        gb2d.drawPieceOnTop(SELECTED_BOX, id);
    }

    /**
     * Enabled or disabled the button for throwing sticks.
     * @param value true enable the button, false disable it
     */
    public void enableThrowing(boolean value) {
        btThrowSticks.setEnabled(value);
        if(value) {
            labelSticksResult.setText(" ");
            sticksPanel.clear();
        }
    }

    public void mayMoveOut() {
        btMoveOut.setEnabled(true);
    }

    public void cannotMoveOut() {
        btMoveOut.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMoveOut;
    private javax.swing.JButton btThrowSticks;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelSticksResult;
    private javax.swing.JLabel labelTurn;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileNewGameTwoPlayers;
    private javax.swing.JMenuItem menuFileQuit;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelpAbout;
    private javax.swing.JMenuItem menuHelpRules;
    private javax.swing.JPanel panelBoard;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelSticks;
    // End of variables declaration//GEN-END:variables

}
