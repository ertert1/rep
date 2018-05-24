/**
 * объявление пакета
 */
package kr.KR;
/**
 * Библиотеки необходимые для работы.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Объявление публичного класса для создания зависимости между классами и выполнение вычислений.
 */
public class MathForm implements ActionListener {
	/**
	 * Переменные отвечающие за вычисление:
	 *k1-Вводимая максимальная мощность
	 *r1-Заранее заданное напряжение сети
	 *result-Результат вычислений
	 */
	static float k1;
	float r1;
	float result;
	/**
	 * Установление связи между родительским и дочерним классом.
	 */
	MathForm(ComponentForm parent){
    }
	/**
	 * Событие для кнопки "Рассчитать", присутствует обработка ошибок.
	 */
public void actionPerformed(ActionEvent e)  {
		try {
		/**
		 * Создание объекта прослушивающего нажатие кнопок.
		 */
        Object src = e.getSource();
        /**
    	 *Условие для прослушиваемой кнопки.
    	 */
        if (src == ComponentForm.btnNewButton){
        	/**
        	 * Считывание введенно максимальной мощности.
        	 */
			k1=Float.parseFloat((ComponentForm.TxtBox1.getText( )));
