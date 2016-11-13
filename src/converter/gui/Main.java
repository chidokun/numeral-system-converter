package converter.gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import converter.Number;
import converter.NumeralSystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
	private JPanel contentPane;
	private JTextField txtConvert;
	private JTextField txtResult;
	private JToggleButton tglbtnDec;
	private JToggleButton tglbtnBin;
	private JToggleButton tglbtnOct;
	private JToggleButton tglbtnHex;
	private JToggleButton tglbtnResultDec;
	private JToggleButton tglbtnResultBin;
	private JToggleButton tglbtnResultOct;
	private JToggleButton tglbtnResultHex;

	private NumeralSystem numeralSystem;
	private NumeralSystem numeralSystemResult;
	private Number number = new Number();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Numeral System Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 375, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Numeral System Converter");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblTitle.setBounds(23, 11, 321, 35);
		panel.add(lblTitle);

		JLabel lblNewLabel_1 = new JLabel("Enter positive integer number:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 68, 324, 23);
		contentPane.add(lblNewLabel_1);

		txtConvert = new JTextField();
		txtConvert.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				convert();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				convert();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				convert();
			}
		});
		txtConvert.setHorizontalAlignment(SwingConstants.RIGHT);
		txtConvert.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtConvert.setBounds(24, 92, 324, 30);
		contentPane.add(txtConvert);
		txtConvert.setColumns(10);

		tglbtnDec = new JToggleButton("DEC");
		tglbtnDec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectOption(arg0);
			}
		});
		tglbtnDec.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnDec.setBounds(24, 128, 80, 35);
		contentPane.add(tglbtnDec);

		tglbtnBin = new JToggleButton("BIN");
		tglbtnBin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectOption(e);
			}
		});
		tglbtnBin.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnBin.setBounds(105, 128, 80, 35);
		contentPane.add(tglbtnBin);

		tglbtnOct = new JToggleButton("OCT");
		tglbtnOct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectOption(e);
			}
		});
		tglbtnOct.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnOct.setBounds(186, 128, 80, 35);
		contentPane.add(tglbtnOct);

		tglbtnHex = new JToggleButton("HEX");
		tglbtnHex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectOption(e);
			}
		});
		tglbtnHex.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnHex.setBounds(267, 128, 80, 35);
		contentPane.add(tglbtnHex);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblResult.setBounds(24, 198, 257, 23);
		contentPane.add(lblResult);

		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setFont(new Font("Consolas", Font.PLAIN, 20));
		txtResult.setColumns(10);
		txtResult.setBounds(24, 222, 324, 30);
		contentPane.add(txtResult);

		tglbtnResultDec = new JToggleButton("DEC");
		tglbtnResultDec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectResultOption(e);
			}
		});
		tglbtnResultDec.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnResultDec.setBounds(24, 258, 80, 35);
		contentPane.add(tglbtnResultDec);

		tglbtnResultBin = new JToggleButton("BIN");
		tglbtnResultBin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectResultOption(e);
			}
		});
		tglbtnResultBin.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnResultBin.setBounds(105, 258, 80, 35);
		contentPane.add(tglbtnResultBin);

		tglbtnResultOct = new JToggleButton("OCT");
		tglbtnResultOct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectResultOption(e);
			}
		});
		tglbtnResultOct.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnResultOct.setBounds(186, 258, 80, 35);
		contentPane.add(tglbtnResultOct);

		tglbtnResultHex = new JToggleButton("HEX");
		tglbtnResultHex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectResultOption(e);
			}
		});
		tglbtnResultHex.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		tglbtnResultHex.setBounds(267, 258, 80, 35);
		contentPane.add(tglbtnResultHex);

		initialize();
	}

	public void restoreOption() {
		tglbtnDec.setSelected(false);
		tglbtnBin.setSelected(false);
		tglbtnOct.setSelected(false);
		tglbtnHex.setSelected(false);
	}

	public void restoreResultOption() {
		tglbtnResultDec.setSelected(false);
		tglbtnResultBin.setSelected(false);
		tglbtnResultOct.setSelected(false);
		tglbtnResultHex.setSelected(false);
	}

	public void selectOption(MouseEvent e) {		
		restoreOption();
		JToggleButton btn = (JToggleButton) e.getSource();
		btn.setSelected(true);
		if (btn.getText().equals("DEC"))
			numeralSystem = NumeralSystem.Decimal;
		else if (btn.getText().equals("BIN"))
			numeralSystem = NumeralSystem.Binary;
		else if (btn.getText().equals("OCT"))
			numeralSystem = NumeralSystem.Octonary;
		else if (btn.getText().equals("HEX"))
			numeralSystem = NumeralSystem.Hexadecimal;
		
		convert();
	}

	public void selectResultOption(MouseEvent e) {
		restoreResultOption();
		JToggleButton btn = (JToggleButton) e.getSource();
		btn.setSelected(true);
		if (btn.getText().equals("DEC"))
			numeralSystemResult = NumeralSystem.Decimal;
		else if (btn.getText().equals("BIN"))
			numeralSystemResult = NumeralSystem.Binary;
		else if (btn.getText().equals("OCT"))
			numeralSystemResult = NumeralSystem.Octonary;
		else if (btn.getText().equals("HEX"))
			numeralSystemResult = NumeralSystem.Hexadecimal;
		
		convert();
	}

	public void initialize() {
		tglbtnDec.setSelected(true);
		tglbtnResultBin.setSelected(true);
		numeralSystem = NumeralSystem.Decimal;
		numeralSystemResult = NumeralSystem.Binary;
	}

	public void convert() {
		String result = null;
		try {
			number.setNumber(txtConvert.getText(), numeralSystem);
			switch (numeralSystemResult) {
			case Decimal:
				result = Long.toString(number.getNumber());
				break;
			case Binary:
				result = number.getBinary();
				break;
			case Octonary:
				result = number.getOctonary();
				break;
			case Hexadecimal:
				result = number.getHexadecimal();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			result = "";
		} finally {
			txtResult.setText(result);
		}
	}
}
