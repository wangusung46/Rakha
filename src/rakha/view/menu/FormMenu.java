package rakha.view.menu;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FormMenu extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public FormMenu() {
        initComponents();
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public JMenuItem getjMenuItemAddSell() {
        return jMenuItemAddSell;
    }

    public void setjMenuItemAddSell(JMenuItem jMenuItemAddSell) {
        this.jMenuItemAddSell = jMenuItemAddSell;
    }

    public JMenuItem getjMenuItemLogOff() {
        return jMenuItemLogOff;
    }

    public void setjMenuItemLogOff(JMenuItem jMenuItemLogOff) {
        this.jMenuItemLogOff = jMenuItemLogOff;
    }

    public JMenuItem getjMenuItemLogOff1() {
        return jMenuItemLogOff1;
    }

    public void setjMenuItemLogOff1(JMenuItem jMenuItemLogOff1) {
        this.jMenuItemLogOff1 = jMenuItemLogOff1;
    }

    public JMenuItem getjMenuItemUpdateSell() {
        return jMenuItemUpdateSell;
    }

    public void setjMenuItemUpdateSell(JMenuItem jMenuItemUpdateSell) {
        this.jMenuItemUpdateSell = jMenuItemUpdateSell;
    }

    public JMenu getjMenuOperator() {
        return jMenuOperator;
    }

    public void setjMenuOperator(JMenu jMenuOperator) {
        this.jMenuOperator = jMenuOperator;
    }

    public JMenu getjMenuSallesAdd() {
        return jMenuSallesAdd;
    }

    public void setjMenuSallesAdd(JMenu jMenuSallesAdd) {
        this.jMenuSallesAdd = jMenuSallesAdd;
    }

    public JMenu getjMenuSallesUpdate() {
        return jMenuSallesUpdate;
    }

    public void setjMenuSallesUpdate(JMenu jMenuSallesUpdate) {
        this.jMenuSallesUpdate = jMenuSallesUpdate;
    }

    public JMenu getjMenuSuper() {
        return jMenuSuper;
    }

    public void setjMenuSuper(JMenu jMenuSuper) {
        this.jMenuSuper = jMenuSuper;
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelHeader = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanelFooter = new javax.swing.JPanel();
        jLabelFooter = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOperator = new javax.swing.JMenu();
        jMenuItemLogOff = new javax.swing.JMenuItem();
        jMenuSuper = new javax.swing.JMenu();
        jMenuItemLogOff1 = new javax.swing.JMenuItem();
        jMenuSallesAdd = new javax.swing.JMenu();
        jMenuItemAddSell = new javax.swing.JMenuItem();
        jMenuSallesUpdate = new javax.swing.JMenu();
        jMenuItemUpdateSell = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanelHeader.setLayout(new java.awt.GridLayout(1, 0));

        jLabelHeader.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("Toko PC");
        jPanelHeader.add(jLabelHeader);

        jPanel1.add(jPanelHeader);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jPanel2);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(956, 400));
        jDesktopPane1.setLayout(new javax.swing.BoxLayout(jDesktopPane1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jDesktopPane1);

        jPanelFooter.setLayout(new java.awt.GridLayout(1, 0));

        jLabelFooter.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFooter.setText("Selamat Datang");
        jPanelFooter.add(jLabelFooter);

        jPanel1.add(jPanelFooter);

        getContentPane().add(jPanel1);

        jMenuOperator.setText("Operator");

        jMenuItemLogOff.setText("Log Off");
        jMenuOperator.add(jMenuItemLogOff);

        jMenuBar1.add(jMenuOperator);

        jMenuSuper.setText("Supervisor");

        jMenuItemLogOff1.setText("Log Off");
        jMenuSuper.add(jMenuItemLogOff1);

        jMenuBar1.add(jMenuSuper);

        jMenuSallesAdd.setText("Sales Entry");

        jMenuItemAddSell.setText("Add Sell");
        jMenuSallesAdd.add(jMenuItemAddSell);

        jMenuBar1.add(jMenuSallesAdd);

        jMenuSallesUpdate.setText("Sales Entry");

        jMenuItemUpdateSell.setText("Uppdate Sell");
        jMenuSallesUpdate.add(jMenuItemUpdateSell);

        jMenuBar1.add(jMenuSallesUpdate);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFooter;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAddSell;
    private javax.swing.JMenuItem jMenuItemLogOff;
    private javax.swing.JMenuItem jMenuItemLogOff1;
    private javax.swing.JMenuItem jMenuItemUpdateSell;
    private javax.swing.JMenu jMenuOperator;
    private javax.swing.JMenu jMenuSallesAdd;
    private javax.swing.JMenu jMenuSallesUpdate;
    private javax.swing.JMenu jMenuSuper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    // End of variables declaration//GEN-END:variables

}
