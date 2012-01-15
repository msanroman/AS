package presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class TextFieldDigitListener implements KeyListener {
	@Override
	public void keyTyped(KeyEvent arg0) {
		char caracter = arg0.getKeyChar();
		if ((caracter < '0') || (caracter > '9')) {
			arg0.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}
}