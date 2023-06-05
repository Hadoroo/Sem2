package StudiKasus.PetShopUI;

import StudiKasus.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class PetShopUI extends JFrame{
    public void main() {
        setTitle("Pet Shop");

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        add(panel1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nama = new JLabel("Nama Hewan");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(nama, gbc);

        JLabel warna = new JLabel("Warna Hewan");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(warna, gbc);

        JLabel tanggalLahir = new JLabel("Tanggal Kelahiran");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(tanggalLahir, gbc);

        JLabel species = new JLabel("Species Hewan");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(species, gbc);

        JLabel ras = new JLabel("Ras");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(ras, gbc);

        JLabel jenisPerawatan = new JLabel("Jenis Perawatan");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel1.add(jenisPerawatan, gbc);

        JLabel perawat = new JLabel("Perawat");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel1.add(perawat, gbc);

        JTextField namaText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        namaText.setPreferredSize(new Dimension(150, namaText.getPreferredSize().height));
        panel1.add(namaText, gbc);

        JTextField warnaText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        warnaText.setPreferredSize(new Dimension(150, warnaText.getPreferredSize().height));
        panel1.add(warnaText, gbc);

        ///callendar
        Integer[] tanggal = new Integer[32];
        for (int i = 1; i < tanggal.length; i++){
            tanggal[i] = i;
        }
        JComboBox<Integer> pilihTanggal = new JComboBox<>(tanggal);
        gbc.gridx = 1;
        gbc.gridy = 2;
        pilihTanggal.setPreferredSize(new Dimension(50, pilihTanggal.getPreferredSize().height));
        panel1.add(pilihTanggal, gbc);

        String[] bulan = {"", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        JComboBox<String> pilihBulan = new JComboBox<>(bulan);
        gbc.gridx = 4;
        gbc.gridy = 2;
        pilihBulan.setPreferredSize(new Dimension(100, pilihBulan.getPreferredSize().height));
        panel1.add(pilihBulan, gbc);

        Integer[] tahun = new Integer[100];
        for (int i = 1; i < tahun.length; i++){
            tahun[i] = 1950 + i;
        }
        JComboBox<Integer> pilihTahun = new JComboBox<>(tahun);
        gbc.gridx = 5;
        gbc.gridy = 2;
        pilihTahun.setPreferredSize(new Dimension(60, pilihTahun.getPreferredSize().height));
        panel1.add(pilihTahun, gbc);
        ///

        String[] pilihHewan = {"-Pilih satu-", "Anjing", "Kucing", "Kelinci"};
        JComboBox<String> jenisHewan = new JComboBox<>(pilihHewan);
        gbc.gridx = 1;
        gbc.gridy = 3;
        jenisHewan.setPreferredSize(new Dimension(150, jenisHewan.getPreferredSize().height));
        panel1.add(jenisHewan, gbc);

        JTextField rasText = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 4;
        rasText.setPreferredSize(new Dimension(150, rasText.getPreferredSize().height));
        panel1.add(rasText, gbc);


        String[] pilihPerawatan = {"-Pilih satu-", "Anjing", "Kucing", "Kelinci"};
        JComboBox<String> pilihanPerawatan = new JComboBox<>(pilihPerawatan);
        gbc.gridx = 1;
        gbc.gridy = 5;
        pilihanPerawatan.setPreferredSize(new Dimension(150, jenisHewan.getPreferredSize().height));
        panel1.add(pilihanPerawatan, gbc);

        String[] pilihPerawat = {"-Pilih satu-", "Anjing", "Kucing", "Kelinci"};
        JComboBox<String> pilihanPerawat = new JComboBox<>(pilihPerawat);
        gbc.gridx = 1;
        gbc.gridy = 6;
        pilihanPerawat.setPreferredSize(new Dimension(150, jenisHewan.getPreferredSize().height));
        panel1.add(pilihanPerawat, gbc);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(new LineBorder(Color.black));
        gbc.gridx = 0;
        gbc.gridy = 7;
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

        simpan.addActionListener(jenisHewan);

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kode = namaText.getText();
                String satuan = jenisHewan.getSelectedItem().toString();
                String harga = kode + " " + satuan;

                // panel1.setVisible(false);
                species.setText(harga);
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

        batal.addActionListener(jenisHewan);

        batal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kode = namaText.getText();
                String satuan = jenisHewan.getSelectedItem().toString();
                String harga = kode + " " + satuan;

                panel1.setVisible(false);
                species.setText(harga);
            }
        });

        panel2.add(keluar, gbc);

        setLayout(new FlowLayout());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        PetShopUI ui = new PetShopUI();
        ui.main();
    }
}
