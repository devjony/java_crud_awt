package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ManipulateTables;
import model.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReadStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6362883120008410026L;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField courseTextField;

	/**
	 * Create the panel.
	 */
	public ReadStudent(EntityManager manager) {
		setLayout(null);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(134, 50, 48, 14);
		add(idLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(134, 81, 48, 14);
		add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(134, 117, 48, 14);
		add(emailLabel);
		
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setBounds(134, 148, 48, 14);
		add(courseLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(192, 47, 48, 20);
		add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setBounds(192, 78, 96, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setEditable(false);
		emailTextField.setBounds(192, 114, 96, 20);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		courseTextField = new JTextField();
		courseTextField.setEditable(false);
		courseTextField.setBounds(192, 145, 96, 20);
		add(courseTextField);
		courseTextField.setColumns(10);
		
		JLabel readStudentTitleLabel = new JLabel("Read Student");
		readStudentTitleLabel.setBounds(182, 11, 106, 14);
		add(readStudentTitleLabel);
		
		JButton btnRead = new JButton("Read");
		btnRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try{
					Student student = ManipulateTables.readStudent(manager, idTextField.getText());
					nameTextField.setText(student.getName());
					emailTextField.setText(student.getEmail());
					courseTextField.setText(student.getCourse());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Student not found");
					idTextField.setText("");
					nameTextField.setText("");
					emailTextField.setText("");
					courseTextField.setText("");
				}
			}
		});
		btnRead.setBounds(168, 187, 89, 23);
		add(btnRead);
	}
}