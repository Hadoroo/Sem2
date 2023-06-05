package GUI;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame{
    public void main() {
        setTitle("Form");

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        add(panel1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel kodeBarang = new JLabel("Kode barang");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(kodeBarang, gbc);

        JLabel nama = new JLabel("Nama");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(nama, gbc);

        JLabel satuan = new JLabel("Satuan");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(satuan, gbc);

        JLabel hargaBeli = new JLabel("Harga beli");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(hargaBeli, gbc);

        JLabel hargaJual = new JLabel("Harga jual");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(hargaJual, gbc);

        JTextField kodeText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        kodeText.setPreferredSize(new Dimension(150, kodeText.getPreferredSize().height));
        panel1.add(kodeText, gbc);

        JTextField namaText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        namaText.setPreferredSize(new Dimension(150, namaText.getPreferredSize().height));
        panel1.add(namaText, gbc);

        String[] pilihan = { "Pcs", "Kg", "Unit", "Liter", "Lusin" };
        JComboBox<String> satuanPilih = new JComboBox<>(pilihan);
        gbc.gridx = 1;
        gbc.gridy = 2;
        satuanPilih.setPreferredSize(new Dimension(150, satuanPilih.getPreferredSize().height));
        panel1.add(satuanPilih, gbc);

        JTextField beliText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        beliText.setPreferredSize(new Dimension(150, beliText.getPreferredSize().height));
        panel1.add(beliText, gbc);

        JTextField jualText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 4;
        jualText.setPreferredSize(new Dimension(150, jualText.getPreferredSize().height));
        panel1.add(jualText, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(new LineBorder(Color.black));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(panel2, gbc);

        JButton tambah = new JButton("Tambah");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel2.add(tambah, gbc);

        JButton ubah = new JButton("Ubah");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel2.add(ubah, gbc);

        JButton simpan = new JButton("Simpan");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        simpan.addActionListener(satuanPilih);

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kode = kodeText.getText();
                String satuan = satuanPilih.getSelectedItem().toString();
                String harga = kode + " " + satuan;

                // panel1.setVisible(false);
                hargaBeli.setText(harga);
            }
        });

        panel2.add(simpan, gbc);

        JButton hapus = new JButton("Hapus");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel2.add(hapus, gbc);

        JButton batal = new JButton("Batal");
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel2.add(batal, gbc);

        JButton keluar = new JButton("Keluar");
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 50, 5, 5);

        batal.addActionListener(satuanPilih);

        batal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kode = kodeText.getText();
                String satuan = satuanPilih.getSelectedItem().toString();
                String harga = kode + " " + satuan;

                panel1.setVisible(false);
                hargaBeli.setText(harga);
            }
        });

        panel2.add(keluar, gbc);

        
        
        panel2.add(keluar, gbc);

        setLayout(new FlowLayout());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.main();
    }
}
