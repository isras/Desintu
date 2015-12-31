package views;

import controller.resources.Explode;
import controller.resources.PanelPersonalizado;
import controller.service.PetitionService;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PetitionPanel extends javax.swing.JPanel {

    private final PetitionService pts;

    public PetitionPanel() {
        this.pts = new PetitionService();
        initComponents();
        this.chargePetitions();
    }

    private void chargePetitions() {
        if (!this.pts.getPetitionListPerName("petitionOne").isEmpty()) {
            petitionOneBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionOneBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionTwo").isEmpty()) {
            petitionTwoBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionTwoBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionThree").isEmpty()) {
            petitionThreeBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionThreeBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionFour").isEmpty()) {
            petitionFourBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionFourBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionFive").isEmpty()) {
            petitionFiveBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionFiveBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionSix").isEmpty()) {
            petitionSixBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionSixBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionSeven").isEmpty()) {
            petitionSevenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionSevenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionEight").isEmpty()) {
            petitionEightBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionEightBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionNine").isEmpty()) {
            petitionNineBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionNineBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionTen").isEmpty()) {
            petitionTenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionTenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionEleven").isEmpty()) {
            petitionElevenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionElevenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionTwelve").isEmpty()) {
            petitionTwelveBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionTwelveBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionThirteen").isEmpty()) {
            petitionThirTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionThirTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionFourteen").isEmpty()) {
            petitionFourTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionFourTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionFifteen").isEmpty()) {
            petitionFifTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionFifTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionSixteen").isEmpty()) {
            petitionSixTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionSixTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionSeventeen").isEmpty()) {
            petitionSixTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionSixTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
        if (!this.pts.getPetitionListPerName("petitionEightteen").isEmpty()) {
            petitionSixTeenBT.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
            petitionSixTeenBT.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
        }
    }

    private void petitionOptionControl(JButton petitionJB) {
        boolean option;
        PetitionView pv = new PetitionView(null, true, petitionJB.getName());
        pv.setVisible(true);
        option = pv.isOptionFlagBt();
        if (!petitionJB.getName().equals("freeTable")) {
            if (option) {
                petitionJB.setIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModel.png")));
                petitionJB.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/ocupadoModelHover.png")));
            } else {
                System.out.println("AQUI ENTRO CUANDO ES FALSO");
                petitionJB.setIcon(new ImageIcon(getClass().getResource("/images/buttons/libreModel.png")));
                petitionJB.setRolloverIcon(new ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png")));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        petitionFiveBT = new javax.swing.JButton();
        petitionOneBT = new javax.swing.JButton();
        petitionTwoBT = new javax.swing.JButton();
        petitionSixBT = new javax.swing.JButton();
        petitionSevenBT = new javax.swing.JButton();
        petitionThreeBT = new javax.swing.JButton();
        petitionFourBT = new javax.swing.JButton();
        petitionNineBT = new javax.swing.JButton();
        petitionTenBT = new javax.swing.JButton();
        petitionEightBT = new javax.swing.JButton();
        petitionElevenBT = new javax.swing.JButton();
        petitionTwelveBT = new javax.swing.JButton();
        petitionThirTeenBT = new javax.swing.JButton();
        petitionFifTeenBT = new javax.swing.JButton();
        petitionFourTeenBT = new javax.swing.JButton();
        petitionSixTeenBT = new javax.swing.JButton();
        freeTable = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        petitionSevenTeenBT = new javax.swing.JButton();
        petitionEightTeenBT = new javax.swing.JButton();
        tableOptions = new javax.swing.JPopupMenu();
        changeTableToAnother = new javax.swing.JMenuItem();
        addTable = new javax.swing.JMenuItem();
        removeTable = new javax.swing.JMenuItem();
        jPanel2 = new PanelPersonalizado("/images/backgrounds/petitionPanel.png");
        backTablesButton = new javax.swing.JButton();
        nextTablesButton = new javax.swing.JButton();
        chargeTablesBt = new javax.swing.JButton();
        tableContainer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setOpaque(false);

        petitionFiveBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionFiveBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionFiveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionFiveBT.setText("MESA 05");
        petitionFiveBT.setToolTipText("PEDIDO 5");
        petitionFiveBT.setBorderPainted(false);
        petitionFiveBT.setContentAreaFilled(false);
        petitionFiveBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionFiveBT.setName("petitionFive"); // NOI18N
        petitionFiveBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionFiveBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionFiveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionFiveBTActionPerformed(evt);
            }
        });

        petitionOneBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionOneBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionOneBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionOneBT.setText("MESA 01");
        petitionOneBT.setToolTipText("PEDIDO 1");
        petitionOneBT.setBorderPainted(false);
        petitionOneBT.setContentAreaFilled(false);
        petitionOneBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionOneBT.setName("petitionOne"); // NOI18N
        petitionOneBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionOneBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionOneBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                petitionOneBTMousePressed(evt);
            }
        });
        petitionOneBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionOneBTActionPerformed(evt);
            }
        });

        petitionTwoBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionTwoBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionTwoBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionTwoBT.setText("MESA 02");
        petitionTwoBT.setToolTipText("PEDIDO 2");
        petitionTwoBT.setBorderPainted(false);
        petitionTwoBT.setContentAreaFilled(false);
        petitionTwoBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionTwoBT.setName("petitionTwo"); // NOI18N
        petitionTwoBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionTwoBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionTwoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionTwoBTActionPerformed(evt);
            }
        });

        petitionSixBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionSixBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionSixBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionSixBT.setText("MESA 06");
        petitionSixBT.setToolTipText("PEDIDO 6");
        petitionSixBT.setBorderPainted(false);
        petitionSixBT.setContentAreaFilled(false);
        petitionSixBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionSixBT.setName("petitionSix"); // NOI18N
        petitionSixBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionSixBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionSixBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionSixBTActionPerformed(evt);
            }
        });

        petitionSevenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionSevenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionSevenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionSevenBT.setText("MESA 07");
        petitionSevenBT.setToolTipText("PEDIDO 7");
        petitionSevenBT.setBorderPainted(false);
        petitionSevenBT.setContentAreaFilled(false);
        petitionSevenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionSevenBT.setName("petitionSeven"); // NOI18N
        petitionSevenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionSevenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionSevenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionSevenBTActionPerformed(evt);
            }
        });

        petitionThreeBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionThreeBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionThreeBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionThreeBT.setText("MESA 03");
        petitionThreeBT.setToolTipText("PEDIDO 3");
        petitionThreeBT.setBorderPainted(false);
        petitionThreeBT.setContentAreaFilled(false);
        petitionThreeBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionThreeBT.setName("petitionThree"); // NOI18N
        petitionThreeBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionThreeBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionThreeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionThreeBTActionPerformed(evt);
            }
        });

        petitionFourBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionFourBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionFourBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionFourBT.setText("MESA 04");
        petitionFourBT.setToolTipText("PEDIDO 4");
        petitionFourBT.setBorderPainted(false);
        petitionFourBT.setContentAreaFilled(false);
        petitionFourBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionFourBT.setName("petitionFour"); // NOI18N
        petitionFourBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionFourBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionFourBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionFourBTActionPerformed(evt);
            }
        });

        petitionNineBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionNineBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionNineBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionNineBT.setText("MESA 09");
        petitionNineBT.setToolTipText("PEDIDO 9");
        petitionNineBT.setBorderPainted(false);
        petitionNineBT.setContentAreaFilled(false);
        petitionNineBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionNineBT.setName("petitionNine"); // NOI18N
        petitionNineBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionNineBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionNineBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionNineBTActionPerformed(evt);
            }
        });

        petitionTenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionTenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionTenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionTenBT.setText("MESA 10");
        petitionTenBT.setToolTipText("PEDIDO 10");
        petitionTenBT.setBorderPainted(false);
        petitionTenBT.setContentAreaFilled(false);
        petitionTenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionTenBT.setName("petitionTen"); // NOI18N
        petitionTenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionTenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionTenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionTenBTActionPerformed(evt);
            }
        });

        petitionEightBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionEightBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionEightBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionEightBT.setText("MESA 08");
        petitionEightBT.setToolTipText("PEDIDO 8");
        petitionEightBT.setBorderPainted(false);
        petitionEightBT.setContentAreaFilled(false);
        petitionEightBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionEightBT.setName("petitionEight"); // NOI18N
        petitionEightBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionEightBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionEightBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionEightBTActionPerformed(evt);
            }
        });

        petitionElevenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionElevenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionElevenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionElevenBT.setText("MESA 11");
        petitionElevenBT.setToolTipText("PEDIDO 11");
        petitionElevenBT.setBorderPainted(false);
        petitionElevenBT.setContentAreaFilled(false);
        petitionElevenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionElevenBT.setName("petitionEleven"); // NOI18N
        petitionElevenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionElevenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionElevenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionElevenBTActionPerformed(evt);
            }
        });

        petitionTwelveBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionTwelveBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionTwelveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionTwelveBT.setText("MESA 12");
        petitionTwelveBT.setToolTipText("PEDIDO 12");
        petitionTwelveBT.setBorderPainted(false);
        petitionTwelveBT.setContentAreaFilled(false);
        petitionTwelveBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionTwelveBT.setName("petitionTwelve"); // NOI18N
        petitionTwelveBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionTwelveBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionTwelveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionTwelveBTActionPerformed(evt);
            }
        });

        petitionThirTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionThirTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionThirTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionThirTeenBT.setText("MESA 13");
        petitionThirTeenBT.setToolTipText("PEDIDO 13");
        petitionThirTeenBT.setBorderPainted(false);
        petitionThirTeenBT.setContentAreaFilled(false);
        petitionThirTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionThirTeenBT.setName("petitionThirteen"); // NOI18N
        petitionThirTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionThirTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionThirTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionThirTeenBTActionPerformed(evt);
            }
        });

        petitionFifTeenBT.setBackground(new java.awt.Color(255, 255, 255));
        petitionFifTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionFifTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionFifTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionFifTeenBT.setText("MESA 15");
        petitionFifTeenBT.setToolTipText("PEDIDO 15");
        petitionFifTeenBT.setBorderPainted(false);
        petitionFifTeenBT.setContentAreaFilled(false);
        petitionFifTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionFifTeenBT.setName("petitionFifteen"); // NOI18N
        petitionFifTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionFifTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionFifTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionFifTeenBTActionPerformed(evt);
            }
        });

        petitionFourTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionFourTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionFourTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionFourTeenBT.setText("MESA 14");
        petitionFourTeenBT.setToolTipText("PEDIDIO 14");
        petitionFourTeenBT.setBorderPainted(false);
        petitionFourTeenBT.setContentAreaFilled(false);
        petitionFourTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionFourTeenBT.setName("petitionFourteen"); // NOI18N
        petitionFourTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionFourTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionFourTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionFourTeenBTActionPerformed(evt);
            }
        });

        petitionSixTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionSixTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionSixTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionSixTeenBT.setText("MESA 16");
        petitionSixTeenBT.setToolTipText("PEDIDO 16");
        petitionSixTeenBT.setBorderPainted(false);
        petitionSixTeenBT.setContentAreaFilled(false);
        petitionSixTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionSixTeenBT.setName("petitionSixteen"); // NOI18N
        petitionSixTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionSixTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionSixTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionSixTeenBTActionPerformed(evt);
            }
        });

        freeTable.setText("LIBRE");
        freeTable.setName("freeTable"); // NOI18N
        freeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(petitionOneBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(petitionTwoBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(petitionThreeBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(petitionSixBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(petitionSevenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(petitionElevenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(petitionTenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(petitionFourTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(petitionFifTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(petitionFiveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(petitionNineBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(petitionThirTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(petitionFourBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(petitionEightBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(petitionTwelveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(petitionSixTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(freeTable)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(petitionFiveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petitionNineBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petitionThirTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(petitionTwoBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petitionSixBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(petitionFourTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(petitionTenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(petitionThreeBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(petitionSevenBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(petitionFifTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(petitionElevenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(petitionOneBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(freeTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(petitionTwelveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(petitionSixTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(petitionEightBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(petitionFourBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        jPanel3.setOpaque(false);

        petitionSevenTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionSevenTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionSevenTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionSevenTeenBT.setText("MESA 17");
        petitionSevenTeenBT.setToolTipText("PEDIDO 17");
        petitionSevenTeenBT.setBorderPainted(false);
        petitionSevenTeenBT.setContentAreaFilled(false);
        petitionSevenTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionSevenTeenBT.setName("petitionSeventeen"); // NOI18N
        petitionSevenTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionSevenTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionSevenTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionSevenTeenBTActionPerformed(evt);
            }
        });

        petitionEightTeenBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        petitionEightTeenBT.setForeground(new java.awt.Color(255, 255, 255));
        petitionEightTeenBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModel.png"))); // NOI18N
        petitionEightTeenBT.setText("MESA 18");
        petitionEightTeenBT.setToolTipText("PEDIDO 18");
        petitionEightTeenBT.setBorderPainted(false);
        petitionEightTeenBT.setContentAreaFilled(false);
        petitionEightTeenBT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        petitionEightTeenBT.setName("petitionEightteen"); // NOI18N
        petitionEightTeenBT.setPreferredSize(new java.awt.Dimension(96, 95));
        petitionEightTeenBT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/libreModelHover.png"))); // NOI18N
        petitionEightTeenBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petitionEightTeenBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(petitionEightTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(petitionSevenTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(petitionSevenTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(petitionEightTeenBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        tableOptions.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                tableOptionsPopupMenuWillBecomeVisible(evt);
            }
        });

        changeTableToAnother.setText("Cambiar Mesa");
        tableOptions.add(changeTableToAnother);

        addTable.setText("Añadir Mesa");
        tableOptions.add(addTable);

        removeTable.setText("Eliminar Mesa");
        tableOptions.add(removeTable);

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(691, 528));

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(691, 528));
        jPanel2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel2ComponentAdded(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        backTablesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/backButton.png"))); // NOI18N
        backTablesButton.setBorderPainted(false);
        backTablesButton.setContentAreaFilled(false);
        backTablesButton.setFocusable(false);
        backTablesButton.setPreferredSize(new java.awt.Dimension(27, 25));
        backTablesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/backButtonHover.png"))); // NOI18N
        backTablesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTablesButtonActionPerformed(evt);
            }
        });

        nextTablesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/nextButton.png"))); // NOI18N
        nextTablesButton.setBorderPainted(false);
        nextTablesButton.setContentAreaFilled(false);
        nextTablesButton.setFocusable(false);
        nextTablesButton.setPreferredSize(new java.awt.Dimension(24, 24));
        nextTablesButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/nextButtonHover.png"))); // NOI18N
        nextTablesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTablesButtonActionPerformed(evt);
            }
        });

        chargeTablesBt.setBackground(new java.awt.Color(51, 0, 255));
        chargeTablesBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/chargeTableButton.png"))); // NOI18N
        chargeTablesBt.setBorderPainted(false);
        chargeTablesBt.setContentAreaFilled(false);
        chargeTablesBt.setFocusable(false);
        chargeTablesBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chargeTablesBt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/chargeTableButtonHover.png"))); // NOI18N
        chargeTablesBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeTablesBtActionPerformed(evt);
            }
        });

        tableContainer.setOpaque(false);

        javax.swing.GroupLayout tableContainerLayout = new javax.swing.GroupLayout(tableContainer);
        tableContainer.setLayout(tableContainerLayout);
        tableContainerLayout.setHorizontalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableContainerLayout.setVerticalGroup(
            tableContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newTableButton.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/newTableButtonHover.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chargeTablesBt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backTablesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextTablesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addComponent(tableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backTablesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chargeTablesBt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nextTablesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void petitionFourBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionFourBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionFourBT);
    }//GEN-LAST:event_petitionFourBTActionPerformed

    private void petitionOneBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionOneBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionOneBT);
    }//GEN-LAST:event_petitionOneBTActionPerformed

    private void petitionSixBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionSixBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionSixBT);
    }//GEN-LAST:event_petitionSixBTActionPerformed

    private void petitionTwoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionTwoBTActionPerformed
        // TODO add your handling code here:      
        this.petitionOptionControl(petitionTwoBT);
    }//GEN-LAST:event_petitionTwoBTActionPerformed

    private void petitionThreeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionThreeBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionThreeBT);
    }//GEN-LAST:event_petitionThreeBTActionPerformed

    private void petitionSevenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionSevenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionSevenBT);
    }//GEN-LAST:event_petitionSevenBTActionPerformed

    private void petitionFiveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionFiveBTActionPerformed
        // TODO add your handling code here:        
        this.petitionOptionControl(petitionFiveBT);
    }//GEN-LAST:event_petitionFiveBTActionPerformed

    private void petitionEightBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionEightBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionEightBT);
    }//GEN-LAST:event_petitionEightBTActionPerformed

    private void petitionNineBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionNineBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionNineBT);
    }//GEN-LAST:event_petitionNineBTActionPerformed

    private void petitionTenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionTenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionTenBT);
    }//GEN-LAST:event_petitionTenBTActionPerformed

    private void petitionElevenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionElevenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionElevenBT);
    }//GEN-LAST:event_petitionElevenBTActionPerformed

    private void petitionTwelveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionTwelveBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionTwelveBT);
    }//GEN-LAST:event_petitionTwelveBTActionPerformed

    private void petitionThirTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionThirTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionThirTeenBT);
    }//GEN-LAST:event_petitionThirTeenBTActionPerformed

    private void petitionFourTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionFourTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionFourTeenBT);
    }//GEN-LAST:event_petitionFourTeenBTActionPerformed

    private void petitionFifTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionFifTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionFifTeenBT);
    }//GEN-LAST:event_petitionFifTeenBTActionPerformed

    private void petitionSixTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionSixTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionSixTeenBT);
    }//GEN-LAST:event_petitionSixTeenBTActionPerformed

    private void freeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeTableActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(freeTable);
    }//GEN-LAST:event_freeTableActionPerformed

    private void petitionEightTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionEightTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionEightTeenBT);
    }//GEN-LAST:event_petitionEightTeenBTActionPerformed

    private void petitionSevenTeenBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petitionSevenTeenBTActionPerformed
        // TODO add your handling code here:
        this.petitionOptionControl(petitionSevenTeenBT);
    }//GEN-LAST:event_petitionSevenTeenBTActionPerformed

    private void nextTablesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTablesButtonActionPerformed
        // TODO add your handling code here:
        new Explode(tableContainer, jPanel3).play();
    }//GEN-LAST:event_nextTablesButtonActionPerformed

    private void chargeTablesBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeTablesBtActionPerformed
        // TODO add your handling code here:
        new Explode(tableContainer, jPanel1).play();
    }//GEN-LAST:event_chargeTablesBtActionPerformed

    private void backTablesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTablesButtonActionPerformed
        // TODO add your handling code here:
        new Explode(tableContainer, jPanel1).play();
    }//GEN-LAST:event_backTablesButtonActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void tableOptionsPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_tableOptionsPopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_tableOptionsPopupMenuWillBecomeVisible

    private void jPanel2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel2ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentAdded

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        if(evt.getButton() == MouseEvent.BUTTON3){
            removeTable.setEnabled(false);
            addTable.setEnabled(true);
            changeTableToAnother.setEnabled(false);
            tableOptions.show(evt.getComponent(), evt.getX(), evt.getY());
            tableOptions.setVisible(true);
        }
    }//GEN-LAST:event_jPanel2MousePressed

    private void tableOptionsPopup(java.awt.event.MouseEvent evt){
        if(evt.getButton() == MouseEvent.BUTTON3){
            removeTable.setEnabled(true);
            addTable.setEnabled(false);
            changeTableToAnother.setEnabled(true);
            tableOptions.show(evt.getComponent(), evt.getX(), evt.getY());
            tableOptions.setVisible(true);
        }
    }
    
    private void petitionOneBTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petitionOneBTMousePressed
        // TODO add your handling code here:
        this.tableOptionsPopup(evt);
    }//GEN-LAST:event_petitionOneBTMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addTable;
    private javax.swing.JButton backTablesButton;
    private javax.swing.JMenuItem changeTableToAnother;
    private javax.swing.JButton chargeTablesBt;
    private javax.swing.JButton freeTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton nextTablesButton;
    public javax.swing.JButton petitionEightBT;
    public javax.swing.JButton petitionEightTeenBT;
    public javax.swing.JButton petitionElevenBT;
    public javax.swing.JButton petitionFifTeenBT;
    public javax.swing.JButton petitionFiveBT;
    public javax.swing.JButton petitionFourBT;
    public javax.swing.JButton petitionFourTeenBT;
    public javax.swing.JButton petitionNineBT;
    public javax.swing.JButton petitionOneBT;
    public javax.swing.JButton petitionSevenBT;
    public javax.swing.JButton petitionSevenTeenBT;
    public javax.swing.JButton petitionSixBT;
    public javax.swing.JButton petitionSixTeenBT;
    public javax.swing.JButton petitionTenBT;
    public javax.swing.JButton petitionThirTeenBT;
    public javax.swing.JButton petitionThreeBT;
    public javax.swing.JButton petitionTwelveBT;
    public javax.swing.JButton petitionTwoBT;
    private javax.swing.JMenuItem removeTable;
    private javax.swing.JPanel tableContainer;
    private javax.swing.JPopupMenu tableOptions;
    // End of variables declaration//GEN-END:variables
}
