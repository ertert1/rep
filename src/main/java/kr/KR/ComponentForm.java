/**
 * объявление пакета
 */
package kr.KR;
/**
 * Библиотеки необходимые для работы
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * Объявление публичного класса для создания окна 
 */
public class ComponentForm extends JFrame {
	/**
	 * Описание компонентов формы
	 */
	JPanel contentPane;
	JPanel Panel1;
	JPanel Panel2;
	static JLabel label_1;
	static JLabel label_2;
	static JLabel label_3;
	static JTextField TxtBox1; 
	static JTextField TxtBox2;
	public static JFrame frame;
	static JButton btnNewButton;
	/**
	 * Объявление метода, в котором объявляются элементы экранной формы
	 * SuppressWarnings-это объявление аннотации для отключения предупреждений об ошибках
	 * Значок собаки может использоваться и для вызова индентифицирующих методов, для инициализации потоковых ресурсов
	 */
	@SuppressWarnings("deprecation")
	ComponentForm() {
		/**
		 * Задание шрифта и размера надписей для кнопок, меток;
		 */
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		/**
		 * Создание и настройка компонентов формы
		 */
		JPanel Panel1 = new JPanel();
		TxtBox1=new JTextField("");
		TxtBox1.setFont(font);
		TxtBox1.setPreferredSize( new Dimension( 100, 24 ) );
		TxtBox2=new JTextField();
		TxtBox2.setFont(font);
		TxtBox2.setPreferredSize( new Dimension( 100, 24 ) );
		label_1=new JLabel("Максимальная мощность, Вт");
		label_1.setFont(font);
		label_2=new JLabel("Напряжение сети, В");
		label_2.setFont(font);
		label_3=new JLabel(" ");
		label_3.setFont(font);
		btnNewButton=new JButton("Расчитать");
		btnNewButton.setFont(font);
		Panel1 = new JPanel();
		Panel1.setLayout(null);
		/**
		 * Добавляем кнопку, текстовые поля и метки на панель
		 */
		btnNewButton.setBounds(410, 50, 150, 35);
		Panel1.add(label_1);
		label_1.setBounds(10, 20, 350, 20);
        Panel1.add(TxtBox1);
        TxtBox1.setBounds(300, 20, 100, 30);
        label_2.setBounds(10, 60, 350, 20);
        Panel1.add(label_2);
        label_3.setBounds(10, 100, 350, 20);
        Panel1.add(label_3);
        Panel1.add(TxtBox2);
        Panel1.add(btnNewButton);
        TxtBox2.setBounds(300, 60, 100, 30);
		TxtBox2.disable();
		
        
        Panel1.add(label_3);
        Panel1.setBounds(100, 200, 300, 200);
        /**
		 * Помещаем панель на главный фрейм
		 */
		frame = new JFrame("Для жилых помещений");
		frame.setContentPane(Panel1);
		frame.setBounds(30,15,600,200);
		/**
		 * Отображаем окно
		 */
		frame.setVisible(true);
		/**
		 * Запрещаем масштабировать окно
		 */
		//frame.setResizable(false);
		/**
		 * Обработчик событий для TxtBox1(поле для ввода максимальной мощности)
		 */
		TxtBox1.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      /**
					 * обработка исключений
					 */
					try {
						/**
						 * Обработка 1го введенного символа , ограничение на длину строки
						 * matches-поиск совпадений по заданному шаблону
						 */
						if(!TxtBox1.getText().matches("[0-9]{0,4}") && (c != KeyEvent.VK_BACK_SPACE))  throw new Exception("Нельзя вводить больше 5 символов");
						if(TxtBox1.getText().matches("")&& (c=='0') && (c != KeyEvent.VK_BACK_SPACE)) throw new Exception("Выражение не должно начинатся с нуля");
						if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) throw new Exception("Можно вводить только цифры от 0 до 9");
					} 
					catch (Exception e1) {
						e.consume();
						JOptionPane.showMessageDialog(new JFrame(),e1.getMessage(), "ОШИБКА",JOptionPane.ERROR_MESSAGE);
					}
			   }
			}) ;
		/**
		 * Вызываем обработчик событий из класса MathForm
		 */
		MathForm calcEngine = new MathForm(this);
	    btnNewButton.addActionListener(calcEngine);
	}
}