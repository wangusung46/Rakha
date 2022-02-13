package rakha.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rakha.combobox.ComboItems;
import rakha.model.transaction.Buy;
import rakha.model.transaction.BuyJdbc;
import rakha.model.transaction.BuyJdbcImplement;
import rakha.model.transaction.Sell;
import rakha.model.transaction.SellJdbc;
import rakha.model.transaction.SellJdbcImplement;
import rakha.view.transaction.FormUpdateSell;

/**
 *
 * @author Khanza
 */
class ControllerUpdateSell {

    private final SellJdbc sellJdbc;
    private final BuyJdbc buyJdbc;
    private Boolean clickTable;

    public ControllerUpdateSell() {
        sellJdbc = new SellJdbcImplement();
        buyJdbc = new BuyJdbcImplement();
    }

    void initController(FormUpdateSell formUpdateSell) {

        DefaultTableModel defaultTableModelSell = new DefaultTableModel();
        formUpdateSell.getjTableSell().setModel(defaultTableModelSell);
        defaultTableModelSell.addColumn("ID");
        defaultTableModelSell.addColumn("Barang");
        defaultTableModelSell.addColumn("Jumlah Jual");
        defaultTableModelSell.addColumn("Harga Jual");
        defaultTableModelSell.addColumn("Total");
        defaultTableModelSell.addColumn("Cash");

        formUpdateSell.getjTableSell().getColumnModel().getColumn(0).setMinWidth(0);
        formUpdateSell.getjTableSell().getColumnModel().getColumn(0).setMaxWidth(0);

        loadItem(formUpdateSell);

        setItem(formUpdateSell);

        loadTableSell(defaultTableModelSell);

        formUpdateSell.getjComboBoxName().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setItem(formUpdateSell);
            }
        });

        formUpdateSell.getjButtonUpdate().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performUpdate(formUpdateSell, defaultTableModelSell);
            }
        });
        
        formUpdateSell.getjButtonDelete().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performDelete(formUpdateSell, defaultTableModelSell);
            }
        });

        formUpdateSell.getjButtonCountPayment().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!formUpdateSell.getjTextFieldTotalSell().getText().isEmpty()) {
                    formUpdateSell.getjTextFieldPayment1().setText(String.valueOf(
                            Integer.parseInt(formUpdateSell.getjTextFieldTotalSell().getText())
                            * Integer.parseInt(formUpdateSell.getjTextFieldPriceTotal().getText())
                    ));
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formUpdateSell.getjButtonCountPayment1().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!formUpdateSell.getjTextFieldTotal().getText().isEmpty()) {
                    formUpdateSell.getjTextFieldChange().setText(String.valueOf(
                            Integer.parseInt(formUpdateSell.getjTextFieldTotal().getText())
                            - Integer.parseInt(formUpdateSell.getjTextFieldPayment1().getText())
                    ));
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formUpdateSell.getjTableSell().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                clickTable = true;
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void loadItem(FormUpdateSell formUpdateSell) {
        List<Buy> buys = buyJdbc.selectBuys();
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        buys.forEach(buy -> {
            defaultComboBoxModel.addElement(new ComboItems(buy.getId(), buy.getNameitem()));
        });
        formUpdateSell.getjComboBoxName().setModel(defaultComboBoxModel);
    }

    private void setItem(FormUpdateSell formUpdateSell) {
        Buy buy = buyJdbc.selectBuy(((ComboItems) formUpdateSell.getjComboBoxName().getSelectedItem()).getKey());
        formUpdateSell.getjTextFieldPriceTotal().setText(buy.getSellPrice().toString());
        formUpdateSell.getjTextFieldAmountBuy().setText(buy.getCountItem().toString());
    }

    private void loadTableSell(DefaultTableModel defaultTableModelSell) {
        defaultTableModelSell.getDataVector().removeAllElements();
        defaultTableModelSell.fireTableDataChanged();
        List<Sell> sells = sellJdbc.selectSells();
        Object[] objects = new Object[6];
        for (Sell sell : sells) {
            objects[0] = sell.getId();
            objects[1] = sell.getName();
            objects[2] = sell.getSellAmount();
            objects[3] = sell.getSellPrice();
            objects[4] = new BigDecimal(sell.getSellAmount() * sell.getSellPrice().intValue());
            objects[5] = sell.getCash();
            defaultTableModelSell.addRow(objects);
        }
        clickTable = false;
    }

    private void performSave(FormUpdateSell formUpdateSell, DefaultTableModel defaultTableModelSell) {
        Sell sell = new Sell();
        sell.setId(0L);
        sell.setIdBuy(((ComboItems) formUpdateSell.getjComboBoxName().getSelectedItem()).getKey());
        sell.setSellAmount(Integer.parseInt(formUpdateSell.getjTextFieldTotalSell().getText()));
        sell.setCash(new BigDecimal(formUpdateSell.getjTextFieldTotal().getText()));
        sellJdbc.insertSell(sell);
        loadTableSell(defaultTableModelSell);
        JOptionPane.showMessageDialog(null, "Berhasil menyimpan data", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void performUpdate(FormUpdateSell formUpdateSell, DefaultTableModel defaultTableModel) {
        if (clickTable) {
            Sell sell = new Sell();
            sell.setId(Long.parseLong(defaultTableModel.getValueAt(formUpdateSell.getjTableSell().getSelectedRow(), 0).toString()));
            sell.setIdBuy(((ComboItems) formUpdateSell.getjComboBoxName().getSelectedItem()).getKey());
            sell.setSellAmount(Integer.parseInt(formUpdateSell.getjTextFieldTotalSell().getText()));
            sell.setCash(new BigDecimal(formUpdateSell.getjTextFieldTotal().getText()));
            sellJdbc.updateSell(sell);
            loadTableSell(defaultTableModel);
            empty(formUpdateSell);
            JOptionPane.showMessageDialog(null, "Berhasil merubah data", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Hapus atau edit harus klik tabel", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void performDelete(FormUpdateSell formUpdateSell, DefaultTableModel defaultTableModel) {
        if (clickTable) {
            if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data dengan id " + defaultTableModel.getValueAt(formUpdateSell.getjTableSell().getSelectedRow(), 0).toString() + " ?", "Warning", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                sellJdbc.deleteSell(Long.parseLong(defaultTableModel.getValueAt(formUpdateSell.getjTableSell().getSelectedRow(), 0).toString()));
                loadTableSell(defaultTableModel);
                empty(formUpdateSell);
                JOptionPane.showMessageDialog(null, "Berhasil manghapus data", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hapus atau edit harus klik tabel", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void empty(FormUpdateSell formUpdateSell) {
        formUpdateSell.getjTextFieldTotalSell().setText("");
        formUpdateSell.getjTextFieldChange().setText("");
    }

}
