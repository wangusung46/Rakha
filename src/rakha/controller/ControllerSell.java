package rakha.controller;

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
import rakha.view.transaction.FormSell;

class ControllerSell {

    private final SellJdbc sellJdbc;
    private final BuyJdbc buyJdbc;

    public ControllerSell() {
        sellJdbc = new SellJdbcImplement();
        buyJdbc = new BuyJdbcImplement();
    }

    void initController(FormSell formSell) {

        DefaultTableModel defaultTableModelSell = new DefaultTableModel();
        formSell.getjTableSell().setModel(defaultTableModelSell);
        defaultTableModelSell.addColumn("ID");
        defaultTableModelSell.addColumn("Barang");
        defaultTableModelSell.addColumn("Jumlah Jual");
        defaultTableModelSell.addColumn("Harga Jual");
        defaultTableModelSell.addColumn("Total");
        defaultTableModelSell.addColumn("Cash");

        formSell.getjTableSell().getColumnModel().getColumn(0).setMinWidth(0);
        formSell.getjTableSell().getColumnModel().getColumn(0).setMaxWidth(0);

        loadItem(formSell);

        setItem(formSell);

        loadTableSell(defaultTableModelSell);

        formSell.getjComboBoxName().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setItem(formSell);
            }
        });

        formSell.getjButtonSave().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performSave(formSell, defaultTableModelSell);
            }
        });

        formSell.getjButtonCountPayment().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!formSell.getjTextFieldPayment().getText().isEmpty()) {
                    formSell.getjTextFieldPayment1().setText(String.valueOf(
                            Integer.parseInt(formSell.getjTextFieldTotalSell().getText())
                            * Integer.parseInt(formSell.getjTextFieldPriceTotal().getText())
                    ));
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        formSell.getjButtonCountPayment1().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!formSell.getjTextFieldTotal().getText().isEmpty()) {
                    formSell.getjTextFieldChange().setText(String.valueOf(
                            Integer.parseInt(formSell.getjTextFieldTotal().getText())
                            - Integer.parseInt(formSell.getjTextFieldPayment1().getText())
                    ));
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah tidak boleh kosong", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void loadItem(FormSell formSell) {
        List<Buy> buys = buyJdbc.selectBuys();
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        buys.forEach(buy -> {
            defaultComboBoxModel.addElement(new ComboItems(buy.getId(), buy.getNameitem()));
        });
        formSell.getjComboBoxName().setModel(defaultComboBoxModel);
    }

    private void setItem(FormSell formSell) {
        Buy buy = buyJdbc.selectBuy(((ComboItems) formSell.getjComboBoxName().getSelectedItem()).getKey());
        formSell.getjTextFieldPriceTotal().setText(buy.getSellPrice().toString());
        formSell.getjTextFieldAmountBuy().setText(buy.getCountItem().toString());
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
    }

    private void performSave(FormSell formSell, DefaultTableModel defaultTableModelSell) {
        Sell sell = new Sell();
        sell.setId(0L);
        sell.setIdBuy(((ComboItems) formSell.getjComboBoxName().getSelectedItem()).getKey());
        sell.setSellAmount(Integer.parseInt(formSell.getjTextFieldTotalSell().getText()));
        sell.setCash(new BigDecimal(formSell.getjTextFieldTotal().getText()));
        sellJdbc.insertSell(sell);

        JOptionPane.showMessageDialog(null, "Berhasil menyimpan data", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void empty(FormSell formSell) {
        formSell.getjTextFieldPayment().setText("");
        formSell.getjTextFieldChange().setText("");
    }

}
